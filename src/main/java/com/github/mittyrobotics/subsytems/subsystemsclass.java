package com.github.mittyrobotics.subsytems;
import com.github.mittyrobotics.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class subsystemsclass extends SubsystemBase {

    private static subsystemsclass instance;
    private static Object subsystemsclass;
    public void initHardware() {
        Spark sparkleft, sparkright;
        Encoder encoderleft, encoderright;
        Encoder encoderleft = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        Encoder encoderright = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);

        sparkleft.setInverted(true);
        sparkleft.setInverted(false);
    }

    public static subsystemsclass getInstance() {
        if(instance == null) {
            instance = new subsystemsclass();
        }
        return subsystemsclass;
    }

    public void setMotors(double left, double right) {
        sparkleft.set(left);
        sparkright.set(right);
    }

    public double leftEncoder() {
        return leftencoder.getDistance();
    }

}

