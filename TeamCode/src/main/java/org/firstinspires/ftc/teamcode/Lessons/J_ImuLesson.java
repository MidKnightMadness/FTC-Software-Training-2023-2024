package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp
public class J_ImuLesson extends OpMode {
    BNO055IMU imu;
    Orientation angles;

    @Override
    public void init(){
        BNO055IMU.Parameters imuParameters = new BNO055IMU.Parameters(); //Declares parameters for imu
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES; //Sets angle units for imu (degrees or radians)
        imuParameters.calibrationDataFile = "BNO055IMUCalibration.json"; // Calibrates imu (the .json file should already exist in the project)
        imu = hardwareMap.get(BNO055IMU.class,"imu"); // Declares IMU
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES); //Gets angle values from IMU
        AngularVelocity velocity = imu.getAngularVelocity(); //Gets rate of change of angles
        Acceleration acceleration = imu.getAcceleration(); //Gets rate of change of velocity
        //Displays angles, velocity, and acceleration of IMU
        telemetry.addData("Z",angles.firstAngle);
        telemetry.addData("Y",angles.secondAngle);
        telemetry.addData("X",angles.thirdAngle);
        telemetry.addData("Z Angular Velocity",velocity.zRotationRate);
        telemetry.addData("Y Angular Velocity",velocity.yRotationRate);
        telemetry.addData("X Angular Velocity",velocity.xRotationRate);
        telemetry.addData("Z Acceleration",acceleration.zAccel);
        telemetry.addData("Y Acceleration",acceleration.yAccel);
        telemetry.addData("X Acceleration",acceleration.xAccel);
    }
}