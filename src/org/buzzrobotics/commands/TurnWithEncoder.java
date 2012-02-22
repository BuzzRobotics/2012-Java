/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author buzz5
 */
public class TurnWithEncoder extends CommandBase {
    public int m_degrees;
    public TurnWithEncoder(int degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
           m_degrees = degrees; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(m_degrees <= 180){
            drivetrain.drive(0, 0.2);
        }else{
            drivetrain.drive(0, -0.2);
        }    
        
            
            
            //System.out.println("Degrees: " + drivetrain.getGyroAngle() + ". Goal!: " + m_degrees);
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
