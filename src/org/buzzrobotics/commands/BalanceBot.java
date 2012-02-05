package org.buzzrobotics.commands;

/**
 * Balances Robot using Gyroscope (For Now). Would like to implement Accelerometer.
 * @author Kyle Deane
 */
public class BalanceBot extends CommandBase {
    
    public BalanceBot() {
        requires(drivetrain);
        requires(shifter);
    }
    double Kp = 0.03;

    // Called just before this Command runs the first time
    protected void initialize() {
       // gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shifter.down();
        double angle = drivetrain.getGyroAngle();
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
