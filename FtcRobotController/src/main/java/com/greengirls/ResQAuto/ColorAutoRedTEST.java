package com.greengirls.ResQAuto;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 1/11/2016.
 */
public class ColorAutoRedTEST extends RobotHardware2016 {

    int state = 0;
    int count = 0;

    @Override
    public void loop() {
        switch (state) {
            case 0:
                //The arm is extended out into starting position
                liftOut();
                if (count >= 115 && count < 500) {
                    stoplift();
                    state++;
                }
                count++;
                break;

            case 1:
                //The arm is winched down into starting position
                liftDown();
                if (count >= 550 && count < 1200) {
                    liftStop();
                    state = 5;
                    count = 0;
                }
                count++;
                break;

            case 5:
                //start facing beacon
                //Drives forward to the floor zone while spinning the collector motor to prevent debris from getting in the way
                setLeftMotors(-1);
                setRightMotors(1);
                setCollectorMotor(-1);
                if (count >= 680 && count < 3700) {
                    state = 9;
                    count = 0;
                    stopRightMotors();
                    stopLeftMotors();
                    stopCollector();
                }
                count++;
                break;

            case 9:
                //turn to face the shelter
                setLeftMotors(1);
                setRightMotors(1);
                if (count >= 67 && count < 220) {
                    state = 10;
                    count = 0;
                    stopLeftMotors();
                    stopRightMotors();
                }
                count++;
                break;

            case 10:
                //Drive forward to shelter
                setLeftMotors(-1);
                setRightMotors(1);
                if (count >= 50 && count < 220) { //was 80
                    state = 11;
                    count = 0;
                    stopLeftMotors();
                    stopRightMotors();
                }
                count++;
                break;

            case 11:
                //lift up arm
                liftUp();
                if (count >= 477 && count < 500) {
                    state = 12;
                    count = 0;
                    stoplift();
                }
                count++;
                break;

            case 12:
                //extend the arm
                liftOut();
                if (count >= 280 && count < 500) {
                    state = 13;
                    count = 0;
                    stoplift();
                }
                count++;
                break;

            case 13:
                //Drive towards shelter again
                setLeftMotors(-1);
                setRightMotors(1);
                if (count >= 108) {
                    state = 14;                    count = 0;
                    stopLeftMotors();
                    stopRightMotors();
                }
                count++;
                break;

            case 14:
                //dumping the climbers
                leftWingOut();
                state=15;
                count++;
                break;

            case 15:
                //dump the climbers
                rightBasket();
                state++;
                count=0;
        }
    }
}