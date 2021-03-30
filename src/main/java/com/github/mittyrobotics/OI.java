package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class OI {

    private static OI instance;
    private XboxController controller;

    private OI() {

    }

    public void initHardware() {
        controller = new XboxController(Constants.CONTROLLER_PORT);
    }

    public static OI getInstance() {
        if(instance == null) {
            instance = new OI();
        }
        return instance;
    }

    public double getJoystickY(GenericHID.Hand hand) {
        return controller.getY(hand);
    }

    public double getJoystickX(GenericHID.Hand hand) {
        return controller.getX(hand);
    }
}
