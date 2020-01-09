/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.AHRS;

/**
 * Add your docs here.
 */
public class limelightSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  AHRS ahrs;
  public double getX() {
    double a1 = 0;
    double a2 = 0;
    double h1 = 0;
    double h2 = 0;
    double d;
    double x;
    double angle = ahrs.getYaw();
    d = (h2-h1) / Math.tan(a1+a2);
    x = d * Math.sin(angle);
    return x;
  }
  public double getY() {
    double a1 = 0;
    double a2 = 0;
    double h1 = 0;
    double h2 = 0;
    double d;
    double y;
    double angle = ahrs.getYaw();
    d = (h2-h1) / Math.tan(a1+a2);
    y = d * Math.cos(angle);
    return y;
  }

  public double getAngle(){
    double angle = 0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(angle);
    return angle;
  }
  public void setPipeline(int pipeline) {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipeline);
  }
} 
