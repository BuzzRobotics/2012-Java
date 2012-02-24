
package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Added our own DELAY pattern :)
 * @author Peter Polis
 * @author Kyle Deane
 */
public class Delay extends CommandBase {
    public double m_timeout;
    public Delay(int timeout) {
        m_timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(m_timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Delaying");
        System.out.println(Timer.getFPGATimestamp());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Delay Done!");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
