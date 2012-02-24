package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Auto Mode 0 - Does Nothing.
 * @author Kyle Deane
 * @author Peter Polis
 * @author Zachary Boyer
 */
public class Nothing extends CommandBase {
    int m_autoPeriodicLoops;
    public Nothing() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        m_autoPeriodicLoops = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){

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
