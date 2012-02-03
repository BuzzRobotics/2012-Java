/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author buzz5
 */
public class BallFeeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Jaguar ballFeederJaguar;
    
    public BallFeeder(){
        ballFeederJaguar = new Jaguar(6);
    }

    public void driveUp(){
        ballFeederJaguar.set(-1);
    }
    
    public void driveDown(){
        ballFeederJaguar.set(1);
    }
    
    public void stop(){
        ballFeederJaguar.set(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
