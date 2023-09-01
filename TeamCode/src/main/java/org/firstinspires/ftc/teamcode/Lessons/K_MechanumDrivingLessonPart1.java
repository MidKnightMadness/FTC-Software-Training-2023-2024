package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class K_MechanumDrivingLessonPart1 extends OpMode {

    BNO055IMU imu;
    Orientation angles;

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

        // IMU
        BNO055IMU.Parameters imuParameters = new BNO055IMU.Parameters(); //Declares parameters for imu
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES; //Sets angle units for imu (degrees or radians)
        imuParameters.calibrationDataFile = "BNO055IMUCalibration.json"; // Calibrates imu (the .json file should already exist in the project)
        imu = hardwareMap.get(BNO055IMU.class,"imu"); // Declares IMU
        imu.initialize(imuParameters);
    }
    @Override
    public void start(){

    }

    double [] powers = {0.0, 0.0, 0.0, 0.0};

    @Override
    public void loop(){
        // IMU
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS); //Gets angle values from IMU
        AngularVelocity velocity = imu.getAngularVelocity(); //Gets rate of change of angles
        Acceleration acceleration = imu.getAcceleration(); //Gets rate of change of velocity

        double fwdSpeed = -gamepad1.left_stick_y;
        double strafeSpeed = gamepad1.left_stick_x;
        double turnSpeed = gamepad1.right_stick_x;



        double newX = strafeSpeed * Math.cos(angles.thirdAngle - Math.PI / 2.0) + fwdSpeed * Math.sin(angles.thirdAngle - Math.PI / 2.0);
        double newY = - strafeSpeed * Math.sin(angles.thirdAngle - Math.PI / 2.0) + fwdSpeed * Math.cos(angles.thirdAngle - Math.PI / 2.0);

        powers [0] = newY+turnSpeed-newX;
        powers [1] = newY-turnSpeed-newX;
        powers [2] = newY+turnSpeed+newX;
        powers [3] = -newY+turnSpeed-newX;

        double maxVal = 0.0;

        for(int i = 0; i < 4; i++){
            if(Math.abs(powers[i]) > maxVal){
                maxVal = Math.abs(powers[i]);
            }
        }

        if(maxVal > 1.0){
            for(int i = 0; i < 4; i++){
                powers[i] /= maxVal;
            }
        }

        FL.setPower(powers[0]);
        FR.setPower(powers[1]);
        BL.setPower(powers[2]);
        BR.setPower(powers[3]);
        telemetry.addData("FL",powers[0]);
        telemetry.addData("FR",powers[1]);
        telemetry.addData("BL",powers[2]);
        telemetry.addData("BR",powers[3]);
        telemetry.update();
    }
}