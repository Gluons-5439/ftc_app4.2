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
                        // is not visible, and must be on the left

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
                            }   // ... otherwise it is on the right
                            else {
                                telemetry.addData("Gold Mineral Position", "Right");
                                p = "Right";
                            }
                        }
                        telemetry.addData("Silver pos 1: ", silverMineral1Y);
                        telemetry.addData("Silver pos 2: ", silverMineral2Y);
                        telemetry.addData("Gold pos: ", goldMineralY);
                    }
                    telemetry.update();
                }
            }
        }

        // t.land(hulk);

        // Thread.sleep(2000);     // FOR TESTING TENSORFLOW
        //t.moveBackward(500,.5, hulk);
        t.turn(1340, 'r', hulk);
        if (p.equals("Center")) {
            t.moveForward(3400,.25, hulk);
            t.moveForward(700,-.25, hulk);
         //   lowerMarker();
            t.turn(680, 'r', hulk);
            t.moveForward(600,.25, hulk);
            t.turn(1660, 'r', hulk);
            t.moveForward(4000,.25, hulk);
            t.moveForward(500,.8,hulk);

        }
        else if (p.equals("Right")) {
            t.moveForward(700,.25,hulk);
            t.turn(1400,'r', hulk);
            t.moveForward(1500,.25,hulk);
            t.turn(1800,'l', hulk);
            t.moveForward(3000,.25,hulk);
            t.moveForward(700,-.25, hulk);
        //    lowerMarker();
            t.turn(1120, 'r', hulk);
            t.moveForward(1450,.25, hulk);
            t.turn(1700, 'r', hulk);
            t.moveForward(4000,.25, hulk);
            t.moveForward(600,.8,hulk);

        }
        else { // "Left"
            t.moveForward(700,.25,hulk);
            t.turn(1400,'l', hulk);
            t.moveForward(1500,.25,hulk);
            t.turn(1800,'r', hulk);
            t.moveForward(3000,.25,hulk);
            t.moveForward(700,-.25, hulk);
          //  lowerMarker();
            t.turn(500, 'r', hulk);
            t.moveForward(1450,.25, hulk);
            t.turn(1700, 'r', hulk);
            t.moveForward(4000,.25, hulk);
            t.moveForward(600,.8, hulk);
        }
    }
}












