/*
 *Autonomous Mode 3
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
 *                          ~SHOOT 2 BALLS THEN GET 3 FROM CENTER BRIDGE AND FIRE THOSE~
 * 
 */
public class AutoMode2 extends CommandGroup {

            
    public AutoMode2() {
        //9907482
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
       // addSequential(new MoveBallFeeder(1));
        addSequential(new Loader_Load());
        //addSequential(new MoveBallFeeder(0));
        addSequential(new WaitCommand(1));
        addSequential(new Shooter_Fire());   
        addSequential(new BridgeArm_Set(2.53));
    }
}
