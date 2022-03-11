package com.github.mittyrobotics;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase{
    public static DrivetrainSubsystem instance = null;
    public static DrivetrainSubsystem getInstance(){
        if (instance == null){
            instance = new DrivetrainSubsystem();
        }
        return instance;
    }
    Spark SparkLeft, SparkRight;



    public void initHardware() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

    }
    public void setSparkLeft(double val){
        SparkLeft.set(val);
    }
    public void setSparkRight(double val){
        SparkRight.set(val);
    }






    public void setMotors(double val){
        SparkLeft.set(val);
        SparkRight.set(val);
    }
    public void updateDashboard() {

    }








}



