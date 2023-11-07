package qantas.integration.util;

import java.util.TimerTask;

public class FTPPollTaskIOFilePoll extends TimerTask {
    public FTPPollTaskIOFilePoll() {
        super();
    }
    
    public void run() {
        QFEQIFFtpPollIOFilePoll.execute();
    }
}
