package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.OI;
import org.buzzrobotics.subsystems.DriveTrain;
import org.buzzrobotics.subsystems.Light;
import org.buzzrobotics.subsystems.Shifter;
import org.buzzrobotics.subsystems.Turret;
import org.buzzrobotics.subsystems.irSensor;
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
    public static Turret turret = new Turret();
public static irSensor ir = new irSensor();
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
        SmartDashboard.putData(turret);
     
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
