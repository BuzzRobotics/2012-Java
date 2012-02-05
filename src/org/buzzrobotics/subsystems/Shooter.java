package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author Kyle Deane
 */
public class Shooter extends Subsystem {
    DoubleSolenoid robotShooter;
    public Shooter(){
        robotShooter = new DoubleSolenoid(1, RobotMap.solenoidShooterExtend, RobotMap.solenoidShooterRetract);
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
    
}
