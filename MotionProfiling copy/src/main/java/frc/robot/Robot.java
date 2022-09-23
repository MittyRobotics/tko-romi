
package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  TrapezoidProfile.State start;
  TrapezoidProfile.State end;
  TrapezoidProfile.Constraints constraints;
  TrapezoidProfile profile;
  TrapezoidProfile.State profileOutput;
  WPI_TalonFX falcon;
  double velocity;

  PIDController controller;
  Encoder encoder;
  double t;


  @Override
  public void robotInit() {
    falcon = new WPI_TalonFX(0);
    start = new TrapezoidProfile.State(0, 0);
    end = new TrapezoidProfile.State(5.0, 0);
    constraints = new TrapezoidProfile.Constraints(2, 0.2);
    profile = new TrapezoidProfile(constraints, end, start);
    double kp = 0.1, ki = 0, kd = 0;
    controller = new PIDController(kp, ki, kd);
  }


  @Override
  public void robotPeriodic() {}


  @Override
  public void autonomousInit() {
  }


  @Override
  public void autonomousPeriodic() {
  }


  @Override
  public void teleopInit() {
    t = 0;
  }



  @Override
  public void teleopPeriodic() {
    profileOutput = profile.calculate(0.2);
    encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
    TrapezoidProfile.State setpoint = profile.calculate(t);
    controller.setSetpoint(setpoint.velocity);
    velocity = controller.calculate(encoder.getRate());
    falcon.set(ControlMode.Velocity, velocity);
    t += 0.02;

  }



  @Override
  public void disabledInit() {}


  @Override
  public void disabledPeriodic() {}


  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}
}
