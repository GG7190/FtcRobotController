package com.greengirls.ResQAuto;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 1/15/2016.
 */
public class ArmAutoFloorLance extends RobotHardware2016 {
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
                if( count >= 770 && count<1200) {
                    liftStop();
                    state=10;
                    count=0;
                }
                count++;
                break;

            case 10:
                //Drive forward to the floor zone while spinning the collector motor to prevent debris from getting int he way
                setLeftMotors(-1);
                setRightMotors(1);
                setCollectorMotor(-1);
                if( count >= 820  && count<4000) {
                    state=20;
                    count=0;
                }
                count++;
                break;

            case 20:

                //stop wheels and collector
                stopRightMotors();
                stopLeftMotors();
                stopCollector();
                state++;
                break;
        }

    }
}
