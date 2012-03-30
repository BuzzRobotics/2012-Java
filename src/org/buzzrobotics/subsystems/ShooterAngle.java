package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.ShooterAngle_Set;

/**
 * Shooter Angle
 * Uses screw (Controlled by Motor and POT) to limit how far the shooter catapult can go.
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
        enable();
      
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
     /*****************************************************************************
     * Do NOT CHANGE
     */
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterAngle_Set());
    }
    

    protected double returnPIDInput() {
        return ShooterPot.getVoltage();
    }
    
    protected void usePIDOutput(double output) {
        ShooterAngleMotor.set(-output);
    }
    /*
     * END DO NOT CHANGE
     *****************************************************************************/
    
    
    /*
     * returnPot
     * Returns the current Shooter Position
     */
    public double returnPot(){
       return ShooterPot.getVoltage();
       
    }
    
    /*
     * JogUp
     * Jogs the setpoint up relative to the current position.
     */
    public void jogUp() {
        setSetpointRelative(-.1);
    }
    
    /*
     * JogDown
     * Jogs the setpoint down relative to the current position.
     */
    public void jogDown() {
        setSetpointRelative(.1);
    }
    
/*
* Set Shots
*/
    /*
     * Shot 1
     * 3 Point Shot From Back of Key
     */
     public void shot1() {
        setSetpoint(3.64);  
     }
     
     /*
      * Shot 2
      * 2 Point Shot fron Bumper Fender
      */
     public void shot2() {
        setSetpoint(1.09);  
         
     }
     /*
      * Shot 3
      * 3 Point Shot from Bumper Fender, Brakes MUST BE DEPLOYED.
      */
     public void shot3() {
        setSetpoint(1.8);
     }
     
     /*
      * Boolean atSetpoint() 
      * Returns if the PID is at the Setpoint
      */
     public boolean atSetpoint() {
        return Math.abs(getPosition() - getSetpoint()) < .1;
    }
}
     

