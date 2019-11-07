package dk.dtu.philipsclockradio;

import android.os.CountDownTimer;

import java.util.Date;

public class StateAl1 extends StateAdapter {

    long Time;
    Alarm AL1;
    Date alarmTid;
    int antalKlik = 0;
    CountDownTimer cT;



    @Override
    public void onEnterState(final ContextClockradio context) {
        Time = context.getTime().getTime();
        alarmTid = new Date(Time);
        AL1 = new Alarm(alarmTid.getTime(), alarmTid);
        context.updateDisplayTime();

        cT = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                if (antalKlik == 1){
                    context.ui.turnOnLED(2);
                } else if (antalKlik == 2){
                    context.ui.turnOffLED(2);
                    context.ui.turnOnLED(1);
                } else if (antalKlik == 3){
                    context.ui.turnOffLED(1);
                    antalKlik = 0;
                }
            }

            @Override
            public void onFinish() {

                if (antalKlik == 1){

                    context.setState(new StateAlRinger());
                } else if (antalKlik == 2){
                    context.setState(new StateR() );
                    context.ui.turnOffTextBlink();

                } else if (antalKlik == 3){
                    context.ui.turnOffTextBlink();
                    context.setState(new StateStandby(context.getTime()));
                    antalKlik = 0;

                }
            }
        };




    }

    @Override
    public void onExitState(ContextClockradio context) {

    }

    @Override
    public void onClick_AL1(final ContextClockradio context) {
        cT.cancel();
        antalKlik++;

        cT.start();
        }



    @Override
    public void onClick_Hour(ContextClockradio context) {
        long timer = AL1.getAlarm().getTime() + 3600000;
        AL1.getAlarm().setTime(timer);
        String tezxt = AL1.getAlarm().toString().substring(11,16);
        context.ui.setDisplayText(tezxt);

    }

    @Override
    public void onClick_Min(ContextClockradio context) {
        long timer1 = AL1.getAlarm().getTime() + 60000;
        AL1.getAlarm().setTime(timer1);
        String text = AL1.getAlarm().toString().substring(11,16);
        context.ui.setDisplayText(text);

    }
}
