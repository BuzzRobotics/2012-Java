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
 *                                 ~Feeds balls into other robot during autonomous Mode
 */
public class AutoMode3 extends CommandGroup {
    public AutoMode3() {
        addSequential(new Rollers_On(1));
        addSequential(new Conveyor_Move(1));
        addSequential(new WaitCommand(4));
        addSequential(new Conveyor_Move(0));
        addSequential(new Rollers_Off());
        
    }
}
