package com.greengirls.ResQAuto;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

/**
 * Created by User on 1/11/2016.
 */
public class ServoTest  extends OpMode {

     /*
	 * Code to run when the op mode is initialized goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init()
	 */
     private Servo basket;
    private ServoController servoController;

    @Override
    public void init() {
        //Map hardware for servo controller
        servoController = hardwareMap.servoController.get("servo");
        basket = hardwareMap.servo.get("basket");
    }

    @Override
    public void loop() {
        if (gamepad2.right_trigger>0) {
            basket.setPosition(0.0);
        }
        //When button x is pressed on gamepad 2 tilt right
        else if (gamepad2.left_trigger>0){
            basket.setPosition(0.99);
        }
        //When button right bumper and left bumper on gampe pad 2 is not pressed keeps basket in middle
        else {
            basket.setPosition(0.58);
        }

    }
}
