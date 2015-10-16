package com.greengirls.chinaTeleOp;

import com.greengirls.RobotHardware;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by G201956 on 10/4/2015.
 */
public class TeleOp extends RobotHardware {

    //position of dino arm
    private double dinoArm1Position;
    private double dinoArm2Position;

    //position of ball channel
    private double ballChannelPosition;

    private DcMotor lf;
    private DcMotor rf;
    private DcMotor lb;
    private DcMotor rb;
    private DcMotor collect;
    private DcMotor shoot;
    private DcMotor deflector;

    /*
	 * Code to run when the op mode is initialized goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init()
	 */


    @Override
    public void init() {

        super.init();

        //starting position of the dino arms
        dinoArm1Position = DINO_ARM_MAX_RANGE;
        dinoArm2Position = DINO_ARM_MAX_RANGE;
        //starting position of the ball channel
        ballChannelPosition = BALL_CHANNEL_MAX_RANGE;
    }
/**
 * Controller One
 *   left_stick_x moves the left wheels forward and backward
 *   right_stick_x moves the right wheels forward and backward
 *   right_trigger collects balls
 *   right_bumper spits out balls
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
            dinoArm1Position = DINO_ARM_MIN_RANGE;
            dinoArm2Position = DINO_ARM_MIN_RANGE;
        }

        //When dino arms are closed
        if (gamepad2.right_bumper){
            dinoArm1Position = DINO_ARM_MAX_RANGE;
            dinoArm2Position = DINO_ARM_MAX_RANGE;
        }

        //When ball channel is open
        if (gamepad2.b) {
            ballChannelPosition = BALL_CHANNEL_MIN_RANGE;
        } else {
        //When ball channel is closed
            ballChannelPosition = BALL_CHANNEL_MAX_RANGE;
        }

        //When the deflector is raised
        if (gamepad2.y) {
            deflector.setPower(0.1);
        }
        //When deflector is lowered
        if (gamepad2.a) {
            deflector.setPower(-0.1);
        }

        //When ball is shooting
        if (gamepad2.x) {
            shoot.setPower();

        }




        dinoArm1.setPosition(dinoArm1Position);
        dinoArm2.setPosition(dinoArm2Position);
        ballChannel.setPosition(ballChannelPosition);
    }
}