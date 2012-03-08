package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.CommandBase;

/**
 * Shooter Angle
 * Uses screw (Controlled by Moter and POT) to limit how far the shooter catapult can go.
 * @author Kyle Deane
 */
public class ShooterAngle extends PIDSubsystem {

    private static final double Kp = 6;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    AnalogChannel ShooterPot;
    SpeedController ShooterAngleMotor;
    public ShooterAngle() {
        super("ShooterAngle", Kp, Ki, Kd);
        ShooterAngleMotor = new Jaguar(RobotMap.ShooterAngleMotor);
        ShooterPot = new AnalogChannel(RobotMap.ShooterPot);
        
        
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
      //  setDefaultCommand(new Shooter_Angle(3));
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
    public void driveUp(){
        ShooterAngleMotor.set(1);
    }
    public void driveDown(){
        ShooterAngleMotor.set(-1);
    }
    public void stop(){
        ShooterAngleMotor.set(0);
    }
}
