package org.buzzrobotics.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Drives with Joystick. Always called during Teleop and should never be ended.
 * VERY IMPORTANT!
 * @author Kyle Deane
 */
public class DriveWithJoystick extends CommandBase {
    public double sensitivity;
    public double turn;
    public double joyx;
    public double joyy;
    public double joyz;
    public double oJoyX;
    public double oJoyY;
    public DriveWithJoystick() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //drivetrain.arcadeDrive(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       // joyz = oi.getRightZ();
 
      
        drivetrain.arcadeDrive(oi.getRightX(),oi.getRightY());
        //y = (.75*x)^3+(1-.75)*x <- beautiful algorthm

        
        if(!sensors.getFloor1IRSensor() || !sensors.getFloor2IRSensor()){
            sensors.on1();
        }else if (sensors.getFloor1IRSensor() && sensors.getFloor2IRSensor()){
            sensors.off1();
        }
        
        if(!sensors.getWallSensor()){     
            sensors.on2();
        }else{
            sensors.off2();
        }        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("DRIVE INTERRUPTED");
    }
}
