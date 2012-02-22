
package org.buzzrobotics.utils;

import org.buzzrobotics.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author 694
 */
public class SystemsCheck extends CommandGroup {

    public SystemsCheck() {
        checkRollers();
        addSequential(new WaitCommand(1));
        checkConveyor();
        addSequential(new WaitCommand(1));
        checkShooter();
        addSequential(new WaitCommand(1));
        
    }

    private void checkRollers(){
        addSequential(new Rollers_On(1));
        addSequential(new WaitCommand(1));
        addSequential(new Rollers_On(-1));
        addSequential(new WaitCommand(1));
        addSequential(new Rollers_Off());
    }
    private void checkShooterAngle(){
        
    }
    private void checkConveyor() {
      
    }

    private void checkShooter() {
        addSequential(new Shooter_In());
        addSequential(new WaitCommand(1));
        addSequential(new Shooter_Out());
    }

    private void checkArm() {
      
    }
}