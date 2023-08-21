package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoLesson  extends OpMode {
    // Finally, the moment you've been waiting for, hardware! We will be coding servos first
    // Servos can either run continuously or set between 2 points. I will show how to do both
    // First we declare the servos as variables
    Servo ContinuousServo;
    Servo PointServo;

    @Override
    public void init(){
        //Initialize servos
        ContinuousServo = hardwareMap.get(Servo.class,"ContinuousServo");
        PointServo = hardwareMap.get(Servo.class,"ContinuousServo");
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        //Makes servo move continuously in one direction
        if(gamepad1.left_bumper){
            ContinuousServo.setDirection(Servo.Direction.FORWARD);
        }else{
            ContinuousServo.setDirection(Servo.Direction.REVERSE);
        }

        //Makes servo move to certain position between 2 points. Positions can be decimal (ex: 0.25)
        if(gamepad1.right_bumper){
            PointServo.setPosition(1);
        }else{
            PointServo.setPosition(0);
        }
    }
}
