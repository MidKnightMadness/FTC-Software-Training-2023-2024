package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class C_TelemetryLesson extends LinearOpMode {
    int number = 5; // variable number set to 5 (you probably already know this)
    @Override
    public void runOpMode(){
        waitForStart();
        while(opModeIsActive()){
            // Telemetry is like a print statement in coding. Simply put, the robot sends data to the driver hub and prints it out
            // Telemetry must be run in a loop or else it will disappear right after the frame/tick ends

            telemetry.addData("number:",number); // Add data requires a caption in front

            telemetry.addLine("number: " + number); // Add line is like a regular print statement
        }
    }
}

