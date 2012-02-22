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
    private DigitalInput floor2 = new DigitalInput(RobotMap.floor2_opticalSensor);
    private DigitalInput floor1 = new DigitalInput(RobotMap.floor1_opticalSensor);


    public void initDefaultCommand() {

    }

   

    public boolean getFloor1IRSensor(){
        boolean floor1stat = floor1.get();
        return !floor1stat;
    }

    public boolean getFloor2IRSensor(){
        boolean floor2stat = floor2.get();
        return !floor2stat;
    }

}
