/*
 * NOBODY TOUCH ANY OF THIS CODE! (UNLESS IT'S AN EXTREME EMERGENCY)
 * THIS IS PROPERTY OF KYLE. IT IS VERY FRAGILE!
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendablePIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * DriveTrain
 * Hope This Works :O
 * @author Kyle Deane
 */
public class DriveTrain extends Subsystem {
    RobotDrive drive;
    Encoder rightDriveEncoder;
    Encoder leftDriveEncoder;
  
    private double forward;
    /*
     * Define Variables
     */
    final int WHEEL_RADIUS = 4;
    final double CIRCUMFERENCE = 2 * Math.PI * WHEEL_RADIUS;
    final int ENCODER_CODES_PER_REV = 360;
    final double DISTANCE_PER_PULSE = CIRCUMFERENCE / ENCODER_CODES_PER_REV;
    
    /*
     * Define PID Variables
     */
    double Kp = 0.035;
    double Ki = 0.0005;
    double Kd = 1.0;
    
    SendablePIDController controller;
    
    public DriveTrain() {
        setForward();
        
        drive = new RobotDrive(RobotMap.driveRight1, RobotMap.driveLeft1);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        rightDriveEncoder = new Encoder(RobotMap.encRightDrive1, RobotMap.encRightDrive2);
        
        leftDriveEncoder = new Encoder(RobotMap.encLeftDrive1, RobotMap.encLeftDrive2);
        leftDriveEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
        rightDriveEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
        rightDriveEncoder.start();
        leftDriveEncoder.start();
        
        PIDSource difference = new PIDSource(){
            public double pidGet(){
                return leftDriveEncoder.getDistance() + rightDriveEncoder.getDistance();
            }
        };
                
        controller = new SendablePIDController(Kp, Ki, Kd, difference, new PIDOutput() {
           
            
            public void pidWrite(double output) {
                drive(forward, output);
            }
        }, 0.005);
    }
    
    /**
     * Implements the Arcade capability of the drivetrain.
     * 
     * @param Xaxis The X-Axis of the Joystick.
     * @param Yaxis The Y-Axis of the Joystick.
     */
    public void arcadeDrive(double Xaxis, double Yaxis) {
        drive.arcadeDrive(Xaxis, Yaxis, true);
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
  
    /*
     * Initializes PID Controller for Driving with Gyroscope.
     */
    public void initController() {
        controller.setSetpoint(0);
        controller.enable();
    }
    
    /*
     * Cancells the controller for driving with Gyro. 
     */
    public void endController() {
        controller.disable();
    }
    
    /*
    * Drives straight using gyroscope as PID input.
    */
    public void driveStraight() {
        controller.setSetpoint(0);  // Go straight
    }

    /**
     * Calculate average distance of the two encoders.  
     * @return Average of the distances (inches) read by each encoder since they were last reset.
     */
    public double getAvgDistance() {

        return (Math.abs(rightDriveEncoder.getDistance()) + Math.abs(leftDriveEncoder.getDistance())) / 2.0;

    }
    
    /*
     * getRightEncoder  
     * @return the distance value of the right encoder
     */
    public double getRightEncoder(){
        return rightDriveEncoder.getDistance();
    }
    
     /*
     * getLeftEncoder  
     * @return the distance value of the left encoder
     */
    public double getLeftEncoder(){
        return leftDriveEncoder.getDistance();
    }
    
    /*
     * getEncoderDifference
     * @return leftDriveEncoder - rightDriveEncoder
     */
    public double getEncoderDifference(){
        return leftDriveEncoder.getDistance() - rightDriveEncoder.getDistance();
    }
    
    /**
     * Reset both encoders's tick, distance, etc. count to zero
     */
    public void resetEncoders() {
        rightDriveEncoder.reset();
        leftDriveEncoder.reset();
    }

    
    /* Defines direction for autonomus as forwards */
    public final void setForward(){
        forward = 0.5;
    }

    /* Defines direction for autonomus as backwards */
    public final void setBackwards(){
        forward = -0.5;
    }
    
    public void initDefaultCommand() {
         setDefaultCommand(new DriveWithJoystick());
    }
    public Command getDefaultCommand(){
        return super.getDefaultCommand();
    }
    
}
