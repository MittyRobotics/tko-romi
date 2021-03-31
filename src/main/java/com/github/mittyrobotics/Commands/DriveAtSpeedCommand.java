package com.github.mittyrobotics.Commands;

import com.github.mittyrobotics.Subsystems.DriveTrainSubsystems;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveAtSpeedCommand extends CommandBase {

    double speed;

    public DriveAtSpeedCommand(double speed) {
        this.speed = speed;
        addRequirements(DriveTrainSubsystems.getInstance());
    }


    @Override
    public void initialize() {
        DriveTrainSubsystems.getInstance().setMotors(speed, speed);
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
