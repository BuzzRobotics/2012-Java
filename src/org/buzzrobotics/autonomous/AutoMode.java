/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.subsystems.Shooter;
import org.buzzrobotics.subsystems.DriveTrain;
import org.buzzrobotics.commands.Shooter_Fire;
import org.buzzrobotics.commands.Drive;
import org.buzzrobotics.commands.AutonDrive;
import org.buzzrobotics.commands.TurnOnRollers;
import org.buzzrobotics.commands.TurnOffRollers;
import org.buzzrobotics.commands.PickupArmRaise;
import org.buzzrobotics.commands.PickupArmLower;
import org.buzzrobotics.commands.Delay;

/**
 *
 * @author buzz5
 */
public class AutoMode extends CommandGroup {
        public int m_delay;
    public AutoMode(int delay) {
        m_delay = delay;
        System.out.println("Delay Start");
        addSequential(new Delay(m_delay));
        System.out.println("Delay End");
        addSequential(new Shooter_Fire());  //Shoot one of the two balls we have
        addSequential(new Shooter_Fire());  //Shoot the other ball
        addSequential(new AutonDrive(13));    //Drive over to the ramp
        addSequential(new PickupArmLower()); //Drop the pickup arm to lower the ramp
        addSequential(new TurnOnRollers(1));     //Turn on Rollers
        Timer.delay(3);                     //???
        addSequential(new TurnOffRollers());    //Turn off the rollers
        addParallel(new PickupArmRaise());                      //Raise the pickup arm...
        addSequential(new AutonDrive(-23));    //...while we drive back to the key
        addSequential(new Shooter_Fire());  //Fire
        addSequential(new Shooter_Fire());  //Fire again
        addSequential(new Drive(0, 0, 15)); //Wait around for 15 seconds
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
