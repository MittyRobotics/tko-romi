package com.github.mittyrobotics;

import com.github.mittyrobotics.commands.DriveAtSpeedCommand;
import com.github.mittyrobotics.commands.DriveDistanceCommand;
import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {

    @Override
    public void robotInit() {

        DrivetrainSubsystem.getInstance().initHardware();

    }

    @Override
    public void teleopInit() {
        CommandScheduler.getInstance().schedule(new DriveAtSpeedCommand(0.8f));
    }

    @Override
    public void autonomousInit() {
        CommandScheduler.getInstance().schedule(new DriveDistanceCommand(10, 0.1f));
    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void testInit() {

    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {

    }
}