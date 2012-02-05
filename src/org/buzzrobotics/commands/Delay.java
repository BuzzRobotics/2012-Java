
package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * (Attempted to) Implement a nice delay pattern here. It obviously didn't work well. :)
 * @author Peter Polis
 * @author Kyle Deane
 */
public class Delay extends CommandBase {
    public double m_yaledTime;
    public Delay(int yaled) {
        m_yaledTime = yaled;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Start Delay");
        Timer.delay(m_yaledTime);
        m_yaledTime = 0;
        System.out.println("End");
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
