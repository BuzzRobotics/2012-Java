/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

/**
 *
 * @author Kyle Deane
 */
public class IRSensorFeed extends CommandBase {
    
    public IRSensorFeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        irsensors.off1();
        irsensors.off2();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (irsensors.getWallSensor()){
           irsensors.on1();
           irsensors.on2();
           brake.lightOn();
        }else{
            if(irsensors.getFloor1IRSensor()){
                irsensors.on1();
            }else{
                irsensors.off1();
            }
            if(irsensors.getFloor2IRSensor()){     
                irsensors.on2();
            }else{
                irsensors.off2();
            } 
            if (!brake.status()){
                brake.lightOff();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("IR SENSORS ENDED :O EPIC FAIL");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("IR SENSORS INTERRUPTED :O EPIC FAIL");
    }
}
