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
import org.buzzrobotics.OI;
import org.buzzrobotics.commands.*;
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
    SendableChooser ShooterLimit;
    SendableChooser YaledChooser;
    Command DriveWithJoystick;
    Command ShooterAngle;
    Command autonomousCommand;
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
        //SmartDashboard.putData("SchedulerData", Scheduler.getInstance());
        
//        autoChooser = new SendableChooser();
//        autoChooser.addDefault("Shoot 2 then Drive to Bridge, 5 Sec Delay", new AutoMode(5));
//        autoChooser.addObject("Shoot 2 then Drive to Bridge, 3 Sec Delay", new AutoMode(3));
//        autoChooser.addObject("Shoot 2 then Drive to Bridge, No Delay", new AutoMode(0));
//        autoChooser.addObject("Hybrid", new Hybrid());
//        autoChooser.addObject("Shoot, drive, then turn 90", new AutoMode2(0));
//        
//        autoChooser.addObject("Nothing", new Nothing());
        //SmartDashboard.putData("autoChooser", autoChooser);
        
//        ShooterLimit = new SendableChooser();
//        ShooterLimit.addDefault("5", new Shooter_Angle(5));
//        ShooterLimit.addObject("4", new Shooter_Angle(4));
//        ShooterLimit.addObject("3", new Shooter_Angle(3));
//        ShooterLimit.addObject("2", new Shooter_Angle(2));
//        ShooterLimit.addObject("1", new Shooter_Angle(1));
//        SmartDashboard.putData("ShooterLimit chooser", ShooterLimit);
        
        //SmartDashboard.putData("ShooterLimit chooser", ShooterLimit);
        
    }

    public void autonomousInit() {
        //ReSTART Auton Command!
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
       autonomousCommand = new Autonomous();
       autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    
    public void teleopInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
                //AutonomousCommand.cancel();
                //ShooterAngle = (Command) ShooterLimit.getSelected();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateDashboard();
        //System.out.print(this);
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
        SmartDashboard.putDouble("gyro", CommandBase.drivetrain.getGyroAngle());
        SmartDashboard.putDouble("pot", CommandBase.shooterangle.returnPot());
        
        SmartDashboard.putDouble("bridgearmpot", CommandBase.bridgearm.returnPot());
        System.out.println(CommandBase.bridgearm.returnPot());
        SmartDashboard.putDouble("accelx", CommandBase.drivetrain.getAccelX());
        SmartDashboard.putDouble("accely", CommandBase.drivetrain.getAccelY());
      
        //SmartDashboard.putDouble("accel", CommandBase.rollerarm.getRollerDirection());
        
        SmartDashboard.putBoolean("floorlight", CommandBase.floorlight.status());
        SmartDashboard.putBoolean("light", CommandBase.light.status());
        
        SmartDashboard.putBoolean("rollerarm  ", CommandBase.rollerarm.status());
        
        SmartDashboard.putBoolean("light", CommandBase.light.status());
        //SmartDashboard.putBoolean("shooter", CommandBase.shooter.status());
        
        SmartDashboard.putDouble("encavg", CommandBase.drivetrain.getAvgDistance());
        SmartDashboard.putDouble("encleft", CommandBase.drivetrain.getLeftEncoder());
        SmartDashboard.putDouble("encright", CommandBase.drivetrain.getRightEncoder());
       
        SmartDashboard.putBoolean("ir1", CommandBase.ir.getTopIRSensor());
        SmartDashboard.putBoolean("ir2", CommandBase.ir.getMiddleIRSensor());
        SmartDashboard.putBoolean("ir3", CommandBase.ir.getBottomIRSensor());
        SmartDashboard.putBoolean("ir4", CommandBase.ir.getFeederIRSensor());
        
        
        SmartDashboard.putBoolean("fir1", CommandBase.ir.getFloor1IRSensor());
        SmartDashboard.putBoolean("fir2", CommandBase.ir.getFloor2IRSensor());
        SmartDashboard.putBoolean("fir3", CommandBase.ir.getFloor3IRSensor());
        
//        SmartDashboard.putBoolean("Ball Load Sensor:", CommandBase.ir.getLoadSensor());
    }
}

