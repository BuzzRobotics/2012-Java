/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;


/**
 *
 * @author buzz5
 */
public class RollerArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Jaguar rollers;
    Jaguar rollerArm;
    AnalogChannel rollerArmPot;
    double rollerArmMax = 1.5;
    double rollerArmMin = 1;
    public RollerArm(){
        rollerArm = new Jaguar(RobotMap.rollerArmPWM);
        rollers = new Jaguar(RobotMap.rollerPWM);
        rollerArmPot = new AnalogChannel(RobotMap.rollerArmPotPort);
}
    public void lower(){
        
            rollerArm.set(-1);
        
}
    public void raise(){
        
            rollerArm.set(1);
        
    }
    public void turnOnRollers(){
        rollers.set(-1);
    }
    public void turnOffRollers(){
        rollers.set(0);
    }
    public double getPotVoltage(){
        return rollerArmPot.getVoltage();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
