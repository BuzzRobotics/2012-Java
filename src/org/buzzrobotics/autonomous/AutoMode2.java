/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.subsystems.Shooter;
import org.buzzrobotics.subsystems.DriveTrain;
import org.buzzrobotics.commands.Shooter_Fire;
import org.buzzrobotics.commands.Drive;
import org.buzzrobotics.commands.AutonDrive;
import org.buzzrobotics.commands.Rollers_On;
import org.buzzrobotics.commands.Rollers_Off;
import org.buzzrobotics.commands.PickupArmRaise;
import org.buzzrobotics.commands.PickupArmLower;
import org.buzzrobotics.commands.Delay;
import org.buzzrobotics.commands.TurnWithGyro;

/**
 *
 * @author buzz5
 */
public class AutoMode2 extends CommandGroup {
        public int m_delay;
    public AutoMode2(int delay) {
        m_delay = delay;
        
        addSequential(new Delay(m_delay));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
        addSequential(new AutonDrive(13));             //Drive over to the ramp
        addSequential(new TurnWithGyro(90));
        addSequential(new AutonDrive(20));
        addSequential(new TurnWithGyro(270));
        addSequential(new PickupArmLower());
        addSequential(new Rollers_On(-1));
        addSequential(new Delay(2));
        addSequential(new Rollers_Off());
        addSequential(new PickupArmRaise());
        addSequential(new Shooter_Fire());
        
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
