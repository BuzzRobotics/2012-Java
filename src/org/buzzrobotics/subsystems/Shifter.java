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
        SmartDashboard.putString("Shifter", "High");
        robotSolenoidShifter.set(DoubleSolenoid.Value.kForward);
    }
    public void down() {
        SmartDashboard.putString("Shifter", "Low");
       robotSolenoidShifter.set(DoubleSolenoid.Value.kReverse);
    }
}
