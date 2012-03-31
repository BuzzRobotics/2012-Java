package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendablePIDController;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.CommandBase;
import org.buzzrobotics.commands.ShooterAngle_Set;

/**
 * Shooter Angle
 * Uses screw (Controlled by Moter and POT) to limit how far the shooter catapult can go.
 * @author Kyle Deane
 */
public class ShooterAngle extends PIDSubsystem {

    private static final double Kp = 5;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    AnalogChannel ShooterPot;
    SpeedController ShooterAngleMotor;
    
    public ShooterAngle() {
        super("ShooterAngle", Kp, Ki, Kd);
        ShooterAngleMotor = new Jaguar(RobotMap.ShooterAngleMotor);
        ShooterPot = new AnalogChannel(RobotMap.ShooterPot);
        setSetpointRange(1.09, 3.79);
        double startpos = returnPot();
        setSetpoint(startpos);
        enable(); //possibly might need to be removed. i can set it to enable on the first run.
      
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
      //  setDefaultCommand(new Shooter_Angle(3));
        setDefaultCommand(new ShooterAngle_Set());
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
    public void jogUp() {
        setSetpointRelative(-.1);
    }
    public void jogDown() {
        setSetpointRelative(.1);
    }
    
    
    
    
    
    
     public void shot1() {
        setSetpoint(3.64);  //1.09
     }
     
     public void shot2() {
         setSetpoint(1.65); //1.602?
     }
     public void shot3() {
         setSetpoint(1.09);  
     }  
     
     public boolean atSetpoint() {
        return Math.abs(getPosition() - getSetpoint()) < .1;
    }
}
     

