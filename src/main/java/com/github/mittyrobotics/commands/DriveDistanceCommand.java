package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {

    double distance;
    double threshold;
    PIDController controller;

    public DriveDistanceCommand(double distanceInInches, double threshold) {

        this.distance = distanceInInches;
        this.threshold = threshold;

        addRequirements(DrivetrainSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        controller = new PIDController(0.5, 0.0001, 0.05);
    }

    @Override
    public void execute() {
        double leftMotorVal = controller.calculate(DrivetrainSubsystem.getInstance().getLeftEncoder(), distance);
        double rightMotorVal = controller.calculate(DrivetrainSubsystem.getInstance().getRightEncoder(), distance);

        DrivetrainSubsystem.getInstance().setMotors(leftMotorVal, rightMotorVal);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return Math.abs(controller.getPositionError()) < threshold;
    }
}
