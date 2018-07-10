package com.nuritelecom.web;

import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/display")

public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

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
	
}
