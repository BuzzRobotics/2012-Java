/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.buzzrobotics.commands;
import org.buzzrobotics.commands.CommandBase;
/**
 *
 * @author English
 */
public class AutonDrive extends CommandBase{

    private double inches_to_travel;
    public AutonDrive(double inches) {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        inches_to_travel = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.initController(); // Enables "drive straight" controller
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute(){
        drivetrain.driveStraight();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(drivetrain.getAvgDistance()) > inches_to_travel; // Check if we have traveled the right distance by encoder measure
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.endController();
        drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
