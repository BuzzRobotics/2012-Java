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
 * 
 *                          ~SHOOT 1 THEN DRIVE TO ALLIANCE BRIDGE AND SHOOT 
 */
public class AutoMode4 extends CommandGroup {
    public AutoMode4() {
        addSequential(new Light(true));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
        addSequential(new AutonDrive(100));             //Drive over to the ramp
        addSequential(new TurnWithGyro(270));
        addSequential(new AutonDrive(100));
        addSequential(new TurnWithGyro(90));
        addSequential(new BridgeArm_Move(-1));
        addSequential(new Rollers_On(1));
        addSequential(new MoveBallFeeder(1));
        addSequential(new Delay(2));
        addSequential(new Rollers_Off());
        addSequential(new MoveBallFeeder(0));
        addSequential(new BridgeArm_Move(1));
        addSequential(new TurnWithGyro(165));           //Point back at hoops
      //addSequential(new SomeCameraTargetingThing());
        
        addSequential(new Load());
        addSequential(new Shooter_Fire());              //FIRE 1
        addSequential(new MoveBallFeeder(1));
        addSequential(new Delay(1));
        addSequential(new MoveBallFeeder(0));
        addSequential(new Load());
        addSequential(new Shooter_Fire());              //FIRE 2
        addSequential(new MoveBallFeeder(1));
        addSequential(new Delay(1));
        addSequential(new MoveBallFeeder(0));
        addSequential(new Load());
        addSequential(new Shooter_Fire());              //FIRE 3
        addSequential(new Drive(0, 0, 10));            //Wait around for 10 seconds            //Wait for automode to end

        
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
