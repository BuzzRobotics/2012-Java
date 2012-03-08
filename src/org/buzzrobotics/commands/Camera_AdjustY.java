package org.buzzrobotics.commands;

/**
 * Adjusts Camera's Y axis. (On Motor Mount)
 * @author Kyle Deane
 */
public class Camera_AdjustY extends CommandBase {
    public double m_y = 1;
    public Camera_AdjustY(double y) {
        requires(camera);
        m_y = y;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        camera.setCameraY(m_y);
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
