//DO NOT TOUCH THIS CLASS

package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.Robot;

public class Main {
    public static void main(String... args) {
        RobotBase.startRobot(Robot::new);
    }
}