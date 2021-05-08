package com.github.mittyrobotics;

import com.github.mittyrobotics.commands.DriveAtSpeedCommand;
import com.github.mittyrobotics.commands.DriveToAngleCommand;
import com.github.mittyrobotics.commands.DriveToDistanceCommand;
import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */


    @Override
    public void robotInit() {
        DrivetrainSubsystem.getInstance().initHardware();
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        CommandScheduler.getInstance().schedule(new DriveAtSpeedCommand(0.5));
    }

    //Runs when autonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {
        CommandScheduler.getInstance().schedule(new SequentialCommandGroup(
                new DriveToDistanceCommand(10, 0.2),
                new DriveToAngleCommand(90, 0.2),
                new DriveToDistanceCommand(10, 0.2),
                new DriveToAngleCommand(90, 0.2),
                new DriveToDistanceCommand(10, 0.2),
                new DriveToAngleCommand(90, 0.2),
                new DriveToDistanceCommand(10, 0.2),
                new DriveToAngleCommand(90, 0.2)
                ));
    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {


    }

    //Runs when test mode is activated
    @Override
    public void testInit() {

    }

    //Runs whenever the robot is on, periodically: should be used for command schedulers
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();

    }

    //Runs periodically during autonomous mode
    @Override
    public void autonomousPeriodic() {

    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}