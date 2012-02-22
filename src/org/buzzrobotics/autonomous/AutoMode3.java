/*
 * Doesn't Do Much!
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
 *                                  ~SHOOT 1 THEN GO TO THE CENTER BRIDGE~
 */
public class AutoMode3 extends CommandGroup {
    public AutoMode3() {
        addSequential(new Light(true));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
        addSequential(new AutonDrive(24));             //Drive over to the ramp
        addSequential(new BridgeArm_Move(-1));           //Drop the pickup arm to lower the ramp
        addSequential(new Rollers_On(1));              //Turn on Rollers
        addSequential(new MoveBallFeeder(1));
        addSequential(new Delay(3));             //Delay again   
        addSequential(new Rollers_Off());              //Turn off the rollers
        addSequential(new MoveBallFeeder(0));
        addSequential(new BridgeArm_Move(1));           //Drop the pickup arm to lower the ramp
        addSequential(new AutonDrive(-24));            //...while we drive back to the key
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
        addSequential(new Drive(0, 0, 10));            //Wait around for 10 seconds            //Wait out rest of automode
        
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
