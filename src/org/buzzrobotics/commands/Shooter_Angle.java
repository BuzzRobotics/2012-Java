/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class Shooter_Angle extends CommandBase {
    public double m_setpoint;
    public Shooter_Angle(int setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooterangle);
        m_setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      shooterangle.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
     shooterangle.setSetpoint(m_setpoint);
     shooterangle.enable();
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
