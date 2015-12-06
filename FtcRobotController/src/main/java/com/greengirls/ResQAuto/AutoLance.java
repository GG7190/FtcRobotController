package com.greengirls.ResQAuto;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 12/6/2015.
 */
public class AutoLance extends RobotHardware2016 {

    int state = 0;
    int count = 0;

    @Override
    public void loop() {

        switch (state){
            case 0:
                //drive forward to line up with end of mountain
                setRightMotors(1);
                setLeftMotors(1);
                wait(100);
                state++;

            case 1:
                //turn to face end of ramp
                setRightMotors(1);
                setLeftMotors(-1);
                wait(100);
                state++;

            case 2:
                //drive to mountain base
                setRightMotors(1);
                setLeftMotors(1);
                wait(100);
                state++;

            case 3:
                //turn to face up mountain
                setRightMotors(1);
                setLeftMotors(-1);
                wait(100);
                state++;

            case 4:
                //drive partially up mountain
                setRightMotors(1);
                setLeftMotors(1);
                wait(100);
                state++;
        }
    }

}
