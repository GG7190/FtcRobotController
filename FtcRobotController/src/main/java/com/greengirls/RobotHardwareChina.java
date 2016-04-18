package com.greengirls;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ServoController;

/**
 * Created by Dell User on 10/15/2015.
 */
public class RobotHardwareChina extends OpMode {

    //Set Max and Min values of dino arms
    protected final static double DINO_ARM_MIN_RANGE  = 0.30;
    protected final static double DINO_ARM_MAX_RANGE  = 0.90;

    //Set Max and Min values of ball channel
    protected final static double BALL_CHANNEL_MIN_RANGE  = 0.70;

    protected final static double BALL_CHANNEL_MAX_RANGE  = 0.40;

    //define servos
    private Servo dinoArm1;
    private Servo dinoArm2;
    private Servo ballChannel;
    private ServoController servoController;

    //define Motors and MotorControllers
    private DcMotorController rightMotorController;
    private DcMotor rightFrontMotor;
    private DcMotorController leftMotorController;
    private DcMotor leftFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotor leftBackMotor;
    private DcMotorController collectorShooterMotorController;
    private DcMotor collectorMotor;
    private DcMotor shooterMotor;
    private DcMotorController deflectorMotorController;
    private DcMotor deflectorMotor;

    //define sensors
    //private IrSeekerSensor IrSeakerSensorSensor;

    @Override public void init(){


        //Map hardware for Right motor controller
        rightMotorController = hardwareMap.dcMotorController.get("Motor Controller 2");
        rightFrontMotor = hardwareMap.dcMotor.get("rfront");
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor = hardwareMap.dcMotor.get("rback");

        //Map hardware for Left motor controller
        leftMotorController = hardwareMap.dcMotorController.get("Motor Controller 4");
        leftFrontMotor = hardwareMap.dcMotor.get("lfront");
        leftBackMotor = hardwareMap.dcMotor.get("lback");
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);

        //Map hardware for collector shooter motor controller
        collectorShooterMotorController = hardwareMap.dcMotorController.get("Motor Controller 5");
        collectorMotor = hardwareMap.dcMotor.get("collector");
        shooterMotor = hardwareMap.dcMotor.get("shooter");

        //Map hardware for deflector motor controller
        deflectorMotorController = hardwareMap.dcMotorController.get("Motor Controller 1");
        deflectorMotor = hardwareMap.dcMotor.get("deflector");

        //Map hardware for servos
        servoController = hardwareMap.servoController.get("Servo Controller 3");
        dinoArm1 = hardwareMap.servo.get("dinoright");
        dinoArm2 = hardwareMap.servo.get("dinoleft");
        ballChannel = hardwareMap.servo.get("ballchannel");

        closeDinoArms();
        closeBallChannel();

        dinoArm1.setPosition(DINO_ARM_MAX_RANGE);
        dinoArm2.setPosition(DINO_ARM_MIN_RANGE);

       //
       // resetEncoders();

    }

    //get the power for both right motors
    public double getRightMotors(){
        return rightFrontMotor.getPower();
    }

    //set get power for both left motors
    public double getLeftMotors(){
        return leftFrontMotor.getPower();
    }

    //set power to right motors
    public void setRightMotors(double power){
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    //set power to left motors
    public void setLeftMotors(double power){
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
    }

    //get the power to collector motor
    public double getCollectorMotor(){
        return collectorMotor.getPower();
    }

    //set the power to collector motor
    public void setCollectorMotor(double power) {
        collectorMotor.setPower(power);
    }

    //get the power to shooter motor
    public double getShooterMotor(){
        return shooterMotor.getPower();
    }

    //set the power to shooter motor
    public void setShooterMotor(double power){
        shooterMotor.setPower(power);
    }

    //get the power to deflector motor
    public double getDeflectorMotor(){
        return deflectorMotor.getPower();
    }

    //get the power to deflector motor
    public void setDeflectorMotor(double power){
        deflectorMotor.setPower(power);
    }

    /**
     * We did this for mapping out the buttons
     * also we could use it in more than one place
     */

    //put dinoArms into open position

    public void openDinoArms(){
        dinoArm1.setPosition(DINO_ARM_MAX_RANGE);
        dinoArm2.setPosition(DINO_ARM_MIN_RANGE);
    }

    //put dinoArms into close position
    public void closeDinoArms(){
        dinoArm1.setPosition(DINO_ARM_MIN_RANGE);
        dinoArm2.setPosition(DINO_ARM_MAX_RANGE);
    }

    //put ball channel into open position
    public void openBallChannel() {
        ballChannel.setPosition(BALL_CHANNEL_MIN_RANGE);
    }

    //put ballChannel into close position
    public void closeBallChannel() {
        ballChannel.setPosition(BALL_CHANNEL_MAX_RANGE);
    }

    //run deflector to open position
    public void openDeflector() {
        deflectorMotor.setPower(1);
    }

    //reverse to close position`
    public void closeDeflector(){
        //deflectorMotor.setPower(-1);
        deflectorMotor.setPower(-1);
    }
    public void stopDeflector() {
        deflectorMotor.setPower(0);
    }
    //stop deflector motor


    //run shooter motor
    public void shootBalls() {
        shooterMotor.setPower(-1);
    }

    //stop the shooter motor
    public void stopShootBalls(){
        shooterMotor.setPower(0);
    }

    //run collector motor
    public void collectorForward(){
        collectorMotor.setPower(1);
    }

    //reverse collector motor
    public void collectorBackward(){
        collectorMotor.setPower(-1);
    }

    //stop the collector motor
    public void stopCollector(){
        collectorMotor.setPower(0);
    }

    //the set up of encoders
    // had to use math.round to convert a double to an int
    public void runWithEncoders() {
        if (leftBackMotor != null) {
            leftBackMotor.setChannelMode
                    (DcMotorController.RunMode.RUN_USING_ENCODERS
                    );
        }
    }

    public void resetEncoders() {

        //
        // Reset the motor encoders on the drive wheels.
        //
        leftBackMotor.setChannelMode
                (DcMotorController.RunMode.RESET_ENCODERS);
    }

    public boolean encoderCountReached(double rightCount)
    {
        //
        // Assume failure.
        //
        boolean l_status = false;

        //
        // Have the encoders reached the specified values?
        //
        // TODO Implement stall code using these variables.
        //
        if ((Math.abs (leftBackMotor.getCurrentPosition ()) > rightCount))
        {
            //
            // Set the status to a positive indication.
            //
            l_status = true;
        }

        //
        // Return the status.
        //
        Log.w("ENCODERCOUNTREACHED ","status " + String.valueOf(l_status));
        Log.w("ENCODERCOUNTREACHED: ","count " + String.valueOf(rightCount));
        Log.w("ENCODERCOUNTREACHED ", "currentPos "+String.valueOf(leftBackMotor.getCurrentPosition()));
        return l_status;

}
   public boolean have_drive_encoders_reset ()
    {
        //
        // Assume failure.
        //
        boolean l_return = false;

        //
        // Have the encoders reached zero?
        //
        if (Math.abs (leftBackMotor.getCurrentPosition ())==0)
        {
            //
            // Set the status to a positive indication.
            //
            l_return = true;
        }

        //
        // Return the status.
        //
        return l_return;

    } // have_drive_encoders_reset



    @Override public void loop() {

    }
}
