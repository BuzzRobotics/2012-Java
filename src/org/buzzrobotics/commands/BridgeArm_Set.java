/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class BridgeArm_Set extends CommandBase {
     public double M_setpoint;
     public BridgeArm_Set(double setpoint) {

       M_setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        bridgearm.disable();
       // setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        bridgearm.setSetpoint(M_setpoint);
        bridgearm.enable();
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        if (isTimedOut()){
//            return true;
//        }else{
//            return false;
//        }
        if (bridgearm.getPosition() + 0.1 >= bridgearm.getSetpoint() && bridgearm.getPosition() - 0.1 <= bridgearm.getSetpoint()){
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
        bridgearm.disable();
    }
}
