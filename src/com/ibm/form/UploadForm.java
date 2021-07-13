package com.ibm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm {

	private static final long serialVersionUID = 2025885369419610335L;
	
	private FormFile uploadedFile = null;
	private String fileName = null;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FormFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(FormFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		uploadedFile = null;
		super.reset(mapping, request);
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(uploadedFile.getFileSize() == 0)
			errors.add("uploadedFile", new ActionMessage("errors.file.notselected"));
		if(errors.isEmpty()){
			if(!uploadedFile.getContentType().equalsIgnoreCase("image/jpeg") && !uploadedFile.getContentType().equalsIgnoreCase("image/jpg")
					&& !uploadedFile.getContentType().equalsIgnoreCase("image/pjpeg"))
				errors.add("uploadedFile", new ActionMessage("errors.file.type", uploadedFile.getFileName(),uploadedFile.getContentType()));
			if(uploadedFile.getFileSize() > 50000)
				errors.add("uploadedFile", new ActionMessage("errors.file.size",uploadedFile.getFileName(),uploadedFile.getFileSize()));
		}
		return errors;
	}

}
