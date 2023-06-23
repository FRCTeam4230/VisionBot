package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Limelight;
import frc.robot.Constants.LimelightConstants;
import frc.robot.Limelight.TargetDistancer;
import frc.robot.subsystems.DriveTrainSubsystem;

public class GetInRangeWithLimelight extends CommandBase {
  private DriveTrainSubsystem driveTrain;
  private PIDController pidController;
  private TargetDistancer targetDistancer;

  public GetInRangeWithLimelight(DriveTrainSubsystem driveTrain) {
    this.driveTrain = driveTrain;
    pidController = new PIDController(LimelightConstants.RANGE_PROPORTIONAL, 0, LimelightConstants.RANGE_DERIVATIVE);
    targetDistancer = Limelight.getInstance().new TargetDistancer(LimelightConstants.CAMERA_HEIGHT, LimelightConstants.CAMERA_ANGLE, LimelightConstants.TARGET_HEIGHT);

    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
    pidController.setSetpoint(LimelightConstants.RANGE_SETPOINT);
  }

  @Override
  public void execute() {
    double power = pidController.calculate(targetDistancer.get());
    driveTrain.tankDrive(power, power);
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
