package com.github.mittyrobotics;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;
//import edu.wpi.first.wpilibj2.command.PIDCommand;

//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class RobotPID extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
    Spark sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
    Spark sparkRight = new Spark(Constants.A_BUTTON_ID);
    Encoder encoder;
    Encoder encoder_right;
    PIDController controller;

    @Override
    public void robotInit() {
        encoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        encoder_right = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        encoder.reset();
        encoder_right.reset();

        encoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        encoder_right.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        controller = new PIDController(0.6, 0.001, 0.05);
    }
    @Override
    public void teleopPeriodic() {

        sparkLeft.set(controller.calculate(encoder.getDistance(), 10.)); //how long should this go for
        sparkRight.set(controller.calculate(encoder_right.getDistance(), 10.));



    }
    //Runs when autonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

    //Runs when teleoperated mode (robot controlled by DRIVER) is first activated
    @Override
    public void teleopInit() {

        controller.setSetpoint(10);
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

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */


    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}