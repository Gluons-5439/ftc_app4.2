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
    private VuforiaLocalizer vuforia;

    private static boolean liftpos = false;

    public void runOpMode() throws InterruptedException {
        hulk.init(hardwareMap);
        AutonomousTools t = new AutonomousTools();
        final double P = 0.5;

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AfmBbcz/////AAAAGbLGg++zzk4MiOrcPTc3t9xQj3QHfISJprebOgt5JJ4+83xtFO+ApGlI3GVY/aMgCpoGEIzaJse9sXiYDiLYpJQlGDX765tWJUrqM+pzqLxVXjWA1J6c968/YqYq74Vq5emNxGHj5SF3HP3m43Iq/YYgkSdMv4BR+RThPPnIIzrbAjEAHHtMgH7vVh036+bcw9UqBfSdD/IBqrKpJLERn5+Qi/4Q4EoReCC0CTDfZ+LcY0rUur0QZRkMpxx/9s4eCgIU+qfOcSlBvjoX7QAQ2MImUME1y5yJiyaWueamnhRBOwERGBuDKyGp4eBWp4i3esJcplrWYovjzPg9fL7Thy8v9KnrHy22PUFAYY+1vjKp";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");    //This might be for Relic Recovery?-------------------------
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary



        waitForStart();


       /** Unhook
        hulk.hangLift.setPower(0.1);
        Thread.sleep(200);
        hulk.hangLift.setPower(0);
        t.moveBackward(100,P);
        hulk.hangLift.setPower(-0.1);
        Thread.sleep(200);
        hulk.hangLift.setPower(0); **/
        t.turn(90,'r');
        t.faceDegree = 0;
        /** Block Sense **/

        hulk.sensorDrop.setPower(0.35);
        Thread.sleep(400);
        hulk.sensorDrop.setPower(0);
        hulk.mineralSensor.enableLed(true);
        t.searchGold(false);
        t.pointToCrater();
        t.moveForward(200, 0.2);
        t.dropMarker();
        t.moveForward(3000, 0.6);

        /*
        hulk.mineralSensor.enableLed(true);
        //servo drop
        t.

        */



        //INSERT COLOR SENSOR STUFF HERE
     //   hulk.mineralSensor.enableLed(true);
     //   if (t.foundGold()) {
     //       t.moveForward(500,0.5);   //moveTime and speed subject to change
            //robot.spin.setPower(1);
       //     t.moveForward(2000,0.5);
       // }
    //    else {
     //       t.turn(45,'r');   //Degree may change based on our distance from the 3 minerals
      //      if (t.foundGold()) {
        //        t.moveForward(500,0.5);
         //       //robot.spin.setPower(1);
        //        t.moveForward(2000,0.5);
       //     }
         //   else {
         //       t.moveForward(500,0.5);
                //robot.spin.setPower(1);
         //       t.moveForward(2000,0.5);
         //   }
     //   }
        //if() //Enter a 3 fold if statement to check ALL blocks using if, else if, checking front, right, and then if not defaulting to left.
        //Moves forward and pushes//foam roller picks up
        // scores both block and team marker in the depot


    }


    public void searchForGold() throws InterruptedException {       //Essentially all numbers in this method are HIGHLY EXPERIMENTAL and will most probably be changed
        //Expect the robot to approach minerals from the centre

    }
}