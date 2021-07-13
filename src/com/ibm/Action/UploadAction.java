package com.ibm.Action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ibm.form.UploadForm;

public class UploadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadForm uploadForm = (UploadForm)form;
		FileOutputStream outputStream = null;
		String filePath = System.getProperty("java.io.tmpdir") + "/" + uploadForm.getUploadedFile().getFileName();
		System.out.println(filePath);
		try {
			outputStream = new FileOutputStream(new File(filePath));
			outputStream.write(uploadForm.getUploadedFile().getFileData());			
		} catch (Exception e) {
			ActionErrors errors = new ActionErrors();
			errors.add("uploadedFile",new ActionMessage("errors.file.save",uploadForm.getUploadedFile().getFileName()));
			saveErrors(request,errors);
		}finally{
			if(outputStream != null)
				outputStream.close();
		}
		if(getErrors(request) == null ||getErrors(request).size() == 0){
			uploadForm.setFileName(uploadForm.getUploadedFile().getFileName());
			return mapping.findForward("success");
		}
		else
			return mapping.getInputForward();
	}
}
