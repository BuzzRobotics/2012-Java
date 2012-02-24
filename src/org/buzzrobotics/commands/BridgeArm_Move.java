package org.buzzrobotics.commands;

/**
 * Moves Bridge Arm in the Specified Direction
 * @author Kyle Deane
 */
public class BridgeArm_Move extends CommandBase {
    public double m_Direction;
    
    public BridgeArm_Move(double direction) {
        requires(bridgearm);
        m_Direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //bridgearm.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       // bridgearm.move(m_Direction);
        if (m_Direction == 1){
            bridgearm.driveUp();
        }else if (m_Direction == -1){
            bridgearm.driveDown();
        }else{
            bridgearm.stop();
        }
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
