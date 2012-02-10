package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Kyle Deane
 */
public class Shooter extends Subsystem {
    DoubleSolenoid robotShooter;
    Jaguar loadMotor;
    public Shooter(){
        robotShooter = new DoubleSolenoid(1, RobotMap.solenoidShooterExtend, RobotMap.solenoidShooterRetract);
        loadMotor = new Jaguar(RobotMap.loadMotorPWM);  //3
    }
    
    public void initDefaultCommand() {
        
    }
    
    /*
     * Retracts Shooter
     */
    public void in(){
        SmartDashboard.putString("Shooter", "Down");
        robotShooter.set(DoubleSolenoid.Value.kReverse);
    }
    /*
     * Deploys Shooter pneumatic thingy!
     */
    public void out(){
        SmartDashboard.putString("Shooter", "Out");
        robotShooter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void load(){
        loadMotor.set(-.5);
    }
    public void stopload(){
        loadMotor.set(0);
   
    }
}


