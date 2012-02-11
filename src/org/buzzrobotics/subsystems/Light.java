package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;

/**
 * I Whip my Hair Back and Forth!
 * @author Kyle Deane
 */
public class Light extends Subsystem {
    public boolean lighton;
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
        lighton = true;
        relay_light.set(Relay.Value.kForward); 
    }
    
    /*
     * @param I Don't Whip My Hair Back and Forth
     * @author Kyle Deane
     */
    public void off() {
        lighton = false;
        relay_light.set(Relay.Value.kOff);
    }
    
    public void toggle(){
         if (!lighton){
            lighton = true;
            relay_light.set(Relay.Value.kForward);
            
        }else{
            relay_light.set(Relay.Value.kOff);
            lighton = false;
        }
    }
    public boolean status(){
        return lighton;
    }
}
