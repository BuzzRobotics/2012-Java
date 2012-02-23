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
    
    public Autonomous(double mode, int delay) {
        if (delay == -1){
        addSequential(new Delay(CommandBase.oi.getDelay()));
        }else{
        addSequential(new Delay(delay));
        }
        if (mode == -1){
            switch(CommandBase.oi.getAutonMode()){
                case 0:        //Hybrid
                    addSequential(new flashyLights());
                    break;
                case 1:
                    addSequential(new AutoMode1());     //Shoot 2 balls
                    break;
                case 2:
                    addSequential(new AutoMode2());     //Drive to alliance bridge
                    break;
                case 3:
                    addSequential(new Hybrid());     //Get balls from center bridge
                    break;
                case 4:
                    addSequential(new AutoMode4());     //Do nothing
                    break;
                case 5:
                    addSequential(new AutoMode5());     //Broken
                   break;
                default:
                    break;
            }
        }else if (mode == 1){
            addSequential(new AutoMode1());
        }else if (mode == 0){
            addSequential(new flashyLights());
        }
    }
}
