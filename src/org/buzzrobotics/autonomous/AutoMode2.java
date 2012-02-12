/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.commands.*;
import org.buzzrobotics.subsystems.Shooter;
import org.buzzrobotics.subsystems.DriveTrain;

/**
 *
 * @author buzz5
 */
public class AutoMode2 extends CommandGroup {
    public AutoMode2() {
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
        addSequential(new AutonDrive(13));             //Drive over to the ramp
        addSequential(new TurnWithGyro(90));
        addSequential(new AutonDrive(20));
        addSequential(new TurnWithGyro(270));
        addSequential(new PickupArm_Lower());
        addSequential(new Rollers_On(-1));
        addSequential(new Delay(2));
        addSequential(new Rollers_Off());
        addSequential(new PickupArm_Raise());
      //addSequential(new SomeCameraTargetingThing());
        addSequential(new Load());
        addSequential(new Shooter_Fire());
        addSequential(new Load());
        addSequential(new Shooter_Fire());
        
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
