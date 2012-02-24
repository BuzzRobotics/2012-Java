/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author buzz5
 */
public class Lights_Flashy extends CommandBase {
    
    
    public Lights_Flashy() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        keysensor.on1();
        Timer.delay(.08);
        keysensor.off1();
        Timer.delay(.08);
        keysensor.on2();
        Timer.delay(.08);
        keysensor.off2();
        Timer.delay(.08);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
