package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by thomasmatthews on 2/27/16.
 */
public class Team7104AutoBlueFloorPark extends Team7104AutoHardware
{
    @Override public void runOpMode() throws InterruptedException
    {
        super.runOpMode();

        Climber_servo.setPosition(Climber_Saftey_Position);
        Scoop_time.reset();
        sleep(500);


        Scoop_time.reset();
        Scoop_Motor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        Scoop_Motor.setTargetPosition(Scoop_Floor);     //Should be 660!!! Temporarily adjusted because PullUp is in way.
        Scoop_Motor.setPower(.1);

        while (Scoop_time.time() < 2)
        {
            SetLeftMotors(0);
            SetRightMotors(0);
        }
        sleep(1000);

        Climber_servo.setPosition(Climber_Default_Position + .1);
        sleep(1000);
        Climber_servo.setPosition(Climber_Default_Position);
        Sweep_servo.setPosition(Sweeper_Reverse);

        RunWithEncoders(.6, .6, 6, 1);      //Small drive forward
        Turn_degrees(.5, 45, 2);            //45 degree turn right using gyro
        Scoop_Motor.setPower(0);
        RunWithEncoders(.6, .6, 40, 3);     //Long drive forward
        Turn_degrees(-.5, 50, 4);           //45 degree turn right using gyro
        sleep(1000);
        Sweep_servo.setPosition(Sweeper_Forward);
        RunWithEncoders(.5, .5, 8, 5);      //Forward to Collect Some Debris
        Sweep_servo.setPosition(.5);        //Stop Sweeper
        Scoop_Motor.setTargetPosition(Scoop_Deposit);
        Scoop_Motor.setPower(.1);
        sleep(750);

        //Move Conveyor
        Conveyor_time.reset();
        Conveyor_servo.setPosition(.6);
        while (Conveyor_time.time() < 2) {} //Do nothing
        Conveyor_servo.setPosition(.5);

        Scoop_Motor.setTargetPosition(Scoop_Floor);
        Scoop_Motor.setPower(.1);
        Turn_degrees(-.5, 90, 6);
        Scoop_Motor.setPower(0);
        RunForTime(-.5, -.5, .5, 1);
        SetLeftMotors(0);
        SetRightMotors(0);



/*
        sleep(4000);
        Climber_servo.setPosition(Climber_Saftey_Position);
        //Scoop_time.reset();
        //while (Scoop_time.time() < 1){        }


        Scoop_time.reset();
        Scoop_Motor.setTargetPosition(Scoop_Storage);     //Should be 660!!! Temporarily adjusted because PullUp is in way.
        Scoop_Motor.setPower(.1);

        while (Scoop_time.time() < .5)
        {
            SetLeftMotors(0);
            SetRightMotors(0);
        }
        telemetry.addData("Scoop Motors Stopped", 1);
        sleep(1000);
   */
    }
}
