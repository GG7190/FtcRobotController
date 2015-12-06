package com.greengirls.chinaAutonomous;

import com.greengirls.RobotHardware2016;

public class WARCAuto extends RobotHardware2016 {
    public void loop() {
        setLeftMotors(1);
        setRightMotors(-1);
        wait(100);
    }

    public static void wait(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
