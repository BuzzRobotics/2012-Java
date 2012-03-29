/*----------------------------------------------------------------------------*/
/* Copyright (c) Buzz Robotics 2012. All Rights Reserved.                     */
/* Kyle Deane | Peter Polis | Zach Boyer                                      */
/* Along with the Mentors Bob Atiyeh, Art, Jeff, and MadDog                   */
/* Lets WIN at the 2012 Rebound Rumble Game!!!                                */
/*----------------------------------------------------------------------------*/

package org.buzzrobotics;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.buzzrobotics.commands.*;
import org.buzzrobotics.utils.Dashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Buzz extends IterativeRobot {
    public static boolean devmode = true;
    Command light;
    
    Command DriveWithJoystick;
    Command autonomousCommand;
    Compressor RobotCompressor;
    
    public static Dashboard dashboard = new Dashboard();
 
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        RobotCompressor = new Compressor(RobotMap.pressureSwitchPWM,RobotMap.compressorPWM);
        RobotCompressor.start();
        
        DriveWithJoystick = new DriveWithJoystick();
        
        NetworkTable.initialize();
        CommandBase.init();
        
        //Print that INIT has COMPLETED!
        System.out.println("RobotInit() completed.\n");
    }
    
    public void autonomousInit() {
        
       CommandBase.shifter.resetCounter();
       //ReSTART Auton Command!
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
      autonomousCommand = new Autonomous(-1, -1);  //set -1 for getting values from Autonomous Box.
      autonomousCommand.start();
       
       
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        if (devmode){dashboard.update();}
        //System.out.println(CommandBase.oi.getAutonMode());
    }

    
    public void teleopInit() {    
        
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        };
        CommandBase.shifter.resetCounter();
    }

    /**
     * This function is called periodically during operator control
     */
    public double status = 0;
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        dashboard.update();  
    }
    
    public void disabledInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
        
    }
    public void disabledPeriodic() {
        if (devmode){dashboard.update();}
        
    }
}

