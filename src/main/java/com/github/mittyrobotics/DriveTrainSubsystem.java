package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
    //declare stuff here
    public static DriveTrainSubsystem instance = null;

    public static DriveTrainSubsystem getInstance() {
        if (instance == null) {
            instance = new DriveTrainSubsystem();
        }
        return instance;
    }

    Spark sparkLeft, sparkRight;


    public void initHardware() {
        //initialize stuff here
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
