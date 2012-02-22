package org.buzzrobotics.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Drives with Joystick. Always called during Teleop and should never be ended.
 * VERY IMPORTANT!
 * @author Kyle Deane
 */
public class DriveWithJoystick extends CommandBase {
    public double sensitivity;
    public double turn;
    public double joyx;
    public double joyy;
    public double joyz;
    public double oJoyX;
    public double oJoyY;
    public DriveWithJoystick() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //drivetrain.arcadeDrive(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      /*  sensitivity = (oi.getRightZ() + 1)/2 + 0.2; 
                if (sensitivity > 1.0){
                    sensitivity = 1.0;
                } */
        joyz = oi.getRightZ();
        oJoyX = oi.getRightX();
        oJoyY = oi.getRightY();
        joyx = (joyz*oJoyX)*(joyz*oJoyX)*(joyz*oJoyX) + (1 - joyz)*oJoyX;
        joyy = (joyz*oJoyY)*(joyz*oJoyY)*(joyz*oJoyY) + (1 - joyz)*oJoyY;
        SmartDashboard.putDouble("JoystickX", joyx);
        SmartDashboard.putDouble("JoystickY", joyy);
            drivetrain.arcadeDrive(oJoyX,oJoyY);
            
       //        if (oi.getRightTwist() > 0.8 || oi.getRightTwist() < -0.8){
//            if (oi.getRightTwist() > 0.1){
//                drivetrain.drive(oi.getRightTwist(), 1);
//            }else if (oi.getRightTwist() < 0.1 ){
//                drivetrain.drive(-oi.getRightTwist(), -1); //we could also try the turn as getrighttwist
//            }
//        }
        
        
//            if (oi.getRightTwist() < -0.10 || oi.getRightTwist() > 0.10){
//                drivetrain.drive(oi.getRightTwist(), turn);
//            }
//        if(ir.getFloor1IRSensor() && ir.getFloor2IRSensor() && ir.getFloor3IRSensor()){
//            floorlight.on();
//        }else{
//            floorlight.off();
//        }
        
        if(ir.getFloor1IRSensor()){
             floorlight.on();
        }else{
             floorlight.off();
        }
        
        if(ir.getFloor2IRSensor()){
             floorlight.light2on();
        }else{
            floorlight.light2off();
        }
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
        System.out.println("DRIVE INTERRUPTED");
    }
}
