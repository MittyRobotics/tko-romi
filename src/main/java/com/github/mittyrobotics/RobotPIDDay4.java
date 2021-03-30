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
public class RobotPIDDay4 extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    // PID Controllers is used to solve overshooting/undershooting because if you just go forward/speed up until you
    // reach the speed or distance you want, breaking is not instantaneous, so you are always slightly off.

    Spark spark;
    Encoder encoder;
    PIDController controller;

    @Override
    public void robotInit() {
       spark = new Spark(Constants.LEFT_MOTOR_ID);
       encoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);

       encoder.reset();
       encoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);

       controller =  new PIDController(0.5, 0.001, 0.05);

    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        spark.set(controller.calculate(encoder.getDistance(), 10.));
        // Using the controller to calculate optimal output
        // setpoint is the distance that you want to reach
    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {
        controller.setSetpoint(10);
    }

    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

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