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
DigitalInput LeftButton, RightButton;

    @Override
    public void robotInit() {
SparkLeft = new Spark(0);
SparkRight = new Spark(1);
DigitalInput LeftButton = new DigitalInput();
DigitalInput RightButton = new DigitalInput();
//digitalInput.get(); To get a digital input either true or false
    }

    @Override
    public void teleopPeriodic() {
if (DigitalInput.get(LeftButton) && DigitalInput.get(RightButton)) {
SparkLeft.set(1);
SparkRight.set(1);
}

//When both buttons are not pressed, the robot will move backwards
        if (!DigitalInput.get(LeftButton) && !DigitalInput.get(RightButton)) {
            SparkLeft.set(-1);
            SparkRight.set(-1);
        }
//When left button is pressed and the right button is not being pressed, the robot will move right
        if (DigitalInput.get(LeftButton) && !DigitalInput.get(RightButton)) {
            SparkLeft.set(1);
            SparkRight.set(-1);
        }
//When left button is not being pressed and the right button is pressed, the robot will move right
        if (!DigitalInput.get(LeftButton) && DigitalInput.get(RightButton)) {
            SparkLeft.set(-1);
            SparkRight.set(1);
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