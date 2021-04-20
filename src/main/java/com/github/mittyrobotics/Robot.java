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

    Spark sparkLeft, sparkRight;
    DigitalInput leftButton, rightButton, middleButton;


    @Override
    public void robotInit() {
        sparkLeft = new Spark(3);
        sparkRight = new Spark(4);
        leftButton = new DigitalInput(0);
        rightButton = new DigitalInput(0);
        middleButton = new DigitalInput(0);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        if (leftButton.get() && rightButton.get()) {
            sparkLeft.set(0.5);
            sparkRight.set(0.5);
        } else if (middleButton.get()) {
            sparkRight.set(0.5);
        } else if (!leftButton.get() && !rightButton.get() && !middleButton.get()) {
            sparkLeft.set(0);
            sparkRight.set(0);
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