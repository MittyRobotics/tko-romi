package com.github.mittyrobotics;

import com.github.mittyrobotics.commands.DriveAtSpeedCommand;
import com.github.mittyrobotics.commands.DriveDistanceCommand;
import com.github.mittyrobotics.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class RobotCommandSubsystem extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    public void robotInit() {
        DrivetrainSubsystem.getInstance().initHardware();
    }
    @Override
    public void teleopPeriodic() {

    }
    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {
        CommandScheduler.getInstance().schedule(new DriveDistanceCommand(10));
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

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */


    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}