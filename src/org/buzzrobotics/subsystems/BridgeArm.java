package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.RobotMap;
import org.buzzrobotics.commands.CommandBase;

/**
 * Shooter Angle
 * Uses screw (Controlled by Motor and POT) to limit how far the shooter catapult can go.
 * @author Kyle Deane
 */
public class BridgeArm extends Subsystem {

    AnalogChannel BridgeArmPot;
    SpeedController BridgeArmMotor;
    public BridgeArm() {
        BridgeArmMotor = new Jaguar(RobotMap.BridgeArmMotor);
        BridgeArmPot = new AnalogChannel(RobotMap.BridgeArmPot);
       // SmartDashboard.putDouble("ShooterPot: ", BridgeArmPot.getVoltage());
      
    }
    
    public void initDefaultCommand() {

    }
    
    protected double returnPIDInput() {
        return BridgeArmPot.getVoltage();
    }
    
    public void driveUp() {
        BridgeArmMotor.set(1);
    }
    public void driveDown() {
        BridgeArmMotor.set(-1);
    }
    public void stop() {
        BridgeArmMotor.set(0);
    }
    public double returnPot(){
       return BridgeArmPot.getVoltage();
    }
}
