/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author buzz5
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    DoubleSolenoid robotShooter;
    public Shooter(){
        robotShooter = new DoubleSolenoid(1, RobotMap.solenoidShooterExtend, RobotMap.solenoidShooterRetract);
    }
    public void initDefaultCommand() {
        
    }
    
    public void in(){
        SmartDashboard.putString("Shooter", "Down");
        robotShooter.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void out(){
        SmartDashboard.putString("Shooter", "Out");
        robotShooter.set(DoubleSolenoid.Value.kForward);
    }
    
}
