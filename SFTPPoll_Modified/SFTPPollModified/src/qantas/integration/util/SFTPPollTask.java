package qantas.integration.util;

import java.util.TimerTask;

public class SFTPPollTask extends TimerTask{
	
	public SFTPPollTask() {
        super();
    }

	@Override
	public void run() {
		SFTPPoll.execute();
	}

}
