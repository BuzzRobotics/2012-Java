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
        setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        bridgearm.setSetpoint(m_setpoint);
        bridgearm.enable();
        //System.out.println("BRIDGE ARM MOVING." + bridgearm.getPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(isTimedOut()){
            return true;
        }else if (bridgearm.getPosition() == (bridgearm.getSetpoint())){
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        bridgearm.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
