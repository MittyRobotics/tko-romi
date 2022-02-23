package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.XboxController;

public class OI {


    private static OI instance;

    private edu.wpi.first.wpilibj.XboxController XboxController;

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;

    }

    public XboxController getxBox  edu.wpi.first.wpilibj.XboxController getXboxController() {
        if (XboxController == null) {
            XboxController = new XboxController(0);

        }
        return XboxController;

    }


}
