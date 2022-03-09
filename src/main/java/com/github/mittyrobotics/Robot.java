package com.github.mittyrobotics;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.github.mittyrobotics.util.Compressor;
//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    Spark SparkLeft, SparkRight;
    DigitalInput digitalInput1;
    DigitalInput input2;
    DigitalInput input3;
    DigitalInput input4;
    XboxController controller;
    RomiGyro gyro;
    boolean clicked;
    boolean released;
    //Runs when the robot is first started up and should be used for any initialization code
    /*

     *  INITIALIZE CLASSES HERE
     */
    TrapezoidProfile.State start; //start variable from type trapezoidprofile.state
    TrapezoidProfile.State end; //end var
    TrapezoidProfile.Constraints constraints; //constraints var from .constraints
    TrapezoidProfile profile; //profile
    int counter;
    double kp, ki, kd;
    PIDController control  = new PIDController(kp, ki, kd);
    Encoder encoder;
    DoubleSolenoid s;
    DoubleSolenoid p;

    @Override
    public void robotInit() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID;
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        SparkLeft.setInverted(true);
        digitalInput1 = new DigitalInput(0);
        input2 = new DigitalInput(1);
        input3 = new DigitalInput(2);
        input4 = new DigitalInput(3);
        controller =  new XboxController(0);
        gyro = new RomiGyro();
        clicked = controller.getAButtonPressed();
        released = controller.getAButtonReleased();
        start = new TrapezoidProfile.State(0, 0);
        end = new TrapezoidProfile.State(1.0, 0);
        constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
        profile = new TrapezoidProfile(constraints, end, start);
        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        s = new DoubleSolenoid(1,2);
    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        
        TrapezoidProfile.State profileOutput = profile.calculate(0.02*counter);
        control.setSetpoint(profileOutput.position);
        double output = control.calculate(encoder.getDistance());
        SparkLeft.set(output);
        SparkRight.set(output);
        counter++;

        if(OI.getInstance().getXboxController().getAButton()){
            s.set(DoubleSolenoid.Value.kForward);
        }
        else if(OI.getInstance().getXboxController().getBButton()){
            s.set(DoubleSolenoid.Value.kReverse);
        }
        else if(OI.getInstance().getXboxController().getXButton()){
            p.set(DoubleSolenoid.Value.kForward);
        }
        else if(OI.getInstance().getXboxController().getYButton()){
            p.set(DoubleSolenoid.Value.kReverse);
        }

        if(clicked==false){
            clicked=false;
        }
        if(digitalInput1.get()) {
            SparkLeft.set(0);
            SparkRight.set(1);
        }
        else if(input2.get()){
            SparkLeft.set(1);
            SparkRight.set(0);
        }
        else if(input3.get()){
            SparkLeft.set(1);
            SparkRight.set(1);
        }
        else if(input4.get()) {
            SparkLeft.set(-1);
            SparkRight.set(-1);
        }
/*        if(controller.getAButton()){
            while(gyro.getAngleZ()<=45){
                SparkLeft.set(-0.5);
                SparkRight.set(0.5);
            }
        }
        */
        if(clicked){
            SparkLeft.set(controller.getY(GenericHID.Hand.kLeft));
            SparkRight.set(controller.getY(GenericHID.Hand.kRight));
        }
        if(controller.getAButton() && gyro.getAngleZ() <= 45){
            SparkLeft.set(-0.5);
            SparkRight.set(0.5);
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