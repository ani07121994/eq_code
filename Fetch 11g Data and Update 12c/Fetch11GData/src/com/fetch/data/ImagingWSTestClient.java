package com.fetch.data;

import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentContentService.DocumentContentService;
import ap.quantas.com.imaging.documentContentService.DocumentContentService_Service;
import ap.quantas.com.imaging.documentContentService.Rendition;
import ap.quantas.com.imaging.documentContentService.RenditionOutput;
import ap.quantas.com.imaging.documentContentService.TypedValue;

import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

public class ImagingWSTestClient {
	public ImagingWSTestClient() {
		super();
	}

	public static FileDescriptor getFileFromImaging(String docId) {
		try {

			FileDescriptor fd = new FileDescriptor();

			System.out.println(" --- getFileFromImaging --- docId : " + docId);
			DocumentContentService documentContentService = new DocumentContentService_Service()
					.getDocumentContentServicePort();
			BindingProvider bindingProvider = (BindingProvider) documentContentService;
			@SuppressWarnings("rawtypes")
			List<Handler> handlerChain = new ArrayList<Handler>();
			handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "W3bl0g!c@123"));
			bindingProvider.getBinding().setHandlerChain(handlerChain);

			Rendition rendition = documentContentService.retrieveRendition(docId, false, true,
					RenditionOutput.ORIGINALORTIFF, null);
			System.out
					.println(" --- getFileFromImaging --- : getOriginalFilename : " + rendition.getOriginalFilename());
			byte[] byteData = rendition.getContent();
			System.out.println(" --- getFileFromImaging --- : Length of document byte data : " + byteData.length);
			String mimeType = rendition.getMimeType();
			mimeType = mimeType.substring(mimeType.lastIndexOf("/") + 1, mimeType.length());
			System.out.println(mimeType);

			fd.setBytedata(byteData);
			fd.setFilename(rendition.getOriginalFilename() == null ? ("invoice_document." + mimeType)
					: rendition.getOriginalFilename());

			System.out.println(" --- getFileFromImaging : Done ---");
			return fd;
		} catch (Exception e) {
			System.out.println(" --- getFileFromImaging : Exception");
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {

		String docId = "IPM_1945317";

		FileDescriptor fd = getFileFromImaging(docId);

		if (fd != null) {

			System.out.println(fd.getFilename());
			System.out.println(fd.getBytedata().length);
			try {

				new FileOutputStream("C:\\Users\\2292543\\Downloads\\OldDocId\\" + fd.getFilename())
						.write(fd.getBytedata());
				System.out.println("DONE");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
}

class FileDescriptor {
	private String filename;
	private byte[] bytedata;

	public FileDescriptor() {
	}

	public FileDescriptor(String filename, byte[] bytedata) {
		super();
		this.filename = filename;
		this.bytedata = bytedata;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setBytedata(byte[] bytedata) {
		this.bytedata = bytedata;
	}

	public byte[] getBytedata() {
		return bytedata;
	}
}
