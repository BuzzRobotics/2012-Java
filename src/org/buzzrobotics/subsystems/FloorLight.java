/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author buzz5
 */
public class FloorLight extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay floor_light;
    public FloorLight(){
        floor_light = new Relay(2);
    }
    
    public void turnOnLight(){
        floor_light.set(Relay.Value.kForward);
    }
    
    public void turnOffLight(){
        floor_light.set(Relay.Value.kReverse);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
