package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import static com.github.mittyrobotics.Constants.*;
import static java.awt.Color.*;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
    Spark sparkRight, sparkLeft;
    RomiGyro gyro;
    TrapezoidProfile.State start;
    TrapezoidProfile.State end;
    TrapezoidProfile.Constraints constraints;
    TrapezoidProfile profile;
    TrapezoidProfile.State profileOutput;
    int counter1, counter2, counter3, counter4, counter5, counter6, counter7, counter8;
    int lounter;
    Encoder encoder;
    PIDController controller;
    AddressableLED greenLight;
    AddressableLED redLight;
    AddressableLED yellowLight;
    int oldangle;
    double getOldangle;

    @Override
    public void robotInit() {
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        gyro = new RomiGyro();
        TrapezoidProfile.State start = new TrapezoidProfile.State(0,0);
        TrapezoidProfile.State end = new TrapezoidProfile.State(1.0,0);
        TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
        TrapezoidProfile profile = new TrapezoidProfile(constraints, end, start);
        TrapezoidProfile.State profileOutput = profile.calculate(0.2);
        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        counter1 = 0;
        counter2 = 0;
        counter3 =0;
        counter4 = 0;
        counter5 = 0;
        counter6 = 0;
        counter7 = 0;
        counter8 = 0;
        lounter = 0;
        oldangle = get;
        double kp = 0.0, ki = 0.0, kd = 0.0;
        controller = new PIDController(kp, ki, kd);
        greenLight = new AddressableLED(1);
        redLight = new AddressableLED(2);
        yellowLight = new AddressableLED(3);
        getOldangle = gyro.getAngleZ();
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

        if (encoder.getDistance() < 12*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter1);
            controller.setSetpoint(12 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter1++;
            lounter++;
        }
//        greenLight.start();
        
        if (gyro.getAngleZ() < 90) {
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);
            lounter++;
        }
//        greenLight.close();
//        redLight.start();
        if (encoder.getDistance() < 18*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter2);
            controller.setSetpoint(6 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter2++;
            lounter++;
        }
<<<<<<< HEAD
//        redLight.close();
//        yellowLight.start();
        if (gyro.getAngleZ() > 0) {
            sparkLeft.set(0);
=======
        redLight.close();
        yellowLight.start();
        while (gyro.getAngleZ() > 0) {
            sparkLeft.set(-0.5);
>>>>>>> 9fd1a90856a03ba095428bf2527596a5faa24e02
            sparkRight.set(0.5);
            lounter++;
        }
//        yellowLight.close();
//        greenLight.start();
        if (encoder.getDistance() < 42*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter3);
            controller.setSetpoint(24 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter3++;
            lounter++;
        }
//        greenLight.close();
//        redLight.start();
        if (gyro.getAngleZ() < 90) {
            sparkLeft.set(0.5);
<<<<<<< HEAD
            sparkRight.set(0);
            lounter++;
=======
            sparkRight.set(-0.5);
>>>>>>> 9fd1a90856a03ba095428bf2527596a5faa24e02
        }
//        redLight.close();
//        yellowLight.start();
        if (encoder.getDistance() < 57*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter4);
            controller.setSetpoint(15 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter4++;
            lounter++;
        }
<<<<<<< HEAD
//        yellowLight.close();
//        greenLight.start();
        if (gyro.getAngleZ() > 0) {
            sparkLeft.set(0);
=======
        yellowLight.close();
        greenLight.start();
        while (gyro.getAngleZ() > 0) {
            sparkLeft.set(-0.5);
>>>>>>> 9fd1a90856a03ba095428bf2527596a5faa24e02
            sparkRight.set(0.5);
            lounter++;
        }
//        greenLight.close();
//        redLight.start();
        if (encoder.getDistance() < 63*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter5);
            controller.setSetpoint(6 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter5++;
            lounter++;
        }
<<<<<<< HEAD
//        redLight.close();
//        yellowLight.start();
        if (gyro.getAngleZ() < 240) {
            sparkLeft.set(0.5);
            sparkRight.set(0);
            lounter++;
=======
        redLight.close();
        yellowLight.start();
        while (gyro.getAngleZ() < 80) {
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);
>>>>>>> 9fd1a90856a03ba095428bf2527596a5faa24e02
        }
//        yellowLight.close();
//        greenLight.start();
        if (encoder.getDistance() < 87*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter6);
            controller.setSetpoint(24 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter6++;
            lounter++;
        }
<<<<<<< HEAD
//        greenLight.close();
//        redLight.start();
        if (gyro.getAngleZ() > -50) {
            sparkLeft.set(0);
=======
        greenLight.close();
        redLight.start();
        while (gyro.getAngleZ() > 10) {
            sparkLeft.set(-0.5);
>>>>>>> 9fd1a90856a03ba095428bf2527596a5faa24e02
            sparkRight.set(0.5);
            lounter++;
        }

//        redLight.close();
//        yellowLight.start();
        if (encoder.getDistance() < 123*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter7);
            controller.setSetpoint(36 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter7++;
            lounter++;
        }
<<<<<<< HEAD
//        yellowLight.close();
//        greenLight.start();
        if (gyro.getAngleZ() > -112) {
            sparkLeft.set(0);
=======
        yellowLight.close();
        greenLight.start();
        while (gyro.getAngleZ() > -60) {
            sparkLeft.set(-0.5);
>>>>>>> 9fd1a90856a03ba095428bf2527596a5faa24e02
            sparkRight.set(0.5);
            lounter++;
        }
//        greenLight.close();
//        redLight.start();
        if (encoder.getDistance() < 153*TICKS_PER_INCH) {
            TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter8);
            controller.setSetpoint(36 * TICKS_PER_INCH);
            double output = controller.calculate(encoder.getDistance());
            sparkRight.set(output);
            sparkLeft.set(output);
            counter8++;
            lounter++;
        }
//        redLight.close();
    }

    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}

