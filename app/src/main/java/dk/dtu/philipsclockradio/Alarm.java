package dk.dtu.philipsclockradio;

import java.util.Date;

public class Alarm  {

    private Long time;
    private Date alarm;

    public Alarm(Long time, Date alarm) {
        this.time = time;
        this.alarm = alarm;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Date getAlarm() {
        return alarm;
    }

    public void setAlarm(Date alarm) {
        this.alarm = alarm;
    }
}
