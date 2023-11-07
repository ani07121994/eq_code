package com.audit.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.audit.pojo.InvoiceAudit;

public class Test {
	
	
	public static void main(String[] args) {
		
		String approverName = "Korapati Surya Chandra, Subrahmanya Raju";
		String[] modifiedName = approverName.split(",");
		System.out.println(modifiedName[1].trim() + " " + modifiedName[0].trim());

	}

	

}
