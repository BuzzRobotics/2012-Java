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
 * Controls Camera Servos
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
    }
    
    public void initDefaultCommand() {
        
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

}
