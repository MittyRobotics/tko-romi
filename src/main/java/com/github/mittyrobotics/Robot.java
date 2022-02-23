package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.PrintCommand;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
    public static Spark SparkLeft, SparkRight;




    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    public static PIDController PIDcontroller;

    int kp = 0;
    int ki = 0;
    int kd = 0;
    int step;

    @Override
    public void robotInit() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        SparkLeft.setInverted(true);
        SparkRight.setInverted(false);

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        leftEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        rightEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        leftEncoder.reset();
        rightEncoder.reset();
        step = 0;

        PIDcontroller = new PIDController(kp, ki, kd);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {

        if (step == 0) {
            if (leftEncoder.getDistance() < 10) {
                SparkLeft.set(0.125);
            } else if (leftEncoder.getDistance() < 15 ) {
                SparkLeft.set(0.1);
            } else if (leftEncoder.getDistance() < 20) {
                SparkLeft.set(0.1);
            } else {
                SparkLeft.set(0);
            }

            if (rightEncoder.getDistance() < 10) {
                SparkRight.set(0.125);
            } else if (rightEncoder.getDistance() < 15) {
                SparkRight.set(0.1);
            } else if (rightEncoder.getDistance() < 20) {
                SparkRight.set(0.1);
            } else {
                SparkRight.set(0);
            }
            if (SparkLeft.get() == 0 && SparkRight.get() == 0) {
                step++;
            }


        /*PIDcontroller.setSetpoint(5*Constants.TICKS_PER_INCH);

        double outputL = PIDcontroller.calculate(leftEncoder.getDistance());
        SparkLeft.set(outputL);

        double outputR = PIDcontroller.calculate(rightEncoder.getDistance());
        SparkRight.set(outputR);

        double FEED_FORWARD = 1.0/10;
        SparkLeft.set(10*FEED_FORWARD);
        PIDcontroller.setSetpoint(10);
        */

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

        //SparkLeft.getSelectedSensorPosition();
    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}