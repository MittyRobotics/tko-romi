package com.github.mittyrobotics.subsystems;

import com.github.mittyrobotics.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    private static DrivetrainSubsystem instance;

    private Spark sparkLeft, sparkRight;
    private Encoder encoderLeft, encoderRight;

    private DrivetrainSubsystem(){

    }
    public void initHardware(){
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        encoderLeft = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        encoderRight = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);

        encoderLeft.reset();
        encoderRight.reset();

        sparkLeft.setInverted(true);
        sparkRight.setInverted(false);

        encoderLeft.setDistancePerPulse(1D/Constants.TICKS_PER_INCH);
        encoderRight.setDistancePerPulse(1D/Constants.TICKS_PER_INCH);

    }


    public static DrivetrainSubsystem getInstance(){
        if (instance == null){
            instance = new DrivetrainSubsystem();
        }
        return instance;
    }

    public void setMotors(double left, double right){
        sparkLeft.set(left);
        sparkRight.set(right);
    }

    public double getLeftEncoder (){
        return encoderLeft.getDistance();
    }
    public double getRightEncoder (){
        return encoderRight.getDistance();
    }
}
