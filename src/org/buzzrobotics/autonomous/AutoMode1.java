package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.commands.*;

/**
 *
 * @author P^2
 * Autonomous Mode 1
 * 
 *                                  ~SHOOT 2 BALLS THEN DO NOTHING~ 
 * 
 */
public class AutoMode1 extends CommandGroup {
    
    public AutoMode1() {
        addSequential(new Light(true));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
        addSequential(new Load());
        addSequential(new Delay(1));
        addSequential(new Shooter_Fire());             //Shoot the other ball
        addSequential(new AutonDrive(100));
        addSequential(new Drive(0, 0, 15));            //Wait around for 15 seconds            //Wait for automode to end
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
