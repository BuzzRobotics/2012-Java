package org.buzzrobotics.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.buzzrobotics.commands.*;

/**
 *
 * @author P^2
 * Autonomous Mode 1
 * 
 *                                  ~SHOOT 2 BALLS THEN DO NOTHING~ 
 * 
 */
public class AutoMode1 extends CommandGroup {
    
    public AutoMode1() {
        addSequential(new lights(true, true, true));
        addSequential(new Shooter_Fire());             //Shoot one of the two balls we have
       // addSequential(new MoveBallFeeder(1));
        addSequential(new Loader_Load());
        //addSequential(new MoveBallFeeder(0));
        addSequential(new WaitCommand(1));
        addSequential(new Shooter_Fire());  
        addSequential(new lights(false, false, false));
      //  addParallel(new Lights_Flashy());//Shoot the other ball
        
//        addSequential(new AutonDrive(24));            //UNCOMMENT LATER
//        addParallel(new BridgeArm_Move(1));
//        addSequential(new Rollers_On(1));
//        addSequential(new MoveBallFeeder(1));
//        addSequential(new Delay(2));
//        addSequential(new Rollers_Off());
//        addSequential(new MoveBallFeeder(0));
//        addSequential(new AutonDrive(-24));
//        addParallel(new Load());
        
        // add
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
