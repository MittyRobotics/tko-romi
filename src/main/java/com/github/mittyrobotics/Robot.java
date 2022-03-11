package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import javax.swing.plaf.nimbus.State;
//import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import com.github.mittyrobotics.util.Compressor;

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

    XboxController controller;
    public static XboxController leftController;
    public static XboxController rightController;
    public static boolean isActivated = false;

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

        controller = new XboxController(0);
        leftController = new XboxController(0);
        rightController = new XboxController(1);
        controller = new XboxController(2);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        if(digitalInputA.get()) {
            SparkLeft.set(-1);
            SparkRight.set(1);
        } else if (digitalInputB.get()) {
            SparkLeft.set(1);
            SparkRight.set(-1);
        } else if (digitalInputC.get()) {
            SparkLeft.set(1);
            SparkRight.set(1);
        } else if (digitalInputD.get()) {
            SparkLeft.set(-1);
            SparkRight.set(-1);
        }
/*
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
            } else if (leftController.getAButtonReleased()) {
                SparkLeft.set(0);
            } else if (leftController.getBButtonReleased()) {
                SparkLeft.set(0);
            } else if (rightController.getAButtonPressed()) {
                SparkRight.set(0.25);
            } else if (rightController.getBButtonPressed()) {
                SparkRight.set(-0.25);
            } else if (rightController.getAButtonReleased()) {
                SparkRight.set(0);
            } else if (rightController.getBButtonReleased()) {
                SparkRight.set(0);
            }
        } else {
            SparkLeft.set(0);
            SparkRight.set(0);
        }*/
        DrivetrainSubsystem.getInstance().setSparkLeft(controller.getY(GenericHID.Hand.kLeft));
        DrivetrainSubsystem.getInstance().setSparkRight(controller.getY(GenericHID.Hand.kRight));
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