package com.github.mittyrobotics.Subsystems;

import com.github.mittyrobotics.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystems extends SubsystemBase {



    private static DriveTrainSubsystems instance;

    private Spark sparkLeft, sparkRight;
    private Encoder leftEncoder, rightEncoder;

    private DriveTrainSubsystems() {

    }



    public static DriveTrainSubsystems getInstance() {
        if(instance == null) {
            instance = new DriveTrainSubsystems();
        }
        return instance;
    }

    public void initHardware() {
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);

        leftEncoder.reset();
        rightEncoder.reset();

        sparkLeft.setInverted(true);
        sparkRight.setInverted(true);

        leftEncoder.setDistancePerPulse(1D/Constants.TICKS_PER_INCH);
        rightEncoder.setDistancePerPulse(1D/Constants.TICKS_PER_INCH);

    }

    public void setMotors(double left, double right) {
        sparkLeft.set(left);
        sparkRight.set(right);
    }

    public double getLeftEncoder() {
        return leftEncoder.getDistance();
    }

    public double getRightEncoder() {
        return rightEncoder.getDistance();
    }

}
