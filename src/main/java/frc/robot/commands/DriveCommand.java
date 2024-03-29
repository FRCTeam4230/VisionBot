// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveCommand extends CommandBase {
  private DriveTrainSubsystem driveTrain;
  private DoubleSupplier xSupplier, ySupplier;

  public DriveCommand(DriveTrainSubsystem driveTrain, DoubleSupplier xSupplier, 
  DoubleSupplier ySupplier) {
    this.driveTrain = driveTrain;
    this.xSupplier = xSupplier;
    this.ySupplier = ySupplier;

    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(ySupplier.getAsDouble() * Constants.DriveTrainSubsystemConstants.SPEED_MULTIPLIER, xSupplier.getAsDouble()* Constants.DriveTrainSubsystemConstants.ROTATION_MULTIPLIER);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
