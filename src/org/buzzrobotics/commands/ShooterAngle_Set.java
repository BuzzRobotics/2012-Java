/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class ShooterAngle_Set extends CommandBase {
     public double M_setpoint;
     public ShooterAngle_Set(double setpoint) {

       M_setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterangle.disable();
        setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooterangle.setSetpoint(M_setpoint);
        shooterangle.enable();
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (isTimedOut()){
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
