/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 *
 * @author buzz5
 */
public class RollerArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Jaguar rollers;
    DoubleSolenoid rollerArm;
    
    public RollerArm(){
        rollerArm = new DoubleSolenoid(RobotMap.rollerArmSolenoidDeploy, RobotMap.rollerArmSolenoidRetract);
        rollers = new Jaguar(RobotMap.rollerPWM);
}
    public void lower(){
        
            rollerArm.set(DoubleSolenoid.Value.kReverse);
        
}
    public void raise(){
        
            rollerArm.set(DoubleSolenoid.Value.kForward);
        
    }
    public void off(){
        rollerArm.set(DoubleSolenoid.Value.kOff);
    }
    public void turnOnRollers(int direction){
        rollers.set(direction);
    }
    public void turnOffRollers(int direction){
        rollers.set(direction);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}