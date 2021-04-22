package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
    /* Day 1
    Spark sparkLeft, sparkRight;
    DigitalInput left_button, right_button, middle_button;
    */

    /* Day 2 leftEncoder = example variable | encoder and spark = challenge variables */
    Encoder leftEncoder;
    Spark spark;
    Encoder encoder;

    RomiGyro gyro;
    Spark leftSpark, rightSpark;

    @Override
    public void robotInit() {
        /* Day 1
        sparkLeft = new Spark(0);
        sparkRight = new Spark(1);
        left_button = new DigitalInput(0);
        right_button = new DigitalInput(1);
        middle_button = new DigitalInput(2);
         */

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        leftEncoder.reset();
        leftEncoder.setDistancePerPulse(1./10.);
        leftEncoder.setMinRate(10.);
        leftEncoder.setReverseDirection(true);
        spark = new Spark(Constants.SPARK_ID);
        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        encoder.reset();
        encoder.setDistancePerPulse(1./256.);

        gyro = new RomiGyro();
        gyro.reset();
        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        /* Day 1
        if (left_button.get() && right_button.get() && middle_button.get()) {
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);
        } else if (middle_button.get() && left_button.get()) {
            sparkLeft.set(-0.5);
        } else if (middle_button.get() && left_button.get()) {
            sparkRight.set(-0.5);
        } else if (left_button.get() && right_button.get()) {
            sparkLeft.set(0.5);
            sparkRight.set(0.5);
        } else if (left_button.get()) {
            sparkLeft.set(0.5);
        } else if (right_button.get()) {
            sparkRight.set(0.5);
        } else if (!left_button.get() && !right_button.get() && !middle_button.get()) {
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        */

        double distance = leftEncoder.getDistance();
        double rate = leftEncoder.getRate();
        if (encoder.getDistance() >= 5) {
            spark.set(0);
        } else {
            spark.set(0.5);
        }


        double angleZ = gyro.getAngleZ();
        if (angleZ < 90) {
            leftSpark.set(0.5);
            rightSpark.set(-0.5);
        } else if (angleZ > 90) {
            rightSpark.set(0.5);
            leftSpark.set(-0.5);
        } else {
            leftSpark.set(0);
            rightSpark.set(0);
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