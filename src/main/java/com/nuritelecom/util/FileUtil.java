package com.nuritelecom.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nuritelecom.domain.BoardVO;
import com.nuritelecom.domain.FileVO;
import com.nuritelecom.service.BoardService;

@Component("fileUtil")
public class FileUtil {
	
	@Inject
	BoardService boardService;
	
    private static final String filePath = "C:\\dev\\file\\";
     
    public String parseInsertFileInfo(BoardVO vo, MultipartHttpServletRequest multi) throws Exception{
    	 String root = multi.getSession().getServletContext().getRealPath("/");
         String path = filePath;
         
         System.out.println("file upload~!!~!");
         System.out.println(vo.getBno());
          
         String newFileName = ""; // 업로드 되는 파일명
          
         File dir = new File(path);
         if(!dir.isDirectory()){
             dir.mkdir();
         }
          
         Iterator<String> files = multi.getFileNames();
         while(files.hasNext()){
             String uploadFile = files.next();
                          
             MultipartFile mFile = multi.getFile(uploadFile);
             String fileName = mFile.getOriginalFilename();
             
             System.out.println("실제 파일 이름 : " +fileName);
             newFileName = System.currentTimeMillis()+"."
                     +fileName.substring(fileName.lastIndexOf(".")+1);
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
             Date date = new Date();
             
             FileVO fvo = new FileVO();
             fvo.setBno(vo.getBno());
             fvo.setCreaDtm(date);
             fvo.setCreaId("admin");
             fvo.setFileSize(mFile.getSize());
             fvo.setOriginalFileName(fileName);
             fvo.setStoredFileName(newFileName);
             
             boardService.insertFile(fvo);
              
             try {
                 mFile.transferTo(new File(path+newFileName));
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
          
         
         return "fileUpload";


    }
}


