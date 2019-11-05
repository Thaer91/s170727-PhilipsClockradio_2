package dk.dtu.philipsclockradio;



public class StateR extends StateAdapter {
    static int frequency;



    @Override
    public void onClick_Power(ContextClockradio context) {
        context.setState(new StateR());
    }


    @Override
    public void onLongClick_Power(ContextClockradio context) {
        context.setState(new StateStandby(context.getTime())); // Return to standby with current time
    }

    @Override
    public void onEnterState(ContextClockradio context) {
        frequency = 1;
        context.ui.toggleRadioPlaying();
        context.ui.setDisplayText(""+ frequency);
    }
    @Override
    public void onExitState(ContextClockradio context) {
        context.ui.toggleRadioPlaying();

    }
    @Override
    public void onClick_Hour(ContextClockradio context) {

            frequency -= 1;
            context.ui.setDisplayText(""+frequency);

    }
    @Override
    public void onClick_Min(ContextClockradio context) {

            frequency += 1;
            context.ui.setDisplayText(""+frequency);

    }


}
