package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

//    Encoder leftEncoder;
//    Encoder encoder;
//Spark Spark;
//
//RomiGyro gyro;
//Spark leftSpark, rightSpark;
//    Spark SparkLeft, SparkRight;
//    DigitalInput LeftButton, RightButton;

PIDController controller;
Spark leftSpark, rightSpark;
Encoder encoder;

    @Override
    public void robotInit() {
        controller = new PIDController(0.5, 0.001, 0.2); //3 doubles
        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);
        encoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        encoder.setDistancePerPulse (1./50.);
        encoder.reset();

//SparkLeft = new Spark(0);
//SparkRight = new Spark(1);
//DigitalInput LeftButton = new DigitalInput();
//DigitalInput RightButton = new DigitalInput();
// digitalInput.get(); To get a digital input either true or false
//        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
//        leftEncoder.reset();
//        leftEncoder.setDistancePerPulse(1./10.); // 1 inch / 10 ticks
//        leftEncoder.setMinRate(10.); //10 inches / sec
//        leftEncoder.setReverseDirection(true);

//        Spark = new Spark(Constants.SPARK_ID);
//        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
//        encoder.reset()
//        encoder.setDistancePerPulse(1./256.);
//
//        gyro = new RomiGyro();
//        gyro.reset();
//        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
//        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);
    }

    @Override
    public void teleopPeriodic() {
//if (DigitalInput.get(LeftButton) && DigitalInput.get(RightButton)) {
//SparkLeft.set(1);
//SparkRight.set(1);
//        double distance = leftEncoder.getDistance();
//        double rate = leftEncoder.getRate();
//double xAngle = gyro.getAngleX(); To get angle of the gyro on an axis

//        if (encoder.getDistance() < 5) {
//            Spark.set(1);
//        } else {
//            Spark.set(0);
//        }
//
//        double zAngle = gyro.getAngleZ();
//        if (zAngle < 90) {
//            leftSpark.set(-1);
//            rightSpark.set(1);
//    } else {
//            leftSpark.set(0);
//            rightSpark.set(0);
//        }

//When both buttons are not pressed, the robot will move backwards
//        if (!DigitalInput.get(LeftButton) && !DigitalInput.get(RightButton)) {
//            SparkLeft.set(-1);
//            SparkRight.set(-1);
//        }
////When left button is pressed and the right button is not being pressed, the robot will move right
//        if (DigitalInput.get(LeftButton) && !DigitalInput.get(RightButton)) {
//            SparkLeft.set(1);
//            SparkRight.set(-1);
//        }
////When left button is not being pressed and the right button is pressed, the robot will move right
//        if (!DigitalInput.get(LeftButton) && DigitalInput.get(RightButton)) {
//            SparkLeft.set(-1);
//            SparkRight.set(1);
//}
        if (Math.abs(controller.getPositionError()) > 0.2) {
            leftSpark.set(controller.calculate(encoder.getDistance())); // encoder value first, setpoint
            rightSpark.set(controller.calculate(encoder.getDistance()));
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
controller.setSetpoint(10.);
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