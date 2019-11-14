package dk.dtu.philipsclockradio;

import android.os.CountDownTimer;

public class StateAlRinger extends StateAdapter {

    CountDownTimer cTAlarm;

    @Override
    public void onEnterState(final ContextClockradio context) {
        context.ui.setDisplayText("Kli Kli");
        // CountDownTimeren får brugeren til StateStandby lige når brugeren trykker på Snooze knappe, så tæler den 9 min. og så vender den tilbage til StateAlRinger.
        cTAlarm = new CountDownTimer(450000,1000) {
            @Override
            public void onTick(long l) {
                context.ui.turnOffTextBlink();
                context.setState(new StateStandby(context.getTime()));
            }
            @Override
            public void onFinish() {
                context.setState(new StateAlRinger());

            }
        };


    }
    // Slutter for alarmen og får brugeren til StateStandby
    @Override
    public void onClick_AL1(ContextClockradio context) {
        context.ui.turnOffTextBlink();
        context.ui.turnOffLED(2);
        context.setState(new StateStandby(context.getTime()));


    }

    @Override
    public void onClick_AL2(ContextClockradio context) {
        context.ui.turnOffTextBlink();
        context.ui.turnOffLED(5);
        context.setState(new StateStandby(context.getTime()));

    }

    @Override
    public void onClick_Snooze(final ContextClockradio context) {

        cTAlarm.cancel();

        cTAlarm.start();
    }
}
