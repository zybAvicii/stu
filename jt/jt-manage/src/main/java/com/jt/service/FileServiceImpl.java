package com.jt.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.vo.EasyUIImage;
@Service
@PropertySource("classpath:/properties/image.properties")//通过注解加载配置文件信息
public class FileServiceImpl implements FileService{
	
	@Value("${image.localFileDir}")//image.localFileDir=D:/JTJT/jt-image/
	private String	localFileDir;
	@Value("${image.urlPath}")	  //http://image.jt.com/
	private String  urlPath;
	/**
	 * 1.判断文件是否是图片 jpg|png|gif
	 * 2.防止恶意程序,判断图片固有属性高度和宽度
	 * 3.将图片分目录存储 按照时间进行存储 yyyy/MM/dd
	 * 4.解决文件重名   UUID
	 * */
	//1.获取图片的名称(如:abc.jpg)
	//2.利用正则表达式判断数据
	//3.获取图片高度和宽度
	//4.以时间的格式进行存储yyyy/MM/dd
	//5.重新生成图片名称
			//5.1生成UUID
			//5.2将-替换""空串
			//5.3获取真实图片的后缀.jpg
			//5.4生成真实的图片名称 uuid.jpg
	/*6.实现文件上传
			* 6.1准备文件全路径
			* 		D:/JTJT/jt-image/2019/08/02/uuid.jpg
		 	* 6.2实现文件上传
			*/
	@Override
	public EasyUIImage uploadFile(MultipartFile uploadFile) {//uploadFile==传上来的图片
		EasyUIImage uiImage=new EasyUIImage();
		//1.获取图片的名称(如:abc.jpg)
		String fileName = uploadFile.getOriginalFilename();//获得文件全名
		//将用户输入内容全转成小写
		fileName= fileName.toLowerCase();
		//2.利用正则表达式判断数据
		if (!fileName.matches("^.+\\.(jpg|png|gif)$")) {//对传入不正确的格式图片做处理
			uiImage.setError(1);//1表示图片不正经
			return uiImage;
		}
		//3.获取图片高度和宽度
		try {
			InputStream inputStream = uploadFile.getInputStream();
			BufferedImage bufferedImage=
					ImageIO.read(inputStream);
			int height = bufferedImage.getHeight();
			int width = bufferedImage.getWidth();
			if (height==0||width==0) {
				uiImage.setError(1);
				return uiImage;
			}
		uiImage.setHeight(height).setWidth(width);
			
		//4.以时间的格式进行存储yyyy/MM/dd
			String dateDir = 
					new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		//准备文件上传路径D:/JTJT/jt-image/yyyy/MM/dd
			String localdir = localFileDir+dateDir;
			File dirFile=new File(localdir);
			if(!dirFile.exists()) {
				//如果文件路径不存在,则创建文件夹
				dirFile.mkdirs();
			}
		//5.重新生成图片名称
		//5.1生成UUID
		//5.2将-替换""空串
		//5.3获取真实图片的后缀.jpg
		//5.4生成真实的图片名称 uuid.jpg
			String uuid = UUID.randomUUID().toString().replace("-","");//""为空串,不能加空格
			//从后向前查找第一个.的位置,之后从该位置向后截取数据.
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			//得到的真实文件名称
			String realFileName=uuid+fileType;
		/*
		 * 6.实现文件上传
		 * 6.1准备文件全路径
		 * 		D:/JTJT/jt-image/2019/08/02/uuid.jpg
		 * 6.2实现文件上传
		 * */
			String realPath=localdir+"/"+realFileName;//路径
			File realFile = new File(realPath);
			uploadFile.transferTo(realFile);
			System.out.println("文件上传成功");
			
			//
			String url=urlPath+dateDir+"/"+realFileName;
			uiImage.setUrl(url);
			
			
			
			
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			uiImage.setError(1);//程序出错,上传终止
		}
		
		return uiImage;
	}

}









