package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveAtSpeedCommand extends CommandBase {

    double speed;

    public DriveAtSpeedCommand(double speed){
        this.speed = speed;

        addRequirements(DrivetrainSubsystem.getInstance());
    }


    @Override
    public void initialize() {
        DrivetrainSubsystem.getInstance().setMotors(speed, speed);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
