package org.firstinspires.ftc.teamcode;

import android.view.Display;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREVColorDistance;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

public class Hardware {

    ColorSensor mineralSensor;
    Servo sensorDrop;
    Servo markerDrop;

    DcMotor frontRight;         //Hub 3 Motor 0
    DcMotor frontLeft;          //Hub 3 Motor 1
    DcMotor backRight;          //Hub 3 Motor 2
    DcMotor backLeft;           //Hub 3 Motor 3

    private BNO055IMU imu;

   // DcMotor rollerLift;
    DcMotor hangLift;           //Hub 2
    //DcMotor spin;


    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();
    static final int tickSpeed = 1120, distanceFromCentermm = 203;
    static final double wheelCircumferencemm = 159.5929;


        public Hardware(){

        }


        public void init (HardwareMap ahwMap){
            hwMap = ahwMap;
            initDevices();
            initMotorSettings();
            initDefaultPosition();
        }

        private void initDevices () {
            imu = hwMap.get(BNO055IMU.class, "gyro");
            BNO055IMU.Parameters param = new BNO055IMU.Parameters();
            param.calibrationDataFile = "BNO055IMUCalibration.json";
            param.loggingEnabled = true;
            param.loggingTag = "IMU";
            param.mode = BNO055IMU.SensorMode.IMU;
            imu.initialize(param);

            frontLeft = hwMap.dcMotor.get("frontLeft");
            frontRight = hwMap.dcMotor.get("frontRight");
            backLeft = hwMap.dcMotor.get("backLeft");
            backRight = hwMap.dcMotor.get("backRight");

            // rollerLift = hwMap.dcMotor.get("rollerLift");
            hangLift = hwMap.dcMotor.get("hangLift");
            markerDrop = hwMap.servo.get("markerDrop");
            sensorDrop = hwMap.servo.get("sensorDrop");
            // spin = hwMap.dcMotor.get("spin");

            mineralSensor = hwMap.colorSensor.get("mineralSensor");
        }

        private void initMotorSettings () {
            frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            // rollerLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hangLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            // spin.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            frontRight.setDirection(DcMotor.Direction.FORWARD);
            backLeft.setDirection(DcMotor.Direction.REVERSE);
            backRight.setDirection(DcMotor.Direction.FORWARD);

            // rollerLift.setDirection(DcMotor.Direction.FORWARD);
            hangLift.setDirection(DcMotor.Direction.FORWARD);
            // spin.setDirection(DcMotor.Direction.FORWARD);

        }

        private void initDefaultPosition () {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
            hangLift.setPower(-0.01);
           // marker
           // Drop.setPosition(0);
            sensorDrop.setPosition(0);

            // rollerLift.setPower(0);
            // spin.setPower(0);
            mineralSensor.enableLed(false);
        }

        public void waitForTick (long periodMs) throws InterruptedException {
            long remaining = periodMs - (long) period.milliseconds();

            if (remaining > 0)
                Thread.sleep(remaining);

            period.reset();
        }
}