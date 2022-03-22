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
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID;
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
        moveDistance(12);
        changeDirection(90, true);
        moveDistance(6);
        changeDirection(90,false);
        moveDistance(12);
        changeDirection(120,true);
        moveDistance(18);
        changeDirection(130,false);
        moveDistance(36);
        changeDirection(90,true);
        moveDistance(10);
        changeDirection(60,false);
        moveDistance(36);
    }
    public void moveDistance(int d_inch){

    }
    public void changeDirection(int a_degrees, boolean right){
        if(right){
            //gyro check if it is greater than a_degrees
            SparkLeft.set(1);
            SparkRight.set(0);
        }
        else{
            //gyro check if it is greater than a_degrees
            SparkLeft.set(0);
            SparkRight.set(1);
        }
    }
    public void autonomousInit() {

        TrapezoidProfile.State profileOutput = profile.calculate(12*counter);
        control.setSetpoint(profileOutput.position);
        double output = control.calculate(encoder.getDistance());
        SparkLeft.set(output);
        SparkRight.set(output);
        counter++;

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

