package com.greengirls.chinaAutonomous;

import com.greengirls.RobotHardwareChina;

/**
 * Created by Dell User on 10/21/2015.
 */
public class CenterGoal extends RobotHardwareChina {

    //set state to zero
    int state = 0;

    @Override
    public void loop() {

        switch (state){
            case 0:
                //start in middle of parking zone facing centergoal
                runWithEncoders();
                //
                setRightMotors(1);
                setLeftMotors(1);

                //
                if (encoderCountReached(1600)){

                    resetEncoders();

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                }
                break;

            case 1:
                //check ir sensor for position
        }
    }
}
