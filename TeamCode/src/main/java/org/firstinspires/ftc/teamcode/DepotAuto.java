package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Depot", group = "Autonomous")
public class DepotAuto extends LinearOpMode {
    Hardware hulk = new Hardware();
    VuforiaLocalizer vuforia;
    TFObjectDetector tfod;
    AutonomousTools t = new AutonomousTools();
    final double MAX_WHEEL_VELOCITY = 0.77203;
    int faceDegree = 0;
    //private VuforiaLocalizer vuforia;
    boolean lightOn = false;
    final double P = 0.5;
    //private static boolean liftpos = false;

    public void runOpMode() throws InterruptedException {


        hulk.init(hardwareMap);
/*
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AfmBbcz/////AAAAGbLGg++zzk4MiOrcPTc3t9xQj3QHfISJprebOgt5JJ4+83xtFO+ApGlI3GVY/aMgCpoGEIzaJse9sXiYDiLYpJQlGDX765tWJUrqM+pzqLxVXjWA1J6c968/YqYq74Vq5emNxGHj5SF3HP3m43Iq/YYgkSdMv4BR+RThPPnIIzrbAjEAHHtMgH7vVh036+bcw9UqBfSdD/IBqrKpJLERn5+Qi/4Q4EoReCC0CTDfZ+LcY0rUur0QZRkMpxx/9s4eCgIU+qfOcSlBvjoX7QAQ2MImUME1y5yJiyaWueamnhRBOwERGBuDKyGp4eBWp4i3esJcplrWYovjzPg9fL7Thy8v9KnrHy22PUFAYY+1vjKp";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");    //This might be for Relic Recovery?-------------------------
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary */

        //  hulk.mineralSensor.enableLed(true);

        waitForStart();


       /* Unhook
        hulk.hangLift.setPower(0.1);
        Thread.sleep(200);
        hulk.hangLift.setPower(0);
        t.moveBackward(100,P);
        hulk.hangLift.setPower(-0.1);
        Thread.sleep(200);
        hulk.hangLift.setPower(0); **/
        /* Block Sense */


        /*
        t.moveForward(1700, 0.3);

        //turn(45/.0,'l');  //45/9 = 90
        t.turnTemp(1125, 'l');
        //0Thread.sleep(1000);
        // hulk.markerDrop.setPower(0.5);
        Thread.sleep(600);
        // hulk.markerDrop.setPower(0);
        t.moveForward(200, 0.3);
        t.moveForward(1400, 0.3);
        // turn(45/9,'l');  //45/9 = 90
        //turnTemp(225, 'r');
        t.moveForward(2750, 0.3);
        //turn(45/36.0,'r');  //45/9 = 90
        */

        t.turnTemp(1000,'l');


        /*t.searchGold(false);
        hulk.mineralSensor.enableLed(false);
        t.pointToCrater();
        t.moveForward(200, 0.2);
        t.dropMarker();
        t.moveForward(3000, 0.6);
        */

    }
}











