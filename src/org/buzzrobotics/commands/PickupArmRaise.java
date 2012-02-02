/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class PickupArmRaise extends CommandBase {
        
        int rollerArmPotRaiseLimit = 4;
    
    public PickupArmRaise() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        rollerarm.raise();
        double rollerarmpot = rollerarm.getPotVoltage();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (rollerarm.getPotVoltage() >= rollerArmPotRaiseLimit){
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
