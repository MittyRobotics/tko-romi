package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

import static com.github.mittyrobotics.Constants.TICKS_PER_INCH;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
    DoubleSolenoid one;
    DoubleSolenoid two;
    XboxController controller;

    @Override
    public void robotInit() {
        Compressor.getInstance().initHardware();
        one = new DoubleSolenoid(PneumaticsModuleType.CTREPOM, 0, 1);
        Compressor.getInstance().initHardware();
        two = new DoubleSolenoid(PneumaticsModuleType.CTREPOM, 2, 3);

    }
    @Override
    public void teleopPeriodic() {
        if (controller.getAButtonPressed()) {
            if (controller.getBButtonPressed()) {
                one.set(DoubleSolenoid.Value.kReverse);
            }
            if (controller.getXButtonPressed()) {
                two.set(DoubleSolenoid.Value.kForward);
            }
            if (controller.getYButtonPressed()) {
                two.set(DoubleSolenoid.Value.kReverse);
            }
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

