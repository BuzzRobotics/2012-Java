/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class BalanceBot extends CommandBase {
    
    public BalanceBot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
        requires(gyro);
        requires(shifter);
    }
    double Kp = 0.03;

    // Called just before this Command runs the first time
    protected void initialize() {
        gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shifter.down();
        double angle = gyro.getGyroAngle();
        if (angle > 1){
            drivetrain.drive(0.2, 1.0);
        }else if (angle < -1){
            drivetrain.drive(-0.2, 1.0);
        }else{
            drivetrain.drive(0,0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
