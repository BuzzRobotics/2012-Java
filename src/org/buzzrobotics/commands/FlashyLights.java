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
public class FlashyLights extends CommandBase {
    
    public FlashyLights() {
     
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        brake.lightOff();
        irsensors.on1();
        Timer.delay(0.5);
        irsensors.off1();
        irsensors.on2();
        Timer.delay(0.5);
        irsensors.off2();
        brake.lightOn();
        Timer.delay(0.5);
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
