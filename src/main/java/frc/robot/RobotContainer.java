// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AimWithLimelight;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;

public class RobotContainer {
  private DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  private AimWithLimelight aimWithLimelight = new AimWithLimelight(driveTrain);

  private XboxController controller = new XboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
    configureDefaultCommands();
  }

  private void configureBindings() {
    new JoystickButton(controller, XboxController.Button.kA.value).whileTrue(aimWithLimelight);
  }

  private void configureDefaultCommands() {
    driveTrain.setDefaultCommand(new DriveCommand(driveTrain, 
    () -> controller.getLeftX(), () -> controller.getLeftY()));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
