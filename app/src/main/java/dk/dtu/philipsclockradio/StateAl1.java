package dk.dtu.philipsclockradio;

import java.util.Date;

public class StateAl1 extends StateAdapter {

    long Time;
    Alarm AL1;
    Date alarmTid;



    @Override
    public void onEnterState(ContextClockradio context) {
        Time = context.getTime().getTime();
        alarmTid = new Date(Time);
        AL1 = new Alarm(alarmTid.getTime(), alarmTid);
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
