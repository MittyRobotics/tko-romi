package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import com.github.mittyrobotics.OI;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDriveCommand extends CommandBase {

    public TankDriveCommand() {
        addRequirements(DrivetrainSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        DrivetrainSubsystem.getInstance().setMotors(0, 0);
    }

    @Override
    public void execute() {

        double leftVel = OI.getInstance().getJoystickY(GenericHID.Hand.kLeft);
        double rightVel = OI.getInstance().getJoystickY(GenericHID.Hand.kRight);

        DrivetrainSubsystem.getInstance().setMotors(leftVel, rightVel);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
