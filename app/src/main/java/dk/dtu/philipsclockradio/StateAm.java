package dk.dtu.philipsclockradio;

public class StateAm extends StateAdapter {
    static double frequency2;

    @Override
    public void onClick_Power(ContextClockradio context) {
        //context.setState(new StateR());
        context.setState(new StateFm());
        StateR k = new StateR();
        k.setRadiomode("FM");
    }


    @Override
    public void onLongClick_Power(ContextClockradio context) {
        context.setState(new StateStandby(context.getTime()));
    }

    // Starter med en frequency på 90
    @Override
    public void onEnterState(ContextClockradio context) {
        frequency2 = 50;
        context.ui.toggleRadioPlaying();
        context.ui.setDisplayText(""+ frequency2);

    }


    @Override
    public void onExitState(ContextClockradio context) {
        context.ui.toggleRadioPlaying();

    }

    // Skift i frequency -
    @Override
    public void onClick_Hour(ContextClockradio context) {

        frequency2 -= 0.1;
        context.ui.setDisplayText(""+frequency2);

    }

    // Skift i frequency +
    @Override
    public void onClick_Min(ContextClockradio context) {

        frequency2 += 0.1;
        context.ui.setDisplayText(""+frequency2);

    }


}



