/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class Load extends CommandBase {
    
    public Load() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.load();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         if (ir.getLoadSensor()){
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.stopload();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
