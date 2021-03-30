package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class SparkRobotDay1 extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    Spark sparkLeft, sparkRight;

    DigitalInput buttonA, buttonB, buttonC;

    @Override
    public void robotInit() {
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        buttonA = new DigitalInput(Constants.A_BUTTON_ID);
        buttonB = new DigitalInput(Constants.B_BUTTON_ID);
        buttonC = new DigitalInput(Constants.C_BUTTON_ID);

        //sparkLeft.setInverted(true);  // if left wheel is inverted
        //sparkRight.setInverted(false);  // if right wheel is not inverted
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {

        // to go forward
        sparkLeft.set(1);
        sparkRight.set(1);

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