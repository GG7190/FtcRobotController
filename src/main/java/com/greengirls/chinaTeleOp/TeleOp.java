package com.greengirls.chinaTeleOp;

import com.greengirls.RobotHardware;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by G201956 on 10/4/2015.
 */
public class TeleOp extends RobotHardware {

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