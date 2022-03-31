package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
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
    public static DigitalInput digitalInputA, digitalInputB, digitalInputC, digitalInputD;
    public static DigitalOutput digitalOutputRed;

    public static XboxController leftController;
    public static XboxController rightController;
    public static XboxController controller;
    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    public static PIDController PIDcontroller;
    public static PIDController leftPIDcontroller;
    public static PIDController rightPIDcontroller;
    public static PIDController gyroPIDcontroller;
    public static boolean isActivated = false;
    RomiGyro gyro;
    int kp = 0;
    int ki = 0;
    int kd = 0;
    int step = 1;

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
        //digitalOutputRed = new DigitalOutput(Constants.RED_LED_ID);

        leftController = new XboxController(0);
        rightController = new XboxController(1);
        controller = new XboxController(2);
        gyro = new RomiGyro();
        gyro.reset();
        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        leftEncoder.setDistancePerPulse(1/Constants.TICKS_PER_INCH);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        rightEncoder.setDistancePerPulse(1/Constants.TICKS_PER_INCH);
        leftEncoder.reset();
        rightEncoder.reset();

        PIDcontroller = new PIDController(kp, ki, kd);
        leftPIDcontroller = new PIDController(kp, ki, kd);
        rightPIDcontroller = new PIDController(kp, ki, kd);
        gyroPIDcontroller = new PIDController(kp, ki, kd);

        step = 1;

    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {

/*
        if (digitalInputA.get()) {
            SparkLeft.set(-1);
            SparkRight.set(1);
        } else if (digitalInputB.get()) {
            SparkLeft.set(1);
            SparkRight.set(-1);
            //digitalOutputRed.set(true);
        } else if (digitalInputC.get()) {
            SparkLeft.set(1);
            SparkRight.set(1);
        } else if (digitalInputD.get()) {
            SparkLeft.set(-1);
            SparkRight.set(-1);
        }
 */
        if (controller.getAButtonPressed()) {
            isActivated = true;
        } else if (controller.getBButtonPressed()) {
            isActivated = false;
        }
        if (isActivated) {
            if (leftController.getAButtonPressed()) {
                SparkLeft.set(1);
            } else if (leftController.getBButtonPressed()) {
                SparkLeft.set(-1);
            } else if (leftController.getAButtonReleased() || leftController.getBButtonReleased() ) {
                SparkLeft.set(0);
            } else if (rightController.getAButtonPressed()) {
                SparkRight.set(1);
            } else if (rightController.getBButtonPressed()) {
                SparkRight.set(-1);
            } else if (rightController.getAButtonReleased() || rightController.getBButtonReleased() ) {
                SparkRight.set(0);
            }
        } else {
            SparkLeft.set(0);
            SparkRight.set(0);
        }

        System.out.println(leftEncoder.getDistance() + " " + rightEncoder.getDistance());

        /*
        if (controller.getAButton()) {
            while (gyro.getAngleZ() < 45) {
                SparkLeft.set(0.5);
                SparkRight.set(0.5);
            }
        }
        */
        /*
        if (controller.getAButton() && gyro.getAngleZ() <  45) {
            SparkRight.set(0.5);
            SparkLeft.set(-0.5);
        }
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
        if (step == 1) {
            step = 3;
        }
        else if (step == 3) {
            while(leftEncoder.getDistance() >= -12 && rightEncoder.getDistance() >= -12) {
                SparkLeft.set(1);
                SparkRight.set(1);
            }
            if (leftEncoder.getDistance() <= -12 && rightEncoder.getDistance() <= -12) {
                SparkLeft.set(0);
                SparkRight.set(0);
            }
            leftEncoder.reset();
            rightEncoder.reset();
            step = 5;
        }
        /*else if (step == 5) {
            while(leftEncoder.getDistance() >= -6 && rightEncoder.getDistance() >= -6) {
                SparkLeft.set(1);
                SparkRight.set(1);
            }
            if (leftEncoder.getDistance() <= -6 && rightEncoder.getDistance() <= -6) {
                SparkLeft.set(0);
                SparkRight.set(0);
            }
            leftEncoder.reset();
            rightEncoder.reset();
            step = 6;
        }
        else {
            SparkLeft.set(0);
            SparkRight.set(0);
        }
        /*if (leftEncoder.getDistance() <= -12 && rightEncoder.getDistance() <= -12) {
            SparkLeft.set(0);
            SparkRight.set(0);
        }*/
        System.out.println(leftEncoder.getDistance() + " " + rightEncoder.getDistance());
    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}