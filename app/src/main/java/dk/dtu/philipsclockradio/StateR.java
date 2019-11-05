package dk.dtu.philipsclockradio;



public class StateR extends StateAdapter {

    private static String radiomode = "FM";

    @Override
    public void onEnterState(ContextClockradio context) {
        if (radiomode == "FM"){
            context.setState(new StateFm());
        }else {
            context.setState(new StateAm());
        }
    }

    public void setRadiomode(String radiomode){
        this.radiomode = radiomode;
    }
}
