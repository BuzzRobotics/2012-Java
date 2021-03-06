package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;

/**
 * Contains Shooter Stuffs
 * Uses Solenoid and a Jaguar for the Loader Motor.
 * @author Kyle Deane
 */
public class Shooter extends Subsystem {
    DoubleSolenoid robotShooter;
    Jaguar loadMotor;
    
    public boolean shooterstatus;
    
    public Shooter(){
        robotShooter = new DoubleSolenoid(1, RobotMap.solenoidShooterExtend, RobotMap.solenoidShooterRetract);
        loadMotor = new Jaguar(RobotMap.loadMotorPWM);  //3
    }
    
    public void initDefaultCommand() {
        
    }
    
    /*
     * FALSE = IN
     * Retracts Shooter
     */
    public void in(){
        shooterstatus = false;
        robotShooter.set(DoubleSolenoid.Value.kReverse);
    }
    
    /*
     * Deploys Shooter pneumatic thingy!
     */
    public void out(){
        shooterstatus = true;
        robotShooter.set(DoubleSolenoid.Value.kForward);
    }
    
    /*
     * Load
     * sets motor forward at half speed.
     */
    public void load(){
        loadMotor.set(0.5);
    }
    /*
     * reverse
     * Drives the loader in REVERSE at FULL sspeed
     */
    public void reverse(){
        loadMotor.set(-1);
    }
    /*
     * Stop
     * stops the loader
     */
    public void stopload(){
        loadMotor.set(0);
    }
    
    /*
     * status
     * @return boolean shooter status
     */
    public boolean status(){
       return shooterstatus;
    }
}


