package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.github.mittyrobotics.util.OI;

public class TankDriveCommand extends CommandBase {
    XboxController controller;

    public TankDriveCommand () {
        super();
        setName("Tank Drive");
        addRequirements(DrivetrainSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        controller = new XboxController(0);
    }

    @Override
    public void execute() {
        DrivetrainSubsystem.getInstance().setSparkLeft(OI.getInstance().getY(GenericHID.Hand.kLeft));
        DrivetrainSubsystem.getInstance().setSparkRight(OI.getInstance().getY(GenericHID.Hand.kRight));
    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().setSparkLeft(0);
        DrivetrainSubsystem.getInstance().setSparkRight(0);
    }

    @Override
    public boolean isFinished() {
        return OI.getInstance().getAButtonPressed();
    }
}