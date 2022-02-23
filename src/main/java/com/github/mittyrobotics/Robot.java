package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import com.github.mittyrobotics.OI;


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
    PIDController controller;

    TrapezoidProfile.State start;
    TrapezoidProfile.State end;
    TrapezoidProfile.Constraints constraints;
    TrapezoidProfile profile;
    TrapezoidProfile.State profileOutput;

    Encoder encoder;

    int kp = 1;
    int ki = 1;
    int kd = 1;

    @Override //test
    public void robotInit() {
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        start = new TrapezoidProfile.State(0, 0);
        end = new TrapezoidProfile.State(1.0, 0);
        constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
        profile = new TrapezoidProfile(constraints, end, start);
        profileOutput = profile.calculate(2.0);

        controller = new PIDController(kp, ki, kd);
        controller.setSetpoint(5*Constants.TICKS_PER_INCH);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
            double output = controller.calculate(encoder.getDistance()*10);
        sparkLeft.set(output);
        sparkRight.set(output);
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