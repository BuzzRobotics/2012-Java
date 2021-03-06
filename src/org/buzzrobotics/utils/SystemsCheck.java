
package org.buzzrobotics.utils;

import org.buzzrobotics.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.buzzrobotics.utils.DS;
import edu.wpi.first.wpilibj.DriverStation;
import org.buzzrobotics.Buzz;
/**
 *
 * @author 694
 */
public class SystemsCheck extends CommandGroup {

    public SystemsCheck() {
        DriverStation driverstation = DriverStation.getInstance();
    
        if (!driverstation.isFMSAttached() && Buzz.devmode){
        DS.disp(2, "SystemsCheck: Rollers");
        
        checkRollers();
        addSequential(new WaitCommand(1));
        DS.disp(2, "SystemsCheck: Conveyor");
        checkConveyor();
        addSequential(new WaitCommand(1));
        DS.disp(2, "SystemsCheck: Door");
        checkConveyorDoor();
        addSequential(new WaitCommand(1));
        DS.disp(2, "SystemsCheck: ShooterAngle");
        checkShooterAngle();
        addSequential(new WaitCommand(1));
        DS.disp(2, "SystemsCheck: Shooter");
        checkShooter();
        addSequential(new WaitCommand(1));
        DS.disp(2, "SystemsCheck: Arm");
        checkArm();
        }
    }

    private void checkRollers(){
        DS.disp(3, "Rollers:Forward");
        addSequential(new Rollers_On(1));
        addSequential(new WaitCommand(1));
        DS.disp(3, "Rollers:Reverse");
        addSequential(new Rollers_On(-1));
        addSequential(new WaitCommand(1));
        DS.disp(3, "Rollers:Off");
        addSequential(new Rollers_Off());
    }
    private void checkShooterAngle(){

    }
    private void checkConveyor() {
        DS.disp(3, "Convey: Forward");
        addSequential(new Conveyor_Move(1));
        addSequential(new WaitCommand(1));
        DS.disp(3, "Convey: Off");
        addSequential(new Conveyor_Move(0));
    }
    private void checkConveyorDoor(){
        DS.disp(3, "Door: Open");
        addSequential(new FeederDoor_Open());
        addSequential(new WaitCommand(1));
        DS.disp(3, "Door: Close");
        addSequential(new FeederDoor_Close());
    }
    private void checkShooter() {
        DS.disp(3, "Shooter:Out");
        addSequential(new Shooter_Out());
        addSequential(new WaitCommand(1));
        DS.disp(3, "Shooter:In");
        addSequential(new Shooter_In());
    }

    private void checkArm() {
        DS.disp(3, "Arm: 1");
        addSequential(new BridgeArm_Move(1));
        addSequential(new WaitCommand(1));
        DS.disp(3, "Arm: -1");
        addSequential(new BridgeArm_Move(-1));
        addSequential(new WaitCommand(1));
        DS.disp(3, "Arm: 0");
        addSequential(new BridgeArm_Move(0));
    }
}