package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "ServoCalibration", group = "TeleOp")

public class ServoCalibration extends LinearOpMode {
    Hardware robot = new Hardware();

    //Creates robot object

    //Declares gyro
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
       /*
        //Upon initialization maps robot hardware
        robot.jewelSensor.enableLed(false);
        //Turns off the color sensor LED to save battery.

        double UpperBound = 1;
        double LowerBound = 0;

        double increment = 0.1;

        waitForStart();

        robot.gyro.resetZAxisIntegrator();


        while (opModeIsActive()) {

            if(gamepad1.a)
                robot.jewelExtend.setPosition(UpperBound);

            if(gamepad1.b)
                robot.jewelExtend.setPosition(LowerBound);

            if(gamepad1.x)
                increment -= .01;

            if(gamepad1.y)
                increment += .01;

            if(gamepad1.dpad_down)
                UpperBound -= increment;

            if(gamepad1.dpad_up)
                UpperBound += increment;

            if(gamepad1.dpad_left)
                LowerBound -= .1;

            if(gamepad1.dpad_right)
                LowerBound += .1;

            telemetry.addData("ServoPosition: ", robot.jewelExtend.getPosition());
            telemetry.addData("UpperBound: ", UpperBound);
            telemetry.addData("LowerBound: ", LowerBound);
            telemetry.addData("Increment", increment);
            telemetry.addLine();


            telemetry.update();


            robot.waitForTick(40);
            //Stops phone from queuing too many commands and breaking
            */

    }
}