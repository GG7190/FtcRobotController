package com.greengirls.chinaTeleOp;

import com.greengirls.RobotHardwareChina;

/**
 * Created by G201956 on 10/4/2015.
 */
public class TeleOp extends RobotHardwareChina {

    /*
	 * Code to run when the op mode is initialized goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init()
	 */


    @Override
    public void init() {

        super.init();

    }
/**
 * Controller One
 *   left_stick_x moves the left wheels forward and backward
 *   right_stick_x moves the right wheels forward and backward
 *   right_trigger collects balls
 *   right_trigger spits out balls
 *
 * Controller Two
 *  Left bumper triggers the dino arm servos to open
 *  Right bumper triggers the dino arm servos to close
 *  Holding B triggers the ball channel servo to open
 *  Pressing Y raises the deflector arm
 *  Pressing A lowers the deflector arm
 *  Holding X shoots

 */

    @Override
    public void loop() {

        // Right wheels will be controlled by the right stick
        // Left wheels will be controlled by the left stick
        float rightWheels = gamepad1.right_stick_y;
        float leftWheels = gamepad1.left_stick_y;

        // write the values to the motors
        setRightMotors(rightWheels);
        setLeftMotors(leftWheels);

        //When dino arms are open
        if (gamepad2.left_bumper){
            openDinoArms();
        }

        //When dino arms are closed
        if (gamepad2.right_bumper){
            closeDinoArms();
        }

        //When ball channel is open
        if (gamepad2.b) {
            openBallChannel();
        } else {
        //When ball channel is closed
            closeBallChannel();
        }

        //When the deflector is raised
        if (gamepad2.y) {
            openDeflector();
        }
        else {
            stopDeflector();
        }

        //When deflector is lowered
        if (gamepad2.a) {
            closeDeflector();
        }
        else {
            stopDeflector();
        }

        //When ball is shooting
        if (gamepad2.x) {
           shootBalls();
        }
        else{
            stopShootBalls();
        }

        //When collector is collecting balls
        if (gamepad1.right_trigger>0){
            collectorForward();
        }
        else {
            stopCollector();
        }

        //When collector is spitting balls out
        if (gamepad1.left_trigger>0){
            collectorBackward();
        }
        else{
            stopCollector();
        }
    }
}