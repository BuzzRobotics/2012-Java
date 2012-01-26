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
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public DigitalInput getIRSensor(){
        return ir_sensor;
    }
}
