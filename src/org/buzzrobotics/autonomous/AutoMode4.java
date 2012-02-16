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
 *                          ~DO NOTHING!!!!!~
 * 
 */
public class AutoMode4 extends CommandGroup {
    public AutoMode4() {
       addSequential(new Light(true)); 
    }
}
