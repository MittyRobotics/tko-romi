package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    DigitalInput forwardButton;
    DigitalInput backwardButton;
    DigitalInput leftButton;
    DigitalInput rightButton;

    Spark sparkLeft;
    Spark sparkRight;

    XboxController controller;
    RomiGyro gyro = new RomiGyro();

    @Override
    public void robotInit() {
        forwardButton = new DigitalInput(0);
        backwardButton = new DigitalInput(1);
        leftButton = new DigitalInput(2);
        rightButton = new DigitalInput(3);

        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        controller = new XboxController(0);
        gyro = new RomiGyro();

        boolean A_clicked = controller.getAButtonPressed();
        boolean A_released = controller.getAButtonReleased();
        boolean B_clicked = controller.getBButtonPressed();
        boolean B_released = controller.getBButtonReleased();
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        if(controller.getAButtonPressed()) {
            if (forwardButton.get()) {
                sparkLeft.set(1);
                sparkRight.set(1);
            }
            if (backwardButton.get()) {
                sparkLeft.set(-1);
                sparkRight.set(-1);
            }
            if (rightButton.get()) {
                sparkLeft.set(1);
                sparkRight.set(-1);
            }
            if (leftButton.get()) {
                sparkLeft.set(-1);
                sparkRight.set(1);
            }
            if (controller.getAButton()) {
                sparkLeft.set(1);
                sparkRight.set(-1);
            }
        /*
        if (controller.getAButton()) {
            while (gyro.getAngleZ() < 45) {
                sparkLeft.set(-0.5);
                sparkRight.set(0.5);
            }
        }
         */
            if (controller.getAButton() && gyro.getAngleZ() < 45) {
                sparkRight.set(0.5);
                sparkLeft.set(-0.5);
            }
        }

        if(controller.getBButtonPressed()) {
            sparkRight.set(0);
            sparkLeft.set(0);
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