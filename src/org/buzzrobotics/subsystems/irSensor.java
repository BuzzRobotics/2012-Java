/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author buzz5
 */
public class irSensor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
private DigitalInput ir_sensor = new DigitalInput(RobotMap.opticalSensorPWM);
private DigitalInput Top_ir_sensor = new DigitalInput(RobotMap.top_opticalSensorPWM);
private DigitalInput Middle_ir_sensor = new DigitalInput(RobotMap.middle_opticalSensorPWM);
private DigitalInput Bottom_ir_sensor = new DigitalInput(RobotMap.bottom_opticalSensorPWM);
private DigitalInput Feeder_ir_sensor = new DigitalInput(RobotMap.feeder_opticalSensorPWM);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public boolean getIRSensor(){
        return ir_sensor.get();
    }
     public boolean getTopIRSensor(){
         return Top_ir_sensor.get();
         
    } public boolean getMiddleIRSensor(){
        return Middle_ir_sensor.get();
        
    } public boolean getBottomIRSensor(){
        return Bottom_ir_sensor.get();
    }
    public boolean getFeederIRSensor(){
        return Feeder_ir_sensor.get();
    }
}
