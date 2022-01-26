package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.*;
import edu.wpi.first.wpilibj.controller.PIDController;


public class Robot extends TimedRobot {

    DigitalInput digitalInput4;
    DigitalInput digitalInput1;
    DigitalInput digitalInput2;
    DigitalInput digitalInput3;





    Spark SparkLeft, SparkRight;

    @Override
    public void robotInit() {

        SparkLeft = new Spark(0);
        SparkRight = new Spark(1);

        SparkLeft.setInverted(true);




        digitalInput4 = new DigitalInput(4);

        if (digitalInput4.get())
            SparkLeft.set(1);
            SparkRight.set(-1);




        digitalInput1 = new DigitalInput(1);

        if (digitalInput1.get())
            SparkLeft.set(-1);
            SparkRight.set(1);





        //forward
        digitalInput2 = new DigitalInput(2);






        //back
        digitalInput3 = new DigitalInput(3);

        if (digitalInput3.get())
            SparkLeft.set(-1);
            SparkRight.set(-1);







        }



    RomiGyro gyro;


    XboxController controller = new XboxController(0);


    @Override
    public void teleopPeriodic() {
        if (digitalInput4.get())
            SparkLeft.set(1);
            SparkRight.set(-1);

        if (digitalInput1.get())
            SparkLeft.set(-1);
            SparkRight.set(1);

        if (digitalInput2.get())
            SparkLeft.set(1);
            SparkRight.set(1);





        if (controller.getAButton())



            while (gyro.getAngleZ() < 45) {
                SparkLeft.set(1);
                SparkRight.set(-1);

            }

            if (controller.getAButton() && gyro.getAngleZ() < 45) {
                SparkLeft.set(1);
                SparkRight.set(-1);
            }




    }

    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

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