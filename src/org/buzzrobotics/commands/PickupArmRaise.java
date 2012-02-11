package org.buzzrobotics.commands;

/**
 * Raises Pickup Arm
 * @author Peter Polis
 */
public class PickupArmRaise extends CommandBase {
        
    public PickupArmRaise() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        rollerarm.raise();
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
