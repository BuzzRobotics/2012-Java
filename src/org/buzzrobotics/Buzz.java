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
import org.buzzrobotics.autonomous.AutoMode1;
import org.buzzrobotics.commands.Nothing;
import org.buzzrobotics.commandgroups.whip;
import org.buzzrobotics.commandgroups.AutoMode;
import org.buzzrobotics.OI;
import org.buzzrobotics.subsystems.DriveTrain;
import org.buzzrobotics.commands.Shooter_Angle;
import org.buzzrobotics.commands.Delay;

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
    SendableChooser ShooterLimit;
    SendableChooser YaledChooser;
    Command DriveWithJoystick;
    Command ShooterAngle;
    Command AutonomousCommand;
    Command YaledCommand;
    Command Nothing;
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
        autoChooser.addObject("Test1", new AutoMode1());
        autoChooser.addObject("AutoMode", new AutoMode(5));
        autoChooser.addObject("Sit On My Lazy But", new Nothing());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
        ShooterLimit = new SendableChooser();
        ShooterLimit.addDefault("5", new Shooter_Angle(5));
        ShooterLimit.addObject("4", new Shooter_Angle(4));
        ShooterLimit.addObject("3", new Shooter_Angle(3));
        ShooterLimit.addObject("2", new Shooter_Angle(2));
        ShooterLimit.addObject("1", new Shooter_Angle(1));
        SmartDashboard.putData("ShooterLimit chooser", ShooterLimit);
        
        YaledChooser = new SendableChooser();
        YaledChooser.addDefault("5", new Delay(5));
        SmartDashboard.putData("ShooterLimit chooser", ShooterLimit);
        
    }

    public void autonomousInit() {
       
       AutonomousCommand = (Command) autoChooser.getSelected();
       //YaledCommand = (Command) YaledChooser.getSelected();
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
                //AutonomousCommand.cancel();
                //ShooterAngle = (Command) ShooterLimit.getSelected();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateDashboard();
        //DriveWithJoystick.start();
        ShooterAngle = (Command) ShooterLimit.getSelected();
        ShooterAngle.start();
    }
    
    public void disabledInit() {
        //DriveWithJoystick.cancel();
    }
    public void disabledPeriodic() {
        
    }
    public void updateDashboard(){
        SmartDashboard.putBoolean("Infrared Sensor Value: ", CommandBase.ir.getIRSensor().get());
        SmartDashboard.putDouble("Gyroscope: ", CommandBase.drivetrain.getGyroAngle());
        SmartDashboard.putDouble("LimitPot: ", CommandBase.shooterangle.returnPot());
        
    }
}
