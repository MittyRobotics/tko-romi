package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;


public class Robot extends TimedRobot {

    DigitalInput digitalInput4;
    DigitalInput digitalInput1;
    DigitalInput digitalInput2;
    DigitalInput digitalInput3;

    Spark SparkLeft, SparkRight;

    boolean clicked;


    @Override
    public void robotInit() {
        TrapezoidProfile.State start = new TrapezoidProfile.State(0, 0);
        PIDController controller = new PIDController();

        //initialize sparks

        SparkLeft = new Spark(0);
        SparkRight = new Spark(1);

        //inverting wheels

        SparkLeft.setInverted(true);

        //digital inputs (on the romi)




        digitalInput4 = new DigitalInput(4);

        if (digitalInput4.get())
            SparkLeft.set(1);
            SparkRight.set(-1);




        digitalInput1 = new DigitalInput(1);

        if (digitalInput1.get())
            SparkLeft.set(-1);
            SparkRight.set(1);





        //forward
        digitalInput2 = new DigitalInput(0);






        //back
        digitalInput3 = new DigitalInput(3);

        if (digitalInput3.get())
            SparkLeft.set(-1);
            SparkRight.set(-1);







        }


    //initialization place



    RomiGyro gyro;

    Joystick joystick = new Joystick(0);


    XboxController controller = new XboxController(0);






    @Override
    public void teleopPeriodic() {












        
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
            SparkLeft.set(controller.getY(GenericHID.Hand.kLeft));
            SparkRight.set(controller.getY(GenericHID.Hand.kRight));
        }



















        //Robot goes forward and backward

        while(controller.getY(GenericHID.Hand.kLeft) > 0) {
            SparkLeft.set(1);
        }

        while(controller.getY(GenericHID.Hand.kLeft) < 0) {
            SparkRight.set(-1);
        }

        //Robot turns left and right

        while(controller.getX(GenericHID.Hand.kRight) > 0) {
            SparkRight.set(-1);
            SparkLeft.set(1);
        }

        while(controller.getX(GenericHID.Hand.kRight) < 0) {
            SparkRight.set(1);
            SparkLeft.set(-1);
        }


        //Robot goes forward and backward depending on button pressed

        while(controller.getAButtonPressed() == true) {
            SparkLeft.set(1);
            SparkRight.set(1);

            if (controller.getBButtonPressed() == true) {
                SparkLeft.set(0);
                SparkRight.set(0);
            }

        }

        //one joystick controls one spark

        while(controller.getY(GenericHID.Hand.kLeft) > 1){
            SparkLeft.set(controller.getY(GenericHID.Hand.kLeft));
        }

        while(controller.getY(GenericHID.Hand.kRight) > 1){
            SparkRight.set(controller.getY(GenericHID.Hand.kRight));
        }



















        //getting the x and y-axis for the joysticks

        joystick.getX();
        joystick.getY();

 //If you press a button on the controller, go forward/backward

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

    @Override
    public void autonomousInit() {

    }

    @Override
    public void teleopInit() {

        //Joystick joystick things

        joystick.getX();
        joystick.getY();

        if (joystick.getX() > 0){
            SparkLeft.set(1);
        }

        if (joystick.getX() < 0){
            SparkRight.set(1);
        }

        if (joystick.getY() > 0){
            SparkLeft.set(1);
            SparkRight.set(1);
        }

        if (joystick.getX() < 0){
            SparkRight.set(-1);
            SparkLeft.set(-1);
        }





        //If you press a button that is on the robot
        if (digitalInput3.get())
            SparkLeft.set(1);
            SparkRight.set(-1);

        if (digitalInput1.get())
            SparkLeft.set(-1);
            SparkRight.set(1);

        if (digitalInput2.get())
            SparkLeft.set(1);
            SparkRight.set(1);



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