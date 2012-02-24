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
    public double counter;
    public Shifter() {   
        robotSolenoidShifter = new DoubleSolenoid(1, RobotMap.solenoidShifterDeploy, RobotMap.solenoidShifterRetract);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    /*
     * Up
     * Sets shifter to high geer (forward)
     */
    public void up() {
        counter = counter + 1;
        shiftersw = true;
        robotSolenoidShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    /*
     * Down
     * Sets shifter to low geer (reverse)
     */
    public void down() {
       counter = counter + 1;
       shiftersw = false;
       robotSolenoidShifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    /*
     * Shifter Toggle
     * Smart Toggle :)
     */
    public void toggle(){
        counter = counter + 1;
        if (!shiftersw){
            robotSolenoidShifter.set(DoubleSolenoid.Value.kForward);
            shiftersw = true;
        }else{
            robotSolenoidShifter.set(DoubleSolenoid.Value.kReverse);
            shiftersw = false;
        }
    }
    
    /*
     * status
     * @return boolean shifter status
     */
    public boolean status(){
        return shiftersw;
    }
    /*
     * Reset Counter
     */
    public void resetCounter(){
        counter = 0;
    }
    /*
     * getCounter
     * @return double number of times the shifter shifted.
     */
    public double getCounter(){
        return counter;
    }
    
}
