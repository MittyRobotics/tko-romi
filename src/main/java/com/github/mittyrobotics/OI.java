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
}
