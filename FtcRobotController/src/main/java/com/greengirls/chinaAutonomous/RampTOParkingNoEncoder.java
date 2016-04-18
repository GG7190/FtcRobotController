package com.greengirls.chinaAutonomous;

import android.os.SystemClock;
import android.util.Log;

import com.greengirls.RobotHardwareChina;

/**
 * Created by User on 11/13/2015.
 */
public class RampTOParkingNoEncoder extends RobotHardwareChina {

    //set state to zero
    int state = 0;
    int count = 0;
    @Override
    public void loop() {
        try {
            switch (state) {
                case 0:
                    //
                    setRightMotors(1);
                    setLeftMotors(1);

                    Thread.sleep(1600);

                    state++;

                    Log.w("State 0 ", String.valueOf(state));
                    break;
                case 1:
                    setRightMotors(-1);
                    setLeftMotors(1);

                    SystemClock.sleep(1600);

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;

                    Log.w("State 1 ", String.valueOf(state));
                    break;

                case 2:
                    setRightMotors(1);
                    setLeftMotors(1);

                    SystemClock.sleep(1600);

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;

                    Log.w("State 2 ", String.valueOf(state));

                    break;
                case 3:
                    count++;
                    if (count < 200) {
                        closeDinoArms();
                        openDeflector();
                    } else if (count >= 200 && count < 500) {
                        stopDeflector();
                        shootBalls();
                    } else {
                        stopShootBalls();
                        state++;
                        count = 0;
                    }
                    Log.w("COUNTER ", String.valueOf(count));
                    Log.w("State 3 ", String.valueOf(state));
                    break;
                case 4:

                    openBallChannel();
                    setRightMotors(-1);
                    setLeftMotors(1);

                    SystemClock.sleep(1600);

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;

                    Log.w("State 4 ", String.valueOf(state));
                    break;
                case 5:
                    setRightMotors(1);
                    setLeftMotors(1);

                    SystemClock.sleep(1600);

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;

                    Log.w("State 5 ", String.valueOf(state));
                    break;
                case 6:
                    setRightMotors(-1);
                    setLeftMotors(1);

                    SystemClock.sleep(1600);

                    setRightMotors(0);
                    setLeftMotors(0);

                    state++;
                    Log.w("State 6 ", String.valueOf(state));
                    break;
            }
        } catch (InterruptedException e){
            Log.e("INTERUPTED EXCEPTION", e.getMessage());
        }
    }
}
