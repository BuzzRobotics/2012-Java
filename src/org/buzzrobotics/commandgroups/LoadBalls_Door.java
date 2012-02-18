/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.commands.FeederDoor_Open;
import org.buzzrobotics.commands.MoveBallFeeder;
import org.buzzrobotics.commands.Rollers_On;

/**
 *
 * @author Kyle Deane
 */
public class LoadBalls_Door extends CommandGroup {
    
    public LoadBalls_Door() {
        addSequential(new MoveBallFeeder(-1));
        addParallel(new Rollers_On(1));
        addParallel(new FeederDoor_Open());
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
