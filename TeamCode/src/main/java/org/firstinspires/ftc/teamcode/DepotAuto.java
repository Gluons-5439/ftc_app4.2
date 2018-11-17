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

    //private VuforiaLocalizer vuforia;
    //final double MAX_WHEEL_VELOCITY = 0.77203;
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
      /*  turn(90,'r');
        setFaceDegree(0);
        hulk.sensorDrop.setPower(0.35);
        Thread.sleep(400);
        hulk.sensorDrop.setPower(0);
        searchGold(false);
        hulk.mineralSensor.enableLed(false);
        pointToCrater();
        moveForward(200, 0.2);
        dropMarker();
        moveForward(3000, 0.6);
*/

      hulk.frontRight.setPower(0.8);
        hulk.frontLeft.setPower(0.8);
        hulk.backRight.setPower(0.8);
        hulk.backLeft.setPower(0.8);
        Thread.sleep(200);
        hulk.frontRight.setPower(0);
        hulk.frontLeft.setPower(0);
        hulk.backRight.setPower(0);
        hulk.backLeft.setPower(0);

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

   /* public int faceDegree = 0;          // Degree relative to direction it faces when landing ON DEPOT SIDE (crater side is -90) left - , right +

    public void moveForward(int moveTime, double speed) throws InterruptedException {
        hulk.frontLeft.setPower(speed);
        hulk.frontRight.setPower(speed);
        hulk.backLeft.setPower(speed);
        hulk.backRight.setPower(speed);
        Thread.sleep(moveTime);
    }
    public void moveBackward(int moveTime, double speed) throws InterruptedException {
        hulk.frontLeft.setPower(-speed);
        hulk.frontRight.setPower(-speed);
        hulk.backLeft.setPower(-speed);
        hulk.backRight.setPower(-speed);
        Thread.sleep(moveTime);

    }
    public void setFaceDegree(int x) {
        faceDegree = x;
    }

    public void turn(int degrees, char dir) throws InterruptedException{
        final double TURN_RADIUS = 0.26043;     //Radius of the circle whose circumference the wheels will follow when turning on its axis (in metres)
        //int time = (int)((TURN_RADIUS * Math.abs(degrees)) / MAX_WHEEL_VELOCITY) * 1000;
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
        //Thread.sleep(time);
        faceDegree += (dir == 'r' ? 1 : -1) * degrees;
    }

   /* public void changeRollerLift(boolean up) throws InterruptedException { //if up is true, it is up, so the lift needs to go down, else, it goes up
        if (!up) {
            hulk.rollerLift.setPower(-0.25); //not too fast
            Thread.sleep(2000);
        }
        else {
            hulk.rollerLift.setPower(0.0625); //gravity pulls the lift down
            Thread.sleep(250);
        }
        //EXPERIMENTAL time = (2 PI rad) / (angular velocity (6.7544 rad/s)) * 1000         (UNUSED)
    }
    */
/*
    public boolean foundGold() {
        if (lightOn) return (hulk.mineralSensor.red() >= 200 && hulk.mineralSensor.green() >= 160 && hulk.mineralSensor.blue() <= 110);
        return false;
    }

    public void searchGold(boolean isCrater) throws InterruptedException { //If approaching three minerals from the centre
        if (foundGold()) {
            moveForward((isCrater ? 350 : 700), 0.5);
        }
        else {
            turn(45, 'r');
            if (foundGold()) {
                turn(45, 'r');
                moveForward((isCrater ? 350 : 700), 0.5);
                turn(120, 'l');
                moveForward((isCrater ? 1000 : 200), 0.5);
            }
            else {
                turn(135,'l');
                moveForward((isCrater ? 750 : 1500), 0.5);
                turn(60, 'r');
                moveForward((isCrater ? 1000 : 2000), 0.5);

            }
        }
    }

    public void dropMarker() throws InterruptedException {
        hulk.markerDrop.setPower(0.35);
        Thread.sleep(400);
        hulk.markerDrop.setPower(-0.35);
        Thread.sleep(400);
        hulk.markerDrop.setPower(0);
    }

    public void pointToCrater() throws InterruptedException {         // If on same axis as crater, but just turned wrong
        turn(-135 - faceDegree, 'l');
        moveForward(3000,0.75);
    }
    */

}