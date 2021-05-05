package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveAtSpeedCommand extends CommandBase {
    private double speed, time;


    public DriveAtSpeedCommand(double speed) {
        addRequirements(DrivetrainSubsystem.getInstance());
        this.speed = speed;
    }

    @Override
    public void initialize() {
        DrivetrainSubsystem.getInstance().setSparkSpeed(speed, speed);
        time = System.currentTimeMillis();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().setSparkSpeed(0, 0);
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - time > 2000);
    }

}
