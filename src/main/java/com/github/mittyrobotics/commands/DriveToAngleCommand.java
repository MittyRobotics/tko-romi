package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveToAngleCommand extends CommandBase {
    double angle;
    double threshold;
    PIDController controller;

    public DriveToAngleCommand(double angle, double threshold) {
        addRequirements(DrivetrainSubsystem.getInstance());
        this.angle = angle;
        this.threshold = threshold;
    }

    @Override
    public void initialize() {
        controller = new PIDController(0.2, 0, 0);
        controller.setSetpoint(DrivetrainSubsystem.getInstance().getZAxis()+angle);
    }

    @Override
    public void execute() {
        double output = controller.calculate(DrivetrainSubsystem.getInstance().getZAxis());
        DrivetrainSubsystem.getInstance().setSparkSpeed(-output, output);
    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().setSparkSpeed(0, 0);
    }

    @Override
    public boolean isFinished() {
        return !(Math.abs(controller.getPositionError()) > threshold);

    }


}
