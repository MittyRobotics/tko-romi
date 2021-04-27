package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;

import java.util.Map;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    DigitalInput leftButton,rightButton,middleButton;

    PIDController controller;
    Spark leftSpark, rightSpark;
    Encoder encoder;
    @Override
    public void robotInit() {
        controller=new PIDController(0.5,0.01,0.2);
        leftSpark=new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark=new Spark(Constants.RIGHT_MOTOR_ID);
        encoder=new Encoder(Constants.ENCODER_IDS[0],Constants.ENCODER_IDS[1]);
        encoder.reset();
        encoder.setDistancePerPulse(1./256);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        if(controller.getPositionError()>0.2) {
            rightSpark.set(controller.calculate(encoder.getDistance()));
            leftSpark.set(controller.calculate(encoder.getDistance()));
        }
        else{
            leftSpark.set(0);
            leftSpark.set(1);
        }

    }

    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit()    {

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