package org.buzzrobotics.commands;

/**
 * Sets Ball Funnel status
 * @author Kyle Deane
 */
public class Funnel_Set_Custom extends CommandBase {
    double m_position;
    public Funnel_Set_Custom(double position) {
        requires(funnel);
        m_position = position;
    }

    protected void initialize() {
    }


    protected void execute() {
        funnel.custom(m_position);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
