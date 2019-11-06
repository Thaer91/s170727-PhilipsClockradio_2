package dk.dtu.philipsclockradio;
import android.os.CountDownTimer;

public class StateS extends StateAdapter {

    int antalKlik;
    public CountDownTimer timer;

    @Override
    public void onEnterState(final ContextClockradio context) {

        context.ui.turnOnLED(3); context.ui.setDisplayText("120");
        antalKlik++;

        timer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long l) {
                // l er i ms => vi dividere med 100 for at få det i sec.
                //context.ui.setDisplayText(Long.toString(l/1000));


            }

            @Override
            public void onFinish() {
                context.ui.setDisplayText("5 Sec er gået");
                context.setState(new StateStandby(context.getTime()));

            }
        };
    }

    @Override
    public void onExitState(ContextClockradio context) {
        context.ui.turnOffLED(3);

    }
    //"if idle for 5 sec then change state"


    @Override
    public void onClick_Sleep(ContextClockradio context) {

        timer.cancel();

        if (antalKlik == 0){
            context.ui.setDisplayText("120");
            antalKlik++;
        } else if (antalKlik == 1){
            context.ui.setDisplayText("90");
            antalKlik++;
        } else if (antalKlik == 2){
            context.ui.setDisplayText("60");
            antalKlik++;
        } else if (antalKlik == 3){
            context.ui.setDisplayText("30");
            antalKlik++;
        } else if (antalKlik == 4){
            context.ui.setDisplayText("15");
            antalKlik++;
        } else if (antalKlik == 5){
            context.ui.setDisplayText("OFF");
            antalKlik = 0;
        }
        timer.start();
    }
}
