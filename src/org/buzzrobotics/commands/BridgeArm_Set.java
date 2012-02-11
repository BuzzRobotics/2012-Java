/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author Kyle Deane
 */
public class BridgeArm_Set extends CommandBase {
    public double m_setpoint;
    public BridgeArm_Set(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(bridgearm);
        m_setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        bridgearm.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        bridgearm.setSetpoint(m_setpoint);
        bridgearm.enable();
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
