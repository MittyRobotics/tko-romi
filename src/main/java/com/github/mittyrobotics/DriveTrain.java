package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    public static DriveTrain instance = null;
    public static DriveTrain getInstance(){
        if(instance==null){
            instance = new DriveTrain();
        }
        return instance;
    }
    Spark sparkLeft, sparkRight;

    public void initHardware(){
        //initialize stuff here
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
    }
    public void setMotors(double val){
        sparkLeft.set(val);
        sparkRight.set(val);
    }
    public void setSparkLeft(double val){
        sparkLeft.set(val);
    }
    public void setSparkRight(double val){
        sparkRight.set(val);
    }
}
