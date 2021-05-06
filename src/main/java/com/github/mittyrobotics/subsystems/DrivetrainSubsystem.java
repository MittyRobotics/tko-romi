package com.github.mittyrobotics.subsystems;

import com.github.mittyrobotics.Constants;
import com.github.mittyrobotics.RomiGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.lang.invoke.WrongMethodTypeException;

public class DrivetrainSubsystem extends SubsystemBase {
    private static DrivetrainSubsystem instance;

    private Spark leftSpark, rightSpark;
    private Encoder leftEncoder, rightEncoder;
    private PIDController controller;
    private RomiGyro gyro;

    private DrivetrainSubsystem() {}

    public static DrivetrainSubsystem getInstance() {
        if (instance == null) {
            instance = new DrivetrainSubsystem();
        }
        return instance;
    }

    public void initHardware() {
        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);
        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        leftEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        rightEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        leftEncoder.reset();
        rightEncoder.reset();
        controller = new PIDController(0.2, 0, 0);
        gyro = new RomiGyro();
        gyro.reset();
    }

    public void moveStraight() {
        leftSpark.set(0.5);
        rightSpark.set(0.5);
    }

    public void setSparkSpeed(double left, double right) {
        rightSpark.set(right);
        leftSpark.set(left);
    }

    public void periodic() {

    }

    public double[] getDistances() {
        double[] returnEncoderArray = {leftEncoder.getDistance(), rightEncoder.getDistance()};
        return returnEncoderArray;
    }

    public PIDController getController() {
        return controller;
    }

    public RomiGyro getGyro() {
        return gyro;
    }
}
