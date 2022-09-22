package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

import static com.github.mittyrobotics.Constants.*;


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
    Talon falcon = new Talon(0);

    PIDController controller;
    Encoder encoder;
    double t;



        @Override
    public void robotInit() {
        start = new TrapezoidProfile.State(0, 0);
        TrapezoidProfile.State end = new TrapezoidProfile.State(5.0, 0);
        TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(2, 0.2);
        TrapezoidProfile profile = new TrapezoidProfile(constraints, end, start);
        TrapezoidProfile.State profileOutput = profile.calculate(0.2);
        double kp = 1.0, ki = 2.0, kd = 3.0;
        controller = new PIDController(kp, ki, kd);

    }
        //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {
        t = 0;
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

    @Override
    public void teleopPeriodic() {
        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        TrapezoidProfile.State setpoint = profile.calculate(t);
        controller.setSetpoint(setpoint.velocity);
        controller.calculate(encoder.getRate());
        t += 0.02;
    }
}

