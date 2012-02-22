
package org.buzzrobotics.utils;

import org.buzzrobotics.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.buzzrobotics.utils.Dashboard;

/**
 *
 * @author 694
 */
public class SystemsCheck extends CommandGroup {

    public SystemsCheck() {
        Dashboard.disp(2, "SystemsCheck: Rollers");
        checkRollers();
        addSequential(new WaitCommand(1));
        Dashboard.disp(2, "SystemsCheck: Conveyor");
        checkConveyor();
        addSequential(new WaitCommand(1));
        Dashboard.disp(2, "SystemsCheck: Door");
        checkConveyorDoor();
        addSequential(new WaitCommand(1));
        Dashboard.disp(2, "SystemsCheck: Camera");
        checkCamera();
        addSequential(new WaitCommand(1));
        Dashboard.disp(2, "SystemsCheck: ShooterAngle");
        checkShooterAngle();
        addSequential(new WaitCommand(1));
        Dashboard.disp(2, "SystemsCheck: Shooter");
        checkShooter();
        addSequential(new WaitCommand(1));
        Dashboard.disp(2, "SystemsCheck: Arm");
        checkArm();
    }

    private void checkRollers(){
        Dashboard.disp(3, "Rollers:Forward");
        addSequential(new Rollers_On(1));
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "Rollers:Reverse");
        addSequential(new Rollers_On(-1));
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "Rollers:Off");
        addSequential(new Rollers_Off());
    }
    private void checkShooterAngle(){
        Dashboard.disp(3, "SA: 2.07");
        addSequential(new ShooterAngle_Set(2.07));
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "SA: 3.70");
        addSequential(new ShooterAngle_Set(3.70));
        addSequential(new WaitCommand(2));
        Dashboard.disp(3, "SA: 2.07");
        addSequential(new ShooterAngle_Set(2.07));
    }
    private void checkConveyor() {
        Dashboard.disp(3, "Convey: Forward");
        addSequential(new Conveyor_Move(1));
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "Convey: Off");
        addSequential(new Conveyor_Move(0));
    }
    private void checkConveyorDoor(){
        Dashboard.disp(3, "Door: Open");
        addSequential(new FeederDoor_Open());
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "Door: Close");
        addSequential(new FeederDoor_Close());
    }
    private void checkCamera() {
        Dashboard.disp(3, "Cam: 0.4,1");
         addSequential(new AdjustCamera(0.4,1));
         addSequential(new Light(true));
         addSequential(new WaitCommand(1));
         Dashboard.disp(3, "Cam: 0.7,.26");
         addSequential(new AdjustCamera(0.7, .26));
         addSequential(new Light(false));
        
    }
    private void checkShooter() {
        Dashboard.disp(3, "Shooter:Out");
        addSequential(new Shooter_Out());
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "Shooter:In");
        addSequential(new Shooter_In());
    }

    private void checkArm() {
        Dashboard.disp(3, "Arm: 1");
        addSequential(new BridgeArm_Move(1));
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "Arm: -1");
        addSequential(new BridgeArm_Move(-1));
        addSequential(new WaitCommand(1));
        Dashboard.disp(3, "Arm: 0");
        addSequential(new BridgeArm_Move(0));
    }
}