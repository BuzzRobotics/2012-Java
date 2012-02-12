package org.buzzrobotics.commands;

/**
 * Raises the brake. Doesnt do anything much. :D
 * @author Kyle Deane
 */
public class Brake_Up extends CommandBase {
    
    public Brake_Up() {
        requires(brake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        brake.retract();
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
