/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.commands.*;

/**
 *
 * @author Kyle Deane
 */
public class LoadBalls_Door_Done extends CommandGroup {
    
    public LoadBalls_Door_Done() {
        addSequential(new MoveBallFeeder(0));
        addParallel(new Rollers_Off());
        addParallel(new FeederDoor_Close());
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
