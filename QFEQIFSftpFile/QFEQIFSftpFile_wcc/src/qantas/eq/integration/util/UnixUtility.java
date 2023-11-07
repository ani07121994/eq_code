package qantas.eq.integration.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import qantas.eq.integration.sftp.QFEQIFSftpFile;

public class UnixUtility {
	
	
	
	String destFolder = null;
	private static final Logger logger = QFEQIFSftpLogger.getLogger(QFEQIFSftpFile.class.getName());
	
	
	
	
	
	public InputStream copyFile(InputStream fis , String fileName)
	{
		FileInputStream fileIns = null;
		InputStream fileInsNew = null;
		/*InputStream fileInsNewServer = null;*/
		FileOutputStream fos = null;
		BufferedReader br = null;
		ByteArrayOutputStream baos = null;
		
		
		
		destFolder = System.getenv("QFEQSOAOUT") + "/";
		logger.info("OutputStream FilePath :" + destFolder + fileName);
		logger.info("Environment Variable :" + System.getenv("QFEQSOAOUT"));
		try {
			fos = new FileOutputStream(destFolder + fileName);
			int b; 
			
	        while  ((b=fis.read()) != -1) 
	            fos.write(b);
	        
			
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING,"IO Exception occured");
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (IOException e) {
			logger.log(Level.WARNING,"IO Exception occured");
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				logger.log(Level.WARNING,"IO Exception occured");
				logger.log(Level.SEVERE, e.getMessage(), e);
			} 
	       
		}
		
		try {
			Process prc = null;
			String cmd = "dos2unix " + destFolder + fileName;
			System.out.println("Trim command " + cmd);
			prc = Runtime.getRuntime().exec(cmd);
			byte[] result = null;
			if(prc != null)
			{
				try {
					fileIns = new FileInputStream(new File(destFolder + fileName));
					br  = new BufferedReader(new InputStreamReader(fileIns));
					baos = new ByteArrayOutputStream();
					int d;
					    while ((d = br.read()) != -1) {
					        if(d != 13)
					        	baos.write(d);
					        result = baos.toByteArray();
					    }
					fileInsNew = new ByteArrayInputStream(result);
					/*fileInsNewServer = new ByteArrayInputStream(result);
				    
					fos1 = new FileOutputStream(destFolder + fileName + "Copy");
					int c; 
					
			        while  ((c=fileInsNew.read()) != -1) 
			            fos1.write(c);*/
					
					
				} catch (FileNotFoundException e) {
					logger.log(Level.WARNING,"File Not Found Exception occured");
					logger.log(Level.SEVERE, e.getMessage(), e);
				}
				finally
				{
					fileIns.close();
					baos.close();
					br.close();
				}
			}
		} catch (IOException e) {
			logger.log(Level.WARNING,"IO Exception occured");
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		
		return fileInsNew;
		
	}
	
	public boolean deleteFileFromLocal(String fileName)
	{
		boolean isDeleted = false;
		try {
			File file = new File(destFolder + fileName);
			if(file.delete())
			{
				isDeleted = true;
			}
		} catch (Exception e) {
			logger.log(Level.WARNING,"File Exception occured during deletion");
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		
		return isDeleted;
		
	}

}
