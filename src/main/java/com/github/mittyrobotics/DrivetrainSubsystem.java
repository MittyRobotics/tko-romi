package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    public static DrivetrainSubsystem instance = null;

    public static DrivetrainSubsystem getInstance() {
        if (instance == null) {
            instance = new DrivetrainSubsystem();
        }
        return instance;
    }

    Spark sparkLeft, sparkRight;

    public void initHardware() {
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
    }

    public void setSparkLeft(double val) {
        sparkLeft.set(val);
    }

    public void setSparkRight(double val) {
        sparkRight.set(val);
    }
}