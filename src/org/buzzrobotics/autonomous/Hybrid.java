
package org.buzzrobotics.autonomous;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Kinect;
import edu.wpi.first.wpilibj.Skeleton;
import edu.wpi.first.wpilibj.Timer;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.*;

/**
 * Hybrid code for Autonomous mode. Should automagically be called, if not, move this code to "Autonomous Periodic". 
 * Drives with the Kinect
 * @author Kyle Deane
 */
public class Hybrid extends CommandBase {
    
    //Constants which define the valid arm positions
    static final int ARM_MAX_ANGLE = 105;
    static final int ARM_MIN_ANGLE = -90;
    static final double Z_PLANE_TOLERANCE = 0.3;    /* In meters */

    //Constants which define the "trigger" angles for the various buttons
    static final int LEG_FORWARD = -110;
    static final int LEG_BACKWARD = -80;
    static final int LEG_OUT = -75;
    static final int HEAD_LEFT = 98;
    static final int HEAD_RIGHT = 82;

    Kinect kinect;
    
    public Hybrid() {
        requires(drivetrain);
        requires(light);
        requires(shifter);
        kinect = Kinect.getInstance();
        
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       double leftAxis = 0;
        double rightAxis = 0;
        double leftAngle, rightAngle, headAngle, rightLegAngle, leftLegAngle, rightLegYZ, leftLegYZ;
        boolean dataWithinExpectedRange;
        boolean[] buttons = new boolean[8];
        /* Only process data if skeleton is tracked */
        if (kinect.getSkeleton().GetTrackState() == Skeleton.tTrackState.kTracked) {

                /* Determine angle of each arm and map to range -1,1 */
                leftAngle = AngleXY(kinect.getSkeleton().GetShoulderLeft(), kinect.getSkeleton().GetWristLeft(), true);
                rightAngle = AngleXY(kinect.getSkeleton().GetShoulderRight(), kinect.getSkeleton().GetWristRight(), false);
                leftAxis = CoerceToRange(leftAngle, -70, 70, -1, 1);
                rightAxis = CoerceToRange(rightAngle, -70, 70, -1, 1);

                /* Check if arms are within valid range and at approximately the same z-value */
                dataWithinExpectedRange = leftAngle < ARM_MAX_ANGLE && leftAngle > ARM_MIN_ANGLE &&
                                      rightAngle < ARM_MAX_ANGLE && rightAngle > ARM_MIN_ANGLE;
                dataWithinExpectedRange = dataWithinExpectedRange &&
                                      InSameZPlane(kinect.getSkeleton().GetShoulderLeft(),
                                                   kinect.getSkeleton().GetWristLeft(),
                                                   Z_PLANE_TOLERANCE) &&
                                      InSameZPlane(kinect.getSkeleton().GetShoulderRight(),
                                                   kinect.getSkeleton().GetWristRight(),
                                                   Z_PLANE_TOLERANCE);

                /* Determine the head angle and use it to set the Head buttons */
                headAngle = AngleXY(kinect.getSkeleton().GetShoulderCenter(), kinect.getSkeleton().GetHead(), false);
                buttons[0] = headAngle > HEAD_LEFT;
                if (buttons[0]){
                    light.on();
                }
                buttons[1] = headAngle < HEAD_RIGHT;
                if (buttons[1]){
                    new Shooter_Fire();
                }

                /* Calculate the leg angles in the XY plane and use them to set the Leg Out buttons */
                leftLegAngle = AngleXY(kinect.getSkeleton().GetHipLeft(), kinect.getSkeleton().GetAnkleLeft(), true);
                rightLegAngle = AngleXY(kinect.getSkeleton().GetHipRight(), kinect.getSkeleton().GetAnkleRight(), false);
                buttons[2] = leftLegAngle > LEG_OUT;
                buttons[3] = rightLegAngle > LEG_OUT;
                if (buttons[2]){
                    shifter.up();
                }
                if (buttons[3]){ 
                    shifter.down();
                }
                /* Calculate the leg angle in the YZ plane and use them to set the Leg Forward and Leg Back buttons */
                leftLegYZ = AngleYZ(kinect.getSkeleton().GetHipLeft(), kinect.getSkeleton().GetAnkleLeft(), false);
                rightLegYZ = AngleYZ(kinect.getSkeleton().GetHipRight(), kinect.getSkeleton().GetAnkleRight(), false);
                buttons[4] = rightLegYZ < LEG_FORWARD;
                buttons[5] = rightLegYZ > LEG_BACKWARD;
                buttons[6] = leftLegYZ < LEG_FORWARD;
                buttons[7] = leftLegYZ > LEG_BACKWARD;

                if (dataWithinExpectedRange){
                    /**
                     * Drives using the Kinect axes scaled to 1/3 power
                     * Axes are inverted so arms up == joystick pushed away from you
                     */
                    drivetrain.tankDrive(-leftAxis*RobotMap.kinectScale, -rightAxis*RobotMap.kinectScale);

                    /**
                     * Do something with boolean "buttons" here
                     */

                    /* Optional SmartDashboard display of Kinect values */
                    //SmartDashboard.putDouble("Left Arm", -leftAxis);
                    //SmartDashboard.putDouble("Right Arm", -rightAxis);
                    //SmartDashboard.putBoolean("Head Left", buttons[0]);
                    //SmartDashboard.putBoolean("Head Right", buttons[1]);
                    //...etc...
                }
                else{
                    /* Arms are outside valid range */
                      drivetrain.tankDrive(0,0);
                    

                    /**
                     * Do default behavior with boolean "buttons" here
                     */

                    /* Optional SmartDashboard display of Kinect values */
                    //SmartDashboard.putDouble("Left Arm", 0);
                    //SmartDashboard.putDouble("Right Arm", 0);
                    //SmartDashboard.putBoolean("Head Left", false);
                    //SmartDashboard.putBoolean("Head Right", false);
                    //...etc...
                }
            }
            else{
                /* Skeleton not tracked */

                drivetrain.tankDrive(0,0);

                /**
                * Do default behavior with boolean "buttons" here
                */

                /* Optional SmartDashboard display of Kinect values */
                //SmartDashboard.putDouble("Left Arm", 0);
                //SmartDashboard.putDouble("Right Arm", 0);
                //SmartDashboard.putBoolean("Head Left", false);
                //SmartDashboard.putBoolean("Head Right", false);
                //...etc...
            }
            Timer.delay(.01);   /* Delay 10ms to reduce proceessing load*/
        
       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    /**
     * This method returns the angle (in degrees) of the vector pointing from Origin to Measured
     * projected to the XY plane. If the mirrored parameter is true the vector is flipped about the Y-axis.
     * Mirroring is used to avoid the region where the atan2 function is discontinuous
     * @param origin The Skeleton Joint to use as the origin point
     * @param measured The Skeleton Joint to use as the endpoint of the vector
     * @param mirrored Whether to mirror the X coordinate of the joint about the Y-axis
     * @return The angle in degrees
     */
    public double AngleXY(Skeleton.Joint origin, Skeleton.Joint measured, boolean mirrored){
        return Math.toDegrees(MathUtils.atan2(measured.getY()- origin.getY(),
                (mirrored) ? (origin.getX() - measured.getX()) : (measured.getX() - origin.getX())));
    }

     /**
     * This method returns the angle (in degrees) of the vector pointing from Origin to Measured
     * projected to the YZ plane. If the mirrored parameter is true the vector is flipped about the Y-axis.
     * Mirroring is used to avoid the region where the atan2 function is discontinuous
     * @param origin The Skeleton Joint to use as the origin point
     * @param measured The Skeleton Joint to use as the endpoint of the vector
     * @param mirrored Whether to mirror the Z coordinate of the joint about the Y-axis
     * @return The angle in degrees
     */
    public double AngleYZ(Skeleton.Joint origin, Skeleton.Joint measured, boolean mirrored){
        return Math.toDegrees(MathUtils.atan2(measured.getY()- origin.getY(),
                (mirrored) ? (origin.getZ() - measured.getZ()) : (measured.getZ() - origin.getZ())));
    }

    /**
     * This method checks if two Joints have z-coordinates within a given tolerance
     * @param origin
     * @param measured
     * @param tolerance
     * @return True if the z-coordinates are within tolerance
     */
    public boolean InSameZPlane(Skeleton.Joint origin, Skeleton.Joint measured, double tolerance)
        {
            return Math.abs(measured.getZ() - origin.getZ()) < tolerance;
        }

    /**
     * This method takes an input, an input range, and an output range,
     * and uses them to scale and constrain the input to the output range
     * @param input The input value to be manipulated
     * @param inputMin The minimum value of the input range
     * @param inputMax The maximum value of the input range
     * @param outputMin The minimum value of the output range
     * @param outputMax The maximum value of the output range
     * @return The output value scaled and constrained to the output range
     */
    public double CoerceToRange(double input, double inputMin, double inputMax, double outputMin, double outputMax)
        {
            /* Determine the center of the input range and output range */
            double inputCenter = Math.abs(inputMax - inputMin) / 2 + inputMin;
            double outputCenter = Math.abs(outputMax - outputMin) / 2 + outputMin;

            /* Scale the input range to the output range */
            double scale = (outputMax - outputMin) / (inputMax - inputMin);

            /* Apply the transformation */
            double result = (input + -inputCenter) * scale + outputCenter;

            /* Constrain to the output range */
            return Math.max(Math.min(result, outputMax), outputMin);
        }
}
