/*
 *Autonomous Mode 3
 * Does nothing much at this point
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
public class AutoMode3 extends CommandGroup {
    public AutoMode3() {
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
        addSequential(new Load());
        addSequential(new Delay(1));
        addSequential(new Shooter_Fire());             //Shoot the other ball
        addSequential(new AutonDrive(100));             //Drive over to the ramp
        addSequential(new BridgeArm_Set(1));           //Drop the pickup arm to lower the ramp
        addSequential(new Rollers_On(1));              //Turn on Rollers
        addSequential(new MoveBallFeeder(1));
        addSequential(new Delay(3));             //Delay again   
        addSequential(new Rollers_Off());              //Turn off the rollers
        addSequential(new MoveBallFeeder(0));
        addSequential(new BridgeArm_Set(5));           //Drop the pickup arm to lower the ramp
        addSequential(new AutonDrive(-100));            //...while we drive back to the key
        addSequential(new MoveBallFeeder(1));
        addSequential(new Delay(1));
        addSequential(new MoveBallFeeder(0));
        addSequential(new Load());
        addSequential(new Delay(1));
        addSequential(new Shooter_Fire());             //Fire
        addSequential(new MoveBallFeeder(1));
        addSequential(new Delay(1));
        addSequential(new MoveBallFeeder(0));
        addSequential(new Load());
        addSequential(new Delay(1));
        addSequential(new Shooter_Fire());             //Fire again
        addSequential(new Drive(0, 0, 10));            //Wait around for 15 seconds            //Shoot one of the two balls we hav
    }
}
