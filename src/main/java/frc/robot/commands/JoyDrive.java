/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class JoyDrive extends CommandBase {
  /**
   * Creates a new JoyDrive.
   */
  public JoyDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    double yaxis = Robot.m_robotContainer.getAxis(Constants.yAxisNum);
    double xaxis = Robot.m_robotContainer.getSteerAxis(Constants.xAxisNum);
    Robot.driveTrain.move(yaxis, xaxis);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.move(0, 0);
    this.end(true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
