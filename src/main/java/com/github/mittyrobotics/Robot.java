package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import javax.swing.plaf.nimbus.State;

//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    Compressor.getInstance().initHardware();
    public static Spark SparkLeft, SparkRight;
    public static Spark Piston1, Piston2;
    public static DigitalInput digitalInputA, digitalInputB, digitalInputC, digitalInputD;

    XboxController controller;
    public static XboxController leftController;
    public static XboxController rightController;
    public static boolean isActivated = false;
    RomiGyro gyro;
    DoubleSolenoid s = new DoubleSolenoid;

    @Override
    public void robotInit() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        Piston1 = new Spark(Constants.LEFT_MOTOR_ID);
        Piston2 = new Spark(Constants.RIGHT_MOTOR_ID);

        Piston1.setInverted(true);
        Piston2.setInverted(false);

        digitalInputA = new DigitalInput(Constants.A_BUTTON_ID);
        digitalInputB = new DigitalInput(Constants.B_BUTTON_ID);
        digitalInputC = new DigitalInput(Constants.C_BUTTON_ID);
        digitalInputD = new DigitalInput(Constants.D_BUTTON_ID);
        controller = new XboxController(0);
        leftController = new XboxController(0);
        rightController = new XboxController(1);
        controller = new XboxController(2);
        gyro = new RomiGyro();
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        /*if (digitalInputA.get()) {
            SparkLeft.set(-1);
            SparkRight.set(1);
        }else if (digitalInputB.get()) {
        } else if (digitalInputB.get()) {
            SparkLeft.set(1);
            SparkRight.set(-1);
            //digitalOutputRed.set(true);
        }else if (digitalInputC.get()) {
        } else if (digitalInputC.get()) {
            SparkLeft.set(1);
            SparkRight.set(1);
        }else if (digitalInputD.get()) {
        } else if (digitalInputD.get()) {
            SparkLeft.set(-1);
            SparkRight.set(-1);
        }*/
        if (controller.getAButtonPressed()) {
            isActivated = true;
        } else if (controller.getBButtonPressed()) {
            isActivated = false;
        }
        if (isActivated) {
            if (leftController.getAButtonPressed()) {
                s.set(DoubleSolenoid.Value.kForward);
            } else if (leftController.getBButtonPressed()) {
                s.set(DoubleSolenoid.Value.kReverse);
            } else if (leftController.getXButtonPressed());
                s.set(DoubleSolenoid.Value.kForward);
            } else if (rightController.getAButtonPressed()) {
                s.set(DoubleSolenoid.Value.kReverse);
            }

        } else {
            s.set(0);
            s.set(0);
    }

    //Runs when autonomous mode (robot runs on its own) first activated via the desktop application
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