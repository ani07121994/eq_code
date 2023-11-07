package com.qantas.ap.quartz;

public class TestDocID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String imgUrl = "https://eqweb.qantas.com.au/imaging/faces/Pages/Viewer.jspx?documentId=2.IPM_992657";
    	System.out.println("Image URL :"+imgUrl);
    	String[] split = imgUrl.split("=");
    	String docURL = split[0];
    	String docID = split[1];
    	System.out.println("docURL..."+docURL);
    	System.out.println("docID..."+docID);
	}

}
