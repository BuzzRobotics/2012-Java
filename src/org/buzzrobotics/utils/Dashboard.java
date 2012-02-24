package org.buzzrobotics.utils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboardData;
import org.buzzrobotics.commands.CommandBase;

 /*
 * @author Kyle Deane
 */
public class Dashboard {
    public void update(){
        SmartDashboard.putDouble("pot", CommandBase.shooterangle.returnPot());
        
        SmartDashboard.putDouble("bridgearmpot", CommandBase.bridgearm.returnPot());
      //  System.out.println(CommandBase.bridgearm.returnPot());

        //SmartDashboard.putDouble("accel", CommandBase.rollerarm.getRollerDirection());
        
        SmartDashboard.putDouble("GetAutonMode", CommandBase.oi.getAutonMode());
        SmartDashboard.putDouble("Delay", CommandBase.oi.getDelay());
        SmartDashboard.putBoolean("floorlight", CommandBase.floorlight.status());
        SmartDashboard.putBoolean("light", CommandBase.light.status());
        
        SmartDashboard.putDouble("rtX", CommandBase.oi.getRightX());
        SmartDashboard.putDouble("rtY", CommandBase.oi.getRightY());
        SmartDashboard.putDouble("ShooterPot", CommandBase.shooterangle.returnPot());
        SmartDashboard.putBoolean("rollerarm  ", CommandBase.rollerarm.status());
        
        SmartDashboard.putBoolean("light", CommandBase.light.status());
        //SmartDashboard.putBoolean("shooter", CommandBase.shooter.status());
        
        SmartDashboard.putDouble("encavg", CommandBase.drivetrain.getAvgDistance());
        SmartDashboard.putDouble("encleft", CommandBase.drivetrain.getLeftEncoder());
        SmartDashboard.putDouble("encright", CommandBase.drivetrain.getRightEncoder());
        
        SmartDashboard.putBoolean("fir1", CommandBase.ir.getFloor1IRSensor());
        SmartDashboard.putBoolean("fir2", CommandBase.ir.getFloor2IRSensor());
        
        SmartDashboard.putBoolean("brake", CommandBase.brake.status());
        SmartDashboard.putBoolean("loaderdoor", CommandBase.ballfeeder.doorStatus());
        SmartDashboard.putBoolean("shifter", CommandBase.shifter.status());
        
            SmartDashboard.putDouble("HatY", CommandBase.oi.getRightHatY());
            SmartDashboard.putDouble("HatX", CommandBase.oi.getRightHatX());
            SmartDashboard.putDouble("Twist", CommandBase.oi.getRightTwist());


                        SmartDashboard.putDouble("shiftercount", CommandBase.shifter.getCounter());

        
    }

}
