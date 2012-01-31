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
public class Nothing extends CommandBase {
    int m_autoPeriodicLoops;
    public Nothing() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
        requires(light);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        m_autoPeriodicLoops = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
            light.on();
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
