package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    Spark sparkLeft, sparkRight;


    Encoder encoder = new Encoder(Constants.LEFT_ENCODER_IDS[1], Constants.LEFT_ENCODER_IDS[2]);


    DigitalInput dia;
    DigitalInput dib;
    DigitalInput dic;


    RomiGyro gyro;

    @Override
    public void robotInit() {
        sparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        sparkRight = new Spark(Constants.RIGHT_MOTOR_ID);

        encoder.reset();

        dia = new DigitalInput(Constants.A_BUTTON_ID);
        dib = new DigitalInput(Constants.B_BUTTON_ID);
        dic = new DigitalInput(Constants.C_BUTTON_ID);

        encoder.setDistancePerPulse(1./256.);

        gyro = new RomiGyro();
        gyro.reset();

        //sparkLeft.setInverted(true);
        //sparkRight.setInverted(false);


    }

    @Override
    public void teleopPeriodic() {

        //sparkLeft.set(1);
        //sparkRight.set(1);

//        if (encoder.getDistance() <= 5) {
//            sparkLeft.set(1);
//            //sparkRight.set(1);
//        }
//       else if (encoder.getDistance() > 5) {
//            sparkLeft.set(0);
//            //sparkRight.set(0);
//        }

       if (gyro.getAngleZ() < 88.5)  {
           sparkRight.set(1);
           sparkLeft.set(-1);
       }

       else if (gyro.getAngleZ() > 91.5)  {
            sparkRight.set(-1);
            sparkLeft.set(1);
        }

       else {
           sparkLeft.set(0);
           sparkRight.set(0);
       }

        /*
        if (dia.get() && dib.get()) {
            sparkRight.set(1);
            sparkLeft.set(1);
        }
        else if (dia.get() || dib.get()) {
          sparkLeft.set(-1);
          sparkRight.set(-1);
      }
        else if (dic.get()) {
            sparkLeft.set(-1);
            sparkRight.set(1);
        }
        else {
            sparkLeft.set(0);
            sparkRight.set(0);
        }

        */


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
        System.out.println("hi");
    }

    //Runs whenever the robot is on, periodically: should be used for command schedulers
    @Override
    public void robotPeriodic() {

    }

    //Runs periodically during autonomous mode
    @Override
    public void autonomousPeriodic() {

    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}