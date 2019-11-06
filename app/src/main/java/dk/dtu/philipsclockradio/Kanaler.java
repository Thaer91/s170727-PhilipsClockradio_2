package dk.dtu.philipsclockradio;

public class Kanaler {

    private String kanalname;
    private double kanalFreq;
    private boolean gemtKanal;

    public Kanaler(String kanalname, double kanalFreq, boolean gemtKanal) {
        this.kanalname = kanalname;
        this.kanalFreq = kanalFreq;
        this.gemtKanal = gemtKanal;
    }

    public String getKanalname() {
        return kanalname;
    }

    public void setKanalname(String kanalname) {
        this.kanalname = kanalname;
    }

    public double getKanalFreq() {
        return kanalFreq;
    }

    public void setKanalFreq(double kanalFreq) {
        this.kanalFreq = kanalFreq;
    }

    public boolean isGemtKanal() {
        return gemtKanal;
    }

    public void setGemtKanal(boolean gemtKanal) {
        this.gemtKanal = gemtKanal;
    }
}
