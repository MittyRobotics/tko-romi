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
    TrapezoidProfile.State start = new TrapezoidProfile.State(0, 0);
    TrapezoidProfile.State end = new TrapezoidProfile.State(15 * TICKS_PER_INCH, 0);
    TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
    TrapezoidProfile profile = new TrapezoidProfile(constraints, end, start);
    TrapezoidProfile.State profileOutput = profile.calculate(2.0);
    PIDController controller = new PIDController(1, 1, 1);
    Spark SparkLeft;
    Spark SparkRight;


    @Override
    public void robotInit() {
        //Runs periodically during teleoperated mode
        /*
         *  WRITE YOUR DRIVE CODE HERE
         */
        SparkLeft = new Spark(0);
        SparkRight = new Spark(1);
        for (profileOutput < ) {

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