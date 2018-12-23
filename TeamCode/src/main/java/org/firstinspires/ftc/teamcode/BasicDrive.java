package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;

import java.util.List;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Basic Drive", group = "TeleOp")
public class BasicDrive extends LinearOpMode {
    final double pow = 0.5;
    Hardware hulk = new Hardware();
    //Creates hulk object
    static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    AutonomousTools t = new AutonomousTools();

    public void runOpMode() throws InterruptedException {
        hulk.init(hardwareMap);
        boolean isSlow = false;
        boolean liftUp = false;
        //Upon initialization maps hulk hardware
        //Turns off the color sensor LED to save battery.
        //  double pow = 1;
        // String driveMode = "Fast Mode";
        //Maps and calibrates gyro heading during initialization
        //Makes sure initialization runs long enough for gyro to finish calibration
        waitForStart();

        while (opModeIsActive()) {


            //TeleOp for 2 Regular Front, 2 Mechanum Back
            double forward = gamepad1.left_stick_y;
            double sideways = gamepad1.right_stick_x;
            if(forward >= 0.1 || forward <= - 0.1) {
                hulk.frontLeft.setPower(forward);
                hulk.frontRight.setPower(forward);
            }
            if(sideways >= 0.1 || sideways <= - 0.1) {
                hulk.backLeft.setPower(sideways);
                hulk.backRight.setPower(-sideways);
            }

            // Manual Hanging Controls
            if (gamepad2.right_bumper) {
                hulk.hangLift.setPower(-1);
            }
            else if (!gamepad2.left_bumper) {
                hulk.hangLift.setPower(0);
            }

            if (gamepad2.left_bumper) {
                hulk.hangLift.setPower(1);
            }
            else if (!gamepad2.right_bumper) {
                hulk.hangLift.setPower(0);
            }


            // double forwards = gamepad1.left_stick_y;
            // double sideways = gamepad1.left_stick_x;

            // double leftMove = -gamepad1.left_stick_y;
            // double rightMove = gamepad1.left_stick_y;


            /*
            if(gamepad1.x)
            {
                hulk.hangLift.setPower(liftUp ? 0.7 : -0.7);
                hulk.hangLift2.setPower(liftUp ? 0.7 : -0.7);
                Thread.sleep(1000);
                hulk.hangLift.setPower(0);
                hulk.hangLift2.setPower(0);
                liftUp = !liftUp;
            }
            */


         /*  if(!xMove && !yMove)  //Case: Not moving
           {
               leftPower = 0;
               rightPower = 0;
           }
           else if(!xMove && yMove)  // Case: Straight up/Down
           {
               leftPower = gamepad1.left_stick_y;
               rightPower = gamepad1.left_stick_y;
           }
           else if(xMove && !yMove) // Case: Straight right/left
           {
               leftPower = gamepad1.left_stick_x;
               rightPower = -gamepad1.left_stick_x;
           }
           else // regular range
           {
                if(gamepad1.left_stick_x > 0)
                {
                    rightPower = 1 - gamepad1.left_stick_x;
                    leftPower = 1;
                }
                else
                {
                    rightPower = 1;
                    leftPower = 1 - gamepad1.left_stick_x;
                }

           }

            hulk.frontLeft.setPower(leftPower * speed);
            hulk.frontRight.setPower(rightPower * speed);
            hulk.backLeft.setPower(leftPower * speed);
            hulk.backRight.setPower(rightPower * speed);
*/
/*
            if (xMove) {                                                // Forward movement
                if (yMove) {                                            // For turns
                    leftPower = 0.5;                                    // Starts at middle (50%)
                    rightPower = 0.5;
                    if (gamepad1.left_stick_x > 0) {                    // x: right
                        rightPower *= 1 - gamepadXABS;                  // Treats gamepad X value as a percentage of sorts (x% of 50% speed, or 50% plus x% of 50%)
                        leftPower += 0.5 * gamepadXABS;
                    }
                    else if (gamepad1.left_stick_x < 0) {               // x: left
                        leftPower *= 1 - gamepadXABS;
                        rightPower += 0.5 * gamepadXABS;
                    }
                }
                else {                                                  // CONDITION 1
                    leftPower = 0.5 * Math.abs(gamepad1.left_stick_y);
                    rightPower = 0.5 * Math.abs(gamepad1.left_stick_y);
                }
            }
            else if (xMove) {                                           // CONDITION 2
                    leftPower = gamepad1.left_stick_x;
                    rightPower = -gamepad1.left_stick_x;
            }
            hulk.frontLeft.setPower(leftPower * speed);                 // CONDITION 3 (direction determined in variable speed (y-axis))
            hulk.frontRight.setPower(rightPower * speed);               // Negative to account for opposing wheel directions
            hulk.backLeft.setPower(leftPower * speed);
            hulk.backRight.setPower(rightPower * speed);

            //CONTROL ---------------------------------------------------------------------------------------------
            /*
            if (gamepad1.left_trigger > 0.1)            //Hold down left trigger to spin outwards (?)
                hulk.spin.setPower(-1);
            if (gamepad1.right_trigger > 0.1) {         //Used for spinning. Hold down right trigger to spin inwards
                hulk.spin.setPower(1);     //Power level subject to change if need be
            }
            else
                hulk.spin.setPower(0);*/

         /*   if (gamepad1.y) {
                t.changeRollerLift(t.liftPos);
                t.liftPos = !t.liftPos;
                sleep(250);

            }
            */

            //  if (gamepad1.a) {
            //   hulk.mineralSensor.enableLed(t.lightOn);
            //    t.lightOn = !t.lightOn;
            //     sleep(250);
            //  }


            /*if(gamepad1.a) {
                    pow = 0.25;
                    driveMode = "Slow Mode";
            } else if(gamepad1.x) {
                    pow = 1;
                    driveMode = "Fast Mode";
            }
            */


            //Creates variable theta which equals hulk heading

            //Failsafe for angle based drive: switch forward and right

            //Variables to set values based on controller input, 0.1 is deadzone

            //double temp = forward*Math.cos(Math.toRadians(theta)) - right*Math.sin(Math.toRadians(theta));
            //right = forward*Math.sin(theta) + right*Math.cos((theta));
            //forward = temp;
            //Math for drive relative to theta


            //Sets speed when rotating, still needs work


            //Three linear variables intersecting non-linearly for mecanum drive



            // If statement area




          //  double padTwoRightY = Math.abs(gamepad2.right_stick_y)>0.2 ? gamepad2.right_stick_y : 0;
            //Deadzone for controller 2 right stick, lift motor
            //ADD RESTRICTIONS TO STOP DRIVER FROM DRIVING IT PAST MAX/MIN HEIGHT
            

           // double padTwoLeftY = Math.abs(gamepad2.left_stick_y)>0.2 ? -0.5*gamepad2.left_stick_y : 0;
            //Deadzone for controller 2 left stick, topLiftMotor motor
            //ADD RESTRICTIONS TO STOP DRIVER FROM DRIVING IT PAST MAX/MIN HEIGHT

            // double leftTrigger = Math.abs(gamepad2.left_trigger)>0.2 ? -0.65*gamepad2.left_trigger : 0;
            // double rightTrigger = Math.abs(gamepad2.right_trigger)>0.2 ? 0.65*gamepad2.right_trigger : 0;
            // telemetry.addData("Drive Mode: ", driveMode);
            //boolean foundGold = false;
            //foundGold = t.foundGold();

            //telemetry.addLine("SERVOS");
            //telemetry.addLine();

            telemetry.addLine("ACCESSORIES");
             telemetry.addData("LIFT Power: ", hulk.hangLift.getPower());

            telemetry.addLine();
            telemetry.addLine();


            telemetry.addLine();
            telemetry.addLine("DRIVE MOTORS");
            telemetry.addData("X: ", gamepad1.left_stick_x);
            telemetry.addData("Y: ", gamepad1.left_stick_y);
            telemetry.addData("FR Power: ", hulk.frontRight.getPower());
            telemetry.addData("FL Power: ", hulk.frontLeft.getPower());
            telemetry.addData("BL Power: ", hulk.backLeft.getPower());
            telemetry.addData("BR Power: ", hulk.backRight.getPower());
            telemetry.addData("Right bumper", gamepad1.right_bumper);
            telemetry.addData("Left bumper", gamepad1.left_bumper);

            telemetry.update();
            // Adds everything to telemetry

            hulk.waitForTick(40);
            // Stops phone from queuing too many commands and breaking
        }
    }
}