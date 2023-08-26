package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//LinearOpMode is another format of coding java in FTC (sorta). I personally use it for autonomous and use OpMode for TeleOp

@TeleOp
public class B_LinearOpModeLesson extends LinearOpMode { //Make sure to put "extends LinearOpMode"
    @Override
    public void runOpMode(){ // This is the function where the robot does stuff
        //Code here is for initialization
        waitForStart(); // Waits until initialization ends
        //Code here is what happens at the very beginning of run mode
        while(opModeIsActive()){ // Its like the loop function in OpMode. Repeats during run mode until program is stopped

        }
    }

    // Most of my lessons will be in OpMode. All my lessons are able to be adapted to LinearOpMode, so you can do so if you prefer it
}
