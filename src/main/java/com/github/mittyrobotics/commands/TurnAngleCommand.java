package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnAngleCommand extends CommandBase {
    private double angle;
    private double output;
    private double threshold;
    private DrivetrainSubsystem instance;

    public TurnAngleCommand(double angle, double threshold) {
        addRequirements(DrivetrainSubsystem.getInstance());
        this.angle = angle;
        this.threshold = threshold;
        this.instance = DrivetrainSubsystem.getInstance();
    }

    @Override
    public void initialize() {
        instance.getController().setSetpoint(instance.getGyro().getAngleZ() + angle);
    }

    @Override
    public void execute() {
        output = instance.getController().calculate(instance.getGyro().getAngleZ());
        instance.setSparkSpeed(-output, output);
    }

    @Override
    public void end(boolean interrupted) {
        instance.setSparkSpeed(0, 0);
    }

    @Override
    public boolean isFinished() {
        return (instance.getController().getPositionError() > -threshold && instance.getController().getPositionError() < threshold);
    }
}
