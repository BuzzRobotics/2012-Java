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
         * Light Relay (Goes on RELAY port of DS)
         * @param I whip my hair back and forth!
         * @param Relay cable slot for the lights on BreadBoard
         */
        public final static int lightrelay = 1;
        
        /*
         * Optical Sensors
         * 6 - 9 : Old style SINGLE optical sensors.
         */
        public static final int
                feeder_opticalSensorPWM = 6,
                top_opticalSensorPWM = 7,
                middle_opticalSensorPWM = 8,
                bottom_opticalSensorPWM = 9;
        
         public static final int loadSensorPWM = 10;
        
        /*
         * Floor Optical Sensors
         * Ports Mapped
         */
        public static final int
                floor1_opticalSensor = 12,
                floor2_opticalSensor = 13,
                floor3_opticalSensor = 14;
        /*
         * Floor Light Relay
         * Triggered when all 3 foor sensors are lit.
         */
         public static int FloorLightRelayPort = 2;


        
        /*
         * ShooterAngle Stuff
         * Analog Slice port 1
         */
        public static final int
                ShooterPot = 3,
                ShooterAngleMotor = 8;
      
        
        /*
         * Gyroscope Port
         * On Analog Input
         * Accelerometer goes on i2c on digital SideCar. :D
         */
        public static final int gyroPort = 1;
        
        /*
         * Roller Arm
         * Controlled by a Solenoid
         * On Solenoid Module.
         */
        public final static int rollerArmSolenoidSpike = 3;
        
        /*
         * the retract is just bolted shut, just used to vent the other end.
         */
        public static final int
                brakeDeploy = 5,
                brakeRetract = 6;
        /*
         * Ball Loader Door
         */
        public static final int
                loaderDoorDeploy = 7,
                loaderDoorRetract = 8;
        
        public static int rollerPWM = 4;
        //public static int rollerArmPotPort = 4;
        
        /*
         * Camera Servo Ports
         * Used on PWM of Digital Sidecar
         */
        public static final int
                camerax = 9,
                cameray = 10;
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
        
        public static final int ballFeederPWM = 6;
       
        
}
