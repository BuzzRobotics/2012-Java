package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;

/**
 * Ball Feeder Subsystem.
 * @author Peter Polis
 */
public class BallFeeder extends Subsystem {

    Jaguar ballFeederJaguar;
    
    public BallFeeder(){
        ballFeederJaguar = new Jaguar(6);
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
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
