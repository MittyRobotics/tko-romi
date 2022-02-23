package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.github.mittyrobotics.OI;

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
        OI.getInstance().sparkLeft(controller.getY(GenericHID.Hand.kLeft)).DriveTrainSubsystem;
        sparkRight.set(OI.getInstance().getXboxController().getAButtonPressed());
    }

    @Override
    public void end(boolean interrupted) {
        OI.getInstance().sparkLeft.set(0).DriveTrainSubsystem;
        OI.getInstance().sparkRight.set(0).DriveTrainSubsystem;
    }

    @Override
    public boolean isFinished() {
        return controller.getAButtonPressed();
    }

}
