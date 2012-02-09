package org.buzzrobotics.commands;

/**
 * Turns rollers on.
 * @author Peter Polis
 */
public class Rollers_On extends CommandBase {
    public int m_direction;
    public Rollers_On(int direction) {
        // Use requires() here to declare subsystem dependencies
        requires(rollerarm);
        direction = m_direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        if(m_direction == 0){
//            m_direction = 1;
//        }else{
//            m_direction = 0;
//        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        rollerarm.turnOnRollers(m_direction);
        ballfeeder.driveUp();
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
