package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


public class AutonomousTools {
    Hardware hulk = new Hardware();
    final double MAX_WHEEL_VELOCITY = 0.77203;
    public boolean liftPos = false;
    public boolean lightOn = false;

    public void moveForward(int moveTime, double speed) throws InterruptedException {
        hulk.frontLeft.setPower(speed);
        hulk.frontRight.setPower(speed);
        hulk.backLeft.setPower(speed);
        hulk.backRight.setPower(speed);
        Thread.sleep(moveTime);
    }
    //public static void main(String args[])
   // {



  //  }
    public void moveBackward(int moveTime, double speed) throws InterruptedException {
        hulk.frontLeft.setPower(-speed);
        hulk.frontRight.setPower(-speed);
        hulk.backLeft.setPower(-speed);
        hulk.backRight.setPower(-speed);
        Thread.sleep(moveTime);

    }

    public void turn(int degrees, char dir) throws InterruptedException {
        final double TURN_RADIUS = 0.26043;     //Radius of the circle whose circumference the wheels will follow when turning on its axis (in metres)
        int time = (int)((TURN_RADIUS * Math.abs(degrees)) / MAX_WHEEL_VELOCITY) * 1000;
        if (dir == 'l') {
            hulk.frontLeft.setPower(-1);
            hulk.frontRight.setPower(1);
            hulk.backLeft.setPower(-1);
            hulk.backRight.setPower(1);
        }
        else if (dir == 'r'){
            hulk.frontLeft.setPower(1);
            hulk.frontRight.setPower(-1);
            hulk.backLeft.setPower(1);
            hulk.backRight.setPower(-1);
        }
        Thread.sleep(time);
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

   // public boolean foundGold() {
   //     if (lightOn) return (hulk.mineralSensor.red() >= 200 && hulk.mineralSensor.green() >= 160 && hulk.mineralSensor.blue() <= 100);
    //    return false;
   // }




















    /*
    Hardware hulk = null;

    AutonomousTools(Hardware newRobot){
        Hardware hulk = newRobot;
    }


//Change this
    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);

    // These constants define the desired driving/control characteristics
    // The can/should be tweaked to suite the specific hulk drive train.
    static final double     DRIVE_SPEED             = 0.7;     // Nominal speed for better accuracy.
    static final double     TURN_SPEED              = 0.5;     // Nominal half speed for better accuracy.

    static final double     HEADING_THRESHOLD       = 1 ;      // As tight as we can make it with an integer gyro
    static final double     P_TURN_COEFF            = 0.1;     // Larger is more responsive, but also less stable
    static final double     P_DRIVE_COEFF           = 0.15;


    public void initVuforia(VuforiaLocalizer vuforia, HardwareMap hardwareMap, VuforiaTrackables relicTrackables, VuforiaTrackable relicTemplate) throws InterruptedException{
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        params.vuforiaLicenseKey = "AfmBbcz/////AAAAGbLGg++zzk4MiOrcPTc3t9xQj3QHfISJprebOgt5JJ4+83xtFO+ApGlI3GVY/aMgCpoGEIzaJse9sXiYDiLYpJQlGDX765tWJUrqM+pzqLxVXjWA1J6c968/YqYq74Vq5emNxGHj5SF3HP3m43Iq/YYgkSdMv4BR+RThPPnIIzrbAjEAHHtMgH7vVh036+bcw9UqBfSdD/IBqrKpJLERn5+Qi/4Q4EoReCC0CTDfZ+LcY0rUur0QZRkMpxx/9s4eCgIU+qfOcSlBvjoX7QAQ2MImUME1y5yJiyaWueamnhRBOwERGBuDKyGp4eBWp4i3esJcplrWYovjzPg9fL7Thy8v9KnrHy22PUFAYY+1vjKp";
        params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;
        vuforia = ClassFactory.createVuforiaLocalizer(params);

        relicTrackables = vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary
    }





    //Input the degree you want to move the drive train and the power (moves in a panning motion)
   /*
    public void moveVector(double degree, double power) throws InterruptedException{
        double clockwise = 0;
        double forward = 0;
        double right = 0;

        double rightDegree = Math.toDegrees(Math.sin(degree)*power);
        double forwardDegree = Math.toDegrees(Math.cos(degree)*power);
        right = Math.toRadians(degree);
        forward = Math.toRadians(degree);

        hulk.frontLeft.setPower(Range.clip(forward+clockwise+right,-1,1));
        hulk.backLeft.setPower(Range.clip(-forward+clockwise-right,-1,1));
        hulk.frontRight.setPower(Range.clip(forward-clockwise-right,-1,1));
        hulk.backRight.setPower(Range.clip(-forward-clockwise+right,-1,1));

    }
    */

   /* public int getColor() throws InterruptedException{
        if(robot.jewelSensor.red() > hulk.jewelSensor.blue()){
            return 1; //1 = red
        } else if(robot.jewelSensor.blue() > hulk.jewelSensor.red()) {
            return 0; // 0 = blue
        } else {
            return -1; // -1 = abort
        }
    }
    */

    /*public void gyroDrive ( double speed, double distance, double angle) {

        int     newLeftTarget;
        int     newRightTarget;
        int     moveCounts;
        double  max;
        double  error;
        double  steer;
        double  leftSpeed;
        double  rightSpeed;

        // Ensure that the opmode is still active
        //if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            moveCounts = (int)(distance * COUNTS_PER_INCH);
            newLeftTarget = hulk.backLeft.getCurrentPosition() + moveCounts;
            newRightTarget = hulk.backRight.getCurrentPosition() + moveCounts;

            // Set Target and Turn On RUN_TO_POSITION
            hulk.backLeft.setTargetPosition(newLeftTarget);
            hulk.backRight.setTargetPosition(newRightTarget);

            hulk.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            hulk.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // start motion.
            speed = Range.clip(Math.abs(speed), 0.0, 1.0);
            hulk.backLeft.setPower(speed);
            hulk.backRight.setPower(speed);

            // keep looping while we are still active, and BOTH motors are running.
           // while (opModeIsActive() &&
                    (robot.backLeft.isBusy() && hulk.backRight.isBusy())) {

                // adjust relative speed based on heading error.
                error = getError(angle);
                steer = getSteer(error, P_DRIVE_COEFF);

                // if driving in reverse, the motor correction also needs to be reversed
                if (distance < 0)
                    steer *= -1.0;

                leftSpeed = speed - steer;
                rightSpeed = speed + steer;

                // Normalize speeds if either one exceeds +/- 1.0;
                max = Math.max(Math.abs(leftSpeed), Math.abs(rightSpeed));
                if (max > 1.0)
                {
                    leftSpeed /= max;
                    rightSpeed /= max;
                }

                hulk.backLeft.setPower(leftSpeed);
                hulk.backRight.setPower(rightSpeed);


            }

            // Stop all motion;
            hulk.backLeft.setPower(0);
            hulk.backRight.setPower(0);
        }
   // }

    public void gyroTurn (  double speed, double angle) {

        // keep looping while we are still active, and not on heading.
       // while (opModeIsActive() && !onHeading(speed, angle, P_TURN_COEFF)) {
            // Update telemetry & Allow time for other processes to run.
       // }
    }



    public void gyroHold( double speed, double angle, double holdTime) {

        ElapsedTime holdTimer = new ElapsedTime();

        // keep looping while we have time remaining.
        holdTimer.reset();
        while (opModeIsActive() && (holdTimer.time() < holdTime)) {
            // Update telemetry & Allow time for other processes to run.
            onHeading(speed, angle, P_TURN_COEFF);
            telemetry.update();
        }

        // Stop all motion;
        hulk.backLeft.setPower(0);
        hulk.backRight.setPower(0);
    }

    boolean onHeading(double speed, double angle, double PCoeff) {
        double   error ;
        double   steer ;
        boolean  onTarget = false ;
        double leftSpeed;
        double rightSpeed;

        // determine turn power based on +/- error
        error = getError(angle);

        if (Math.abs(error) <= HEADING_THRESHOLD) {
            steer = 0.0;
            leftSpeed  = 0.0;
            rightSpeed = 0.0;
            onTarget = true;
        }
        else {
            steer = getSteer(error, PCoeff);
            rightSpeed  = speed * steer;
            leftSpeed   = -rightSpeed;
        }

        // Send desired speeds to motors.
        hulk.backLeft.setPower(leftSpeed);
        hulk.backRight.setPower(rightSpeed);


        return onTarget;
    }

    // Difference in current heading and target heading
    // Used to calculate how much further the hulk has left to go
    public double getError(double targetAngle) {

        double hulkError;

        // calculate error in -179 to +180 range  (
        hulkError = targetAngle -  hulk.gyro.getIntegratedZValue();
        while (robotError > 180)  hulkError -= 360;
        while (robotError <= -180) hulkError += 360;
        return hulkError;
    }


    public double getSteer(double error, double PCoeff) {
        return Range.clip(error * PCoeff, -1, 1);
    }

*/
}