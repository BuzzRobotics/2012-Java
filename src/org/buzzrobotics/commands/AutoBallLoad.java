package org.buzzrobotics.commands;



/**
 * Autonomously Loads Balls.
 * @author BUZZWS1
 */
public class AutoBallLoad extends CommandBase {
    public int m_Light;
    public AutoBallLoad(int Light) {
        m_Light = Light;
    
    
        //requires(ballfeeder);
        //requires(rollerarm);
        setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            rollerarm.turnOnRollers(-1);     //Turn on feeder and rollers
            ballfeeder.driveUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { 
        if (ir.getTopIRSensor() && (m_Light == 1)){
            m_Light = 2;
            return true;
        }else if(ir.getMiddleIRSensor() && (m_Light == 2)){
            m_Light = 1;
            return true;
        }else{
            return false;
        }
        
    }
    
    // Called once after isFinished returns true
    protected void end() {
        rollerarm.turnOffRollers();
        ballfeeder.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
