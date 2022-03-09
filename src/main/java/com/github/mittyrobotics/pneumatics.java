package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import com.github.mittyrobitcs.util.Compressor;

public class Robot extends TimedRobot {
    Spark SparkLeft, SparkRight;
    XboxController controller;
    DoubleSolenoid sol1, sol2;

    public void robotInit() {
        SparkLeft = new Spark(0);
        SparkRight = new Spark(1);
        SparkLeft.setInverted(true);
        XboxController controller = new XboxController(0);
    }


    @Override
    public void teleopPeriodic() {
        if (OI.getInstance().getXboxController().getAButton()) {
            sol1.set(DoubleSolenoid.Value.kReverse);
        }
        if (OI.getInstance().getXboxController().getBButton()){
            sol1.set(DoubleSolenoid.Value.kForward);
        }
        if(OI.getInstance().getXboxController().getXButton()){
            sol2.set(DoubleSolenoid.Value.kForward);
        }
        if(OI.getInstance().getXboxController().getYButton()){
            sol2.set(DoubleSolenoid.Value.kReverse);
        }
    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {


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