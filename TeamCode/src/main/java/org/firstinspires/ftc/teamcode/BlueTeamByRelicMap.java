package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BlueTeamByRelic", group = "Autonomous")
public class BlueTeamByRelicMap extends LinearOpMode {
    Hardware robot = new Hardware();

    VuforiaLocalizer vuforia;

    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);
/*
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AfmBbcz/////AAAAGbLGg++zzk4MiOrcPTc3t9xQj3QHfISJprebOgt5JJ4+83xtFO+ApGlI3GVY/aMgCpoGEIzaJse9sXiYDiLYpJQlGDX765tWJUrqM+pzqLxVXjWA1J6c968/YqYq74Vq5emNxGHj5SF3HP3m43Iq/YYgkSdMv4BR+RThPPnIIzrbAjEAHHtMgH7vVh036+bcw9UqBfSdD/IBqrKpJLERn5+Qi/4Q4EoReCC0CTDfZ+LcY0rUur0QZRkMpxx/9s4eCgIU+qfOcSlBvjoX7QAQ2MImUME1y5yJiyaWueamnhRBOwERGBuDKyGp4eBWp4i3esJcplrWYovjzPg9fL7Thy8v9KnrHy22PUFAYY+1vjKp";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        double pow = 0.5; //For slowing drive

        int jewelDriveTime = 0; //will be used to modify drive time for placing block in column

        waitForStart();

        //Vuforia scan and column detection
        relicTrackables.activate();
        sleep(500);
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
        if (vuMark != RelicRecoveryVuMark.UNKNOWN) { telemetry.addData("VuMark", "%s visible", vuMark);}
        else { telemetry.addData("VuMark", "not visible");}



        relicTrackables.deactivate(); // turn off vuforia camera

        //Deploy jewel arm and grab block
        robot.jewelExtend.setPosition(0.95);
        robot.bottomClaw.setPower(.20); // Closes claw, open pos is .04

        sleep(1500);

        //Raise top lift
        robot.topLiftMotor.setPower(1);
        sleep(750);
        robot.topLiftMotor.setPower(0);

        //Begin scanning for the jewel
        robot.jewelSensor.enableLed(true); //enables color sensor light for jewel
        robot.jewelSensor.enableLight(true);
        sleep(1000);

        int colorReturn = getColor();

        sleep(500);
        if(colorReturn == 1) {
            jewelDriveTime = 300;
            goForward(-0.5);
            sleep(300);
            goStop();
        }else if(colorReturn == 0) {
            jewelDriveTime = -300;
            goForward(0.5);
            sleep(300);
            goStop();
        }else{
            System.out.println("No Color");
        }

        robot.jewelSensor.enableLed(false);
        robot.jewelSensor.enableLight(false);
        robot.jewelExtend.setPosition(0.05);

        sleep(500);


        //Drive forwards to be positioned to rotate towards proper column
        goForward(pow);
        sleep(1000 + jewelDriveTime);
        goStop();

        robot.gyro.calibrate();
        while (!isStopRequested() && robot.gyro.isCalibrating()) { sleep(50); idle();}

        if(vuMark == RelicRecoveryVuMark.LEFT){

            goLeft(pow);
            sleep(100);
            while(!isStopRequested() &&robot.gyro.getHeading() < 105) { sleep(50);}
            goStop();

        }else if(vuMark == RelicRecoveryVuMark.RIGHT){

            goLeft(pow);
            sleep(100);
            while(!isStopRequested() && robot.gyro.getHeading() < 65) { sleep(50);}
            goStop();

        }else{

            goLeft(pow);
            sleep(100);
            while(!isStopRequested() && robot.gyro.getHeading() < 85) {sleep(50);}
            goStop();

        }

        //Drives forwards and drops block
        goForward(pow/2);
        sleep(1200);
        goStop();
        robot.bottomClaw.setPower(.06); //Opens claw, .06 is open position

        //Drives away from placed block
        goForward(-pow);
        sleep(250);
        goStop();
        */

    }

}