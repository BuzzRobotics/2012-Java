package org.buzzrobotics.commands;
/*
 * @param speed how fast the robot should go
 * @param turn how much turn the bot should have. 0 is straight.
 * @param timeout 
 * @author Kyle Deane
 */
public class Drive_Time_Turn extends CommandBase {
    public double m_timeout;
    public double m_speed;
    public double m_turn;
    /*
     * Drive - drives the specified speed with the specified turn for the specified time
     * @param speed the speed the wheels turn 
     * @param turn how much turn goes on that side.
     * @param timeout how long to drive for
     * 
     * @author Kyle Deane
     */
    public Drive_Time_Turn(double speed, double turn, double timeout) {
        m_turn = turn;
        m_speed = speed;
        m_timeout = timeout;
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(m_timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.drive(m_speed, m_turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("isTimedOut = true");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
