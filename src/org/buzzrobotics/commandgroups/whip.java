package org.buzzrobotics.commandgroups;
import edu.wpi.first.wpilibj.Timer;
import org.buzzrobotics.commands.LightOn;
import org.buzzrobotics.commands.LightOff;
import org.buzzrobotics.commands.Shift_Down;
import org.buzzrobotics.commands.Shift_Up;
import org.buzzrobotics.commands.Drive;
import org.buzzrobotics.subsystems.Light;
        
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Testing Command Groups
 * @author Kyle Deane
 */
public class whip extends CommandGroup {
    /*
     * I Whip my hair back and forth :D
     */
    public whip() {
        addSequential(new Drive(1, 0, 3));
        addSequential(new Shift_Down());
        addSequential(new LightOn());
        addSequential(new Shift_Up());
        addSequential(new Drive(1, 0, 3));
        addSequential(new LightOff());
        
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
