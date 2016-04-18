package com.greengirls.ResQAuto;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 1/11/2016.
 */
public class ColorAutoLanceBlue extends RobotHardware2016 {

    int state = 0;
    int count = 0;

    @Override
    public void loop() {
        switch (state) {
            case 0:
                liftOut();
                if( count >= 100 && count<500) {
                    stoplift();
                    state++;
                }
                count++;
                break;


            case 1:
                liftDown();
                if( count >= 600 && count<1200) {
                    liftStop();
                    state=5;
                    count=0;
                }
                count++;
                break;
            case 5://0-9 will align us to dump the climbers

                //start facing beacon
                //Drive forward to the floor zone while spinning the collector motor to prevent debris from getting in the way
                setLeftMotors(-1);
                setRightMotors(1);
                setCollectorMotor(-1);
                if( count >= 700  && count<3700) {
                    state=9;
                    count=0;
                    stopRightMotors();
                    stopLeftMotors();
                    stopCollector();
                }
                count++;
                break;
            case 9:
                //turn to face the basket
                setLeftMotors(-1);
                setRightMotors(-1);
                if( count >= 81 && count<220) {
                    state=10;
                    count=0;
                    stopLeftMotors();
                    stopRightMotors();
                }
                count++;
                break;
            case 10:
                setLeftMotors(-1);
                setRightMotors(1);
                if( count >= 80 && count<220) {
                    state=11;
                    count=0;
                    stopLeftMotors();
                    stopRightMotors();
                }

            case 11://case 10-19 will be dumping climber into the bucket
                //lift up arm
                liftUp();
                if ( count >= 450 && count<500) {
                    state=12;
                    count=0;
                    stoplift();
                }
                count++;
                break;
            case 12:
                //extend the arm
                liftOut();
                if ( count >= 220 && count<500) {
                    state=19;
                    count=0;
                    stoplift();
                }

                count++;
                break;
            case 13:
                //dumping the climbers
                leftWingOut();
                state=14;
                count++;
                break;

            case 14:
                leftBasket();
                state=15;
                count++;
                break;

            case 15:
                leftWingIn();
               state=16;
                count++;
                break;

            case 16:
                middleBasket();
                state=17;
                count++;
                break;

            case 17:
                //bringing the arm in
                liftDown();
                if ( count >= 100 && count<300) {
                    state=18;
                    count=0;
                }
                count++;
                break;
            case 18:
                //bring winch down
                liftIn();
                if ( count >= 100 && count<200) {
                    state=1000;
                    count=0;
                }

            case 19:
                setLeftMotors(-1);
                setRightMotors(1);
                if( count >=76  && count<100) {
                    state=13;
                    count=0;
                    stopRightMotors();
                    stopLeftMotors();
                count++;
                break;
                }

            case 20://case 20-39 will sense the color and push the corresponding button to push
                //we are going forward into sensing position
                setLeftMotors(-1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state=21;
                    count=0;
                }
                count++;
                break;
            case 21:
                //we are turning into sensing position
                setLeftMotors(1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state=22;
                    count=0;
                }
                count++;
                break;
            case 22:
                //we are backing up into sensing position
                setLeftMotors(1);
                setRightMotors(-1);
                if( count >= 600 && count<3000) {
                    state=23;
                    count=0;
                }
                count++;
                break;
            case 23:
                //we are backing up into sensing position
                setLeftMotors(-1);
                setRightMotors(-1);
                if( count >= 600 && count<3000) {
                    state=24;
                    count=0;
                }
                count++;
                break;
            case 24:
                //if needed go backward to get closer to the color sensor
                state=25;
                break;
            case 25:
                if (checkBlue()){
                    state=26;
                }
                else {
                    state=27;
                }

                break;
            case 26:
                //we are backing up to press button
                setLeftMotors(1);
                setRightMotors(-1);
                if( count >= 600 && count<3000) {
                    state=40;
                    count=0;
                }
                count++;
                break;
            case 40://found blue go to other button
                //we are going forward up to press button
                setLeftMotors(-1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state=41;
                    count=0;
                }
                count++;
                break;
            case 41:
                //we are turning to press button
                setLeftMotors(1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state=42;
                    count=0;
                }
                count++;
                break;
            case 42:
                //we are backing up to press button
                setLeftMotors(1);
                setRightMotors(-1);
                if( count >= 600 && count<3000) {
                    state=43;
                    count=0;
                }
                count++;
                break;
            case 43:

                //we are backing up to press button
                setLeftMotors(-1);
                setRightMotors(-1);
                if( count >= 600 && count<3000) {
                    state=44;
                    count=0;
                }
                count++;
                break;
            case 44:

                //we are backing up to press button
                setLeftMotors(1);
                setRightMotors(-1);
                if( count >= 600 && count<3000) {
                    state++;
                    count=0;
                }
                count++;
        }
    }
}

