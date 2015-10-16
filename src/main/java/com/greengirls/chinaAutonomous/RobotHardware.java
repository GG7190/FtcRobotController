package com.greengirls.chinaAutonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Dell User on 10/15/2015.
 */
public class RobotHardware extends OpMode {

    //define servos
    private Servo dinoArm1;
    private Servo dinoArm2;
    private Servo ballChannel;

    //define Motors and MotorControllers
    private DcMotorController rightMotorController;
    private DcMotor rightFrontMotor;
    private DcMotorController leftMotorController;
    private DcMotor leftFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotor leftBackMotor;
    private DcMotorController collectorShooterMotorController;
    private DcMotor collectorMotor;
    private DcMotor shooterMotor;
    private DcMotorController deflectorMotorController;
    private DcMotor deflectorMotor;

    @Override public void init(){
        //Map hardware for Right motor controller
        rightMotorController = hardwareMap.dcMotorController.get("right_drive_controller");
        rightFrontMotor = hardwareMap.dcMotor.get("right_front_motor");
        rightBackMotor = hardwareMap.dcMotor.get("right_back_motor");

        //Map hardware for Left motor controller
        leftMotorController = hardwareMap.dcMotorController.get("left_drive_controller");
        leftFrontMotor = hardwareMap.dcMotor.get("left_front_motor");
        leftBackMotor = hardwareMap.dcMotor.get("left_back_motor");

        //Map hardware for collector shooter motor controller
        collectorShooterMotorController = hardwareMap.dcMotorController.get("collector_shooter_controller");
        collectorMotor = hardwareMap.dcMotor.get("collector_motor");
        shooterMotor = hardwareMap.dcMotor.get("shooter_motor");

        //Map hardware for deflector motor controller
        deflectorMotorController = hardwareMap.dcMotorController.get("deflector_controller");
        deflectorMotor = hardwareMap.dcMotor.get("deflector_motor");

        //Map hardware for servos
        dinoArm1 = hardwareMap.servo.get("servo_1");
        dinoArm2 = hardwareMap.servo.get("servo_2");
        ballChannel = hardwareMap.servo.get("servo_3");

    }

    @Override public void loop() {
        
    }
}
