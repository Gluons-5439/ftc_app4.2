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
    // VuforiaLocalizer vuforia;
    // TFObjectDetector tfod;
    AutonomousTools t = new AutonomousTools();

    final double MAX_WHEEL_VELOCITY = 0.77203;
    int faceDegree = -135;

    public void runOpMode() throws InterruptedException {
        hulk.init(hardwareMap);
        t.initVuforia();
        t.initTfod(hardwareMap);

        String p = "";

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

        t.strafe(670, 'l', hulk);
        if(p.equals("Center"))
        {
            t.moveForward(3000,.8, hulk);
        }
        else if(p.equals("Right"))
        {
            t.turn(400,'r',hulk);
            t.moveForward(2000,.25, hulk);
            t.turn(800,'l',hulk);
            t.moveForward(2000,.8, hulk);
        }
        else
        {
            t.turn(400,'l',hulk);
            t.moveForward(2000,.25, hulk);
            t.turn(800,'r',hulk);
            t.moveForward(2000,.8, hulk);
        }
    }
}