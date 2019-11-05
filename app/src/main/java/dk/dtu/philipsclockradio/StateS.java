package dk.dtu.philipsclockradio;

import java.util.Timer;

public class StateS extends StateAdapter {

    int antalKlik;
    Timer timer = new Timer();

    @Override
    public void onEnterState(ContextClockradio context) {
        super.onEnterState(context);
    }
}
