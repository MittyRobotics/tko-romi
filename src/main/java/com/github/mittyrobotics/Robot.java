package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import org.w3c.dom.ls.LSOutput;



public class Robot extends TimedRobot {


    Spark SparkLeft, SparkRight;


    TrapezoidProfile.State start; //start variable from type trapezoidprofile.state
    TrapezoidProfile.State end; //end var
    TrapezoidProfile.Constraints constraints; //constraints variable .constraints
    TrapezoidProfile profile; //profile from trapezoidprofile
    int counter = 0;
    double kp = 0.0, ki = 0.0, kd = 0.0;
    PIDController controller = new PIDController(kp, ki, kd);
    Encoder encoder;


    @Override
    public void robotInit() {
        start = new TrapezoidProfile.State(0, 0);
        end = new TrapezoidProfile.State(1, 0);
        constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
        profile = new TrapezoidProfile(constraints, end, start);
        encoder = new Encoder(Constants.Encoder_IDS[0], Constants.Encoder_IDS[1]);


        //initialize sparks

        SparkLeft = new Spark(0);
        SparkRight = new Spark(1);

        //inverting wheels

        SparkLeft.setInverted(true);


        RomiGyro gyro;

        Joystick joystick = new Joystick(0);

    }
        @Override
        public void teleopPeriodic() {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter);
            controller.setSetpoint(profileOutput.position);
            double output = controller.calculate(encoder.getDistance());
            counter++;
            SparkLeft.set(output);
            SparkRight.set(output);
        }

    }

