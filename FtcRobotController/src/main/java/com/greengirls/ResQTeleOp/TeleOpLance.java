package com.greengirls.ResQTeleOp;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 12/4/2015.
 */
public class TeleOpLance extends RobotHardware2016 {

     /*
	 * Code to run when the op mode is initialized goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init()
	 */


    @Override
    public void init() {

        super.init();

    }

    @Override
    public void loop() {

        // Right wheels will be controlled by the right stick
        // Left wheels will be controlled by the left stick
        float leftWheels = gamepad1.right_stick_y;
        float rightWheels = -gamepad1.left_stick_y;

        // write the values to the motors
        setRightMotors(rightWheels);
        setLeftMotors(leftWheels);

        //When collector is collecting balls
        if (gamepad1.right_bumper){
            setCollectorMotor(1);
        }
        //When collector is spitting balls out
        else if (gamepad1.left_bumper){
            setCollectorMotor(-1);
        }
        else{
            stopCollector();
        }

        //open and close asket button mapping
        //tilt left
        if (gamepad2.right_bumper) {
            rigtBasket();
        }
        //When button x is pressed on gamepad 2 tilt right
        else if (gamepad2.left_bumper){
            leftBasket();
        }
        //When button right bumper and left bumper on gampe pad 2 is not pressed keeps basket in middle
        else {
            middleBasket();
        }

        //When button y is pressed on game pad 2 the lift extends
        if (gamepad2.y){
            liftOut();
            //coilOut();
        }
        //When button a is pressed on game pad 2 the lift retracts
        else if (gamepad2.a){
            liftIn();
            //coilIn();
        }
        //when button a is not pressed stop lift motor
        else {
            stoplift();
            //coilStop();
        }

        //when button x is pressed on gamepad 2 lift angle increases
        if (gamepad2.x){
            liftUp();
        }
        //when button b is pressed on gamepad 2 lift angle decreases
        else if (gamepad2.b){
            liftDown();
        }
        //when b and x are not pressed stop lift angle motor
        else {
            liftStop();
        }
    }
}
