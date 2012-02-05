package org.buzzrobotics.commands;

/**
 * Controls the Light. Takes the parameter. True is on, false is off.sss
 * @author Kyle Deane
 */

public class Light extends CommandBase {
    boolean lighton = false;
    
    public Light(boolean on) {
        requires(light);
        lighton = on;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (lighton) {
            light.on();
        }else{
            light.off();
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
