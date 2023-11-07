//
// Copyright (c) 2002 Oracle Corp
// System       : eQ
// Subsystem    : Integration
// File         : QFEQIFUtil.java
// Classes      : QFEQIFUtil
//
// Change History
// Date     Version	Author      Description
// ----     ------- ------      ------------
// 3/6/03	1.0	    Luke Lam    Created.
//

package qantas.integration.util;


/**
 * The QFEQIFUtil class contains utility functionalities.
 *
 * @author Oracle Consulting
 * @version $version$
 *
 * @see QFEQIFConstantIOFilePoll
 */
public class QFEQIFUtilIOFilePoll implements QFEQIFBaseIOFilePoll
{
  private final String CLASS_NAME = getClass().getName();

 /**
  * Returns BLANK is the input string is null or contains white space.
  *
  * @param p_str the input string
  * @return the string
  *
  */
	synchronized public static String toBlank(String p_str)
	{
    //final String METHOD_NAME = CLASS_NAME + ".toBlank";
    //m_log.trace(QFEQIFConstant.ENTER + METHOD_NAME);
    //m_log.trace(QFEQIFConstant.EXIT + METHOD_NAME);
		return (p_str==null?QFEQIFConstantIOFilePoll.BLANK:p_str);
 }
 
}