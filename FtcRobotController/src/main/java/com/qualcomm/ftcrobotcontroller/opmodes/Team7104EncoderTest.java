package com.qualcomm.ftcrobotcontroller.opmodes;
import static java.lang.Math.*;

/**
 * Created by Daniel on 2/12/2016.
 */

/*
    Encoder Counts/Revolution
    NeveRest 20: 560
    NeveRest 40: 1120
    NeveRest 60: 1680
*/

public class Team7104EncoderTest extends Team7104AutoHardware{

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
        //RunWithEncoders(-.5, .5, 30, 1);
        //sleep(2000);
        //RunWithEncoders(.5, .5, 5, 2);
        //sleep(2000);
        //RunWithEncoders(-.5,-.5, 35, 3);
        //sleep(2000);
        //RunWithEncoders(.5,.5,.1,0); //A check to see if the program skips the first run.
        RunWithEncoders(.8, .8, 10, 1);
        sleep(2000);
        Turn_degrees(.8, 20, 1);
        sleep(2000);
        Turn_degrees(-.2, 20, 1);
        sleep(2000);
        //Turn_degrees(.3, 175, 1);
        RunForTime(.5, .5, 1, 1);
        sleep(2000);
        //Turn_degrees(-.8, 179, 1);
        RunForTime(-.5, -.5, 5, 1);
        sleep(2000);
        RunWithEncoders(-.5,.5, 11.5, 2);
        sleep(2000);
        RunWithEncoders(.6,.6, 40, 3);
        sleep(2000);
    }
}
//  eg: if (Math.abs(target-position) < 100) stop motor.
   //     Then exit when all motors are off.