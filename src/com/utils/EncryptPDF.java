package com.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

/**
 * 
 */

/**
 * @author mohammmedmaaz
 *
 */
public class EncryptPDF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pdfPassword = "", filePath = "/Users/mohammmedmaaz/Downloads/MohammedMaaz_CV.pdf";
		try {
			encryptPdf(filePath, pdfPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void encryptPdf(String pdfFileName, String pdfPwd) throws Exception {
		PDDocument doc = null;
		try {
			doc = PDDocument.load(pdfFileName);
			AccessPermission ap = new AccessPermission();
			ap.setCanModify(false);
			ap.setCanFillInForm(false);
			ap.setCanExtractContent(false);
			ap.setCanExtractForAccessibility(false);
			ap.setCanAssembleDocument(false);
			ap.setCanModifyAnnotations(false);
			ap.setReadOnly();
			StandardProtectionPolicy policy = new StandardProtectionPolicy(pdfPwd, pdfPwd, ap);
			doc.protect(policy);
			doc.save(pdfFileName);
			doc.close();
			System.out.println("File Encrypted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}