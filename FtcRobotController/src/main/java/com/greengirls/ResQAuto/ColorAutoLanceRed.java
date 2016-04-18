package com.greengirls.ResQAuto;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 1/6/2016.
 */
public class ColorAutoLanceRed extends RobotHardware2016 {

    int state = 0;
    int count = 0;

    @Override
    public void loop() {
        switch (state) {
            case 0://0-9 will align us to dump the climbers

                //start facing beacon
                //Drive forward to the floor zone while spinning the collector motor to prevent debris from getting in the way
                setLeftMotors(-1);
                setRightMotors(1);
                //TODO: add arm movements
                setCollectorMotor(-1);
                if( count >= 600 && count<3000) {
                    state=1;
                    count=0;
                }
                count++;
                break;
            case 1:
                //turn to face the basket
                setLeftMotors(1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state=10;
                    count=0;
                }
                count++;
                break;
            case 10://case 10-19 will be dumping climber into the bucket
                //lift up arm
                liftUp();
                if ( count >= 600 && count<3000) {
                    state++;
                    count=0;
                }

                count++;
                break;
            case 11:
                //extend the arm
                liftOut();
                if ( count >= 600 && count<3000) {
                    state=12;
                    count=0;
                }

                count++;
                break;
            case 12:
                //dumping the climbers
                rightWingOut();
                rightBasket();
                rightWingIn();
                middleBasket();
                state=13;
                break;
            case 13:
                //bringing the arm in
                liftDown();
                if ( count >= 600 && count<3000) {
                    state=14;
                    count=0;
                }
                count++;
                break;
            case 14:
                //bring winch down
                liftIn();
                if ( count >= 600 && count<3000) {
                    state=20;
                    count=0;
                }

                count++;
                break;
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
                if (checkRed()){
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