package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.CommandBase;

/**
 * Brake Subsystem
 * @author Kyle Deane
 */
public class Brake extends Subsystem {
    Relay brakeLight = new Relay(RobotMap.brakelight);
    DoubleSolenoid robotBrake = new DoubleSolenoid(RobotMap.brakeDeploy, RobotMap.brakeRetract);
    public boolean brakestatus = false;
    
    
    public void Brake(){
    }

    public void initDefaultCommand() {
    }
    /*
     * Deploys Brake!
     * Stops Robot :O
     */
    public void deploy(){
        brakestatus = true;
        robotBrake.set(DoubleSolenoid.Value.kReverse);
        brakeLight.set(Relay.Value.kForward);
    }
    
    /*
     * Retracts Brake
     */
    public void retract(){
        brakestatus = false;
        robotBrake.set(DoubleSolenoid.Value.kForward);
        brakeLight.set(Relay.Value.kOff);
    }
    

    /*
     * Toggle Brake
     * Smart Toggle: uses information for previous settings (if something else DEPLOYED it you won't have to hit it twice)
     * 
     * 
     * BRAKE LIGHT OR KEYSENSOR LIGHT? WHICH IS IT!!!!!!!!!!!!!!!
     * 
     * Chill, I got this... - P
     */
    public void toggle(){
         if (!brakestatus){
            brakestatus = true;
            robotBrake.set(DoubleSolenoid.Value.kForward);
            brakeLight.set(Relay.Value.kForward);
        }else{
            brakestatus = false;
            robotBrake.set(DoubleSolenoid.Value.kReverse);
            brakeLight.set(Relay.Value.kOff);
        }
    }
    
    public void lightOn(){
        brakeLight.set(Relay.Value.kForward);
    }
    public void lightOff(){
        brakeLight.set(Relay.Value.kOff);
    }
   /*
    * status
    * @return boolean brakestatus
    */
    public boolean status(){
        return brakestatus;
    }
}
