package com.semi.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class GowithFileRename implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		File newFile=null;
		do {
			//날짜를 밀리세컨 까지 가져와서 파일이름에 붙힘
			long currentTime=System.currentTimeMillis();//현제 시간 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndNum = (int)(Math.random()*1000);
			//확장자명만 가져오기
			String oriName=oldFile.getName();
			String ext="";
			int dot=oriName.lastIndexOf(".");
			if(dot>-1) {
				ext=oriName.substring(dot);
			}
			
			//t새파일 이름을 변경하기
			String newName = "Gowith"+sdf.format(new Date(currentTime))+"_"+rndNum+ext;
			newFile=new File(oldFile.getParent(),newName);
		}while(!createNewFile(newFile));
		return newFile;
	}
	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		}catch(IOException e) {
			return false;
		}
	}

	
	
}
