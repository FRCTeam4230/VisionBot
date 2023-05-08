package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Limelight;
import frc.robot.Constants.LimelightConstants;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AimWithLimelight extends CommandBase {
  DriveTrainSubsystem driveTrain;
  double tx;
  public AimWithLimelight(DriveTrainSubsystem driveTrain) {
    this.driveTrain = driveTrain;

    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    tx = Limelight.getInstance().getX();

    double power = tx * LimelightConstants.AIM_PROPORTIONAL;

    driveTrain.turn(power);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
