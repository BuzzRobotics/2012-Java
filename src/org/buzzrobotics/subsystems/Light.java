/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author Kyle Deane
 */
public class Light extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay relay_light;
    public Light() {   
        relay_light = new Relay(RobotMap.lightrelay);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /*
     * @param I Whip My Hair Back and Forth
     * @author Kyle Deane
     */
    public void on() {
        SmartDashboard.putString("Light", "I WHIP MY HAIR BACK AND FORTH!");
        relay_light.set(Relay.Value.kForward);
    }
    
    /*
     * @param I Don't Whip My Hair Back and Forth
     * @author Kyle Deane
     */
    public void off() {
        SmartDashboard.putString("Light", "Off");
        relay_light.set(Relay.Value.kOff);
    }
}
