package com.github.mittyrobotics.subsystems;

import com.github.mittyrobotics.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    private static DrivetrainSubsystem instance;

    private Spark sparkLeft, sparkRight;
    private Encoder leftEncoder, rightEncoder;

    private DrivetrainSubsystem() {
    }

    public void initHardware() {
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);

        sparkLeft.setInverted(true);
        sparkRight.setInverted(false);

        leftEncoder.reset();
        rightEncoder.reset();

        leftEncoder.setDistancePerPulse(1D/Constants.TICKS_PER_INCH);
        rightEncoder.setDistancePerPulse(1D/Constants.TICKS_PER_INCH);
    }

    public static DrivetrainSubsystem getInstance() {
        if(instance == null) {
            instance = new DrivetrainSubsystem();
        }
        return instance;
    }

    public void setMotors(double v1, double v2) {
        sparkLeft.set(v1);
        sparkRight.set(v2);
    }

    public double getLeftEncoder() {
        return leftEncoder.getDistance();
    }

    public double getRightEncoder() {
        return rightEncoder.getDistance();
    }

    @Override
    public void periodic() {

    }
}
