package org.buzzrobotics.commands;

/**
 * Use either a button (or a mode) on the SmartDashboard to adjust the screw on the shooter.
 * @author Kyle Deane
 */
public class Shooter_Angle extends CommandBase {
    public double m_setpoint;
    public Shooter_Angle(int setpoint) {
        requires(shooterangle);
        m_setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      shooterangle.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
     //shooterangle.setSetpoint(m_setpoint);
     shooterangle.disable();  //when fixed, return to enable()
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        shooterangle.disable();
        return true; //have it return false in ideal conditions.
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
