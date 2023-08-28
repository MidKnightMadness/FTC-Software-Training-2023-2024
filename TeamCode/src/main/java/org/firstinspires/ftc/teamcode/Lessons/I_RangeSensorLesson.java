package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class I_RangeSensorLesson extends OpMode {
    ModernRoboticsI2cRangeSensor rangeSensor;

    @Override
    public void init(){
        rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class,"rangeSensor");
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        // Reminder: The range sensor is more accurate than the distance sensor
        // The range sensor is an I2C sensor, meaning it uses multiple sensors together to make an accurate measurement

        // You get these values individually to see if anything is broken
        telemetry.addData("Ultrasonic:",rangeSensor.rawUltrasonic());
        telemetry.addData("Optical:",rangeSensor.rawOptical());

        telemetry.addData("Range:",rangeSensor.getDistance(DistanceUnit.INCH)); // The final calculated distance. You can also change the measuring units
    }
}