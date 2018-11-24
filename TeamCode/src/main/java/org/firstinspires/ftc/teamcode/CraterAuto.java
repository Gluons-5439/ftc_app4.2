package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

@Autonomous(name = "Crater", group = "Autonomous")

public class CraterAuto extends LinearOpMode {
    Hardware hulk = new Hardware();
    VuforiaLocalizer vuforia;
    TFObjectDetector tfod;
    AutonomousTools t = new AutonomousTools();

    final double MAX_WHEEL_VELOCITY = 0.77203;
    int faceDegree = -135;


    public void runOpMode() throws InterruptedException {
        hulk.init(hardwareMap);
        t.initVuforia(vuforia);
        t.initTfod(tfod,hardwareMap,vuforia);
        AutonomousTools t = new AutonomousTools();


        final double P = 0.5;

        waitForStart();

        moveForward(1500, 0.5);

    }

    public void moveForward(int moveTime, double speed) throws InterruptedException {
        hulk.frontLeft.setPower(speed);
        hulk.frontRight.setPower(speed);
        hulk.backLeft.setPower(speed);
        hulk.backRight.setPower(speed);
        Thread.sleep(moveTime);
    }

    public void turn(int degrees, char dir) throws InterruptedException {
        final double TURN_RADIUS = 0.26043;     //Radius of the circle whose circumference the wheels will follow when turning on its axis (in metres)
        int time = (int) ((TURN_RADIUS * Math.abs(degrees)) / MAX_WHEEL_VELOCITY) * 1000;
        if (dir == 'l') {
            hulk.frontLeft.setPower(1);
            hulk.frontRight.setPower(-1);
            hulk.backLeft.setPower(1);
            hulk.backRight.setPower(-1);
        } else if (dir == 'r') {
            hulk.frontLeft.setPower(-1);
            hulk.frontRight.setPower(1);
            hulk.backLeft.setPower(-1);
            hulk.backRight.setPower(1);
        }
        Thread.sleep(time);
        faceDegree += (dir == 'r' ? 1 : -1) * degrees;
    }

}