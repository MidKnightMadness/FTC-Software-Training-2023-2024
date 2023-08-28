package org.firstinspires.ftc.teamcode.Lessons;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp
public class G_TouchSensorLesson extends OpMode {
    // Moving on to sensors now
    // Since im starting to get tired making comments for these lessons, I will assume that you already know a few things
    // 1. A variable is needed for all sensors
    // 2. They need to be initialized
    // 3. The mode needs to be set (most of the time)
    // 4. The code that actually makes the sensor sense stuff will be in the loop function
    // If there is a need for more info, I will add comments for them

    // There are 3 types of sensors. Analog, Digital, and I2C
    // To put simply:
    // Analog outputs a number
    // Digital outputs a boolean
    // I2C communicates with multiple devices (we will go into more detail later)

    DigitalChannel Button;

    @Override
    public void init(){
        Button = hardwareMap.get(DigitalChannel.class,"Button");
        Button.setMode(DigitalChannel.Mode.INPUT);
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        telemetry.addData("Button Pressed:",Button.getState()); // returns as a boolean (pressed is false, not pressed is true)
    }
}
