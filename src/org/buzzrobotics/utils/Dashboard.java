package org.buzzrobotics.utils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboardNamedData;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboardData;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.buzzrobotics.commands.CommandBase;

 /*
 * @author Kyle Deane
 */
public class Dashboard {    
    public void update(){
        SmartDashboard.putDouble("Shooter Angle Pot", CommandBase.shooterangle.returnPot());
        SmartDashboard.putDouble("Bridge Arm Pot", CommandBase.bridgearm.returnPot());
        SmartDashboard.putBoolean("Shoter", CommandBase.shooter.status());
        
        SmartDashboard.putDouble("Autonomous Mode", CommandBase.oi.getAutonMode());
        SmartDashboard.putDouble("Autonomous Dely", CommandBase.oi.getDelay());
        
        SmartDashboard.putDouble("R Joystick X", CommandBase.oi.getRightX());
        SmartDashboard.putDouble("R joystick Y", CommandBase.oi.getRightY());
        
        SmartDashboard.putDouble("Encoder - Average", CommandBase.drivetrain.getAvgDistance());
        SmartDashboard.putDouble("Encoder - Left", CommandBase.drivetrain.getLeftEncoder());
        SmartDashboard.putDouble("Encoder - Right", CommandBase.drivetrain.getRightEncoder());
        
        SmartDashboard.putBoolean("IR 1", CommandBase.keysensor.getFloor1IRSensor());
        SmartDashboard.putBoolean("IR 2", CommandBase.keysensor.getFloor2IRSensor());
        
        SmartDashboard.putBoolean("Brake", CommandBase.brake.status());
        
        SmartDashboard.putBoolean("Loader Door", CommandBase.ballfeeder.doorStatus());
        
        SmartDashboard.putBoolean("Shifter", CommandBase.shifter.status());
        SmartDashboard.putDouble("Shifter Count", CommandBase.shifter.getCounter());
    
        SmartDashboard.putDouble("Joystick Twist", CommandBase.oi.getRightTwist());

        SmartDashboard.putDouble("Sonar", CommandBase.keysensor.getSonarSensor());
    }
}
