package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    RomiGyro gyro;

    Spark sparkLeft, sparkRight;

    Encoder encoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);

    DigitalInput buttonA, buttonB, buttonC;

    @Override
    public void robotInit() {
        gyro = new RomiGyro();
        gyro.reset();

        encoder.reset();

        encoder.setDistancePerPulse(1./200.);

        encoder.reset();

        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        buttonA = new DigitalInput(Constants.A_BUTTON_ID);
        buttonB = new DigitalInput(Constants.B_BUTTON_ID);
        buttonC = new DigitalInput(Constants.C_BUTTON_ID);

        //sparkLeft.setInverted(true);
        //sparkRight.setInverted(false);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        double distance = encoder.getDistance();
        double rate = encoder.getRate();

        encoder.setDistancePerPulse(1./256.);
        sparkLeft.set(1);
        sparkRight.set(1);
        if(distance==5) {
            sparkLeft.set(0);
            sparkRight.set(0);
        }

        if(buttonA.get()) { // left
            sparkLeft.set(-1);
            sparkRight.set(1);
        }
        else if(buttonB.get()) { // backward
            sparkLeft.set(-1);
            sparkRight.set(-1);
        }
        else if(buttonC.get()) { // stop
            sparkLeft.set(0);
            sparkRight.set(0);
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