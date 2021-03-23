package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Encoder;

//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    Spark sparkLeft, sparkRight;
    Encoder encoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]); //4 and 5 are the ports where the raspberry pi connects to the encoder
    DigitalInput buttonA, buttonB, buttonC;
    double botdistance;
    //Spark gyro;
    @Override
    public void robotInit() {
        /*
        encoder.reset();

        encoder.setDistancePerPulse(1./256.);
        //encoder.setMinRate(TICKS_PER_INCH);
        encoder.getDistance();
        //encoder
        //gyro = new Spark(RomiGyro.m_simAngleX);
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        buttonA = new DigitalInput(Constants.A_BUTTON_ID);

        buttonB = new DigitalInput(Constants.B_BUTTON_ID);

        buttonC = new DigitalInput(Constants.C_BUTTON_ID);

        //check if they're inverted
        sparkLeft.setInverted(true);
        sparkRight.setInverted(false);
    */

    }
    @Override
    public void teleopPeriodic() {

        double distance = Math.abs(encoder.getDistance());

        //stahp
        if(buttonA.get()) {
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        //drive forward
        else if (buttonB.get()) {
            while (botdistance <= 5) {
                sparkLeft.set(1);
                sparkRight.set(1);

                botdistance = encoder.getDistance();
            }
            sparkLeft.set(1);
            sparkRight.set(1);
        }

        //do some random rubbish ig
        else if (buttonC.get()) {
            //drive backwards
            sparkLeft.set(-1);
            sparkRight.set(-1);
            //Thread.sleep() is a wait command to tell the robot how long to drive for
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //stop
            sparkLeft.set(0);
            sparkRight.set(0);
            try {
                Thread.sleep(1000); //try it
            } catch (InterruptedException e) {
                e.printStackTrace(); //if it doesn't work quit the program to prevent an infinite loop
            }
            //turn left
            sparkLeft.set(-1);
            sparkRight.set(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //drive forwards ???????
            sparkLeft.set(1);
            sparkRight.set(1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //stop
            sparkLeft.set(0);
            sparkRight.set(0);

        }
    }
    //Runs when autonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

    //Runs when teleoperated mode (robot controlled by DRIVER) is first activated
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

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */


    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}