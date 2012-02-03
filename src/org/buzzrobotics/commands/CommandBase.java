package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.OI;
import org.buzzrobotics.subsystems.DriveTrain;
import org.buzzrobotics.subsystems.Light;
import org.buzzrobotics.subsystems.Shifter;
import org.buzzrobotics.subsystems.irSensor;
import org.buzzrobotics.subsystems.Shooter;
import org.buzzrobotics.subsystems.ShooterAngle;
import org.buzzrobotics.subsystems.RollerArm;
import org.buzzrobotics.subsystems.Camera;
import org.buzzrobotics.subsystems.BallFeeder;
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
    public static irSensor ir = new irSensor();
    public static Shooter shooter = new Shooter();
    public static ShooterAngle shooterangle = new ShooterAngle();
    public static RollerArm rollerarm = new RollerArm();
    public static Camera camera = new Camera();
    public static BallFeeder ballfeeder = new BallFeeder();
    //public static ShooterAngle shooterangle = new ShooterAngle();
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(light);     
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
