/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author Kyle Deane
 */
public class lights extends CommandBase {
    public boolean m_on;
    public lights(boolean on) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        m_on = on;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (m_on){
        keysensor.on2();
        keysensor.on1();
        brake.lighton();
        }else{
        keysensor.off2();
        keysensor.off1();
        brake.lightoff();  
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
