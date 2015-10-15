package com.greengirls.chinaTeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by G201956 on 10/4/2015.
 */
public class TeleOp extends OpMode {

    //Set Max and Min values of dino arms
    final static double DINO_ARM_MIN_RANGE  = 0.20;
    final static double DINO_ARM_MAX_RANGE  = 0.90;

    //position of dino arm
    private double dinoArmPosition;

    //define motors and servos
    private Servo dinoArm;

    /*
	 * Code to run when the op mode is initialized goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init()
	 */

    @Override
    public void init() {

        dinoArm = hardwareMap.servo.get("servo_1");

        //starting position of the dino arms
        dinoArmPosition = DINO_ARM_MAX_RANGE;
    }

    @Override
    public void loop() {

        if (gamepad2.left_bumper){
            dinoArmPosition = DINO_ARM_MIN_RANGE;
        }

        if (gamepad2.right_bumper){
            dinoArmPosition = DINO_ARM_MAX_RANGE;
        }
    }
}