package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveToDistanceCommand extends CommandBase {
    private double distance;
    private double threshold;
    private PIDController controller;

    public DriveToDistanceCommand(double distance, double threshold) {
        this.distance = distance;
        this.threshold = threshold;
        addRequirements(DrivetrainSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        controller = new PIDController(0.2, 0, 0);
        controller.setSetpoint(distance);
    }

    @Override
    public void execute() {
        double leftSparkOutput = controller.calculate(DrivetrainSubsystem.getInstance().getLeftDistance());
        double rightSparkOutput = controller.calculate(DrivetrainSubsystem.getInstance().getRightDistance());
        DrivetrainSubsystem.getInstance().setSparkSpeed(leftSparkOutput, rightSparkOutput);
    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().setSparkSpeed(0,0);
    }

    @Override
    public boolean isFinished() {
        return !(Math.abs(distance-DrivetrainSubsystem.getInstance().getLeftDistance()) > threshold || Math.abs(distance-DrivetrainSubsystem.getInstance().getRightDistance()) > threshold);
    }


}
