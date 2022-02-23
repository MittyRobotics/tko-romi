package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class TankDrive extends CommandBase {
    Spark sparkLeft, sparkRight;
    XboxController controller;

    @Override
    public void initialize() {
        super.initialize();

        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        controller = new XboxController(0);
    }

    @Override
    public void execute() {
        super.execute();

        sparkLeft.set(controller.getY(GenericHID.Hand.kLeft));
        sparkRight.set(controller.getY(GenericHID.Hand.kRight));
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
