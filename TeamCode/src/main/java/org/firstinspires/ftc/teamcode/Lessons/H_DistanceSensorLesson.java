package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class H_DistanceSensorLesson extends OpMode {

    DistanceSensor distSensor;

    @Override
    public void init(){
        distSensor = hardwareMap.get(DistanceSensor.class,"distSensor");
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        telemetry.addData("Distance:",distSensor.getDistance(DistanceUnit.INCH)); // You can set the units to whatever you like
    }
}