/*
 * Shifter Subsystem
 * Controls Shifter solenoids.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author Kyle Deane
 */
public class Shifter extends Subsystem {
    DoubleSolenoid robotSolenoidShifter;
    public Shifter() {   
        robotSolenoidShifter = new DoubleSolenoid(1, RobotMap.solenoidShifterDeployPort, RobotMap.solenoidShifterRetractPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void up() {
        System.out.println("Shifted Reverse");
        robotSolenoidShifter.set(DoubleSolenoid.Value.kForward);
    }
    public void down() {
        System.out.println("Shifted Forward");
       robotSolenoidShifter.set(DoubleSolenoid.Value.kReverse);
    }
}
