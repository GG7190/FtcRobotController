package com.greengirls;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ServoController;
/**
 * Created by Dell User on 10/25/2015.
 */
public class RobotHardware2016 extends OpMode{

    protected final static double BASKET_MIN_RANGE  = 0.00;
    protected final static double BASKET_MID_RANGE  = 0.45;
    protected final static double BASKET_MAX_RANGE  = 1.00;

    protected final static double LWING_MIN_RANGE  = 0.00;
    protected final static double LWING_MAX_RANGE  = 0.60;

    protected final static double RWING_MIN_RANGE  = 0.80;
    protected final static double RWING_MAX_RANGE  = 0.00;

    protected final static double LDINO_MIN_RANGE = 0.90;
    protected final static double LDINO_MAX_RANGE = 0.20;

    protected final static double RDINO_MIN_RANGE = 0.00;
    protected final static double RDINO_MAX_RANGE = 0.60;

    //define Motors and MotorControllers
    private DcMotorController rightMotorController;
    private DcMotor rightFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotorController leftMotorController;
    private DcMotor leftFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotorController attachmentMotorController;
    private DcMotor collectorMotor;
    private DcMotor angleMotor;
    private DcMotorController liftMotorController;
    private DcMotor lift1;
    private DcMotor lift2;
    private ServoController servoController;
    private Servo basket;
    private Servo leftWing;
    private Servo rightWing;
    private Servo leftDino;
    private Servo rightDino;
    private ColorSensor sensorRGB;
    private DeviceInterfaceModule cdim;
    static final int LED_CHANNEL = 5;


    @Override public void init() {

        cdim = hardwareMap.deviceInterfaceModule.get("dim");

        // set the digital channel to output mode.
        // remember, the Adafruit sensor is actually two devices.
        // It's an I2C sensor and it's also an LED that can be turned on or off.
        // cdim.setDigitalChannelMode(LED_CHANNEL, DigitalChannelController.Mode.OUTPUT);

        // get a reference to our ColorSensor object.
        sensorRGB = hardwareMap.colorSensor.get("color");
        sensorRGB.enableLed(false);
        cdim.setDigitalChannelState(LED_CHANNEL, false);

        //Map hardware for Right motor controller
        rightMotorController = hardwareMap.dcMotorController.get("rightdrive");
        rightFrontMotor = hardwareMap.dcMotor.get("rfront");
        rightBackMotor = hardwareMap.dcMotor.get("rback");

        //Map hardware for Left motor controller
        leftMotorController = hardwareMap.dcMotorController.get("leftdrive");
        leftFrontMotor = hardwareMap.dcMotor.get("lfront");
        leftBackMotor = hardwareMap.dcMotor.get("lback");

        //Map hardware for attachment motor controller
        attachmentMotorController = hardwareMap.dcMotorController.get("attachment");
        collectorMotor = hardwareMap.dcMotor.get("collector");
        angleMotor = hardwareMap.dcMotor.get("anglemotor");

        //Map hardware for lift motor controller
        liftMotorController = hardwareMap.dcMotorController.get("lift");
        lift1 = hardwareMap.dcMotor.get("lift1");
        lift2 = hardwareMap.dcMotor.get("lift2");
        //Map hardware for servo controller
        servoController = hardwareMap.servoController.get("servo");
        basket = hardwareMap.servo.get("basket");
        leftWing = hardwareMap.servo.get("lwing");
        rightWing = hardwareMap.servo.get("rwing");
        leftDino = hardwareMap.servo.get("ldino");
        rightDino = hardwareMap.servo.get("rdino");

        middleBasket();


        //initial position for start of round
        basket.setPosition(BASKET_MID_RANGE);

        rightWingIn();
        leftWingIn();
        dinoUp();

        hardwareMap.logDevices();

        // get a reference to our DeviceInterfaceModule object.
       // cdim = hardwareMap.deviceInterfaceModule.get("dim");

        // get a reference to our ColorSensor object.
       // sensorRGB = hardwareMap.colorSensor.get("color");

    }

    //setters and getters for all motors for use outside this program
    //above 0= forward, below 0= backward, 0= not moving
    //right set
    public void setRightMotors(double power){
        rightFrontMotor.setPower(.9*power);
        rightBackMotor.setPower(power);
    }

    //stop right motors
    public void stopRightMotors(){
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);
    }

    //set power to left motors
    public void setLeftMotors(double power){
        leftFrontMotor.setPower(.9*power);
        leftBackMotor.setPower(power);
    }

    //stop left motors
    public void stopLeftMotors(){
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
    }

    //get the power to collector motor
    public double getCollectorMotor(){
        return collectorMotor.getPower();
    }
    //set the power to collector motor
    public void setCollectorMotor(double power) {
        collectorMotor.setPower(power);
    }
    //stop collector
    public void stopCollector(){
        collectorMotor.setPower(0);
    }

    //put ball channel into open position
    public void rightBasket() {
        basket.setPosition(BASKET_MIN_RANGE);
    }

    public void middleBasket() {
        basket.setPosition(BASKET_MID_RANGE);
    }
    //put ballChannel into close position
    public void leftBasket() {
        basket.setPosition(BASKET_MAX_RANGE);
    }


    public void leftWingOut() {leftWing.setPosition(LWING_MIN_RANGE);}

    public void leftWingIn() {
        leftWing.setPosition(LWING_MAX_RANGE);
    }

    public void rightWingOut() {
        rightWing.setPosition(RWING_MIN_RANGE);
    }
    public void rightWingIn() {
        rightWing.setPosition(RWING_MAX_RANGE);
    }
    public void dinoUp(){
        leftDino.setPosition(LDINO_MIN_RANGE);
        rightDino.setPosition(RDINO_MIN_RANGE);
    }

    public void dinoDown (){
        leftDino.setPosition(LDINO_MAX_RANGE);
        rightDino.setPosition(RDINO_MAX_RANGE);
    }

    //lift out
    public void liftOut() {
        lift1.setPower(-1);
        lift2.setPower(1);
    }
    //lift in
    public void liftIn() {
        lift1.setPower(1);
        lift2.setPower(-1);
    }
    //stop lift motor
    public void stoplift() {
        lift1.setPower(0);
        lift2.setPower(0);
        angleMotor.setPower(0);
    }

    //lift angle up
    public void liftUp() {
        angleMotor.setPower(1);
    }
    //lift angle down
    public void liftDown(){
        angleMotor.setPower(-1);
    }
    //angle motor stop
    public void liftStop() {
        angleMotor.setPower(0);
    }

    public boolean checkRed (){
        return sensorRGB.red()>0;
    }
    public boolean checkBlue (){return sensorRGB.blue()>0;}
    //coil in
  //  public void coilIn(){
  //      coilMotor.setPower(-1);
  //  }
    //coil out
   // public void coilOut(){
   //     coilMotor.setPower(1);
   // }
    //stop coil motor
   // public void coilStop(){
   //     coilMotor.setPower(0);
   // }

    //wait config
    public static void wait(int time) {

        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(e.getClass().toString(),e.getStackTrace().toString());
        }
    }

    @Override public void loop() {

    }
}
