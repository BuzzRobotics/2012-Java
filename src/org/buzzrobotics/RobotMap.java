package org.buzzrobotics;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Kyle Deane
 * @author Pete Polis
 * @author Zach ISAWESOME
 * @author Buzz Robotics
 */
public class RobotMap {
    
         /*
          * Kinect Multiplier
          * Multiplies speed of kinect driving by this number. 
          * Note that setting this number too high may cause the robot to go 
          * out of control.
          * 
          * Do not set above 1
          * @author Kyle Deane
          */
         public final static int kinectScale = 1;
        
                
        /*
         * SuperShifter Ports
         * Used on Solenoid Board
         * solenoidShifterDeployPort - High Gear
         * solenoidShifterRetractPort - Low Gear
         */
         public static final int
            solenoidShifterDeploy = 1,   //High Gear
            solenoidShifterRetract = 2;    //Low Gear  
         
         /*
         * Solenoid Shooter
         * Used on Solenoid Board
         * solenoidShooterExtend - Extends to propel ball.
         * solenoidShooterRetract - Retracts to be loaded again.
         * 
         * Solenoid Slice
         */
         public static final int
            solenoidShooterExtend = 3,   //High Gear
            solenoidShooterRetract = 4;    //Low Gear  
         /*
         * Compressor Ports
         * compresserPWM - Compressor Spike RELAY port. Digital Sidecar Relay PORT 8
         * pressureSwitchPWM - DIGITAL I/O - Used to tell when to stop Compressor. Digital Sidecar DigitalIO Port 1
         * 
         * Digital Side Car
         */
         public static final int
            compressorPWM = 8,      //Compressor Spike RELAY port
            pressureSwitchPWM = 1;  //DIGITAL I/O - Used to tell when to stop Compressor
        /*
         * Drive Ports
         * PWM for drive speed controllers.
         * 
         * Digital Sidecar PWM
         */
        public static final int
            driveRight1 = 1,
            driveLeft1 = 2;
        
        /*
         * Drive Encoders
         * Gets us info at where we're at!
         * 
         * Digital Sidecar Digital Input
         */
        public static final int
            encRightDrive1 = 2,
            encRightDrive2 = 3,
            encLeftDrive1 = 4,
            encLeftDrive2 = 5
                ;
        /*
         * Light Relay
         * @param I whip my hair back and forth!
         * @param Relay cable slot for the lights on BreadBoard
         */
        public final static int lightrelay = 1;
        public static int opticalSensorPWM = 6;
        
        /*
         * TurretPot
         * Analog Slice port 1
         */
        public static int TurretPot = 3;
        /*
         * Turret Motor
         */
        public static int turretMotor = 5;
        
        /*
         * Gyroscope Port
         * On Analog Input
         */
        public static int gyroPort = 1;
        
        
        
}
