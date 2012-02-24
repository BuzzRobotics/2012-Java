package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.OI;
import org.buzzrobotics.subsystems.DriveTrain;
import org.buzzrobotics.subsystems.Light;
import org.buzzrobotics.subsystems.Shifter;
import org.buzzrobotics.subsystems.Shooter;
import org.buzzrobotics.subsystems.ShooterAngle;
import org.buzzrobotics.subsystems.Rollers;
import org.buzzrobotics.subsystems.Camera;
import org.buzzrobotics.subsystems.Conveyor;
import org.buzzrobotics.subsystems.KeySensor;
import org.buzzrobotics.subsystems.BridgeArm;
import org.buzzrobotics.subsystems.Brake;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Kyle Deane
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    //public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static DriveTrain drivetrain = new DriveTrain();
    public static Light light = new Light();
    public static Shifter shifter = new Shifter();
    public static Shooter shooter = new Shooter();
    public static ShooterAngle shooterangle = new ShooterAngle();
    public static Rollers rollerarm = new Rollers();
    public static Camera camera = new Camera();
    public static Conveyor ballfeeder = new Conveyor();
    public static KeySensor keysensor = new KeySensor();
    public static BridgeArm bridgearm = new BridgeArm();
    public static Brake brake = new Brake();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard  
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
