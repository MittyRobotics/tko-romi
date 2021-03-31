package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import com.github.mittyrobotics.commands.driveatspeedcommand;
import com.github.mittyrobotics.commands.driveatdistancecommand;
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

        encoder.getDistance().initHardware();
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


        CommandScheduler.getInstance().schedule(new driveatspeedcommand(1f));
    }
    //Runs when autonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {
        CommandScheduler.getInstance().schedule(new driveatdistancecommand(10));
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
        CommandScheduler.getInstance().run();
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