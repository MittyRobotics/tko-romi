package com.github.mittyrobotics.Commands;

import com.github.mittyrobotics.Subsystems.DriveTrainSubsystems;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {

    PIDController controller;
    double distance;

    public DriveDistanceCommand(double distance) {

        this.distance = distance;
        addRequirements(DriveTrainSubsystems.getInstance());
    }


    @Override
    public void initialize() {
        controller = new PIDController(0.5, 0.0001, 0.05);

    }

    @Override
    public void execute() {
        double leftMotorValue = controller.calculate(DriveTrainSubsystems.getInstance().getLeftEncoder(), distance);
        double rightMotorValue = controller.calculate(DriveTrainSubsystems.getInstance().getRightEncoder(), distance);

        DriveTrainSubsystems.getInstance().setMotors(leftMotorValue, rightMotorValue);


    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return Math.abs(controller.getPositionError()) < 0.1f;
    }
}
