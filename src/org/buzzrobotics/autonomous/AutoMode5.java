/*
 * Doesn't Do Much!
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
 *                          ~SHOOT TWICE, Lower Arm, drive to bridge
 * 
 */
public class AutoMode5 extends CommandGroup {
    public AutoMode5() {
        addSequential(new lights(true, true, true));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
       // addSequential(new MoveBallFeeder(1));
        addSequential(new Loader_Load());
        //addSequential(new MoveBallFeeder(0));
        addSequential(new WaitCommand(1));
        addParallel(new Shooter_Fire());  
        addSequential(new BridgeArm_Set(2.53)); //down
        addParallel(new Drive_Encoder_Straight(60f));
       
        addSequential(new lights(false, false, false));
        //}
    }
}
