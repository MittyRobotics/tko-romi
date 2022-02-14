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
    public static DigitalInput digitalInputA, digitalInputB, digitalInputC, digitalInputD;
    public static DigitalOutput digitalOutputRed;

    public static XboxController leftController;
    public static XboxController rightController;
    public static XboxController controller;
    public static boolean isActivated = false;
    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    public static PIDController PIDcontroller;
    RomiGyro gyro;
    int kp = 0;
    int ki = 0;
    int kd = 0;

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

        PIDcontroller = new PIDController(kp, ki, kd);
        leftEncoder=new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        rightEncoder=new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
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
                SparkLeft.set(0.25);
            } else if (leftController.getBButtonPressed()) {
                SparkLeft.set(-0.25);
            } else if (leftController.getAButtonReleased() || leftController.getBButtonReleased() ) {
                SparkLeft.set(0);
            } else if (rightController.getAButtonPressed()) {
                SparkRight.set(0.25);
            } else if (rightController.getBButtonPressed()) {
                SparkRight.set(-0.25);
            } else if (rightController.getAButtonReleased() || rightController.getBButtonReleased() ) {
                SparkRight.set(0);
            } else if (leftController.getXButtonPressed()) {
                gyro.reset();
                while (gyro.getAngleZ() == 0) {
                    SparkLeft.set(-0.1);
                    SparkRight.set(0.1);
                }
            }
        } else {
            SparkLeft.set(0);
            SparkRight.set(0);
        }

        if (leftController.getYButtonPressed()) {
            SparkRight.set(0);
            SparkLeft.set(0);
        }




        PIDcontroller.setSetpoint(5*Constants.TICKS_PER_INCH);

        double outputL = PIDcontroller.calculate(leftEncoder.getDistance());
        SparkLeft.set(outputL);

        double outputR = PIDcontroller.calculate(rightEncoder.getDistance());
        SparkRight.set(outputR);

        double FEED_FORWARD = 1.0/10;
        SparkLeft.set(10*FEED_FORWARD);
        PIDcontroller.setSetpoint(10);
        

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