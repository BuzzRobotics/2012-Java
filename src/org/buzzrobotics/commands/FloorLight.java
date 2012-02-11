package org.buzzrobotics.commands;

/**
 * @Param on TRUE OR FALSE
 * True is ON and FALSE is off.
 * Turns On Floor Light
 * ????? What is this for?
 * @author Peter Polis
 * @author Kyle Deane
 */

public class FloorLight extends CommandBase {
    public boolean light_on = false;
    public FloorLight(boolean on) {
        light_on = on;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (light_on){
            floorlight.on();
        }else{
            floorlight.off();
        }
        
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
