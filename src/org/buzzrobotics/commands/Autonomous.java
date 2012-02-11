/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.buzzrobotics.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.autonomous.*;

/**
 *
 * @author Kyle Deane
 */
public class Autonomous extends CommandGroup {
    
    public Autonomous() {
       
        addSequential(new Delay(CommandBase.oi.getDelay()));
        switch(CommandBase.oi.getAutonMode()){
            case 0:
                addSequential(new AutoMode1());
                break;
            case 1:
                addSequential(new AutoMode1());
                break;
            case 2:
                addSequential(new AutoMode2());
                break;
            case 3:
                addSequential(new AutoMode3());
                break;
            case 4:
                addSequential(new AutoMode4());
                break;
            case 5:
                addSequential(new AutoMode5());
                break;
            case 6:
                addSequential(new Hybrid());
                break;
            default:
                break;
        }
    }
}
