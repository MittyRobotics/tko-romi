package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;



public class Robot extends TimedRobot {
    private Spark leftSpark, rightSpark;
    private DigitalInput aButton, bButton, cButton;

    private int dir;
    private static volatile boolean wPressed = false;


    @Override
    public void robotInit() {
        leftSpark = new Spark(Constants.LEFT_MOTOR_ID);
        rightSpark = new Spark(Constants.RIGHT_MOTOR_ID);

        leftSpark.setInverted(false);
        rightSpark.setInverted(true);
        aButton = new DigitalInput(Constants.A_BUTTON_ID);
        bButton = new DigitalInput(Constants.B_BUTTON_ID);
        cButton = new DigitalInput(Constants.C_BUTTON_ID);

        dir = 0;

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void teleopInit() {
        leftSpark.set(0);
        rightSpark.set(0);
    }

    @Override
    public void testInit() {

    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopPeriodic() {

        if(dir != 0 && (aButton.get() || bButton.get() || cButton.get())) {
            leftSpark.set(0);
            rightSpark.set(0);
            dir = 0;
        }

        if(aButton.get() || wPressed){
            leftSpark.set(1);
            rightSpark.set(1);
            dir = 1;
        } else if(bButton.get()){
            leftSpark.set(-1);
            rightSpark.set(-1);
            dir = -1;
        }

    }

    @Override
    public void testPeriodic() {

    }
}