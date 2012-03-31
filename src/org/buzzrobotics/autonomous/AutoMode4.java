/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.buzzrobotics.commands.*;
import org.buzzrobotics.subsystems.Shooter;
import org.buzzrobotics.subsystems.DriveTrain;

/**
 *
 * @author buzz5
 * 
 * 
 */
public class AutoMode4 extends CommandGroup {
    public AutoMode4() {
       addSequential(new Shooter_Fire());            
       // addSequential(new MoveBallFeeder(1));
       addSequential(new Loader_Load());
        //addSequential(new MoveBallFeeder(0));
       addSequential(new WaitCommand(1));
       addSequential(new Shooter_Fire());   
       addSequential(new WaitCommand(1));
       addSequential(new Rollers_On(-1));
        addSequential(new Conveyor_Move(-1));
        addSequential(new WaitCommand(4));
        addSequential(new Conveyor_Move(0));
        addSequential(new Rollers_Off());
        addParallel(new Loader_Load());
        addSequential(new Shooter_Fire());
        addParallel(new Conveyor_Move(-1));
        addSequential(new Loader_Load());
        addSequential(new Shooter_Fire());
        }
        
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
