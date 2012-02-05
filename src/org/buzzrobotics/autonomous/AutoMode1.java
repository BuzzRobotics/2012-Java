package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.commands.*;

/**
 *
 * @author Kyle Deane
 * Autonomous Mode 1
 * 
 */
public class AutoMode1 extends CommandGroup {
    
    public AutoMode1() {
        addSequential(new resetEncoders());
        addSequential(new Light(true));
        addSequential(new AutonDrive(20));
        addSequential(new Light(false));
       // add
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
