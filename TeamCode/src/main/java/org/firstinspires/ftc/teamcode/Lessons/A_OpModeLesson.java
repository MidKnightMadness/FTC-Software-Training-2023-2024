package org.firstinspires.ftc.teamcode.Lessons;

//importing libraries (will usually add it automatically)
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp //This determines what kind of program you are using (TeleOp or Auto). TeleOp is better for experimentation because Auto ends the program after 30 seconds
public class A_OpModeLesson extends OpMode { //Make sure to put "extends OpMode"
    //There are 2 phases in an FTC program. Initialize and Run Mode

    @Override //Honestly idk exactly what it does, but its kinda important to make sure to have it before a method
    public void init(){ // This function is what happens during initialization. Used for setting up sensors, motors, etc

    }
    @Override
    public void start(){ // This function is what happens at the very start of run mode

    }
    @Override
    public void loop(){ // This function runs constantly during run mode. Will run forever until program is stopped

    }

}
