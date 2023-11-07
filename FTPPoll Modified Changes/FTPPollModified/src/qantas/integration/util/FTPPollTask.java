package qantas.integration.util;

import java.util.TimerTask;

public class FTPPollTask extends TimerTask {
    public FTPPollTask() {
        super();
    }
    
    public void run() {
        QFEQIFFtpPoll.execute();
    }
}
