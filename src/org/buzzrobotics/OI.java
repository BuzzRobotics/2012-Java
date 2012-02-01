package org.buzzrobotics;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.buzzrobotics.commands.ShiftUp;
import org.buzzrobotics.commands.ShiftDown;
import org.buzzrobotics.commands.LightOn;
import org.buzzrobotics.commands.LightOff;
import org.buzzrobotics.commands.ToggleLight;
import org.buzzrobotics.commands.Shooter_In;
import org.buzzrobotics.commands.Shooter_Out;
import org.buzzrobotics.commands.Shooter_Fire;
import org.buzzrobotics.commands.BalanceBot;
import org.buzzrobotics.commands.ResetGyro;
import org.buzzrobotics.commandgroups.whip;
import org.buzzrobotics.commands.TurnOnRollers;
import org.buzzrobotics.commands.*;


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
    Joystick leftJoy = new Joystick(2);
    Button lbutton1 = new JoystickButton(leftJoy, 1),
           lbutton2 = new JoystickButton(leftJoy, 2),
           lbutton3 = new JoystickButton(leftJoy, 3),
           lbutton4 = new JoystickButton(leftJoy, 4),
           lbutton5 = new JoystickButton(leftJoy, 5),
           lbutton6 = new JoystickButton(leftJoy, 6),
           lbutton7 = new JoystickButton(leftJoy, 7),
           lbutton8 = new JoystickButton(leftJoy, 8);
    
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
           rbuttonUp = new JoystickButton(rightJoy, 128),
           rbuttonDn = new JoystickButton(rightJoy, 132);
    
    /**
     * Bind the press of each button to a specific command or command group.
     * 
     * Right Button 1 (Pressed): Shift Up
     * Right Button 1 (Released): Shift Down
     * Right Button 4: Light On
     * Right Button 5: Light Off
     * @author Kyle Deane
     */
    public OI() {
        rbutton1.whenPressed(new ShiftDown());
        rbutton1.whenReleased(new ShiftUp());
        lbutton1.whenPressed(new Shooter_Out());
        lbutton1.whenReleased(new Shooter_In());
        rbutton2.whenPressed(new ToggleLight()); 
        lbutton2.whenPressed(new Shooter_Fire());
        rbutton3.whenPressed(new PickupArmLower());
        lbutton4.whenPressed(new TurnOnRollers());
        lbutton5.whenPressed(new TurnOffRollers());
        rbutton6.whenPressed(new ResetGyro());
        rbutton7.whileHeld(new BalanceBot());
        rbuttonUp.whenPressed(new LightOn());
        rbuttonDn.whenPressed(new LightOff());
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
     public double getRightTwist() {
         System.out.println(rightJoy.getAxis(Joystick.AxisType.kTwist));
         return rightJoy.getAxis(Joystick.AxisType.kTwist);
     }
     public double getRightHat() {
         return rightJoy.getAxis(Joystick.AxisType.kNumAxis);
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
        return rightJoy.getAxis(Joystick.AxisType.kZ);
    }
    /**
     * @return The value of the left joystick Z axis.
     * @author Kyle Deane
     */
    public double getLeftZ() {
        return leftJoy.getZ();
    }
}

