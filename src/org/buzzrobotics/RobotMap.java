package org.buzzrobotics;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Kyle Deane
 * @author Pete Polis
 * @author Zach Boyer
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
            encLeftDrive2 = 5;
        
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
         * Solenoid Shooter
         * Used on Solenoid Board
         * solenoidShooterExtend - Extends to propel ball.
         * solenoidShooterRetract - Retracts to be loaded again.
         * 
         * Solenoid Slice
         */
         public static final int
            solenoidShooterExtend = 3,
            solenoidShooterRetract = 4;
         
        
        /*
         * ShooterAngle Stuff
         * POT - Analog Slice port 1
         * MOTOR - Digital Sidecar PWM
         */
        public static final int
                ShooterPot = 3,
                ShooterAngleMotor = 7;
        
        /*
         * Brake Solenoid
         * On Solenoid Module
         */
        public static final int
                brakeDeploy = 5,
                brakeRetract = 6,
                brakelight = 1;
        
        /*
         * Ball Loader Door
         * On Solenoid Module
         */
        public static final int
                loaderDoorDeploy = 7,
                loaderDoorRetract = 8;
        
         /*
         * Ball Pickup Rollers :)
         */
        public static int rollerPWM = 4;
       
        /*
         * Ball Feeder Motor
         * (Ball Conveyor)
         */
        public static final int ballFeederPWM = 6;
        
        /*
         * LoadMotorPWM
         * (Loads Ball onto shooter)
         */
        public static int loadMotorPWM = 5;
        
        /*
         * Bridge ARm
         * POT - reads position
         * Motor - Controlls Motor
         * POT connected to Analog IO
         * Motor connected to PWM
         */
        public static final int
                BridgeArmPot = 4,
                BridgeArmMotor = 3; 
        
        /*
         * Camera Servo Ports
         * Used on PWM of Digital Sidecar
         * (SERVOS)
         */
        public static final int
                camerax = 9,
                cameray = 10;
       
         /*
         * Floor Optical Sensors
         * On Digital IO on digital sidecar.
         */
        public static final int
                floor1_opticalSensor = 12,
                floor2_opticalSensor = 13;
        
        /*
         * Floor Light Relay
         * Triggered when all 3 foor sensors are lit.
         */
         public static final int 
                 FloorLightRelayPort = 2,
                 FloorLight2RelayPort = 4;
         
         /*
         * Camera Light
         * On Relay port 1 of Digital Sidecar
         */
        public final static int lightrelay = 5;
        
        public final static int sonarPort = 1;
}
