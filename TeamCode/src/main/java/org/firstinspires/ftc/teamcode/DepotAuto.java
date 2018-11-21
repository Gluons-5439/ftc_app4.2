package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Depot", group = "Autonomous")
public class DepotAuto extends LinearOpMode {
    Hardware hulk = new Hardware();
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


        moveForward(1700,0.3);

        //turn(45/.0,'l');  //45/9 = 90
        turnTemp(1125, 'l');
        //0Thread.sleep(1000);
        hulk.markerDrop.setPower(0.5);
        Thread.sleep(600);
        hulk.markerDrop.setPower(0);
        moveForward(200,0.3);
        moveForward(1400,0.3);
        // turn(45/9,'l');  //45/9 = 90
        //turnTemp(225, 'r');
        moveForward(2750,0.3);
        //turn(45/36.0,'r');  //45/9 = 90


        /*t.searchGold(false);
        hulk.mineralSensor.enableLed(false);
        t.pointToCrater();
        t.moveForward(200, 0.2);
        t.dropMarker();
        t.moveForward(3000, 0.6);
        */

    }
    public void moveForward(int moveTime, double speed) throws InterruptedException {
        hulk.frontLeft.setPower(speed);
        hulk.frontRight.setPower(speed);
        hulk.backLeft.setPower(speed);
        hulk.backRight.setPower(speed);
        Thread.sleep(moveTime);
    }
    public void turn(double degrees, char dir) throws InterruptedException {
        final double TURN_RADIUS = 0.26043;     //Radius of the circle whose circumference the wheels will follow when turning on its axis (in metres)
        // AFTER MEET, CHANGE TURN_RADIUS TO 0.345, AND CONTINUE TESTING
        int time = (int)((TURN_RADIUS * Math.abs(degrees)) / MAX_WHEEL_VELOCITY) * 1000;
        if (dir == 'l') {
            hulk.frontLeft.setPower(1);
            hulk.frontRight.setPower(-1);
            hulk.backLeft.setPower(1);
            hulk.backRight.setPower(-1);
        }
        else if (dir == 'r'){
            hulk.frontLeft.setPower(-1);
            hulk.frontRight.setPower(1);
            hulk.backLeft.setPower(-1);
            hulk.backRight.setPower(1);
        }
        Thread.sleep(time);
        hulk.frontLeft.setPower(0);
        hulk.frontRight.setPower(0);
        hulk.backLeft.setPower(0);
        hulk.backRight.setPower(0);
        faceDegree += (dir == 'r' ? 1 : -1) * degrees;
    }

    public void turnTemp(int time, char dir) throws InterruptedException {
        if (dir == 'l') {
            hulk.frontLeft.setPower(1);
            hulk.frontRight.setPower(-1);
            hulk.backLeft.setPower(1);
            hulk.backRight.setPower(-1);
        }
        else if (dir == 'r'){
            hulk.frontLeft.setPower(-1);
            hulk.frontRight.setPower(1);
            hulk.backLeft.setPower(-1);
            hulk.backRight.setPower(1);
        }
        Thread.sleep(time);
        hulk.frontLeft.setPower(0);
        hulk.frontRight.setPower(0);
        hulk.backLeft.setPower(0);
        hulk.backRight.setPower(0);
    }
}











