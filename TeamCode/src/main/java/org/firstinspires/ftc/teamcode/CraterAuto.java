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
import java.util.List;

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
        t.initVuforia();
        t.initTfod();
        AutonomousTools t = new AutonomousTools();
        List<Recognition> updatedRecognitions;

        // Moving prototype ===== WORK IN PROGRESS =====
        do {
            t.setMotorPower(1);
            updatedRecognitions = tfod.getUpdatedRecognitions();
        }
        while (updatedRecognitions.size() != 3);


        final double P = 0.5;

        waitForStart();

        /*
        t.moveForward(1500, 0.5);
        */

        t.turnTemp(1000,'r');

    }
}