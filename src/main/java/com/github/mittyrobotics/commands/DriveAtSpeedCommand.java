package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveAtSpeedCommand extends CommandBase {

    double speed;
    long time;

    public DriveAtSpeedCommand(double speed) {
        this.speed = speed;
        addRequirements(DrivetrainSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        DrivetrainSubsystem.getInstance().setMotors(speed, speed);
        time = System.currentTimeMillis();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().setMotors(0,0);
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - time > 5000;
    }
}
