package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LimelightConstants;
import frc.robot.Limelight;
import frc.robot.Limelight.TargetDistancer;
import frc.robot.subsystems.DriveTrainSubsystem;

public class GetInRangeAndAimWithLimelight extends CommandBase {
  private DriveTrainSubsystem driveTrain;
  private PIDController rangePidController;
  private PIDController tunrPidController;
  private TargetDistancer targetDistancer;

  public GetInRangeAndAimWithLimelight(DriveTrainSubsystem driveTrain) {
    this.driveTrain = driveTrain;
    rangePidController = new PIDController(LimelightConstants.RANGE_PROPORTIONAL, 0, LimelightConstants.RANGE_DERIVATIVE);
    targetDistancer = Limelight.getInstance().new TargetDistancer(LimelightConstants.CAMERA_HEIGHT, LimelightConstants.CAMERA_ANGLE, LimelightConstants.TARGET_HEIGHT);

    tunrPidController = new PIDController(LimelightConstants.AIM_PROPORTIONAL, 0, LimelightConstants.AIM_DERIVATIVE);


    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
    rangePidController.setSetpoint(LimelightConstants.RANGE_SETPOINT);
    tunrPidController.setSetpoint(0);
  }

  @Override
  public void execute() {
    double power = rangePidController.calculate(targetDistancer.get());
    double turn = -tunrPidController.calculate(Limelight.getInstance().getX());

    driveTrain.arcadeDrive(MathUtil.clamp(power, -0.6,.6), turn);
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
