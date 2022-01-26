package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;


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
    public static DigitalInput digitalInputA, digitalInputB, digitalInputC, digitalInputD;
    public static DigitalOutput digitalOutputRed;

    XboxController controller;
    RomiGyro gyro;

    @Override
    public void robotInit() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        SparkLeft.setInverted(true);
        SparkRight.setInverted(false);

        digitalInputA = new DigitalInput(Constants.A_BUTTON_ID);
        digitalInputB = new DigitalInput(Constants.B_BUTTON_ID);
        digitalInputC = new DigitalInput(Constants.C_BUTTON_ID);
        digitalInputD = new DigitalInput(Constants.D_BUTTON_ID);
        digitalOutputRed = new DigitalOutput(Constants.RED_LED_ID);

        controller = new XboxController(0);
        gyro = new RomiGyro();
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {

        if (digitalInputA.get()) {
            SparkLeft.set(-1);
            SparkRight.set(1);
        }else if (digitalInputB.get()) {
            SparkLeft.set(1);
            SparkRight.set(-1);
            //digitalOutputRed.set(true);
        }else if (digitalInputC.get()) {
            SparkLeft.set(1);
            SparkRight.set(1);
        }else if (digitalInputD.get()) {
            SparkLeft.set(-1);
            SparkRight.set(-1);
        } else {
            SparkLeft.set(0);
            SparkRight.set(0);
        }
        /*
        if (controller.getAButton()) {
            while (gyro.getAngleZ() < 45) {
                sparkLeft.set(0.5);
                sparkRight.set(0.5);
            }
        }
        */
        if (controller.getAButton() && gyro.getAngleZ() <  45) {
            sparkRight.set(0.5);
            sparkLeft.set(-0.5);
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