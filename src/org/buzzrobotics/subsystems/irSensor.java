package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import org.buzzrobotics.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Holds the key to all of the IR Sensors!
 * @author Kyle Deane
 * @author Peter Polis
 */
public class irSensor extends Subsystem {
    private DigitalInput Top_ir_sensor = new DigitalInput(RobotMap.top_opticalSensorPWM);
    private DigitalInput Middle_ir_sensor = new DigitalInput(RobotMap.middle_opticalSensorPWM);
    private DigitalInput Bottom_ir_sensor = new DigitalInput(RobotMap.bottom_opticalSensorPWM);
    private DigitalInput Feeder_ir_sensor = new DigitalInput(RobotMap.feeder_opticalSensorPWM);
    private DigitalInput LoadSensor = new DigitalInput(RobotMap.loadSensorPWM);

    private DigitalInput floor2 = new DigitalInput(RobotMap.floor2_opticalSensor);
    private DigitalInput floor1 = new DigitalInput(RobotMap.floor1_opticalSensor);


    public void initDefaultCommand() {

    }

    public boolean getTopIRSensor(){
        return Top_ir_sensor.get();
    } 

    public boolean getMiddleIRSensor(){
        return Middle_ir_sensor.get();
    } 

    public boolean getBottomIRSensor(){
        return Bottom_ir_sensor.get();
    }

    public boolean getFeederIRSensor(){
        return Feeder_ir_sensor.get();
    }

    public boolean getFloor1IRSensor(){
        boolean floor1stat = floor1.get();
        return !floor1stat;
    }

    public boolean getFloor2IRSensor(){
        boolean floor2stat = floor2.get();
        return !floor2stat;
    }

    public boolean getLoadSensor(){
        return LoadSensor.get();
    }
}
