package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
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
    TrapezoidProfile.State start;
    TrapezoidProfile.State end;
    TrapezoidProfile.Constraints constraints;
    TrapezoidProfile profile;
    TrapezoidProfile.State profileOutput;
    Spark sparkRight;
    Spark sparkLeft;
    Talon talon;
    double kp = 0, ki = 0, kd = 0;
    PIDController controller = new PIDController(kp, ki, kd);
    int counter = 0;


    @Override
    public void robotInit() {

        start = new TrapezoidProfile.State(0,0);
        end = new TrapezoidProfile.State(1,0);
        constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
        profile = new TrapezoidProfile(constraints, start, end);
        profileOutput = profile.calculate(1.0);
        talon = new Talon(0);


    }
    @Override
    public void teleopPeriodic() {

        double encoder = talon.getSpeed();

        double FEED_FORWARD = 1.0/constraints.maxVelocity;
        sparkLeft.set(10 * FEED_FORWARD);
        sparkRight.set(10 * FEED_FORWARD);

        controller.setSetpoint(15 * TICKS_PER_INCH);
        double output = controller.calculate(encoder * 10);

        sparkLeft.set(10 * FEED_FORWARD + output);
        sparkRight.set(10 * FEED_FORWARD + output);

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

