package org.buzzrobotics.commands;

/**
 * Toggles Brake
 * @author Kyle Deane
 */
public class Brake_Toggle extends CommandBase {
    
    public Brake_Toggle() {
        requires(brake);
    }

    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        brake.toggle();
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
