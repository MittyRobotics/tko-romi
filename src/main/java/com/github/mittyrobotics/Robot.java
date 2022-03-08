package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import org.w3c.dom.ls.LSOutput;



public class Robot extends TimedRobot {


    Spark SparkLeft, SparkRight;
    XboxController controller;
    DoubleSolenoid s;
    DoubleSolenoid p;


    public void robotInit() {
        SparkLeft = new Spark(0); // 0 is example of left channel
        SparkRight = new Spark(1); // 1 is example of right channel
        SparkLeft.setInverted(true); // boolean parameter example
        XboxController controller = new XboxController(0);


    }


    @Override
    public void teleopPeriodic() {
        if (OI.getInstance().getXboxController().getAButton()) {

            s.set(DoubleSolenoid.Value.kReverse);
        }

        if (OI.getInstance().getXboxController().getBButton()){
            s.set(DoubleSolenoid.Value.kForward);
        }

        if(OI.getInstance().getXboxController().getYButton()){
            p.set(DoubleSolenoid.Value.kReverse);
        }

        if(OI.getInstance().getXboxController().getXButton()){
            p.set(DoubleSolenoid.Value.kForward);
        }
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


