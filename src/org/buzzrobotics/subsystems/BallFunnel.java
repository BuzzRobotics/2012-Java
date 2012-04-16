/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author Kyle Deane
 */
public class BallFunnel extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Servo floorLoader = new Servo(RobotMap.FunnelServo);
    public int status;
    public BallFunnel(){
        
    }
    public void deploy(){
        floorLoader.set(1.0);
        status = 1;
    }
    public void retract(){
        status = 0;
        floorLoader.set(0.0);
    }
    public void custom(double position){
        floorLoader.set(position);
        status = 3;
    }
    public int status(){
        return status();
    }
    public double position(){
        return floorLoader.get();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}
