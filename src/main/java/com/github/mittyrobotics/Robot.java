package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */
    Spark SparkLeft, SparkRight;
    OI.getInstance().getXboxController();
    PIDController controller = new PIDController();
    TrapezoidProfile.State start = new TrapezoidProfile.State(0, 0);







    @Override
    public void robotInit() {
        SparkLeft = new Spark(0); // 0 is example of left channel
        SparkRight = new Spark(1); // 1 is example of right channel
        //SparkLeft.setInverted(true); // boolean parameter example
        //SparkRight.setInverted(false); // boolean parameter example





    }



    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    public void challenge() {
        double y = controller.getY(GenericHID.Hand.kLeft);
        double y2 = controller.getY(GenericHID.Hand.kRight);
        double x = controller.getX(GenericHID.Hand.kLeft);
        double x2 = controller.getX(GenericHID.Hand.kRight);
        //forward command\
        if (y > 0 && y <= 1) {
            if (y2 > 0 && y2 <= 1) {
                // go forward spark commands
                SparkLeft.set(1);
                SparkRight.set(1);
            }
        }
        //go backwards
        else if (y < 0 && y >= -1) {
            if (y2 < 0 && y2 >= -1){
                // go backward spark commands
                SparkLeft.set(-1);
                SparkRight.set(-1);
            }
        }
        //go right
        else if (x2 > 0 && x2 <= 1) {
            //go right spark command
            SparkRight.set(1);
            SparkLeft.set(0);
        }
        // go left
        else if (x < 0 && x >= -1) {
            //go left spark command
            SparkRight.set(1);
            SparkRight.set(0);
        }
    }

    @Override
    public void teleopPeriodic() {
        controller.setSetpoint(15*TICKS_PER_INCH);
        double output = controller.calculate(encoder.getPosition());
        spark.set(output);

        double FEED_FORWARD = 1.0/MAX_VELOCITY
        spark.set(10*FEED_FORWARD);

        controller.setSetpoint(10);
        double output = controller.calculate(encoder.getVelocity()*10);
        spark.set(10*FEED_FORWARD + output);



    }

    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {
        SparkLeft.set(1);
        SparkRight.set(-1);


    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {
        SparkLeft.set(-1);
        SparkRight.set(1);
    }

    //Runs when test mode is activated
    @Override
    public void testInit() {
        SparkLeft.set(-1);
        SparkRight.set(-1);
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