package com.github.mittyrobotics;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;

class TankDrive extends CommandBase {
    public TankDrive(){
        super();
        setName("Tank Drive");
        addRequirements(DrivetrainSubsystems.getInstance());

    }
    Spark SparkLeft;
    Spark SparkRight;
    boolean clicked;




    @Override
    public void initialize() {
        SparkLeft = new Spark(Constants.LEFT_MOTOR_ID);
        SparkRight = new Spark(Constants.RIGHT_MOTOR_ID);




    }
    public void execute() {

        //starts tank drive
        if (OI.getXboxController().getAButtonPressed()) {
            clicked = true;
        }
    }
    public class TankDriveCommand extends CommandBase {

            }
            public boolean isFinished() {
                return OI.getXboxController().getAButtonPressed();
            }
            public void end(boolean interrupted) {
                super.end(interrupted);
                //  DrivetrainSubsystem.getInstance().setSparkLeft(0);
                //  DrivetrainSubsystem.getInstance().setSparkRight(0);
            }
        }

