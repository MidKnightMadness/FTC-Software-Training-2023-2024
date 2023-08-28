package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class K_MechanumDrivingLessonPart1 extends OpMode {
    //There are many ways to code a mechanum robot, so the tutorial will be split into 3 parts
    //Theres probably more than 3 ways to do this, but these are easiest or most reliable
    // We'll start off with the simplest method

    //Making the wheel variables
    DcMotorEx FR; // Front right wheel
    DcMotorEx FL; // Front left wheel
    DcMotorEx BR; // Back right wheel
    DcMotorEx BL; // Back left wheel
    @Override
    public void init(){
        //Initializing the motors. Nothing new. Make sure its not "RUN_TO_POSITION"
        FR = hardwareMap.get(DcMotorEx.class,"FR");
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FL = hardwareMap.get(DcMotorEx.class,"FL");
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR = hardwareMap.get(DcMotorEx.class,"BR");
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL = hardwareMap.get(DcMotorEx.class,"BL");
        BL.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        double fwdSpeed = -gamepad1.left_stick_y;
        double strafeSpeed = gamepad1.left_stick_x;
        double turnSpeed = gamepad1.right_stick_x;

        // Theres probably some math behind it, but since its not as accurate as the other methods, its not worth looking into
        FR.setPower(fwdSpeed-turnSpeed-strafeSpeed);
        FL.setPower(fwdSpeed+turnSpeed+strafeSpeed);
        BR.setPower(fwdSpeed-turnSpeed+strafeSpeed);
        BL.setPower(fwdSpeed+turnSpeed-strafeSpeed);
        // don't worry I know exactly how the other 2 methods work

        //Parts 2 and 3 Coming soon
    }
}
