package com.greengirls;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ServoController;
/**
 * Created by Dell User on 10/25/2015.
 */
public class RobotHardware2016 extends OpMode{

    protected final static double BASKET_MIN_RANGE  = 0.30;
    protected final static double BASKET_MID_RANGE  = 0.70;
    protected final static double BASKET_MAX_RANGE  = 0.90;

    //define Motors and MotorControllers
    private DcMotorController rightMotorController;
    private DcMotor rightFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotorController leftMotorController;
    private DcMotor leftFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotorController attachmentMotorController;
    private DcMotor collectorMotor;
    private DcMotor coilMotor;
    private DcMotorController liftMotorController;
    private DcMotor angleMotor;
    private DcMotor liftMotor;
    private ServoController servoController;
    private Servo basket;

    @Override public void init() {


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
        coilMotor = hardwareMap.dcMotor.get("coil");

        //Map hardware for lift motor controller
        liftMotorController = hardwareMap.dcMotorController.get("lift");
        angleMotor = hardwareMap.dcMotor.get("anglemotor");
        liftMotor = hardwareMap.dcMotor.get("liftmotor");

        //Map hardware for servo controller
        servoController = hardwareMap.servoController.get("servo");
        basket = hardwareMap.servo.get("basket");

        middleBasket();

        basket.setPosition(BASKET_MAX_RANGE);
        basket.setPosition(BASKET_MIN_RANGE);
    }

    //setters and getters for all motors for use outside this program
    //right set
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
    //stop collector
    public void stopCollector(){
        collectorMotor.setPower(0);
    }

    //put ball channel into open position
    public void rigtBasket() {
        basket.setPosition(BASKET_MIN_RANGE);
    }

    public void middleBasket() {
        basket.setPosition(BASKET_MID_RANGE);
    }
    //put ballChannel into close position
    public void leftBasket() {
        basket.setPosition(BASKET_MAX_RANGE);
    }

    //lift out
    public void liftOut() {
        liftMotor.setPower(-1);
    }
    //lift in
    public void liftIn() {
        liftMotor.setPower(1);
    }
    //stop lift motor
    public void stoplift() {
        liftMotor.setPower(0);
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

    //coil in
    public void coilIn(){
        coilMotor.setPower(-1);
    }
    //coil out
    public void coilOut(){
        coilMotor.setPower(1);
    }
    //stop coil motor
    public void coilStop(){
        coilMotor.setPower(0);
    }

    //wait config
    public static void wait(int time) {

        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override public void loop() {

    }
}
