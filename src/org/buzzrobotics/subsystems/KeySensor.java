package org.buzzrobotics.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Ultrasonic;
import org.buzzrobotics.RobotMap;

/**
 * Floor Light Sensor
 * Shows that we are on KEY.
 * @author Peter Polis
 * 
 *///smahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
public class KeySensor extends Subsystem {
    public boolean lighton;
    Relay floor_light;
    Relay floor_light2;
    Relay sonarLight;
    AnalogChannel sonarSensor;
    private DigitalInput floor2 = new DigitalInput(RobotMap.floor2_opticalSensor);
    private DigitalInput floor1 = new DigitalInput(RobotMap.floor1_opticalSensor);
    
    
    public KeySensor(){
        floor_light = new Relay(RobotMap.FloorLightRelayPort);
        floor_light2 = new Relay(RobotMap.FloorLight2RelayPort);
        sonarSensor = new AnalogChannel(RobotMap.sonarPort);
        sonarLight = new Relay(7);      //Put this in the Robotmap later...
    }
    public double getSonarSensor(){
        return sonarSensor.getAverageVoltage();
        
    }
    
    /*
     * Turns floor Light 1 On
     */
    public void on1(){
        lighton = true;
        floor_light.set(Relay.Value.kForward);
    }
    
    /*
     * Turns floor Light 1 Off
     */
    public void off1(){
        lighton = false;
        floor_light.set(Relay.Value.kOff);
    }
    
    /*
     * Turns floor Light 2 On
     */
    public void on2(){
        floor_light2.set(Relay.Value.kForward);
    }
    
    /*
     * Turns floor Light 2 Off
     */
    public void off2(){
        floor_light2.set(Relay.Value.kOff);
    }
    
    /*
     * Returns light 1's status
     */
    public boolean status(){
        return lighton;
    }
    
    public void sonarLightOn(){
        sonarLight.set(Relay.Value.kForward);
    }
    
    public void sonarLightOff(){
        sonarLight.set(Relay.Value.kOff);
    }

    /*
     * Returns an inverse of the floor sensor 1
     * @return false if nothings present
     * @return true if its triggered
     */
    public boolean getFloor1IRSensor(){
        boolean floor1stat = floor1.get();
        return !floor1stat;
    }

    /*
     * Returns an inverse of the floor sensor 2
     * @return false if nothings present
     * @return true if its triggered
     */
    public boolean getFloor2IRSensor(){
        boolean floor2stat = floor2.get();
        return !floor2stat;
    }
    
    public void initDefaultCommand() {
       
    }
}
