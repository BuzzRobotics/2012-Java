/*----------------------------------------------------------------------------*/
/* Copyright (c) Buzz Robotics 2012. All Rights Reserved.                     */
/* Kyle Deane | Peter Polis | Zach Boyer                                      */
/* Along with the Mentors Bob Atiyeh, Art, Jeff, and MadDog                   */
/* Lets WIN at the 2012 Rebound Rumble Game!!!                                */
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
import org.buzzrobotics.autonomous.AutoMode;
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
        autoChooser.addObject("AutoMode", new AutoMode(5));
        autoChooser.addDefault("Hybrid", new Hybrid());
        autoChooser.addObject("whip", new whip());
        autoChooser.addObject("Automode1", new AutoMode1());
        autoChooser.addObject("Nothing", new Nothing());
        SmartDashboard.putData("autoChooser", autoChooser);
        
//        ShooterLimit = new SendableChooser();
//        ShooterLimit.addDefault("5", new Shooter_Angle(5));
//        ShooterLimit.addObject("4", new Shooter_Angle(4));
//        ShooterLimit.addObject("3", new Shooter_Angle(3));
//        ShooterLimit.addObject("2", new Shooter_Angle(2));
//        ShooterLimit.addObject("1", new Shooter_Angle(1));
//        SmartDashboard.putData("ShooterLimit chooser", ShooterLimit);
        
        YaledChooser = new SendableChooser();
        YaledChooser.addDefault("5", new Delay(5));
        //SmartDashboard.putData("ShooterLimit chooser", ShooterLimit);
        
    }

    public void autonomousInit() {
       
       AutonomousCommand = (Command) autoChooser.getSelected();
       AutonomousCommand.start();
       //YaledCommand = (Command) YaledChooser.getSelected();
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        
        Scheduler.getInstance().run();
        
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
        System.out.print(this);
        //DriveWithJoystick.start();
//        ShooterAngle = (Command) ShooterLimit.getSelected();
        //ShooterAngle.start();
    }
    
    public void disabledInit() {
        //DriveWithJoystick.cancel();
    }
    public void disabledPeriodic() {
        
    }
    public void updateDashboard(){
       
        SmartDashboard.putDouble("Gyroscope: ", CommandBase.drivetrain.getGyroAngle());
        SmartDashboard.putDouble("LimitPot: ", CommandBase.shooterangle.returnPot());

        SmartDashboard.putDouble("Accelerometer X: ", CommandBase.drivetrain.getAccelX());
        SmartDashboard.putDouble("Accelerometer Y: ", CommandBase.drivetrain.getAccelY());
        
        SmartDashboard.putDouble("Encoder Average: ", CommandBase.drivetrain.getAvgDistance());
        SmartDashboard.putDouble("Left Encoder: ", CommandBase.drivetrain.getLeftEncoder());
        SmartDashboard.putDouble("Right Encoder: ", CommandBase.drivetrain.getRightEncoder());
       
        SmartDashboard.putBoolean("IR Sensor - Top: ", CommandBase.ir.getTopIRSensor());
        SmartDashboard.putBoolean("IR Sensor - Middle: ", CommandBase.ir.getMiddleIRSensor());
        SmartDashboard.putBoolean("IR Sensor - Bottom: ", CommandBase.ir.getBottomIRSensor());
        SmartDashboard.putBoolean("IR Sensor - Feeder:", CommandBase.ir.getFeederIRSensor());
        
        
        SmartDashboard.putBoolean("Floor IR Sensor - 1:", CommandBase.ir.getFloor1IRSensor());
        SmartDashboard.putBoolean("Floor IR Sensor - 2:", CommandBase.ir.getFloor2IRSensor());
        SmartDashboard.putBoolean("Floor IR Sensor - 3:", CommandBase.ir.getFloor3IRSensor());
    }
}

