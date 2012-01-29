/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.CommandBase;
import org.buzzrobotics.commands.Shooter_Angle;

/**
 *
 * @author buzz5
 */
public class ShooterAngle extends PIDSubsystem {

    private static final double Kp = 6;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    AnalogChannel ShooterPot;
    SpeedController ShooterAngleMotor;
    // Initialize your subsystem here
    public ShooterAngle() {
        super("ShooterAngle", Kp, Ki, Kd);
        ShooterAngleMotor = new Jaguar(RobotMap.ShooterAngleMotor);
        ShooterPot = new AnalogChannel(RobotMap.ShooterPot);
        SmartDashboard.putDouble("ShooterPot: ", ShooterPot.getVoltage());
       
        
        
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Shooter_Angle(5));
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return ShooterPot.getVoltage();
    }
    
    protected void usePIDOutput(double output) {
        ShooterAngleMotor.set(-output);
    }
    public double returnPot(){
       return ShooterPot.getVoltage();
    }
}
