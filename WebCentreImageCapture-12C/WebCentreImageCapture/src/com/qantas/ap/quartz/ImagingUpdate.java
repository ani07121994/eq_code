package com.qantas.ap.quartz;


/*import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ImagingUpdate extends QuartzJobBean {
	


	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		ImagingUpdateTask task = new ImagingUpdateTask();
		task.run();
	}
	
	

}*/



public class ImagingUpdate {

	protected void executeInternal() {
		
		ImagingUpdateTask task = new ImagingUpdateTask();
		task.run();
	}
	

}


