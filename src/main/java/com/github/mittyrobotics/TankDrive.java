package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {

    Spark SparkLeft, SparkRight;
    DigitalInput input0;
    DigitalInput input1;
    DigitalInput input2;
    DigitalInput input3;
    XboxController controller;
    RomiGyro gyro;
    @Override
    public void initialize() {
        super.initialize();
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        SparkLeft.setInverted(true);
        input0 = new DigitalInput(0);
        input1 = new DigitalInput(1);
        input2 = new DigitalInput(2);
        input3 = new DigitalInput(3);
        controller = new XboxController(0);
        gyro = new RomiGyro();
    }

    @Override
    public void execute() {
        super.execute();
        if(controller.getAButtonPressed()) {
            if (input0.get()) {
                //move left
                SparkLeft.set(0);
                SparkRight.set(1);
            }
            if (input1.get()) {
                //move right
                SparkLeft.set(1);
                SparkRight.set(0);
            }
            if (input2.get()) {
                //move forward
                SparkLeft.set(1);
                SparkRight.set(1);
            }
            if (input3.get()) {
                SparkLeft.set(-1);
                SparkRight.set(-1);
            }
        }
        else{
            while(gyro.getAngleX()<45){
                SparkLeft.set(0.75);
                SparkRight.set(0);
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}