package com.semi.common;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRename implements FileRenamePolicy{
 

	
	@Override
	public File rename(File oldFile) {
		
		File newFile=null;
		
		do {
			long currentTime=System.currentTimeMillis(); //현재시간 가져옴
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int randomNum=(int)(Math.random()*1000);
	
			String oriName=oldFile.getName();
			String ext="";
			int dot=oriName.lastIndexOf("."); 
			if(dot>-1) { //
				ext=oriName.substring(dot);
			}
			
			String newName=sdf.format(new Date(currentTime))+"_"+randomNum+ext; 
			newFile=new File(oldFile.getParent(),newName);
			
		}while(!createNewFile(newFile));
		
		return newFile;
		
	}

	private boolean createNewFile(File f) {
		try{
			return f.createNewFile();
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
