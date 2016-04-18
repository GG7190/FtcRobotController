package com.greengirls.ResQAuto;

import com.greengirls.RobotHardware2016;

/**
 * Created by User on 12/30/2015.
 */
public class ColorAutoLanceRedXXX extends RobotHardware2016 {

    int state = 0;
    int count = 0;

    @Override
    public void loop() {
        switch (state){
            case 0:
                //start facing beacon
                //Drive forward to the floor zone while spinning the collector motor to prevent debris from getting in the way
                setLeftMotors(-1);
                setRightMotors(1);
                //TODO: add arm movements
                setCollectorMotor(-1);
                if( count >= 600 && count<3000) {
                    state++;
                    count=0;
                }
                count++;
                break;

            case 1:
                //turn to face the basket
                setLeftMotors(-1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state++;
                    count=0;
                }
                count++;
                break;
            case 2:
                //lift up arm using winch to begin the climber sequence
                liftUp();
                if ( count >= 600 && count<3000) {
                    state++;
                    count=0;
                }

                count++;
                break;
            case 3:
                //extend the arm to continue the climber sequence
                liftOut();
                if ( count >= 600 && count<3000) {
                    state=4;
                    count=0;
                }

                count++;
                break;
            case 4:
                //
            case 8:
                //TODO: read color sensor
                state++;
                //TODO: if red go to case 3
                // TODO: if blue go to case 10
                break;
            case 9:
                //TODO:  servo out
                setLeftMotors(-1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state++;
                    count=0;
                }
                count++;
                break;
            case 10:
                setLeftMotors(1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state++;
                }
                setLeftMotors(-1);
                setRightMotors(1);
                if( count >= 600 && count<3000) {
                    state++;
                }
                //button servo out
                count++;
                break;
            case 5:
                liftUp();
                if( count >= 600 && count<3000) {
                    state++;
                }

                liftOut();
                if( count >= 600 && count<3000) {
                    state++;
                }

                liftDown();
                if( count >= 600 && count<3000) {
                    state++;
                }

                leftWingOut();

                leftBasket();

                break;

        }
    }


}
