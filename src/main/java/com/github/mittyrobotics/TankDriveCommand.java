package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDriveCommand extends CommandBase {
    XboxController controller;

    public TankDriveCommand () {
        super();
        setName("Tank Drive");
        addRequirements(DriveTrainSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        controller = new XboxController(0);
    }

    @Override
    public void execute() {
        DriveTrainSubsystem.getInstance().setSparkLeft(controller.getY(GenericHID.Hand.kLeft));
        DriveTrainSubsystem.getInstance().setSparkRight(controller.getY(GenericHID.Hand.kRight));

    }

    @Override
    public void end(boolean interrupted) {
        DriveTrainSubsystem.getInstance().setSparkLeft(0);
        DriveTrainSubsystem.getInstance().setSparkRight(0);

    }

    @Override
    public boolean isFinished() {
        return controller.getAButtonPressed();
    }
}
