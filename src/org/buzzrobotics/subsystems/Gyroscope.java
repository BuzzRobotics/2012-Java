/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;


import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author buzz5
 */
public class Gyroscope extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //Gyro gyro1;
    private Gyro gyro =  new Gyro(RobotMap.gyroPort);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void reset(){
        gyro.reset();
    }
    public double getGyroAngle(){
       return gyro.getAngle();
    }

   
}
