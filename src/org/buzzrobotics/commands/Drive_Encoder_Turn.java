package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Turns until one encoder is (X) greater than the other. :)
 * @author Kyle Deane
 */
public class Drive_Encoder_Turn extends CommandBase {
    public int m_degrees;
    public Drive_Encoder_Turn(int degrees) {
           m_degrees = degrees; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(m_degrees <= 180){
            drivetrain.drive(0.5, 1);
        }else{
            drivetrain.drive(0.5, -1);
        }    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
          if (drivetrain.getEncoderDifference() > m_degrees){
              return true;
          }else{
              return false;
          }
    }


    // Called once after isFinished returns true
    protected void end() {
        drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
