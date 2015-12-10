package com.greengirls.ResQAuto;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 12/9/2015.
 */
public class AutoFloorLance extends RobotHardware2016 {
    int state = 0;
    int count = 0;

    @Override
    public void loop() {

        switch (state) {
            case 0:

                //Drive forward to the floor zone while spinning the collector motor to prevent debris from getting in the way
                setLeftMotors(-1);
                setRightMotors(1);
                setCollectorMotor(-1);
                if( count >= 40 && count<200) {
                    state++;
                }
                count++;
                break;
            case 1:

                //stop wheels and collector
                stopRightMotors();
                stopLeftMotors();
                stopCollector();
                state++;
                break;
        }

    }
}
