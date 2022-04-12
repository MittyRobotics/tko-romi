package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

import static com.github.mittyrobotics.Constants.*;


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
    Encoder encoder;
    PIDController controller;
    //  AddressableLED greenLight;
//  AddressableLED redLight;
//  AddressableLED yellowLight;
    double oldAngle;
    int counting;
    double distanceTraveled;

    @Override
    public void robotInit() {
        System.out.println("Robot init working");
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
        double kp = 0.0, ki = 0.0, kd = 0.0;
        controller = new PIDController(kp, ki, kd);
//      greenLight = new AddressableLED(1);
//      redLight = new AddressableLED(2);
//      yellowLight = new AddressableLED(3);
        oldAngle = 0;
        counting = 1;
        distanceTraveled = 0;
    }

    public void moveForward(int inchesToTravel, int stepNumber) {
        if (counting == stepNumber) {
            if (distanceTraveled < encoder.getDistance() - inchesToTravel) {
                TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter1);
                controller.setSetpoint(inchesToTravel * TICKS_PER_INCH);
                double output = controller.calculate(encoder.getDistance());
                sparkRight.set(output);
                sparkLeft.set(output);
                counter1++;
            }
            counting ++;
            distanceTraveled += inchesToTravel;
        }
    }

    public void turn (double angleToTurn, int stepNumber, boolean rightTurn) {
        if (stepNumber == counting) {
            if (rightTurn) {
                if (gyro.getAngleZ() < oldAngle + angleToTurn) {
                    sparkLeft.set(0.5);
                    sparkRight.set(-0.5);
                }
                oldAngle = oldAngle + angleToTurn;
            }
            else {
                if (gyro.getAngleZ() > oldAngle - angleToTurn) {
                    sparkLeft.set(-0.5);
                    sparkRight.set(0.5);
                }
                oldAngle = oldAngle - angleToTurn;
            }
            counting ++;
        }
    }

    @Override
    public void teleopPeriodic() {
        moveForward(12, 1);
        turn(90, 2, true);
        moveForward(6, 3);
        turn(90, 4, false);
        moveForward(24, 5);
        turn(90, 6, true);
        moveForward(15, 6);
        turn(90, 7, false);
        moveForward(6, 8);
        turn(80, 9, true);
        moveForward(24, 10);
        turn(70, 11, false);
        moveForward(36, 12);
        turn(70, 13, false);
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

