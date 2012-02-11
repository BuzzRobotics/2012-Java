package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Roller Arm
 * @author Peter Polis
 */
public class RollerArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Jaguar rollers;
    DoubleSolenoid rollerArm;
    public double rollerdirection = 0;
    public boolean rollerstatus;
    
    public RollerArm(){
        rollerArm = new DoubleSolenoid(RobotMap.rollerArmSolenoidDeploy, RobotMap.rollerArmSolenoidRetract);
        rollers = new Jaguar(RobotMap.rollerPWM);
}
    /*
     * Lower Roller Arm
     */
    public void lower(){
        rollerstatus = true;
        
            rollerArm.set(DoubleSolenoid.Value.kReverse);
        
}
    
    /*
     * Raise Roller Arm
     */
    public void raise(){
        rollerstatus = false;
            rollerArm.set(DoubleSolenoid.Value.kForward);
        
    }
    /*
     * Turn Off Solenoid?
     */
    public void off(){
        rollerArm.set(DoubleSolenoid.Value.kOff);
    }
    
    /*
     * Turn on Rollers
     * @param Direction
     */
    public void turnOnRollers(int direction){
        SmartDashboard.putString("Rollers", "On");
        if (direction > 0){
            rollerdirection = 1;
        }else if (direction < 0){
            rollerdirection = -1;
        }else if (direction == 0){
            rollerdirection = 0;
        }
        rollers.set(direction);
    }
    
    /*
     * Turn Off Rolers
     */
    public void turnOffRollers(){
        rollers.set(0);
        rollerdirection = 0;
    }
    
    public double getRollerDirection(){
        return rollerdirection;
    }
    public boolean status(){
        return rollerstatus;
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}