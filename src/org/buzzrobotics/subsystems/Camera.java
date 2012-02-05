package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.AdjustCamera;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Kyle Deane
 */
public class Camera extends Subsystem {
    Servo cameraX;
    Servo cameraY;
    public Camera() {
       cameraX = new Servo(RobotMap.camerax);
       
       cameraY = new Servo(RobotMap.cameray);
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
}
