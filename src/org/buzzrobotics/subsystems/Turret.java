/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.buzzrobotics.RobotMap;

/**
 *
 * @author buzz5
 */
public class Turret extends PIDSubsystem {

    private static final double Kp = 6;
    private static final double Ki = 0;
    private static final double Kd = 0;
    
    AnalogChannel turretpot;
    SpeedController turret;
    
    public static final double FORWARD = 2.5;
    // Initialize your subsystem here
    public Turret() {
        super("Turret", Kp, Ki, Kd);
        turret = new Jaguar(RobotMap.turretMotor);
        turretpot = new AnalogChannel(RobotMap.TurretPot);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        setSetpoint(FORWARD);
        enable();
        //System.out.println(turretpot.getVoltage());
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
       // System.out.println(turretpot.getVoltage());
        return turretpot.getVoltage();
    }
    
    protected void usePIDOutput(double output) {
        turret.set(output);
    }
}
