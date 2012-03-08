package org.buzzrobotics.commands;

/**
 * Adjusts Camera according to the x and y parameters.
 * @author buzz5
 */
public class Camera_AdjustXY extends CommandBase {
    public double m_x = 1;
    public double m_y = 1;
    public Camera_AdjustXY(double x, double y) {
        // Use requires() here to declare subsystem dependencies
        requires(camera);
        m_x = x;
        m_y = y;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        camera.setCamera(m_x, m_y);
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
