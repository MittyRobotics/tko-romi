package com.github.mittyrobotics;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDriveCommand extends CommandBase {
    public static XboxController leftController;
    public static XboxController rightController;
    public static DrivetrainSubsystem drivetrainSubsystem;

    public void initialize() {
        leftController = new XboxController(0);
        rightController = new XboxController(1);
        drivetrainSubsystem = new DrivetrainSubsystem();
    }

    public void execute() {
        if (leftController.getAButtonPressed()) {
            drivetrainSubsystem.leftForward();
        }
        if (leftController.getBButtonPressed()) {
            drivetrainSubsystem.leftBackward();
        }
        if (rightController.getAButtonPressed()) {
            drivetrainSubsystem.rightForward();
        }
        if (rightController.getBButtonPressed()) {
            drivetrainSubsystem.rightBackward();
        }
        if (leftController.getAButtonReleased() || leftController.getBButtonReleased() ) {
            drivetrainSubsystem.leftStop();
        }
        if (rightController.getAButtonReleased() || rightController.getBButtonReleased() ) {
            drivetrainSubsystem.rightStop();
        }
    }

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return false;
    }
}
