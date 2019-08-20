package com.jt.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jt.service.FileService;
import com.jt.vo.EasyUIImage;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	
	/**
	 * MultipartFile: SpringMVC负责流操作的API
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * 
	 * 
	 * */
	@RequestMapping("/file")
	public String file(MultipartFile fileImage) throws IllegalStateException, IOException {
			File dirFile =new File("D:/JTJT/jt-image");
			if(!dirFile.exists()) {
				//如果文件不存在
				//dirFile.mkdir();只创建一级目录 如:在D,C盘下创建
				dirFile.mkdirs();//创建多级目录
			}
		
			//动态获取文件名称
			String fileName = fileImage.getOriginalFilename();
			File file =new File("D:/JTJT/jt-image/"+fileName);
			//文件上传
			fileImage.transferTo(file);

		return "redirect:/file.jsp"; //转发和重定向不经过视图解析器
	}
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public  EasyUIImage  uploadFile(MultipartFile uploadFile ) {
			EasyUIImage uploadFile2 =
						fileService.uploadFile(uploadFile);
			return uploadFile2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
