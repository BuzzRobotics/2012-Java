/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class DriveToEncoderCount extends CommandBase {
    public double m_speed;
    public double m_turn;
    public double m_countDestination;
    public DriveToEncoderCount(double speed, double turn, double countDestination) {
        m_speed = speed;
        m_turn = turn;
        m_countDestination = countDestination;
        requires(drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.drive(m_speed, m_turn);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.getEncoderCounts() >= m_countDestination);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
