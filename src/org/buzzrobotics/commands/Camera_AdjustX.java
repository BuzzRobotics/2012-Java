package org.buzzrobotics.commands;

/*
 * Adjusts camera X
 * @author Kyle Deane
 */
public class Camera_AdjustX extends CommandBase {
    public double m_x = .5;
    public Camera_AdjustX(double x) {
        requires(camera);
        m_x = x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        camera.setCameraX(m_x);
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
