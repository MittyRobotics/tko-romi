package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.w3c.dom.ls.LSOutput;



public class Robot extends TimedRobot {
    Boolean clicked;


    Spark SparkLeft, SparkRight;
    XboxController controller;
    DoubleSolenoid s;
    DoubleSolenoid p;


    public void robotInit() {
        //starts tank drive
        if (controller.getAButtonPressed()){
            clicked = true;
        }
        //stops tank drive
        if (controller.getBButtonPressed()){
            clicked = false;
        }
        //tank drive
        if (clicked){
            SparkLeft.set(OI.getInstance().getXboxController().getY(GenericHID.Hand.kLeft));
            SparkRight.set(OI.getInstance().getXboxController().getY(GenericHID.Hand.kRight));
        }

    }


    @Override
    public void teleopPeriodic() {

        DrivetrainSubsystem.getInstance().setSparkLeft(OI.getInstance().getXboxController().getY(GenericHID.Hand.kLeft));
        DrivetrainSubsystem.getInstance().setSparkRight(OI.getInstance().getXboxController().getY(GenericHID.Hand.kRight));
        
    }
        /*if (OI.getInstance().getXboxController().getAButton()) {

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

    */


//hi
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


