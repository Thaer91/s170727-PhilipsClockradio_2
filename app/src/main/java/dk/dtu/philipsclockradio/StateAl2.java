package dk.dtu.philipsclockradio;

import java.util.Date;

public class StateAl2 extends StateAdapter {

    long Time;
    Alarm AL2;
    Date alarmTid;


    @Override
    public void onEnterState(ContextClockradio context) {
        Time = context.getTime().getTime();
        alarmTid = new Date(Time);
        AL2 = new Alarm(alarmTid.getTime(), alarmTid);
        context.updateDisplayTime();
    }

    @Override
    public void onExitState(ContextClockradio context) {

    }

    @Override
    public void onClick_AL1(ContextClockradio context) {



    }



    @Override
    public void onClick_Hour(ContextClockradio context) {
        long timer = AL2.getAlarm().getTime() + 3600000;
        AL2.getAlarm().setTime(timer);
        String tezxt = AL2.getAlarm().toString().substring(11,16);
        context.ui.setDisplayText(tezxt);

    }

    @Override
    public void onClick_Min(ContextClockradio context) {
        long timer1 = AL2.getAlarm().getTime() + 60000;
        AL2.getAlarm().setTime(timer1);
        String text = AL2.getAlarm().toString().substring(11,16);
        context.ui.setDisplayText(text);

    }
}