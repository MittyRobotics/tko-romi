
package com.github.mittyrobotics;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
class DrivetrainSubsystem extends SubsystemBase {
    public static DrivetrainSubsystem instance = null;

    public static Subsystem getInstance() {
        if (instance == null) {
            instance = new DrivetrainSubsystem();
        }
        return instance;
    }

    Spark SparkLeft, SparkRight;


    public void initHardware() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

    }

    public void setSparkLeft(double value) {
        SparkLeft.set(value);
    }

    public void setSparkRight(double value) {
        SparkRight.set(value);
    }

    public void setMotors(double value) {
        SparkLeft.set(value);
        SparkRight.set(value);
    }

    public void updateDashboard() {

    }
}