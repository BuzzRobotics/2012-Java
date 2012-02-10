package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.commands.*;
import org.buzzrobotics.subsystems.Shooter;
import org.buzzrobotics.subsystems.DriveTrain;

/**
 *
 * @author buzz5
 */
public class AutoMode extends CommandGroup {
        public int m_delay;
    public AutoMode(int delay) {
        m_delay = delay;
        addSequential(new Delay(m_delay));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
        addSequential(new Load());
        addSequential(new Shooter_Fire());             //Shoot the other ball
        addSequential(new AutonDrive(13));             //Drive over to the ramp
        addSequential(new PickupArmLower());           //Drop the pickup arm to lower the ramp
        addSequential(new Rollers_On(1));              //Turn on Rollers
        addSequential(new Delay(m_delay));             //Delay again   
        addSequential(new Rollers_Off());              //Turn off the rollers
        addSequential(new PickupArmRaise());           //Raise the pickup arm...
        addSequential(new AutonDrive(-23));            //...while we drive back to the key
        addSequential(new Load());
        addSequential(new Shooter_Fire());             //Fire
        addSequential(new Load());
        addSequential(new Shooter_Fire());             //Fire again
        addSequential(new Drive(0, 0, 10));            //Wait around for 15 seconds
        
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
