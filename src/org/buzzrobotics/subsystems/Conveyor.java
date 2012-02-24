package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import org.buzzrobotics.RobotMap;

/**
 * Ball Feeder Subsystem.
 * Also Controls Ball Feeder Door!
 * @author Peter Polis
 * @author Kyle Deane
 */
public class Conveyor extends Subsystem {
    DoubleSolenoid loaderDoor;
    Jaguar ballFeederJaguar;
    public boolean loaderDoorStatus;
     
    public Conveyor(){
        ballFeederJaguar = new Jaguar(RobotMap.ballFeederPWM);
        loaderDoor = new DoubleSolenoid(1, RobotMap.loaderDoorDeploy, RobotMap.loaderDoorRetract);
    }

    /*
     * Drives the Ball Feeder Reverse.
     */
    public void driveUp(){
        ballFeederJaguar.set(-1);
    }
    
    /*
     * Drives the Ball Feeder Forward.
     */
    public void driveDown(){
        ballFeederJaguar.set(1);
    }
    
    /*
     * Stops the ball feeder 
     */
    public void stop(){
        ballFeederJaguar.set(0);
    }
    
    /*
     * Opens Ball Feeder Door
     */
    public void openDoor(){
        loaderDoorStatus = true;
        loaderDoor.set(DoubleSolenoid.Value.kForward);
    }
    
    /*
     * Closes Ball Feeder Door
     */
    public void closeDoor(){
        loaderDoorStatus = false;
        loaderDoor.set(DoubleSolenoid.Value.kReverse);
    }
    
    /*
     * Toggles Ball Feeder Door
     * Smart Toggle :)
     * 
     */
    public void toggleDoor(){
         if (!loaderDoorStatus){
            loaderDoorStatus = true;
            loaderDoor.set(DoubleSolenoid.Value.kForward);
            
        }else{
            loaderDoor.set(DoubleSolenoid.Value.kReverse);
            loaderDoorStatus = false;
        }
        
    }
    
    /*
     * Door Status
     * @return boolean loaderdoorstatus
     */
    public boolean doorStatus(){
        return loaderDoorStatus;
    }
    public void initDefaultCommand() {
    }
}
