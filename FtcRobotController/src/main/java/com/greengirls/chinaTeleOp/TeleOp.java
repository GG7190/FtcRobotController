package com.greengirls.chinaTeleOp;

import android.util.Log;

import com.greengirls.RobotHardwareChina;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

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
        float leftWheels = -gamepad1.right_stick_y;
        float rightWheels = gamepad1.left_stick_y;

        // write the values to the motors
        setRightMotors(rightWheels);
        setLeftMotors(leftWheels);

        //When dino arms are open
        if (gamepad2.left_trigger>0){
            openDinoArms();
        }

        //When dino arms are closed
        if (gamepad2.right_trigger>0){
            closeDinoArms();
        }

        //When ball channel is open
        if (gamepad2.b) {
            openBallChannel();
        }
        else {
            closeBallChannel();
        }

        //When the deflector is raised
        if (gamepad2.a) {
            openDeflector();
            Log.w("GAMEPAD 2 A", "Value: " + gamepad2.a);
        }
        else if (gamepad2.y) {
            closeDeflector();
        }
        //When deflector is lowered
        else {
            stopDeflector();
        }Log.w("LOOP", "Value: " + gamepad2.a);

        shootBalls();
        //When ball is shooting
        if (gamepad2.x) {

        }
        else{
            stopShootBalls();
        }

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
    }
}