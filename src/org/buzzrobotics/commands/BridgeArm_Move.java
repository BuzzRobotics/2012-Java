/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author Kyle Deane
 */
public class BridgeArm_Move extends CommandBase {
    public double m_Direction;
    public BridgeArm_Move(double direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(bridgearm);
        m_Direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        bridgearm.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        bridgearm.move(m_Direction);
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
