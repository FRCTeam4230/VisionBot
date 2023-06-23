package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Limelight;
import frc.robot.Constants.LimelightConstants;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AimWithLimelight extends CommandBase {
  private DriveTrainSubsystem driveTrain;
  private PIDController pidController;
  
  public AimWithLimelight(DriveTrainSubsystem driveTrain) {
    this.driveTrain = driveTrain;
    pidController = new PIDController(LimelightConstants.AIM_PROPORTIONAL, 0, LimelightConstants.AIM_DERIVATIVE);

    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
    pidController.setSetpoint(0);
  }

  @Override
  public void execute() {
    double power = pidController.calculate(Limelight.getInstance().getX());

    driveTrain.arcadeDrive(0, -power);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
