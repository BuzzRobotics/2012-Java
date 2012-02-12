package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import org.buzzrobotics.RobotMap;

/**
 * Ball Feeder Subsystem.
 * @author Peter Polis
 */
public class BallFeeder extends Subsystem {
    DoubleSolenoid loaderDoor;
    Jaguar ballFeederJaguar;
    public boolean loaderDoorStatus;
     
    public BallFeeder(){
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
    
    public void openDoor(){
        //loaderDoorStatus = true;
        loaderDoor.set(DoubleSolenoid.Value.kForward);
    }
    public void closeDoor(){
        //loaderDoorStatus = false;
        loaderDoor.set(DoubleSolenoid.Value.kReverse);
    }
//    public void toggleDoor(){
//         if (!loaderDoorStatus){
//            loaderDoorStatus = true;
//            loaderDoor.set(DoubleSolenoid.Value.kForward);
//            
//        }else{
//            loaderDoor.set(DoubleSolenoid.Value.kReverse);
//            loaderDoorStatus = false;
//        }
//        
//    }
    public boolean doorStatus(){
        return loaderDoorStatus;
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
