package com.nuritelecom.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/display")

public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		return null;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath= File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath 
				+ File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String dataPath = monthPath + File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, dataPath);
		 logger.info(dataPath);
		 return dataPath;
	}
	
	private static void makeDir(String uploadPath, String... paths) {
		
		if (new File(paths[paths.length-1]).exists()) {
			return;
		}
		
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			 if (! dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
	}
	
	private static String makethumbnail(String uploadPath, String path, String fileName)throws Exception{
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+ path , fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100 );
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	@GetMapping(produces = { "image/jpg" })
	@ResponseBody
	public byte[] display(String fName) throws Exception {
		
		logger.info("image~!~!~!~~!~!~!~!~!~!~!~!");
		
		logger.info(fName);

		if (fName == "") {

			fName = "none.jpg";

		}
		
		try {
			FileInputStream fin = new FileInputStream("C:\\dev\\file\\" + fName);

			byte[] arr = IOUtils.toByteArray(fin);

			return arr;
		} catch (Exception e) {
			FileInputStream fin = new FileInputStream("C:\\dev\\file\\none.jpg");

			byte[] arr = IOUtils.toByteArray(fin);

			return arr;
		}

	}
	
	@GetMapping("/uploadAjax")
	public void uploadajax() {
		
	}
	
	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadA(MultipartFile file){
		
		logger.info(file.getOriginalFilename());
		logger.info(""+ file.getSize());
		logger.info(file.getContentType());
		
		return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.CREATED);
	}
	
	
}
