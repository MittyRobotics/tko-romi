package com.github.mittyrobotics.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.github.mittyrobotics.subsytems.subsystemsclass;
public class driveatspeedcommand extends CommandBase {

    double speed;

    public driveatspeedcommand(double speed) {
        this.speed = speed;
        addRequirements(subsystemsclass.getInstance());
    }
    @Override
    public void initialize() {
        subsystemsclass.getInstance().setMotors(speed, speed);
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
