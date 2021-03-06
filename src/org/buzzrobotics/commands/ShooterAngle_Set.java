/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author buzz5
 */
public class ShooterAngle_Set extends CommandBase {
     public double startpoint;
     public ShooterAngle_Set() {
           requires(shooterangle);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       startpoint = shooterangle.getPosition();
       
       shooterangle.setSetpoint(startpoint);
       shooterangle.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Setpoint: " + shooterangle.getSetpoint() + "  Joystick Pos: " + oi.getLeftX());
            if (oi.getLeftX() >= .9){
                shooterangle.shot3();
            }
            if (oi.getLeftX() >= .25 && oi.getLeftX() <= .75){
                shooterangle.shot2();
            }
            if (oi.getLeftX() >= -0.25 && oi.getLeftX() <= .25){
                shooterangle.shot1();
            }
            if (oi.getLeftX() <= -0.75){
                if (oi.getLeftY() >= 0.8){
                    shooterangle.jogDown();
                }
                if (oi.getLeftY() <= -0.8){
                    shooterangle.jogUp();
                }
            }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
