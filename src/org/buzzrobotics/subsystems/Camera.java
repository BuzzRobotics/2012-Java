package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.AdjustCamera;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.commands.CommandBase;

/**
 * @author Kyle Deane
 */
public class Camera extends Subsystem {
    Servo cameraX;
    Servo cameraY;
//    AxisCamera camera;
//    CriteriaCollection cc;
//    
//    public static final int CAMERA_CENTER = 320;
//    private double targetCenter;
    
    public Camera() {
       cameraX = new Servo(RobotMap.camerax);
       cameraY = new Servo(RobotMap.cameray);
//       camera = AxisCamera.getInstance();  // get an instance ofthe camera
//       cc = new CriteriaCollection();      // create the criteria for the particle filter
//       cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
//       cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);
    }
    
    public void initDefaultCommand() {
         //setDefaultCommand(new AdjustCamera(0, 0));
    }
    /*
     * Sets the Camera Position using X and Y axis
     * @param x Pan camera
     * @param y tilt camera
     */
    public void setCamera(double x, double y) {
        cameraX.setPosition(x);
        cameraY.setPosition(y);
    }
    /*
     * Sets camera's x position.
     * @param x pan camera
     */
    public void setCameraX(double x) {
        cameraX.setPosition(x);
    }
    /*
     * Sets canera's Y position
     * @param y tilt camera
     */
    public void setCameraY(double y) {
        cameraY.setPosition(y);
    }
    
//    public void doCamera() {
//        try {
//           
//            CommandBase.light.on();
//            ColorImage image = camera.getImage();
//            BinaryImage rectImage = image.thresholdHSL(136, 182, 45, 255, 116, 255);
//            rectImage.write("myimage.jpg");
//            //BinaryImage thresholdImage = rectImage.thresholdRGB(25, 255, 0, 45, 0, 47);   // keep only red objects
//            BinaryImage bigObjectsImage = rectImage.removeSmallObjects(false, 2);  // remove small artifacts
//            BinaryImage convexHullImage = bigObjectsImage.convexHull(false);          // fill in occluded rectangles
//            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangles
//
//            ParticleAnalysisReport[] reports = filteredImage.getOrderedParticleAnalysisReports();  // get list of results
//            ParticleAnalysisReport r = reports[0];
//            System.out.println("Center of mass x: " + r.center_mass_x);
//            targetCenter = r.center_mass_x;
//            System.out.println(filteredImage.getNumberParticles() + "  " + Timer.getFPGATimestamp());
//
//            /**
//             * all images in Java must be freed after they are used since they
//             * are allocated out of C data structures. Not calling free() will
//             * cause the memory to accumulate over each pass of this loop.
//             */
//            filteredImage.free();
//            convexHullImage.free();
//            bigObjectsImage.free();
//            rectImage.free();
//            image.free();
//
//        } catch (NIVisionException ex) {
//            ex.printStackTrace();
//        } catch (AxisCameraException ex){
//            ex.printStackTrace();
//        }
//        if(isFacingTarget()){
//            CommandBase.light.on();
//        }else{
//            CommandBase.light.off();
//        }
//    }
//
//    /**
//     * Displays the center of the largest, rectangular target detected
//     * @return targetCenter
//     */
//    public double getTargetCenter() {
//        return targetCenter;
//    }
//
//    public boolean isFacingTarget() {
//        double absValue = Math.abs(CAMERA_CENTER - targetCenter);
//        return absValue < 50;
//
//    }
}
