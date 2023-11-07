package qantas.integration.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

import qantas.integration.util.QFEQIFConstant;
import qantas.integration.util.QFEQIFLogger;
import qantas.integration.util.ftp.QFEQIFFtpClient;

public class QFEIQIFProcedureUtility {

	private static final Logger logger = QFEQIFLogger.getLogger(QFEQIFFtpClient.class.getName());

	public boolean writeFile(String m_targetFolder, String m_fileName, InputStream inputStream) {
		
		boolean rval = false;
		String filePath = (m_targetFolder + QFEQIFConstant.PATH_DELIMITER + m_fileName);
		File file = new File(filePath);
		if(file.exists())
		{
			try {
			logger.info(m_fileName + " File exists");
			file.delete();
			logger.info("Previous file deleted.");
			}
			catch(Exception e)
			{
				rval = false;
				logger.log(Level.WARNING,"Can't delete this file! "+m_fileName);
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
		try {
			Files.copy(inputStream, file.toPath());
			rval = true;
		} catch (IOException e) {
			rval = false;
			logger.log(Level.WARNING, "Exception caught for path" + filePath);
        	logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return rval;
	}

}
