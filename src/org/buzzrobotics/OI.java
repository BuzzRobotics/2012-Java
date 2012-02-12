package org.buzzrobotics;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.buzzrobotics.commands.*;
import org.buzzrobotics.subsystems.BallFeeder;
import edu.wpi.first.wpilibj.DriverStation;

/*
 * Operator Interface
 * @author PETER POLIS aka P^2
 * @author Zach Boyer
 * @author Kyle Deane
 * @author Buzz Robotics 2012 Programming Team
 */
public class OI {
    
    /*
     * Joystick 1 Button Definition
     * Left Joystick
     * @author Kyle Deane
     */

    DriverStation driver = DriverStation.getInstance();
    public double modebox = driver.getAnalogIn(1);
    public double yaled = driver.getAnalogIn(2);
    
    public int delay;
    public int mode;
    
    public AutoBallLoad autoBallLoad;
    Joystick leftJoy = new Joystick(2);
    Button lbutton1 = new JoystickButton(leftJoy, 1),
           lbutton2 = new JoystickButton(leftJoy, 2),
           lbutton3 = new JoystickButton(leftJoy, 3),
           lbutton4 = new JoystickButton(leftJoy, 4),
           lbutton5 = new JoystickButton(leftJoy, 5),
           lbutton6 = new JoystickButton(leftJoy, 6),
           lbutton7 = new JoystickButton(leftJoy, 7),
           lbutton8 = new JoystickButton(leftJoy, 8),
           lbutton9 = new JoystickButton(leftJoy, 9),
           lbutton10 = new JoystickButton(leftJoy, 10),
           lbutton11 = new JoystickButton(leftJoy, 11);
    
    /*
     * Joystick 2 Button Definitions
     * Right Joystick
     * @author Kyle Deane
     */
    Joystick rightJoy = new Joystick(1);
    Button rbutton1 = new JoystickButton(rightJoy, 1),
           rbutton2 = new JoystickButton(rightJoy, 2),
           rbutton3 = new JoystickButton(rightJoy, 3),
           rbutton4 = new JoystickButton(rightJoy, 4),
           rbutton5 = new JoystickButton(rightJoy, 5),
           rbutton6 = new JoystickButton(rightJoy, 6),
           rbutton7 = new JoystickButton(rightJoy, 7),
           rbutton8 = new JoystickButton(rightJoy, 8),
           rbutton9 = new JoystickButton(rightJoy, 9),
           rbutton10 = new JoystickButton(rightJoy, 10),
           rbutton11 = new JoystickButton(rightJoy, 11);
         
    
    /**
     * Bind the press of each button to a specific command or command group.
     * 
     * Right Button 1 (Pressed): Shift Up
     * Right Button 1 (Released): Shift Down
     * Right Button 4: Light On
     * Right Button 5: Light Off
     * @author Kyle Deane
     */
    /*
     * 
     * 
     * '
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public OI() {
        /*
         * Left
         */
        lbutton1.whenPressed(new Shooter_Fire());
        
        lbutton4.whenPressed(new Rollers_On(-1));
        lbutton4.whenReleased(new Rollers_Off());
        lbutton5.whenPressed(new Rollers_On(1));
        lbutton5.whenReleased(new Rollers_Off());
        
        lbutton6.whenPressed(new Shooter_Angle(1));
        lbutton7.whenPressed(new Shooter_Angle(3));
        lbutton8.whenPressed(new Shooter_Angle(5));     
        
        lbutton10.whenPressed(new MoveBallFeeder(1));
        lbutton10.whenReleased(new MoveBallFeeder(0));
        
        lbutton11.whenPressed(new InterruptAutoLoad());
        //LEFT Z - does nothing right now.
        
        /*
         * Right
         */
        rbutton1.whenPressed(autoBallLoad = new AutoBallLoad(1));
        rbutton9.whenPressed(new ToggleLight());
        lbutton3.whenPressed(new PickupArm_Toggle());
        rbutton4.whenPressed(new BridgeArm_Move(-1));
        rbutton4.whenReleased(new BridgeArm_Move(0));
        rbutton5.whenPressed(new BridgeArm_Move(1));
        rbutton5.whenReleased(new BridgeArm_Move(0));
        rbutton6.whenPressed(new ResetGyro());
        rbutton7.whileHeld(new BalanceBot());
        rbutton8.whenPressed(new Shifter_Toggle());
        rbutton10.whenPressed(new AdjustCamera(0.4,.26));  // ( Tilt, Pan) Target???
        rbutton11.whenPressed(new AdjustCamera(0.7, 1));   // ( Tilt, Pan) Ball????
        
        //RIGHT Z = Drive Sensitivity
       
                
        // LATCH INSTEAD rbutton4.whenPressed(new PickupArmRaise());
        
    }
    /*
     * getRightStick
     * Returns full value of joystick
     * @return rightJoy
     * @author Kyle Deane
     */
//    public Joystick getRightStick() {
//        return rightJoy;
//    }
    
    /*
     * getLeftStick
     * Retruns full value of left Joystick
     * @return leftJoy
     * @author KYle Deane
     */
//    public Joystick getLeftStick() {
//        return leftJoy;
//    }
    
    /**
     * @return The value of the left joystick Y axis.
     * @author Kyle Deane
     */
    public double getLeftY() {
        return leftJoy.getY();
    }

    
    /**
     * @return The value of the left joystick X axis
     * @author Kyle Deane
     */
    public double getLeftX() {
        return leftJoy.getX();
    }
    
    /**
     * @return The value of the right joystick Y axis.
     * @author Kyle Deane
     */
     public double getRightY() {
        return rightJoy.getY();
    }
     
    /**
     * @return The value of the right joystick X axis.
     * @author Kyle Deane
     */
    public double getRightX() {
        return rightJoy.getX();
    }

    /**
     * @return The value of the right joystick Z axis.
     * @author Kyle Deane
     */
    public double getRightZ() {
        return rightJoy.getZ();
    }
    /**
     * @return The value of the left joystick Z axis.
     * @author Kyle Deane
     */
    public double getLeftZ() {
        return leftJoy.getZ();
    }
    
    public int getDelay(){
        if (yaled == 0){
            delay = 0;
        }else if(yaled >= 0.5 && yaled <= 0.7){
            delay = 1;
        }else if(yaled >= 1.2 && yaled <= 1.4){
            delay = 4;
        }else if(yaled >= 1.8 && yaled <= 2.1){
            delay = 6;
        }else if(yaled >= 2.5 && yaled <= 2.8){
            delay = 8;
        }else if(yaled >= 3.0 && yaled <= 4.0){
            delay = 10;
        }
        System.out.println(delay);
        return delay;
        
    }
    
    public int getAutonMode(){
        if (modebox == 0){
            mode = 0;
        }else if(modebox >= 0.5 && modebox <= 0.7){
            mode = 1;
        }else if(modebox >= 1.2 && modebox <= 1.4){
            mode = 2;
        }else if(modebox >= 1.8 && modebox <= 2.1){
            mode = 3;
        }else if(modebox >= 2.5 && modebox <= 2.8){
            mode = 4;
        }else if(modebox >= 3.0 && modebox <= 4.0){
            mode = 5;
        }
        return mode;
    }
}

