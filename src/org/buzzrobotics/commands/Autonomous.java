/*
 * Calls the autonomous mode determined by the parameters or the autonomous box. :)
 */
package org.buzzrobotics.commands;

import org.buzzrobotics.autonomous.Hybrid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.buzzrobotics.autonomous.*;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous Mode Selector
 * @author Kyle Deane
 */
public class Autonomous extends CommandGroup {
    public int mode;
    public Autonomous(int autonmode, int delay) {
        /*
         * Delay
         */
        if (delay == -1){
            addSequential(new WaitCommand(CommandBase.oi.getDelay()));
        }else if (delay != 0){
            addSequential(new WaitCommand(delay));
        }
        /*
         * Select the Autonomous Mode
         * if the parameter is -1, then it gets the mode from the box.
         * if the parameter is anything else, it uses the parameter s mode.
         */
        if (autonmode == -1){
            mode = CommandBase.oi.getAutonMode();
        }else{
            mode = autonmode; 
        }

        switch(mode){
            case 0:        
                break;
            case 1:
                addSequential(new AutoMode1());     //Shoot 2 balls
                break;
            case 2:
                addSequential(new AutoMode2());     //Drive to alliance bridge
                break;
            case 3:
                addSequential(new AutoMode3());
                break;
            case 4:
                addSequential(new AutoMode4());     //Do nothing
                break;
            case 5:
                addSequential(new Hybrid());      //Broken
                break;
            default:
                break;
        }
        
    }
}
