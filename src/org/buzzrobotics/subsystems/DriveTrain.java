/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Kyle Deane
 */
public class DriveTrain extends Subsystem {
    RobotDrive drive;
    Encoder robotDriveEncoder;
    
    public DriveTrain() {
        drive = new RobotDrive(RobotMap.driveRight1, RobotMap.driveRight2, RobotMap.driveLeft1, RobotMap.driveLeft2);
        robotDriveEncoder = new Encoder(2, 3);
    }
    
    public void initDefaultCommand() {
         setDefaultCommand(new DriveWithJoystick());
    }
    
    /**
     * Implements the Arcade capability of the drivetrain.
     * 
     * @param Xaxis The X-Axis of the Joystick.
     * @param Yaxis The Y-Axis of the Joystick.
     */
    public void arcadeDrive(double Xaxis, double Yaxis) {
        drive.arcadeDrive(Xaxis, Yaxis, false);
    }
    /**
     * Implements the Tank Drive capability of the drivetrain.
     * 
     * @param left The speed for the left side of the drivetrain.
     * @param right The speed for the right side of the drivetrain.
     */
    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);
    }
    
    /*
     * Drives the desired speed in the desired direction
     * 
     * @param double speed - speed the bot moves at
     * @param double turn - direction in which the bot turns
     */
    public void drive(double speed, double turn){
        drive.drive(speed, turn);
    }
    
    public void getEncoderCounts(){
        double encoderCounts;
        robotDriveEncoder.start();
        encoderCounts = robotDriveEncoder.getDistance();
        //System.out.println(encoderCounts);
    }
    public void resetEncoder(){
        robotDriveEncoder.reset();
        System.out.println("Encoder(s) reset.");
    }
}
