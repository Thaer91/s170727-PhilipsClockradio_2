package dk.dtu.philipsclockradio;

public class StateFm extends StateAdapter {

    static double frequency;

    int [] kanalerFm = {1,2,3,4,5};


    @Override
    public void onClick_Power(ContextClockradio context) {
       // context.setState(new StateR());
        context.setState(new StateAm());
        StateR l = new StateR();
        l.setRadiomode("AM");
    }

    @Override
    public void onLongClick_Power(ContextClockradio context) {
        context.setState(new StateStandby(context.getTime()));
    }

    // Starter med en frequency på 90
    @Override
    public void onEnterState(ContextClockradio context) {
        frequency = 70;
        context.ui.toggleRadioPlaying();
        context.ui.setDisplayText(""+ frequency);

    }


    @Override
    public void onExitState(ContextClockradio context) {
        context.ui.toggleRadioPlaying();

    }

    // Skift i frequency -
    @Override
    public void onClick_Hour(ContextClockradio context) {
        frequency -= 0.1;
        context.ui.setDisplayText(""+frequency);

    }

    // Skift i frequency +
    @Override
    public void onClick_Min(ContextClockradio context) {
        frequency += 0.1;
        context.ui.setDisplayText(""+frequency);

    }





}

