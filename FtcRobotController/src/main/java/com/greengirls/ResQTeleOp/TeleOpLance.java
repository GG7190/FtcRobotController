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
        float leftWheels = gamepad1.left_stick_y;
        float rightWheels = -gamepad1.right_stick_y;

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

        //open and close basket button mapping
        //tilt left
        if (gamepad2.right_bumper) {
            rightBasket();
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
        if (gamepad2.a){
            liftOut();
            //coilOut();
        }
        //When button a is pressed on game pad 2 the lift retracts
        else if (gamepad2.y){
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
        //when dpad left is pressed the left basket wing extends
        if (gamepad2.dpad_left){
            rightWingOut();
        }
        //when dpad right is pressed the right basket wing extends
        else if (gamepad2.dpad_right){
                leftWingOut();
        }
        //if neither game pad buttons are pressed the wings stay in the starting position
        else {
            rightWingIn();
            leftWingIn();
        }
        //when dpad up is pressed the dino arms go up
        if (gamepad2.dpad_up){
            dinoUp();
        }
        //when dpad down is pressed the dino arms go down
        else if (gamepad2.dpad_down){
            dinoDown();
        }
        telemetry.addData("right bumper",gamepad2.right_bumper);
        telemetry.addData("left bumper",gamepad2.left_bumper);
        telemetry.addData("dpad left",gamepad2.dpad_left);
        telemetry.addData("dpad right",gamepad2.dpad_right);



    }
}
