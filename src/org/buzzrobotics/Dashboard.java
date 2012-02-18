package org.buzzrobotics;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.buzzrobotics.commands.CommandBase;

 /*
 * @author Kyle Deane
 */
public class Dashboard {
    public void update(){
        SmartDashboard.putDouble("gyro", CommandBase.drivetrain.getGyroAngle());
        SmartDashboard.putDouble("pot", CommandBase.shooterangle.returnPot());
        
        SmartDashboard.putDouble("bridgearmpot", CommandBase.bridgearm.returnPot());
      //  System.out.println(CommandBase.bridgearm.returnPot());
        SmartDashboard.putDouble("accelx", CommandBase.drivetrain.getAccelX());
        SmartDashboard.putDouble("accely", CommandBase.drivetrain.getAccelY());
      
        //SmartDashboard.putDouble("accel", CommandBase.rollerarm.getRollerDirection());
        
        SmartDashboard.putBoolean("floorlight", CommandBase.floorlight.status());
        SmartDashboard.putBoolean("light", CommandBase.light.status());
        SmartDashboard.putDouble("rtX", CommandBase.oi.getRightX());
        SmartDashboard.putDouble("rtY", CommandBase.oi.getRightY());
        SmartDashboard.putBoolean("rollerarm  ", CommandBase.rollerarm.status());
        
        SmartDashboard.putBoolean("light", CommandBase.light.status());
        //SmartDashboard.putBoolean("shooter", CommandBase.shooter.status());
        
        SmartDashboard.putDouble("encavg", CommandBase.drivetrain.getAvgDistance());
        SmartDashboard.putDouble("encleft", CommandBase.drivetrain.getLeftEncoder());
        SmartDashboard.putDouble("encright", CommandBase.drivetrain.getRightEncoder());
       
        SmartDashboard.putBoolean("ir1", CommandBase.ir.getTopIRSensor());
        SmartDashboard.putBoolean("ir2", CommandBase.ir.getMiddleIRSensor());
        SmartDashboard.putBoolean("ir3", CommandBase.ir.getBottomIRSensor());
        SmartDashboard.putBoolean("ir4", CommandBase.ir.getFeederIRSensor());
        
        
        SmartDashboard.putBoolean("fir1", CommandBase.ir.getFloor1IRSensor());
        SmartDashboard.putBoolean("fir2", CommandBase.ir.getFloor2IRSensor());
        
        SmartDashboard.putBoolean("brake", CommandBase.brake.status());
        SmartDashboard.putBoolean("loaderdoor", CommandBase.ballfeeder.doorStatus());
        SmartDashboard.putBoolean("shifter", CommandBase.shifter.status());
        
            SmartDashboard.putDouble("HatY", CommandBase.oi.getRightHatY());
            SmartDashboard.putDouble("HatX", CommandBase.oi.getRightHatX());
            SmartDashboard.putDouble("Twist", CommandBase.oi.getRightTwist());


                        SmartDashboard.putDouble("shiftercount", CommandBase.shifter.getCounter());

        
        if (CommandBase.shifter.getCounter() > 5){
            this.disp(2, "ZOMG YOU'RE GONNA BREAK ME! STOP SHIFTING! ;)");
        }
    }
    /*
     * Displays information on the DriverStation LCD (On the diagnostics tab)
     * @param line what line number to print to
     * @param msg message to print
     */
    public static void disp(int line, String msg) {
        DriverStationLCD.Line l;
        switch (line){
            case 1:
                l = DriverStationLCD.Line.kUser2;
                break;
            case 2:
                l = DriverStationLCD.Line.kUser3;
                break;
            case 3:
                l = DriverStationLCD.Line.kUser4;
                break;
            case 4:
                l = DriverStationLCD.Line.kUser5;
                break;
            case 5:
                l = DriverStationLCD.Line.kUser6;
                break;
            case 6:
                l = DriverStationLCD.Line.kMain6;
                break;
            default:
                l = DriverStationLCD.Line.kUser2;
                break;
        }
        DriverStationLCD.getInstance().println(l, 1, msg);
        DriverStationLCD.getInstance().updateLCD();
    }
}
