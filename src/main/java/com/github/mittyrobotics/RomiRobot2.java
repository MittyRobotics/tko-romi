package com.github.mittyrobotics;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

public class RomiRobot2 extends TimedRobot {
    Spark SparkLeft, SparkRight;
    TrapezoidProfile.State start; //start variable from type trapezoidprofile.state
    TrapezoidProfile.State end; //end var
    TrapezoidProfile.Constraints constraints; //constraints var from .constraints
    TrapezoidProfile profile; //profile
    RomiGyro gyro;
    int counter;
    double kp, ki, kd;
    PIDController control  = new PIDController(kp, ki, kd);
    Encoder encoder;

    public void robotInit() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        SparkLeft.setInverted(true);
        gyro = new RomiGyro();
        start = new TrapezoidProfile.State(0, 0);
        end = new TrapezoidProfile.State(1.0, 0);
        constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
        profile = new TrapezoidProfile(constraints, end, start);
        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
    }
    public void teleopPeriodic() {

        //straight 12 inches


    }
    public void challenge(){
        //no whiles
        //use variable so ++ when done with step6
        int currDistance = 0;
        currDistance += 12;
        moveForward(12, currDistance);
        changeDirection(90, true);
        currDistance += 6;
        moveForward(6,currDistance);
        changeDirection(90,false);
        currDistance += 12;
        moveForward(12,currDistance);
        changeDirection(120,true);
        currDistance += 18;
        moveForward(18,currDistance);
        changeDirection(130,false);
        currDistance += 36;
        moveForward(36, currDistance);
        changeDirection(90,true);
        currDistance += 10;
        moveForward(10, currDistance);
        changeDirection(60,false);
        currDistance += 36;
        moveForward(36, currDistance);
    }
    public void challenge2(){
        int currDistance = 0;
        currDistance += 12;
        moveForward(12, currDistance);
        changeDirection(90, true);
        currDistance += 6;
        moveForward(6,currDistance);
        changeDirection(90,false);
        currDistance += 24;
        moveForward(24,currDistance);
        changeDirection(90,true);
        currDistance += 15;
        moveForward(15,currDistance);
        changeDirection(80,false);
        currDistance += 6;
        moveForward(6, currDistance);
        changeDirection(100,true);
        currDistance += 24;
        moveForward(24, currDistance);
        changeDirection(110,false);
        currDistance += 36;
        moveForward(36, currDistance);
        changeDirection(70,false);
        currDistance += 30;
        moveForward(30, currDistance);
    }
    public void moveForward(int d_inch, int currDistance){
        while(encoder.getDistance()<currDistance){
            TrapezoidProfile.State profileOutput = profile.calculate(0.2*counter);
            control.setSetpoint(d_inch*Constants.TICKS_PER_INCH);
            double output = control.calculate(encoder.getDistance());
            SparkLeft.set(output);
            SparkRight.set(output);
            counter++;
        }
    }
    public void changeDirection(int a_degrees, boolean right){
        if(right){
            //gyro check if it is greater than a_degrees
            while(gyro.getAngleZ()<a_degrees){
                SparkLeft.set(1);
                SparkRight.set(-1);
            }
        }
        else{
            //gyro check if it is greater than a_degrees
            while(gyro.getAngleZ()<a_degrees){
                SparkLeft.set(-1);
                SparkRight.set(1);
            }
        }
    }
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

