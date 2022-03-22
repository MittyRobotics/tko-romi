package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot1 extends TimedRobot {

    Spark SparkLeft, SparkRight;
    double deadZone = 0.2;
    boolean inDeadZone;
    XboxController controller;
    @Override
    public void robotInit() {
        DriveTrain.getInstance().initHardware();
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        //Runs periodically during teleoperated mode
        /*
         *  WRITE YOUR DRIVE CODE HERE
         */
        controller =  new XboxController(0);

    }
    @Override
    public void teleopPeriodic() {
        if(controller.getY(GenericHID.Hand.kLeft) > -deadZone && OI.getInstance().getXboxController().getY(GenericHID.Hand.kLeft) > deadZone){
             DriveTrain.getInstance().setSparkLeft(OI.getInstance().getXboxController().getY(GenericHID.Hand.kLeft));
             SparkLeft.set(controller.getY(GenericHID.Hand.kLeft));
             SparkRight.set(controller.getY(GenericHID.Hand.kRight));
            inDeadZone = false;
        }
        else if() {
            inDeadZone = true;
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