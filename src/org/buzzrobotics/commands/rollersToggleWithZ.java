package org.buzzrobotics.commands;

/**
 * Turns rollers on.
 * @author Peter Polis
 */
public class rollersToggleWithZ extends CommandBase {
    public double leftZ;
    public int m_direction;
    public rollersToggleWithZ() {
        // Use requires() here to declare subsystem dependencies
        requires(rollerarm);
        //m_direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        leftZ = oi.getLeftZ();  
        if(leftZ >= 0){
            m_direction = 1;
        }else{
            m_direction = -1;
        }
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        rollerarm.turnOnRollers(m_direction);

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
