/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author kyledeane
 */
public class MoveShooterAngle extends CommandBase {
        public int m_direction;
    public MoveShooterAngle(int direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        m_direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(m_direction > 0){
            shooterangle.driveUp();
        }else{
            shooterangle.driveDown();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooterangle.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
