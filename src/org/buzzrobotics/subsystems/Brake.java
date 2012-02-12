/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author Kyle Deane
 */
public class Brake extends Subsystem {
    DoubleSolenoid robotBrake;
    public boolean brakestatus = false;
    
    public void Brake(){
        robotBrake = new DoubleSolenoid(RobotMap.brakeDeploy, RobotMap.brakeRetract);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void deploy(){
        brakestatus = true;
        robotBrake.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void retract(){
        brakestatus = false;
        robotBrake.set(DoubleSolenoid.Value.kReverse);
    }
    
//    public void off(){
//        brakestatus = false;
//        robotBrake.set(DoubleSolenoid.Value.kOff);
//    }
    /*
     * Toggle Brake
     */
    public void toggle(){
         if (!brakestatus){
            brakestatus = true;
            robotBrake.set(DoubleSolenoid.Value.kForward);
        }else{
            brakestatus = false;
            robotBrake.set(DoubleSolenoid.Value.kReverse);
        }
    }
    /*
     * Brake Status
     * @return brakestatus
     */
    public boolean status(){
        return brakestatus;
    }
}
