package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import javax.swing.plaf.nimbus.State;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.github.mittyrobotics.util.Compressor;

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
    public static DigitalInput digitalInputA, digitalInputB, digitalInputC, digitalInputD;

    XboxController controller;
    public static XboxController leftController;
    public static XboxController rightController;
    public static boolean isActivated = false;
    RomiGyro gyro;
    s = new DoubleSolenoid(1, 2);

    @Override
    public void robotInit() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

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

        if (controller.getAButtonPressed()) {
            isActivated = true;
        } else if (controller.getBButtonPressed()) {
            isActivated = false;
        }
        if (isActivated) {
            if (controller.getAButtonPressed()) {
                s.set(DoubleSolenoid.Value.kForward);
            } else if (controller.getBButtonPressed()) {
                s.set(DoubleSolenoid.Value.kReverse);
            } else if (controller.getXButtonPressed());
                s.set(DoubleSolenoid.Value.kForward);
            } else if (controller.getYButtonPressed()) {
                s.set(DoubleSolenoid.Value.kReverse);
            }
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