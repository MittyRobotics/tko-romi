package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {
    XboxController controller;

    public TankDrive () {
        super();
        setName("Tank Drive");
        addRequirements(DriveTrainSubsystem.getInstance());
    }

    public void initialize() {
        controller = new XboxController(0);
    }

    @Override
    public void execute() {
        DriveTrainSubsystem.getInstance().sparkLeft(controller.getY(GenericHID.Hand.kLeft));
        DriveTrainSubsystem.getInstance().sparkRight(controller.getX(GenericHID.Hand.kRight));
    }

    @Override
    public void end(boolean interrupted) {
        DriveTrainSubsystem.getInstance().sparkLeft.set(0);
        DriveTrainSubsystem.getInstance().sparkRight.set(0);
    }

    @Override
    public boolean isFinished() {
        return controller.getAButtonPressed();
    }

}
