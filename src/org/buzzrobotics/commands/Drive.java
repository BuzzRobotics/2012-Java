/*
 * Go Completely Crazy
 * Drives bot around in circles
 */
package org.buzzrobotics.commands;


/**
 *
 * @author Kyle Deane
 */
public class Drive extends CommandBase {
    public double m_timeout;
    public double m_speed;
    public double m_turn;
    public Drive(double speed, double turn, double timeout) {
        m_timeout = timeout;
        m_speed = speed;
        m_timeout = timeout;
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(m_timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        drivetrain.drive(m_speed, m_turn);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
