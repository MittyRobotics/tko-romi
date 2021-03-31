package com.github.mittyrobotics.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class driveatspeedcommand extends CommandBase {

    double speed;

    public driveatspeedcommand(double speed) {
        this.speed = speed;

    }
    @Override
    public void initialize() {
        subsystemsclass.getInstance().setmotors(speed, speed);
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
