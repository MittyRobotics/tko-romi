package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

public class DriveTrainSubsystem extends Robot {

    public void initialize() {
        //Runs when you call the command
        Spark SparkLeft;
        Spark SparkRight;
        DigitalInput ForwardButton;
        DigitalInput LeftButton;

        ForwardButton = new DigitalInput(0);
        LeftButton = new DigitalInput(1);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
    }

    public void execute() {
        //Runs periodically
        if (ForwardButton.get()) {
            SparkRight.set(0.5);
            SparkLeft.set(0.5);
        }

        if (LeftButton.get()) {
            SparkRight.set(0.5);
            SparkLeft.set(-0.5);

        }

        public boolean isFinished() {
            //Decides if command is done
        }

        public void end (boolean interrupted){
            //Runs once at the end
        }
    }
}
