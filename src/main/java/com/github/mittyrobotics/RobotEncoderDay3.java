package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class RobotEncoderDay3 extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    Spark spark;

    Encoder encoder;


    @Override
    public void robotInit() {
        encoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        spark = new Spark(Constants.LEFT_MOTOR_ID);

        encoder.reset(); // Reset (for relative distance) - always do this in RobotInit
        encoder.setDistancePerPulse(1./256.); // Returns distance in feet (1 foot = 256 ticks)
        // Configures the encoder to return a distance of 1 for every X pulses (tick) - also changes rate

    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        double distance = encoder.getDistance(); // Get distance (ticks), negative or positive
        //double rate = encoder.getRate(); // Get rate (ticks/sec)

        //encoder.setMinRate(X); // Configures the encoder to consider itself stopped when its rate is below X
        //encoder.setReverseDirection(true); // Reverses the direction of the encoder  - returns negative for positive, positive for negative

        // Drives forward until the robot has moved 5 feet, then stops:
        if(distance<5) {
            spark.set(1);
        }
        else {
            spark.set(0);
        }

    }

    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {

    }

    //Runs when test mode is activated
    @Override
    public void testInit() {

    }

    //Runs whenever the robot is on, periodically: should be used for command schedulers
    @Override
    public void robotPeriodic() {

    }

    //Runs periodically during autonomous mode
    @Override
    public void autonomousPeriodic() {

    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}