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
    Spark SparkLeft, SparkRight;
    DigitalInput left_button, right_button, middle_button;

    @Override
    public void robotInit() {
        SparkLeft = new Spark(0);
        SparkRight = new Spark(1);
        left_button = new DigitalInput(0);
        right_button = new DigitalInput(1);
        middle_button = new DigitalInput(2);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        if (left_button.get() && right_button.get() && middle_button.get()) {
            SparkLeft.set(-0.5);
            SparkRight.set(-0.5);
        }
        else if (middle_button.get() && left_button.get()) {
            SparkLeft.set(-0.5);
        }
        else if (middle_button.get() && left_button.get()) {
            SparkRight.set(-0.5);
        }
        else if (left_button.get() && right_button.get()) {
            SparkLeft.set(0.5);
            SparkRight.set(0.5);
        }
        else if (left_button.get()) {
            SparkLeft.set(0.5);
        }
        else if (right_button.get()) {
            SparkRight.set(0.5);
        }
        else if (!left_button.get() && !right_button.get() && !middle_button.get()) {
            SparkLeft.set(0);
            SparkRight.set(0);
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