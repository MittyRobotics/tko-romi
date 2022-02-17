package com.github.mittyrobotics;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private final Spark leftMotor = new Spark(0);
    private final Spark rightMotor = new Spark(1);

    private final Encoder leftEncoder = new Encoder(4, 5);
    private final Encoder rightEncoder = new Encoder(6, 7);


    public DrivetrainSubsystem() {
        rightMotor.setInverted(true);
    }

    public void leftForward(){
        leftMotor.set(0.25);
    }

    public void leftBackward(){
        leftMotor.set(-0.25);
    }

    public void leftStop(){
        leftMotor.set(0);
    }

    public void rightForward(){
        rightMotor.set(0.25);
    }

    public void rightBackward(){
        rightMotor.set(-0.25);
    }

    public void rightStop(){
        rightMotor.set(0);
    }

}
