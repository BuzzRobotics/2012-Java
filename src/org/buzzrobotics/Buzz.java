/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.buzzrobotics;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.buzzrobotics.commands.CommandBase;
import org.buzzrobotics.commands.Hybrid;
import org.buzzrobotics.commands.DriveWithJoystick;
import org.buzzrobotics.commands.AutoMode1;
import org.buzzrobotics.commandgroups.whip;
import org.buzzrobotics.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Buzz extends IterativeRobot {

    Command Hybrid;
    SendableChooser autoChooser;
    Command DriveWithJoystick;
    Command AutonomousCommand;
    Compressor RobotCompressor;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        RobotCompressor = new Compressor(RobotMap.pressureSwitchPWM,RobotMap.compressorPWM);
        RobotCompressor.start();
        // instantiate the command used for the autonomous period
        Hybrid = new Hybrid();
        DriveWithJoystick = new DriveWithJoystick();
        NetworkTable.initialize();
        // Initialize all subsystems
        CommandBase.init();
        
        //Print that INIT has COMPLETED!
        System.out.println("RobotInit() completed.\n");
        
        //Initialize SmartDashboard, and put currently running tasks in there!
        SmartDashboard.putData("SchedulerData", Scheduler.getInstance());
        
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Kinect", new Hybrid());
        autoChooser.addObject("Autonomous", new whip());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
    }

    public void autonomousInit() {
       AutonomousCommand = (Command) autoChooser.getSelected();
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
         
        AutonomousCommand.start();
    }

    public void teleopInit() {
		Hybrid.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateDashboard();
        //DriveWithJoystick.start();
    }
    
    public void disabledInit() {
        //DriveWithJoystick.cancel();
    }
    public void disabledPeriodic() {
        
    }
    public void updateDashboard(){
        SmartDashboard.putBoolean("Infrared Sensor Value: ", CommandBase.ir.getIRSensor().get());
    }
}
