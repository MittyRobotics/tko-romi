package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {
    private double distance;
    private double threshold;
    private DrivetrainSubsystem instance;

    public DriveDistanceCommand(double distance, double threshold) {
        addRequirements(DrivetrainSubsystem.getInstance());
        this.distance = distance;
        this.threshold = threshold;
        this.instance = DrivetrainSubsystem.getInstance();
    }

    @Override
    public void initialize() {
        instance.getController().setSetpoint(distance);
    }

    @Override
    public void execute() {
        double leftSparkSpeed = instance.getController().calculate(instance.getDistances()[0]);
        double rightSparkSpeed = instance.getController().calculate(instance.getDistances()[1]);
        instance.setSparkSpeed(leftSparkSpeed, rightSparkSpeed);

    }

    @Override
    public void end(boolean interrupted) {
        instance.setSparkSpeed(0, 0);
    }

    @Override
    public boolean isFinished() {
        return !((Math.abs(distance - instance.getDistances()[0]) > threshold || Math.abs(distance - instance.getDistances()[1]) > threshold));
    }
}
