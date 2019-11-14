package dk.dtu.philipsclockradio;

import java.util.ArrayList;

public class StateFm extends StateAdapter {

    static int frequency;

    // ArrayList over alle de kanaler vi har i FM
    ArrayList < Kanaler> kanalerFmArrayList =  new ArrayList<>();
    ArrayList <Kanaler> GemteFmKanaler = new ArrayList<>();
    public StateFm() {
        kanalerFmArrayList.add(new Kanaler("Kanal1", 72, false));
        kanalerFmArrayList.add(new Kanaler("Kanal2",75,false));
        kanalerFmArrayList.add(new Kanaler("Kanal3",79,false));
    }
    // skifter mellem fm og am
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

    // Starter med en frequency på 70
    @Override
    public void onEnterState(ContextClockradio context) {
        frequency = 70;
        context.ui.toggleRadioPlaying();
        context.ui.setDisplayText("FM  "+ frequency);



    }

    // Skift i frequency -
    @Override
    public void onClick_Hour(ContextClockradio context) {
        frequency -= 1;
        for (int i = 0; i < kanalerFmArrayList.size() ; i++) {
            if (kanalerFmArrayList.get(i).getKanalFreq() == frequency){

                context.ui.setDisplayText(kanalerFmArrayList.get(i).getKanalname()+ " " +frequency);
                break;
            }
            else {
                context.ui.setDisplayText(""+frequency);

            }
        }
    }

    // Skift i frequency +
    @Override
    public void onClick_Min(ContextClockradio context) {
        frequency += 1;
        for (int i = 0; i < kanalerFmArrayList.size() ; i++) {
            if (kanalerFmArrayList.get(i).getKanalFreq()==frequency){

                context.ui.setDisplayText(kanalerFmArrayList.get(i).getKanalname() +" "+ frequency);
                break;
            }
            else {
                context.ui.setDisplayText(""+frequency);

            }
        }
    }
    // Tjekker hvis der er en kanal er inde i kanalerFmArrayList, så gemmer den i Gemtekanaler
    @Override
    public void onLongClick_Preset(ContextClockradio context) {
        for (int i = 0; i < kanalerFmArrayList.size(); i++) {
            for (int j = 0; j < GemteFmKanaler.size(); j++) {
                if (kanalerFmArrayList.get(i).getKanalFreq() == GemteFmKanaler.get(j).getKanalFreq()){
                    //context.ui.setDisplayText("NEJ");
                    break;
                }
            }
            if (kanalerFmArrayList.get(i).getKanalFreq() == frequency){
                GemteFmKanaler.add(kanalerFmArrayList.get(i));
                //context.ui.setDisplayText("Yaa");

                break;
            }
        }


    }

    @Override
    public void onClick_AL1(ContextClockradio context) {
        context.ui.turnOffTextBlink();
        context.ui.turnOffLED(1);
        context.setState(new StateStandby(context.getTime()));
    }
    @Override
    public void onClick_AL2(ContextClockradio context) {
        context.ui.turnOffTextBlink();
        context.ui.turnOffLED(4);
        context.setState(new StateStandby(context.getTime()));

    }

    @Override
    public void onClick_Snooze(ContextClockradio context) {

    }
}

