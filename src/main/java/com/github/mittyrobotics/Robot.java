package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
        //declaring motor objects (left and right motor and encoder + middle encoder)
        Spark leftMotor;
        Encoder leftEncoder;
        Spark rightMotor;
        Encoder rightEncoder;
        Encoder encoder;
        //declaring button objects
        DigitalInput a_button, b_button, c_button;
        //declaring gyro
        RomiGyro gyro;

    @Override
    public void robotInit() {
        //initializing motor objects
        sparkLeft = new Spark(0);
        sparkRight = new Spark(1);

        //initializing button objects
        a_button = new DigitalInput(0);
        b_button = new DigitalInput(2);
        c_button = new DigitalInput(1);

        //initialize encoders
        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        leftEncoder.reset();
        leftEncoder.setDistancePerPulse(1./10.);
        leftEncoder.setMinRate(10.);
        leftEncoder.setReverseDirection(true);

        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        rightEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        rightEncoder.reset();

        encoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        encoder.setDistancePerPulse(1.Constants.TICKS_PER_INCH);
        encoder.reset();

        gyro = new RomiGyro();
        gyro.reset();
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        /*
        if(a_button.get() && b_button.get() && c_button.get()){
            //REVERSE
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);
        } else if(a_button.get() && b_button.get()){
            //FORWARD
            sparkLeft.set(0.5);
            sparkRight.set(0.5);
        } else if(b_button.get() && c_button.get()){
            //TURN LEFT
            sparkLeft.set(-0.5);
            sparkRight.set(0.5);
        } else if(a_button.get() && c_button.get()){
            //TURN RIGHT
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);
        } else if(a_button.get){
            //TURN RIGHT THEN DRIVE FORWARD THEN STOP
            sparkLeft.set(0.5);
            sparkRight.set(-0,5);
        } else if(b_button.get){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);
        } else if(c_button.get){
            sparkLeft.set(0);
            sparkRight.set(0);
        }

        double distance = leftEncoder.getDistance();
        double rate = leftEncoder.getRate();
        double angleZ = gyro.getAngleZ();

        //drive 48 inches
        if(encoder.getDistance() >= 48){
            leftSpark.set(0);
            rightSpark.set(0);
        } else {
            leftSpark.set(0.5);
            rightSpark.set(0.5);
        }

        //make 90 degree turn
        if(angleZ<90)[
            leftSpark.set(0.25);
            rightSpark.set(-0.25);
        ]else if(angleZ>90){
            leftSpark.set(-0.25);
            rightSpark.set(-0.25);

        } else(
            leftSpark.set(0);
            rightSpark.set(0);
        )
    
    */

   if[encoder.getDistance()>= 101.5][
    left Spark(0);
    rightSpark(0);
    ]
   else {
    leftSpark.set(1);
    rightSpark.set(1);
   }
//------------------------
   if [angleZ<90]{
    leftSpark.set(0.5);
    rightSpark.set(-0.5);
    }else if[angleZ>90]{
    leftSpark.set(-0.5);
    rightSpark.set(0.5);
    encoder.reset();
    }else{
        if [encoder.getDistance()<72]{
            leftSpark.set(1);
            rightSpark.set(1);
            }}
//------------------------
   } if [angleZ<45]{
    leftSpark.set(0.5);
    rightSpark.set(-0.5);
    }else if[angleZ>45]{
    leftSpark.set(-0.5);
    rightSpark.set(0.5);
    encoder.reset();
    }else{
        if [encoder.getDistance()<44]{
            leftSpark.set(1);
            rightSpark.set(1);
            }}
//------------------------
   } if [angleZ<135]{
    leftSpark.set(0.5);
    rightSpark.set(-0.5);
    }else if[angleZ>135]{
    leftSpark.set(-0.5);
    rightSpark.set(0.5);
    encoder.reset();
    }else{
        if [encoder.getDistance()<]55{
            leftSpark.set(1);
            rightSpark.set(1);
            }}

    //Runs when autonomous mode (robot runs on its own) first activated via the desktop application
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