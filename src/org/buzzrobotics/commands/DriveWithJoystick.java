/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author Kyle Deane
 */
public class DriveWithJoystick extends CommandBase {
    public double sensitivity;
    public DriveWithJoystick() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //drivetrain.arcadeDrive(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        sensitivity = (oi.getRightZ() + 1)/2 + 0.2; 
                if (sensitivity > 1.0){
                    sensitivity = 1.0;
                }
        drivetrain.arcadeDrive( oi.getRightX() * sensitivity, oi.getRightY() * sensitivity);
        drivetrain.getEncoderCounts();
        
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
}
