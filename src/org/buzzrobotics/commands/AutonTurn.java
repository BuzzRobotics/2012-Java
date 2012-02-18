/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author kyledeane
 */
public class AutonTurn extends CommandBase {
        public int m_direction;
    public AutonTurn(int direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        m_direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(m_direction > 0){
            drivetrain.drive(0, 0.3);
        }else{
            drivetrain.drive(0, -0.3);            
        }
}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(drivetrain.getLeftEncoder() - drivetrain.getRightEncoder()) > 100){     //
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
