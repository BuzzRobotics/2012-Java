package org.buzzrobotics;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.buzzrobotics.commands.Shift_Up;
import org.buzzrobotics.commands.Shift_Down;
import org.buzzrobotics.commands.Light;
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
            rbutton9 = new JoystickButton(rightJoy, 9),
            rbutton10 = new JoystickButton(rightJoy, 10),
            rbutton11 = new JoystickButton(rightJoy, 11),
            rbutton12 = new JoystickButton(rightJoy, 12);
    
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
        rbutton1.whenPressed(new Shift_Down());
        rbutton1.whenReleased(new Shift_Up());
        lbutton1.whenPressed(new Shooter_Out());
        lbutton1.whenReleased(new Shooter_In());
        rbutton2.whenPressed(new ToggleLight()); 
      //  rbutton2.whenPressed(new Shooter_Fire());
        lbutton3.whenPressed(new PickupArmRaise());
        lbutton2.whenPressed(new PickupArmLower());
        
        lbutton4.whenPressed(new TurnOnRollers(-1));
        lbutton5.whenPressed(new TurnOnRollers(0));
        
        lbutton6.whenPressed(new Shooter_Angle(1));
        lbutton7.whenPressed(new Shooter_Angle(3));
        lbutton8.whenPressed(new Shooter_Angle(5));       
        
        rbutton6.whenPressed(new ResetGyro());
        rbutton7.whileHeld(new BalanceBot());
        
        rbutton10.whenPressed(new AdjustCamera(0.4, 0));
        rbutton11.whenPressed(new AdjustCamera(0.7,1));
        
        rbutton5.whenPressed(new MoveBallFeeder());
                
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
         System.out.println(rightJoy.getTwist());
         return rightJoy.getTwist();
     }
     public double getRightHatX() {
         return rightJoy.getRawAxis(5);
     }
     public double getRightHatY() {
         return rightJoy.getRawAxis(6);
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
        return rightJoy.getRawAxis(4);
    }
    /**
     * @return The value of the left joystick Z axis.
     * @author Kyle Deane
     */
    public double getLeftZ() {
        return leftJoy.getZ();
    }
}

