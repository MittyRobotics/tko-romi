package com.github.mittyrobotics;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.github.mittyrobotics.OI;

public class TankDriveCommand extends CommandBase {
    public TankDriveCommand(){
        super();
        setName("Tank Drive");
        addRequirements(DrivetrainSubsystem.getInstance());
        
    }
    Spark SparkLeft, SparkRight;
    boolean clicked;


    XboxController controller;
    DigitalInput digitalInput;



    @Override
    public void initialize() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);
        controller = new XboxController(0);



    }
    public void execute() {


        DrivetrainSubsystem.getInstance().setSparkLeft(OI.getInstance().getXboxController().getY(GenericHID.Hand.kLeft));
        DrivetrainSubsystem.getInstance().setSparkRight(OI.getInstance().getXboxController().getY(GenericHID.Hand.kRight));

        
        
        //starts tank drive
        if (controller.getAButtonPressed()){
            clicked = true;
        }
        //stops tank drive
        if (controller.getBButtonPressed()){
            clicked = false;
        }
        //tank drive
        if (clicked){
            SparkLeft.set(controller.getY(GenericHID.Hand.kLeft));
            SparkRight.set(controller.getY(GenericHID.Hand.kRight));
        }

        if (clicked = true)
            SparkLeft.set(0);
            SparkRight.set(0);

        super.execute();
    }
    public boolean isFinished() {
        return OI.getInstance().getXboxController().getAButton();

    }
    public void end(boolean interrupted) {
      //  DrivetrainSubsystem.getInstance().setSparkLeft(0);
      //  DrivetrainSubsystem.getInstance().setSparkRight(0);
    }
}



