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
    public boolean m_on1;
    public boolean m_on2;
    public boolean m_on3;
    public lights(boolean on1, boolean on2, boolean on3) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        m_on1 = on1;
        m_on2 = on2;
        m_on3 = on3;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (m_on1){
        sensors.on1();
        }else{
        sensors.off1();
        }
        
        if (m_on2){
            sensors.on2();
        }else{
            sensors.off2();
        }
        
        if (m_on3){
            brake.lighton();
        }else{
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
