package dk.dtu.philipsclockradio;

import android.os.CountDownTimer;

import java.util.Date;

public class StateAl2 extends StateAdapter {

    long Time;
    Alarm AL2;
    Date alarmTid;
    int antalKlik;
    CountDownTimer cT2;

    //S
    @Override
    public void onEnterState(final ContextClockradio context) {
        Time = context.getTime().getTime();
        alarmTid = new Date(Time);
        AL2 = new Alarm(alarmTid.getTime(), alarmTid);
        context.updateDisplayTime();

        cT2 = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                if (antalKlik == 1){
                    context.ui.turnOnLED(5);
                } else if (antalKlik == 2){
                    context.ui.turnOffLED(5);
                    context.ui.turnOnLED(4);
                } else if (antalKlik == 3){
                    context.ui.turnOffLED(4);
                    antalKlik = 0;
                }
            }

            @Override
            public void onFinish() {

                if (antalKlik == 1){

                    context.setState(new StateAlRinger());
                } else if (antalKlik == 2){
                    context.setState(new StateR() );
                   // context.ui.turnOffTextBlink();

                } else if (antalKlik == 3){
                    context.ui.turnOffTextBlink();
                    context.setState(new StateStandby(context.getTime()));
                    antalKlik = 0;

                }
            }
        };
    }

    @Override
    public void onClick_AL2(final ContextClockradio context) {
        cT2.cancel();
        antalKlik++;

        cT2.start();

    }
    // Øger med en 3600000 ms som er en time
    @Override
    public void onClick_Hour(ContextClockradio context) {
        long timer = AL2.getAlarm().getTime() + 3600000;
        AL2.getAlarm().setTime(timer);
        String tezxt = AL2.getAlarm().toString().substring(11,16);
        context.ui.setDisplayText(tezxt);

    }
    // Øger med en 60000 ms som er et minut
    @Override
    public void onClick_Min(ContextClockradio context) {
        long timer1 = AL2.getAlarm().getTime() + 60000;
        AL2.getAlarm().setTime(timer1);
        String text = AL2.getAlarm().toString().substring(11,16);
        context.ui.setDisplayText(text);

    }
}
