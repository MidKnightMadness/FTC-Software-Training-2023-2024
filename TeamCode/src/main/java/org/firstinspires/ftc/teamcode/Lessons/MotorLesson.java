package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorLesson extends OpMode {
    // Motors are a bit more complex than servos
    // There are 2 ways to code motors. Power and Encoders

    // First we declare the motors as variables
    // I prefer to use Ex because its said to be better and sounds cooler
    DcMotorEx PowerMotor;
    DcMotorEx EncoderMotor;

    @Override
    public void init(){
        // Now we gotta initialize the motors
        PowerMotor = hardwareMap.get(DcMotorEx.class, "PowerMotor");
        EncoderMotor = hardwareMap.get(DcMotorEx.class, "EncoderMotor");
        // First parameter is initializing the motor. Second is the configuration name
        //You will need to set the config on the driver hub

        //Next up is setting the modes of the motors
        EncoderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Sets encoder value to 0 at the start
        EncoderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION); // You can set the motor to an encoder value. You can also use RUN_USING_ENCODERS which is slightly different
        // You can also set the PID values for the encoder motor, but that's for another lesson (probably)
        PowerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // encoders are not needed when just using power
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        if(gamepad1.left_bumper){
            PowerMotor.setPower(1); // Makes the motor run at full power
        }else{
            PowerMotor.setPower(0); // Stops the motor (will drift a bit unless you set zero power behavior at init)
        }

        EncoderMotor.setPower(1); // Makes the motor run at full power
        if(gamepad1.right_bumper){
            EncoderMotor.setTargetPosition(2000); // Makes the motor run to the encoder value of 2000
        }else{
            EncoderMotor.setTargetPosition(0); // Makes the motor run to the encoder value of 0
        }
        //Even though the power is set to 1, the motor will only move towards its target
    }
}
