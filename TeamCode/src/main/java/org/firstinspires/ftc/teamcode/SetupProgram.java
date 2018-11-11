package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Setup Program", group = "TeleOp")

public class SetupProgram extends LinearOpMode {
    Hardware robot = new Hardware();

    double factor = 2;

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        //Upon initialization maps robot hardware

        waitForStart();

        while (opModeIsActive()) {

            robot.waitForTick(40);
            //Stops phone from queuing too many commands and breaking
        }
    }
}