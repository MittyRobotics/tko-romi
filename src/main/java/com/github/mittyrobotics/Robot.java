package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;

import java.util.ArrayList;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    /** Day 1
    Spark sparkLeft, sparkRight;
    DigitalInput left_button, right_button, middle_button;
    **/

    /** Day 2 leftEncoder = example variable | encoder and spark = challenge variables
    Encoder leftEncoder;
    Spark spark;
    Encoder encoder;

    RomiGyro gyro;
    Spark leftSpark, rightSpark;
     **/

    /** Day 3
    PIDController controller;
    Spark leftSpark, rightSpark;
    Encoder encoder;
    **/

    Spark leftSpark, rightSpark;

    Encoder leftEncoder, rightEncoder;

    RomiGyro gyro;
    double angleX;
    double angleY;
    double angleZ;

    PIDController leftController, rightController;

    int step;


    @Override
    public void robotInit() {
        /** Day 1
        sparkLeft = new Spark(0);
        sparkRight = new Spark(1);
        left_button = new DigitalInput(0);
        right_button = new DigitalInput(1);
        middle_button = new DigitalInput(2);
         **/

        /** Day 2
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
        **/

        /** Day 3
        controller = new PIDController(0.5, 0.0001, 0.2);
        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);
        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        encoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        encoder.reset();
        **/

        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);
        rightSpark.setInverted(true);

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        leftEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        rightEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        leftEncoder.reset();
        rightEncoder.reset();

        gyro = new RomiGyro();
        gyro.reset();

        leftController = new PIDController(7, 0.0000000000001, 0.2);
        rightController = new PIDController(7, 0.0000000000001, 0.2);

        step = 0;
    }
    
    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        /** Day 1
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
        **/

        /** Day 2
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
         **/

        /** Day 3
        if (Math.abs(controller.getPositionError()) > 0.2) {
            leftSpark.set(controller.calculate(encoder.getDistance()));
            rightSpark.set(controller.calculate(encoder.getDistance()));
        } else {
            leftSpark.set(0);
            rightSpark.set(0);
        }
        **/

        if (step == 0) {
            if (leftEncoder.getDistance() < 10) {
                leftSpark.set(0.125);
            } else if (leftEncoder.getDistance() < 15) {
                leftSpark.set(0.1);
            } else if (leftEncoder.getDistance() < 20) {
                leftSpark.set(0.1);
            } else {
                leftSpark.set(0);
            }

            if (rightEncoder.getDistance() < 10) {
                rightSpark.set(0.125);
            } else if (rightEncoder.getDistance() < 15) {
                rightSpark.set(0.1);
            } else if (rightEncoder.getDistance() < 20) {
                rightSpark.set(0.1);
            } else {
                rightSpark.set(0);
            }

            if (leftSpark.get() == 0 && rightSpark.get() == 0) {
                step++;
            }
        }
        if (step == 1) {
            angleX = gyro.getAngleX();
            angleY = gyro.getAngleY();
            angleZ = gyro.getAngleZ();

            if (angleZ > -90) {
                leftSpark.set(-0.1);
                rightSpark.set(0.1);
            } else if (angleZ < -90) {
                leftSpark.set(0.1);
                rightSpark.set(-0.1);
            } else {
                leftSpark.set(0);
                rightSpark.set(0);
            }
        }

        // leftSpark.set(leftController.calculate(leftEncoder.getDistance()));
        // rightSpark.set(rightController.calculate(rightEncoder.getDistance()));

    }

    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {
        /** Day 3
         controller.setSetpoint(10.);
         **/

        leftController.setSetpoint(10);
        rightController.setSetpoint(10);
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