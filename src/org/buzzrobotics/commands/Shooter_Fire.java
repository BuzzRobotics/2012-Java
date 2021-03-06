package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Fires Shooter
 * @author Kyle Deane
 */
public class Shooter_Fire extends CommandBase {
    
    public Shooter_Fire() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.out();
        Timer.delay(.5);
        shooter.in();
        System.out.println("FIRING.");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.in();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to r
    
    
    
    protected void interrupted() {
        shooter.in();
    }
}
