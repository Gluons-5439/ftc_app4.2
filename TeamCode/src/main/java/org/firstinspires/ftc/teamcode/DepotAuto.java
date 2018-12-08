package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;
import java.util.Objects;
import java.lang.String;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Depot", group = "Autonomous")
public class DepotAuto extends LinearOpMode {
    Hardware hulk = new Hardware();
    AutonomousTools t = new AutonomousTools();

    final double MAX_WHEEL_VELOCITY = 0.77203;
    int faceDegree = -135;

    public void runOpMode() throws InterruptedException {
        hulk.init(hardwareMap);
        t.initVuforia();
        t.initTfod(hardwareMap);


        final double POW = 0.5;
        String p = "";

        waitForStart();


        t.tfod.activate();


        if (t.tfod != null) {
            boolean foundMinerals = false;


            while (!foundMinerals) {
                List<Recognition> updatedRecognitions = t.tfod.getUpdatedRecognitions();
                if (updatedRecognitions != null) {
                    /*
                    if (updatedRecognitions.size() == 2)
                        t.setMotorPower(0);
                    else t.setMotorPower(-0.05);
                    */

                    telemetry.addData("# Objects Detected", updatedRecognitions.size());
                    if (updatedRecognitions.size() == 2) {
                        foundMinerals = true;
                        int goldMineralY = -1;
                        int silverMineral1Y = -1;
                        int silverMineral2Y = -1;

                        // This just records values, and is unchanged

                        for (Recognition recognition : updatedRecognitions) {
                            if (recognition.getLabel().equals(t.LABEL_GOLD_MINERAL)) {
                                goldMineralY = (int) recognition.getTop();
                            }
                            else if (silverMineral1Y == -1) {
                                silverMineral1Y = (int) recognition.getTop();
                            }
                            else {
                                silverMineral2Y = (int) recognition.getTop();
                            }
                        }

                        // If there is no gold (-1) and there two silvers (not -1) the gold
                        // is not visible, and must be on the right

                        if (goldMineralY == -1 && silverMineral1Y != -1 && silverMineral2Y != -1) {
                            telemetry.addData("Gold Mineral Position", "Left");
                            p = "Left";
                        }

                        // If you can see one gold and one silver ...

                        else if (goldMineralY != -1 && silverMineral1Y != -1) {
                            // ... if the gold is to the right of the silver, the gold is in the center ...
                            if (goldMineralY > silverMineral1Y) {
                                telemetry.addData("Gold Mineral Position", "Center");
                                p = "Center";
                            }

                            // ... otherwise it is on the left

                            else {
                                telemetry.addData("Gold Mineral Position", "Right");
                                p = "Right";
                            }
                        }
                    }
                    telemetry.update();
                }
            }
        }






        // Thread.sleep(2000);     // FOR TESTING PURPOSES
        //t.moveBackward(500,.5, hulk);
        t.turnTemp(670, 'r', hulk);
        if (p.equals("Center")) {
            t.moveForward(3400,.25, hulk);
            lowerMarker();
            t.moveBackward(700,.25, hulk);
            t.turnTemp(340, 'r', hulk);
            t.moveForward(1000,.25, hulk);
            t.turnTemp(810, 'r', hulk);
            t.moveForward(4000,.25, hulk);
            t.moveForward(500,.8,hulk);

        }
        else if (p.equals("Right")) {
            t.moveForward(700,.25,hulk);
            t.turnTemp(700,'r', hulk);
            t.moveForward(2000,.25,hulk);
            t.turnTemp(900,'l', hulk);
            t.moveForward(2500,.25,hulk);
            t.moveBackward(700,.25, hulk);
            lowerMarker();
            t.turnTemp(810-250, 'r', hulk);
            t.moveForward(1000,.25, hulk);
            t.turnTemp(810, 'r', hulk);
            t.moveForward(4000,.25, hulk);
            t.moveForward(500,.8,hulk);
            
        }
        else { // "Left"
            t.moveForward(700,.25,hulk);
            t.turnTemp(700,'l', hulk);
            t.moveForward(1500,.25,hulk);
            t.turnTemp(900,'r', hulk);
            t.moveForward(3000,.25,hulk);
            t.moveBackward(700,.25, hulk);
            lowerMarker();
            t.turnTemp(250, 'r', hulk);
            t.moveForward(1000,.25, hulk);
            t.turnTemp(810, 'r', hulk);
            t.moveForward(4000,.25, hulk);
            t.moveForward(500,.8,hulk);
        }


    }

    private void lowerMarker() throws InterruptedException {

        hulk.rollerLift.setPower(-1);
        Thread.sleep(1000);
        hulk.rollerLift.setPower(0);
        Thread.sleep(1000);
        hulk.rollerLift.setPower(1);
        Thread.sleep(100);
        hulk.rollerLift.setPower(.5);
        Thread.sleep(500);
        hulk.rollerLift.setPower(0);
    }

    /* Unhook
    copy what is in button Y **/


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



    /*t.searchGold(false);
    hulk.mineralSensor.enableLed(false);

    t.moveForward(200, 0.2);
    t.dropMarker();
    t.moveForward(3000, 0.6);
    */
}












