/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void setCamera(double x, double y) {
        cameraX.setPosition(x);
        cameraY.setPosition(y);
    }
    public void setCameraX(double x) {
        cameraX.setPosition(x);
    }
    public void setCameraY(double y) {
        cameraY.setPosition(y);
    }
}
