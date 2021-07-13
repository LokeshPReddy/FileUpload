<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File in this page</title>
</head>
<body>
	<html:form action="/fileUpload" enctype="multipart/form-data" method="POST">
		<html:errors/><br/>
		Select File : <html:file property="uploadedFile"/><br/>
		<html:submit value="Upload"/>
	</html:form>
</body>
</html>