package com.greengirls.chinaAutonomous;

import android.util.Log;

import com.greengirls.RobotHardwareChina;

import java.util.concurrent.TimeUnit;


/**
 * Created by Dell User on 10/15/2015.
 */
public class RampToParking extends RobotHardwareChina {
    
    //set state to zero
    int state = 0;
    int count = 0;
    @Override
    public void loop() {

        switch (state){
            case 0:
                //start facing backward
                runWithEncoders();
                //
                setRightMotors(-0.5);
                setLeftMotors(-0.5);

                closeDinoArms();

                //
                if(encoderCountReached(5850)){

                    resetEncoders();

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                }
                Log.w("State 0 ", String.valueOf(state));
                break;
            case 1:

                if (have_drive_encoders_reset()) {


                    state++;
                }
                break;
            case 2:
                runWithEncoders();
                setRightMotors(-0.8);
                setLeftMotors(0.8);

                if(encoderCountReached(2250)){

                    resetEncoders();

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                }
                Log.w("State 1 ", String.valueOf(state));
                break;

            case 3:

                if (have_drive_encoders_reset()) {


                    state++;
                }
                break;
            case 4:
                runWithEncoders();
                setRightMotors(1);
                setLeftMotors(1);

                if(encoderCountReached(1800)){

                    resetEncoders();

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                }
                Log.w("State 3", String.valueOf(state));

                break;

            case 5:

                if (have_drive_encoders_reset()) {


                    state++;
                }
                break;

            case 6:
                count++;
                if (count <40) {
                    openDinoArms();
                    openDeflector();
                }
                else if( count >= 40 && count<200) {
                    stopDeflector();
                }
                else if (count >= 200 && count < 300){
                    shootBalls();
                }

                else {
                    stopShootBalls();
                    state++;
                    count = 0;
                }
                Log.w("COUNTER ", String.valueOf(count));
                Log.w("State 5 ", String.valueOf(state));
                break;
            case 7:

                Log.w("We got here", "State 6");
                runWithEncoders();
                Log.w("We got paste encoders", "Past encoders");
                setRightMotors(1);
                setLeftMotors(-1);

                if(encoderCountReached(410)){

                    resetEncoders();

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                }
                Log.w("State 6 ", String.valueOf(state));
                break;

            case 8:

                if (have_drive_encoders_reset()) {


                    state++;
                }
                break;

            case 9:
                runWithEncoders();
                setRightMotors(-1);
                setLeftMotors(-1);

                if(encoderCountReached(7500)){

                    resetEncoders();

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                }
                Log.w("State 8 ", String.valueOf(state));
                break;
            case 10:

                if (have_drive_encoders_reset()) {


                    state++;
                }
                break;
            case 11:
                runWithEncoders();
                setRightMotors(-1);
                setLeftMotors(1);

                if(encoderCountReached(200)){

                    resetEncoders();

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                }

            Log.w("State 10 ", String.valueOf(state));
                break;
        }
    }
}
