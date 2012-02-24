package org.buzzrobotics.commands;

/**
 * Loads Loader. Drives it for 1.5 seconds. :)
 * @author Kyle Deane
 */
public class Loader_Load extends CommandBase {
    
        public double shooterTimeOut = 1.5;
    
    public Loader_Load() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(shooterTimeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.load();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
//         if (ir.getLoadSensor()){
//            return true;
//        }else{
//            return false;
//        }
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.stopload();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
