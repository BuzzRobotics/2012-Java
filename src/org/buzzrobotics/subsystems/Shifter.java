/*
 * Shifter Subsystem
 * Controls Shifter solenoids.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;

/**
 * Shifter Subsystem
 * Exactly what a BEAUTIFUL subsystem should look like (:
 * @author Kyle Deane
 */
public class Shifter extends Subsystem {
    DoubleSolenoid robotSolenoidShifter;
    public boolean shiftersw = false;
    public Shifter() {   
        robotSolenoidShifter = new DoubleSolenoid(1, RobotMap.solenoidShifterDeploy, RobotMap.solenoidShifterRetract);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void up() {
        shiftersw = true;
        robotSolenoidShifter.set(DoubleSolenoid.Value.kForward);
    }
    public void down() {
        shiftersw = false;
       robotSolenoidShifter.set(DoubleSolenoid.Value.kReverse);
    }
    public void toggle(){
        if (!shiftersw){
            robotSolenoidShifter.set(DoubleSolenoid.Value.kForward);
            shiftersw = true;
        }else{
            robotSolenoidShifter.set(DoubleSolenoid.Value.kReverse);
            shiftersw = false;
        }
    }
    public boolean status(){
        return shiftersw;
    }
}
