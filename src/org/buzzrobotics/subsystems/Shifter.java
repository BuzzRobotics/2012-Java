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
    public Shifter() {   
        robotSolenoidShifter = new DoubleSolenoid(1, RobotMap.solenoidShifterDeploy, RobotMap.solenoidShifterRetract);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void up() {
        SmartDashboard.putString("Shifter", "High");
        robotSolenoidShifter.set(DoubleSolenoid.Value.kForward);
    }
    public void down() {
        SmartDashboard.putString("Shifter", "Low");
       robotSolenoidShifter.set(DoubleSolenoid.Value.kReverse);
    }
}
