/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class ShooterAngle_Move extends CommandBase {
     public double m_Direction;
     public ShooterAngle_Move(double dir) {
       m_Direction = dir;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterangle.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (m_Direction > 0){
           shooterangle.driveUp();
        }else if (m_Direction < 0){
            shooterangle.driveDown();
        }else{
            shooterangle.stop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
