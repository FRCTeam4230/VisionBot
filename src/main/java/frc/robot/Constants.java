package frc.robot;


public final class Constants {
  public static class DriveTrainSubsystemConstants{
    public static final double RAMP_RATE = 0.2;
    public static final double CONVERSION_FACTOR = 1;

    public static final int BACK_LEFT_ID = 1;
    public static final int FRONT_RIGHT_ID = 3;
    public static final int BACK_RIGHT_ID = 4;
    public static final int FRONT_LEFT_ID = 2;

    public static final double SPEED_MULTIPLIER = .6;
    public static final double ROTATION_MULTIPLIER = 0.5;

  }
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class LimelightConstants {

    public static final double AIM_PROPORTIONAL = 0.02;//Need to refine
    public static final double AIM_DERIVATIVE = 0;

    public static final double RANGE_PROPORTIONAL = 0.12;
    public static final double RANGE_DERIVATIVE = 0;
    public static final double RANGE_SETPOINT = 36.0;

    public static final double CAMERA_ANGLE = 58.7;//Degrees
    public static final double TARGET_HEIGHT = 36.0;//Inches
    public static final double CAMERA_HEIGHT = 10.0;//Inches
  }
}
