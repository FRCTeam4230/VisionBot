// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainSubsystemConstants;

import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrainSubsystem extends SubsystemBase {  
  private WPI_TalonSRX backLeft, frontRight;
  private WPI_VictorSPX frontLeft, backRight;
  private MotorControllerGroup leftGroup, rightGroup;
  private DifferentialDrive differentialDrive;

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  double x = 0;
  double y = 0;
  double area = 0;
  
  public DriveTrainSubsystem() {
    backLeft = new WPI_TalonSRX(DriveTrainSubsystemConstants.BACK_LEFT_ID);
    backLeft.setInverted(false);
    frontLeft = new WPI_VictorSPX(DriveTrainSubsystemConstants.FRONT_LEFT_ID);
    frontLeft.setInverted(false);
    
    frontRight = new WPI_TalonSRX(DriveTrainSubsystemConstants.FRONT_RIGHT_ID);
    frontRight.setInverted(true);
    backRight = new WPI_VictorSPX(DriveTrainSubsystemConstants.BACK_RIGHT_ID);
    backRight.setInverted(true);

    leftGroup = new MotorControllerGroup(frontLeft, backLeft);
    rightGroup = new MotorControllerGroup(frontRight, backRight);

    differentialDrive = new DifferentialDrive(leftGroup, rightGroup);

    SmartDashboard.putData(this);
  }

  public void arcadeDrive(double forward, double rotation) {
    forward = forward * DriveTrainSubsystemConstants.SPEED_MULTIPLIER;
    rotation = rotation * DriveTrainSubsystemConstants.ROTATION_MULTIPLIER;
    forward = MathUtil.clamp(forward, -0.99, 0.99);
    rotation = MathUtil.clamp(rotation, -0.99, 0.99);
    differentialDrive.arcadeDrive(forward, rotation);
  }

  public void stop(){
    differentialDrive.arcadeDrive(0, 0);
  }

  public void turn(double rotation) {
    arcadeDrive(0, rotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {}

  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
  }
  }
