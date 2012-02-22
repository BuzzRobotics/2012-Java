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
 *                          ~SHOOT TWICE, DRIVE BACK!!!!!~
 * 
 */
public class AutoMode5 extends CommandGroup {
    public AutoMode5() {
        //addSequential(new ResetGyro());
        addSequential(new Light(true));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
       // addSequential(new MoveBallFeeder(1));
        addSequential(new Load());
        //addSequential(new MoveBallFeeder(0));
        addSequential(new Delay(1));
        addSequential(new Shooter_Fire());  
        addSequential(new Drive(0.5, 0, 2));
    }
}
