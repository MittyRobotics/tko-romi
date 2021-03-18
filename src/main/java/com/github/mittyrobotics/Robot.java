package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
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

    Spark sparkLeft, sparkRight;

    DigitalInput digitalInputA;
    DigitalInput digitalInputB;
    DigitalInput digitalInputC;

    @Override
    public void robotInit() {
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        digitalInputA = new DigitalInput(Constants.A_BUTTON_ID);
        digitalInputB = new DigitalInput(Constants.B_BUTTON_ID);
        digitalInputC = new DigitalInput(Constants.C_BUTTON_ID);


        sparkRight.setInverted(false);
        sparkLeft.setInverted(true);
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

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        sparkLeft.setSpeed(0);
        sparkRight.setSpeed(0);
        if (digitalInputA.get()){
            sparkLeft.setSpeed(1);
            sparkRight.setSpeed(1);
        }else if (digitalInputB.get()){
            sparkLeft.setSpeed(-1);
            sparkRight.setSpeed(-1);
        }else if (digitalInputC.get()){
            sparkLeft.setSpeed(0);
            sparkRight.setSpeed(0);
        }

    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}