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

            }
            @Override
            public void onFinish() {
                context.setState(new StateStandby(context.getTime()));
            }
        };
    }

    @Override
    public void onExitState(ContextClockradio context) {
       context.ui.turnOffLED(3);

    }
    // Kører CountDownTimeren og Tjekker om hvor mange gang man trykker på Sleep knappen, og så giver den bestemte displayet
    // Når der går 5 sec siden man har tryklket sidste tryk bliver brugeren tilbagesendt til Standby
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
           // context.ui.turnOffLED(3);
            antalKlik = 0;
        }
        timer.start();
    }
}
