package org.saiden.springmvc21.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.saiden.springmvc21.model.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	// 파일 업로드 경로
	private String uploadPath;
	
	@RequestMapping(value = "registerProduct.do", method = RequestMethod.POST)
	public ModelAndView registerProduct(ProductVO pvo, HttpServletRequest request){
		// 실제 운영시에 사용할 서버 업로드 경로
		// uploadPath = request.getSession().getServletContext().getRealPath("/resources/upload/");

		// 개발시에는 Workspace 업로드 경로로 준다.
		uploadPath = "C:\\java-kosta\\framework-workspace2\\springmvc21-fileupload\\src\\main\\webapp\\resources\\upload\\";
		
		MultipartFile file = pvo.getUploadFile();
	
		if(file.isEmpty() == false){
			System.out.println("파일명 : " + file.getOriginalFilename());
			File uploadFile = new File(uploadPath + file.getOriginalFilename());
			try {
				file.transferTo(uploadFile);
				System.out.println("파일 업로드 완료!");
			} 
			catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} 
		}
		
		ModelAndView mv = new ModelAndView("product/register_result.tiles");
		mv.addObject("name", pvo.getName());
		mv.addObject("fileName", file.getOriginalFilename());
		
		return mv;
	}
	
	@RequestMapping("fileDownload.do")
	public String fileDownload(String fileName){
		System.out.println("fileName : " + fileName);
		return "downloadView";
	}
}
