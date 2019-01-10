package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Basic Drive", group = "TeleOp")
public class BasicDrive extends LinearOpMode {
    final double pow = 1;
    boolean latch = false;
    Hardware hulk = new Hardware();
    //Creates hulk object
    static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    AutonomousTools t = new AutonomousTools();

    public void runOpMode() throws InterruptedException {
        hulk.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            //DRIVE

            double forward = Math.abs(gamepad1.left_stick_y) > 0.1 ? gamepad1.left_stick_y * pow : 0;
            double clockwise = Math.abs(gamepad1.left_stick_x) > 0.1 ? -gamepad1.left_stick_x * pow : 0;
            double right = Math.abs(gamepad1.right_stick_x) > 0.1 ? gamepad1.right_stick_x : 0;
            //Math for drive relative to theta
            clockwise *= -0.5;

            double fr = forward + clockwise + right;
            double br = forward + clockwise - right;
            double fl = forward - clockwise - right;
            double bl = forward - clockwise + right;
            double max = Math.abs(fl);
            if (Math.abs(fr) > max)
                max = Math.abs(fr);
            if (Math.abs(bl) > max)
                max = Math.abs(bl);
            if (Math.abs(br) > max)
                max = Math.abs(br);
            if (max > 1) {
                fl /= max;
                fr /= max;
                bl /= max;
                br /= max;
            }
            hulk.frontLeft.setPower(Range.clip(fl,-1,1));
            hulk.backLeft.setPower(Range.clip(bl,-1,1));
            hulk.frontRight.setPower(Range.clip(fr,-1,1));
            hulk.backRight.setPower(Range.clip(br,-1,1));

            // BUTTONS
            if (gamepad1.a)
                t.lowerMarker(hulk);
            if(gamepad1.x)
                t.moveLatch(latch,hulk); //latch is a boolean which true = is latched, false = isn't latched.

            if(gamepad1.right_trigger > 0.1)
            {
                hulk.hangLift.setPower(-0.75);
            }
            else if(gamepad1.left_trigger > 0.1)
            {
                hulk.hangLift.setPower(0.75);
            }
            else
                hulk.hangLift.setPower(0);

            if(gamepad1.right_bumper)
            {
                hulk.latch.setPosition(hulk.latch.getPosition() + 0.01);
            }
            else if(gamepad1.left_bumper)
            {
                hulk.latch.setPosition(hulk.latch.getPosition() - 0.01);
            }


            // TELEMETRY STATEMENTS

            telemetry.addLine("SERVOS");
            telemetry.addLine();

            telemetry.addLine("ACCESSORIES");
            telemetry.addData("LIFT Power: ", hulk.hangLift.getPower());

            telemetry.addLine();
            telemetry.addLine();


            telemetry.addLine();
            telemetry.addLine("DRIVE MOTORS");
            telemetry.addData("X: ", gamepad1.left_stick_x);
            telemetry.addData("Y: ", gamepad1.left_stick_y);
            telemetry.addData("FR Power: ", hulk.frontRight.getPower());
            telemetry.addData("FL Power: ", hulk.frontLeft.getPower());
            telemetry.addData("BL Power: ", hulk.backLeft.getPower());
            telemetry.addData("BR Power: ", hulk.backRight.getPower());
            telemetry.addData("Right bumper", gamepad1.right_bumper);
            telemetry.addData("Left bumper", gamepad1.left_bumper);
            telemetry.addData("Right stick power: ", gamepad1.right_stick_x);
            telemetry.addData("Marker Drop Servo Power: ", hulk.markerDrop.getPower());
            telemetry.addData("Latch Servo Position: ", hulk.latch.getPosition());

            telemetry.update();
            // Adds everything to telemetry

            hulk.waitForTick(40);
            // Stops phone from queuing too many commands and breaking
        }
    }
}