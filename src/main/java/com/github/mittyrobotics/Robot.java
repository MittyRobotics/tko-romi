package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

import static com.github.mittyrobotics.Constants.TICKS_PER_INCH;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
    Spark SparkLeft;
    Spark SparkRight;
    DigitalInput ForwardButton;
    DigitalInput LeftButton;

    @Override
    public void robotInit() {
        //Runs periodically during teleoperated mode
        /*
         *  WRITE YOUR DRIVE CODE HERE
         */
        ForwardButton = new DigitalInput(0);
        LeftButton = new DigitalInput(1);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);

        if (ForwardButton.get()) {
            SparkRight.set(0.5);
            SparkLeft.set(0.5);
        }

        if (LeftButton.get()) {
            SparkRight.set(0.5);
            SparkLeft.set(-0.5);
        }
    }
    @Override
    public void teleopPeriodic() {

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

