/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.JoyDrive;

public class Drivetrain extends SubsystemBase {

  // private TalonSRX mL1;
  // private TalonSRX mL2;
  // private TalonSRX mR1;
  // private TalonSRX mR2;
  private WPI_TalonSRX mL1;
  private WPI_TalonSRX mL2;
  private WPI_TalonSRX mR1;
  private WPI_TalonSRX mR2;
  private SpeedControllerGroup leftSide;
  private SpeedControllerGroup rightSide;
  private DifferentialDrive ddrive;

  /**
   * Creates a new Drivetrain.
   */

  public Drivetrain() {
    // mL1 = new TalonSRX(Constants.Motor_Left_1_ID);
    // mL2 = new TalonSRX(Constants.Motor_Left_2_ID);
    // mR1 = new TalonSRX(Constants.Motor_Right_1_ID);
    // mR2 = new TalonSRX(Constants.Motor_Right_2_ID);
    mL1 = new WPI_TalonSRX(Constants.Motor_Left_1_ID);
    mL2 = new WPI_TalonSRX(Constants.Motor_Left_2_ID);
    mR1 = new WPI_TalonSRX(Constants.Motor_Right_1_ID);
    mR2 = new WPI_TalonSRX(Constants.Motor_Right_2_ID);
    leftSide = new SpeedControllerGroup(mL1, mL2);
    rightSide = new SpeedControllerGroup(mR1, mR2);
    // leftSide.setInverted(true);
    ddrive = new DifferentialDrive(leftSide, rightSide);
    // mL1.setInverted(true);
  }

  public void move(double power, double offset){
    // System.out.println(power + " " + offset);
    ddrive.curvatureDrive(power, offset, Math.abs(power) < .1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new JoyDrive());
  }
}
