package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnCommand extends CommandBase {

    private double angle;
    private PIDController controller;
    private double threshold;

    public TurnCommand(double angle) {
        this(angle, 0.1);
    }

    public TurnCommand(double angle, double threshold) {
        this.angle = angle + DrivetrainSubsystem.getInstance().getGyroAngle();
        addRequirements(DrivetrainSubsystem.getInstance());
        this.threshold = threshold;
    }

    @Override
    public void initialize() {
        controller = new PIDController(0.5, 0.001, 0.01);
        controller.setSetpoint(angle);
    }

    @Override
    public void execute() {
        DrivetrainSubsystem.getInstance().setMotors(
                controller.calculate(DrivetrainSubsystem.getInstance().getGyroAngle(), angle),
                -controller.calculate(DrivetrainSubsystem.getInstance().getGyroAngle(), angle)
        );
    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().setMotors(0,0);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(controller.getPositionError()) < threshold;
    }


}
