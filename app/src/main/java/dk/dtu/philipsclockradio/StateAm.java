package dk.dtu.philipsclockradio;

import java.util.ArrayList;

public class StateAm extends StateAdapter {
    static int frequency2;

    // ArrayList over alle de kanaler vi har i AM
    ArrayList <Kanaler> kanalerAmArrayList = new ArrayList<>();
    ArrayList <Kanaler> GemteAmKanaler = new ArrayList<>();
    public StateAm() {
        kanalerAmArrayList.add(new Kanaler("Dm1",55,false));
        kanalerAmArrayList.add(new Kanaler("Dm2",57,false));
        kanalerAmArrayList.add(new Kanaler("Dm3",59,false));
    }

    // skifter mellem am og fm
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
        context.ui.setDisplayText("AM  "+ frequency2);

    }

    // Skift i frequency -
    @Override
    public void onClick_Hour(ContextClockradio context) {

        frequency2 -= 1;
        for (int i = 0; i < kanalerAmArrayList.size() ; i++) {
            if (kanalerAmArrayList.get(i).getKanalFreq() == frequency2){

                context.ui.setDisplayText(kanalerAmArrayList.get(i).getKanalname() + " " + frequency2);
                break;
            }
            else {
                context.ui.setDisplayText(""+frequency2);
            }
        }
    }

    // Skift i frequency +
    @Override
    public void onClick_Min(ContextClockradio context) {

        frequency2 += 1;
        for (int i = 0; i < kanalerAmArrayList.size() ; i++) {
            if (kanalerAmArrayList.get(i).getKanalFreq() == frequency2){

                context.ui.setDisplayText(kanalerAmArrayList.get(i).getKanalname()+ " " + frequency2);
                break;
            }
            else {
                context.ui.setDisplayText(""+frequency2);
            }
        }
    }
    // Gemmer kanalerne inde i den anden ArrayList
    @Override
    public void onLongClick_Preset(ContextClockradio context) {
        for (int i = 0; i < kanalerAmArrayList.size(); i++) {
            for (int j = 0; j < GemteAmKanaler.size(); j++) {
                if (kanalerAmArrayList.get(i).getKanalFreq() == GemteAmKanaler.get(j).getKanalFreq()){
                    break;
                }
            }
            if (kanalerAmArrayList.get(i).getKanalFreq() == frequency2){
                GemteAmKanaler.add(kanalerAmArrayList.get(i));
                break;
            }
        }


    }
}



