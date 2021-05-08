package com.github.mittyrobotics.subsystems;

import com.github.mittyrobotics.Constants;
import com.github.mittyrobotics.RomiGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private static DrivetrainSubsystem instance;

    private Spark leftSpark, rightSpark;
    private Encoder leftEncoder, rightEncoder;
    private RomiGyro gyro;

    private DrivetrainSubsystem() {
    }
    public static DrivetrainSubsystem getInstance() {
        if (instance==null) {
            instance = new DrivetrainSubsystem();
        }
        return instance;
    }

    public void initHardware() {
        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        leftEncoder.reset();
        rightEncoder.reset();
        leftEncoder.setDistancePerPulse(1/Constants.TICKS_PER_INCH);
        rightEncoder.setDistancePerPulse(1/Constants.TICKS_PER_INCH);

        gyro = new RomiGyro();
        gyro.reset();
    }

    public void setSparkSpeed(double left, double right) {
        leftSpark.set(left);
        rightSpark.set(right);
    }

    public void periodic() {
    }

    public double getLeftDistance() {
        return leftEncoder.getDistance();
    }
    public double getRightDistance() {
        return rightEncoder.getDistance();
    }

    // get gyro z axis
    public double getZAxis() {
        return gyro.getAngleZ();
    }


}
