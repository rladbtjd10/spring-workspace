package com.kh.mvc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String path = (String) model.get("path");
		String fileName = request.getParameter("filename");
		
		// ���ε� ��ΰ� ����� ���� ��ü
		File file = new File(path + fileName);
		
		// ���� �ٿ�ε�
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length()); // ���� ũ�� ����
		
		// �ٿ�ε� ���Ͽ� ���� ����
		response.setHeader("Content-Disposition", "attachment; fileName=" + new String(file.getName().getBytes("UTF-8"), "8859_1"));
		
		// ������ ���ڵ��� ���̳ʸ� �������� ���
		response.setHeader("Content-Transfer-encoding", "binary");
		
		// ���� ���ε� ������ inputStream���� �о
		// response�� ����� outputStream���� �����ϰڴ�
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os); 
		
	}
	
}
