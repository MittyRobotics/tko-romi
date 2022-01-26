package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    Spark SparkLeft, SparkRight;
    DigitalInput digitalInput1;
    DigitalInput input2;
    DigitalInput input3;
    DigitalInput input4;
    XboxController controller;
    RomiGyro gyro;
    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */



    @Override
    public void robotInit() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID;
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        SparkLeft.setInverted(true);
        digitalInput1 = new DigitalInput(0);
        input2 = new DigitalInput(1);
        input3 = new DigitalInput(2);
        input4 = new DigitalInput(3);
        controller =  new XboxController(0);
        gyro = new RomiGyro();


    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        if(digitalInput1.get()) {
            SparkLeft.set(0);
            SparkRight.set(1);
        }
        else if(input2.get()){
            SparkLeft.set(1);
            SparkRight.set(0);
        }
        else if(input3.get()){
            SparkLeft.set(1);
            SparkRight.set(1);
        }
        else if(input4.get()) {
            SparkLeft.set(-1);
            SparkRight.set(-1);
        }
/*        if(controller.getAButton()){
            while(gyro.getAngleZ()<=45){
                SparkLeft.set(-0.5);
                SparkRight.set(0.5);
            }
        }
        */
        if(controller.getAButton() && gyro.getAngleZ() <= 45){
            SparkLeft.set(-0.5);
            SparkRight.set(0.5);
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