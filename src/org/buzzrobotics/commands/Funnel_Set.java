package org.buzzrobotics.commands;

/**
 * Sets Ball Funnel status
 * @author Kyle Deane
 */
public class Funnel_Set extends CommandBase {
    boolean m_position;
    public Funnel_Set(boolean position) {
        requires(funnel);
        m_position = position;
    }

    protected void initialize() {
    }


    protected void execute() {
        if (m_position){
            funnel.deploy();
        }else{
            funnel.retract();
        }
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
