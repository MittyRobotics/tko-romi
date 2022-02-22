package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import org.w3c.dom.ls.LSOutput;


public class Robot extends TimedRobot {

    DigitalInput digitalInput4;
    DigitalInput digitalInput1;
    DigitalInput digitalInput2;
    DigitalInput digitalInput3;

    Spark SparkLeft, SparkRight;

    boolean clicked;

    TrapezoidProfile.State start;
    TrapezoidProfile.State end;
    TrapezoidProfile.Constraints constraints;
    TrapezoidProfile profile;
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
        //encoder = new Encoder(Constants.Encoder_IDS[0], Constants.Encoder_IDS[1]));


        //initialize sparks

        SparkLeft = new Spark(0);
        SparkRight = new Spark(1);

        //inverting wheels

        SparkLeft.setInverted(true);

        //digital inputs (on the romi)


        digitalInput4 = new DigitalInput(4);

        if (digitalInput4.get())
            SparkLeft.set(1);
        SparkRight.set(-1);


        digitalInput1 = new DigitalInput(1);

        if (digitalInput1.get())
            SparkLeft.set(-1);
        SparkRight.set(1);


        //forward
        digitalInput2 = new DigitalInput(0);


        //back
        digitalInput3 = new DigitalInput(3);

        if (digitalInput3.get())
            SparkLeft.set(-1);
        SparkRight.set(-1);


    }


    //initialization place


    //   RomiGyro gyro;

    //   Joystick joystick = new Joystick(0);


    @Override
    public void teleopPeriodic() {
        TrapezoidProfile.State profileOutput = profile.calculate(0.01 * counter);
        controller.setSetpoint(profileOutput.position);
        //counter++;double output = controller.calculate(encoder.getPosition());
        //Spark.set(output);
    }

}