/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Kyle Deane
 */
public class Brake_Down extends CommandBase {
    
    public Brake_Down() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(brake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        brake.deploy();
        
        floorlight.on();
        Timer.delay(.08);
        floorlight.off();
        Timer.delay(.08);
        floorlight.light2on();
        Timer.delay(.08);
        floorlight.light2off();
        Timer.delay(.08);
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
