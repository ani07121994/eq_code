//
// Copyright (c) 2002 Oracle Corp
// System       : eQ
// Subsystem    : Integration
// File         : QFEQIFWorkflowBase.java
// Classes      : QFEQIFWorkflowBase
//
// Change History
// Date     Version	Author      Description
// ----     ------- ------      ------------
// 20/12/02	1.0	    Luke Lam    Created.
//

package qantas.integration.util;

/**
 * This is the base class for all workflow classes within eQ
 *
 * @author Oracle Consulting
 * @version $version$
 *
 */
public abstract class QFEQIFWorkflowBase implements QFEQIFBase
{

  protected String m_fileName = QFEQIFConstant.BLANK;
  protected String m_targetFolder = QFEQIFConstant.BLANK;
  protected String m_sourceFolder = QFEQIFConstant.BLANK;
  protected String m_overwriteFlag = QFEQIFConstant.BLANK;

  public static final String IFS_WF = "WF";
  public static final String IFS_WF_FN_ERROR = "WF_FN_ERROR";
  public static final String IFS_WF_MODULE = "MODULE";
  public static final String IFS_WF_ITEM_TYPE = "ITEMTYPE";
  public static final String IFS_WF_ITEM_KEY = "ITEMKEY";
  public static final String IFS_WF_ACT_ID = "ACTID";
  public static final String IFS_WF_FUNCTION_MODE = "FUNCMODE";
  public static final String IFS_WF_ERROR_MESSAGE = "ERRMESSAGE";

 /**
 	* Constructor
 	*
 	*/
	public QFEQIFWorkflowBase()
	{
		super();
	}

 /**
  * Returns true if mode is binary else false.
  * 
  * @param p_xferMode the xfer mode
  * @return true if mode is binary
  */
  public boolean isBinaryXfer(String p_xferMode)
  {
    return ((p_xferMode.toUpperCase()).equals(QFEQIFConstant.WF_FTP_XFER_BINARY));
  }

 /**
  * Returns true if it is passive.
  * 
  * @param p_isPassive the passive flag
  * @return true if is passive
  */
  public boolean isPassive(String p_isPassive)
  {
    return ((p_isPassive.toUpperCase()).equals(QFEQIFConstant.WF_FTP_MODE_PASSIVE));
  }
 
}