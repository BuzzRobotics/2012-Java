/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class MoveBallFeeder extends CommandBase {
        public int state;
    public MoveBallFeeder(int m_state) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        state = m_state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(state == 1){
            ballfeeder.driveUp();
        }else if(state == -1){
            ballfeeder.driveDown();
    }else{
            ballfeeder.stop();
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
