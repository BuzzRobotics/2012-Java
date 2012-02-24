package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Rollers
 * @author Peter Polis
 */
public class Rollers extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Jaguar rollers;
    public double rollerdirection = 0;
    public boolean rollerstatus;
    public boolean v;
    
    public Rollers(){
        rollers = new Jaguar(RobotMap.rollerPWM);
    }
    
    /*
     * Turn on Rollers
     * @param Direction
     */
    public void turnOnRollers(int direction){
        SmartDashboard.putString("Rollers", "On");
        if (direction > 0){
            rollerdirection = 1;
        }else if (direction < 0){
            rollerdirection = -1;
        }else if (direction == 0){
            rollerdirection = 0;
        }
        rollers.set(direction);
    }
    
    /*
     * Turn Off Rolers
     */
    public void turnOffRollers(){
        rollers.set(0);
        rollerdirection = 0;
    }
    
    public double getRollerDirection(){
        return rollerdirection;
    }
    public boolean status(){
        return rollerstatus;
    }
    public void initDefaultCommand() {
    
    }
}