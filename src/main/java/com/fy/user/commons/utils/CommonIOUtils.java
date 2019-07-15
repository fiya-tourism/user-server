package com.fy.user.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class CommonIOUtils {

	
	public static String uploadFile(String path,HttpServletRequest req,MultipartFile imgFile) {
			//		 第一步 从客户端上传文件至服务器端 springmvc
		
			//   第二步 从服务器的临时文件夹  复制到制定文件夹
			
			//  2.1 创建指定的文件夹
			 
			 File folder = new File(path);
			 // 创建文件夹
			 if(!folder.exists()) {
				 folder.mkdir();
			 }
			 // 重命名
			 String fileName = UUID.randomUUID().toString()+"_"+imgFile.getOriginalFilename();
			 
			 // 创建文件
			 File pointFile = new File(path+"/"+fileName);
			
			try {
				 // 将获取的文件copy至新文件中
				imgFile.transferTo(pointFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String newPath = path.substring(path.indexOf("/")+2)+"/"+fileName;
			 
			return newPath;
	}
	
	
	/**
	 * <pre>imgRead(获取图片)   
	 * 创建人：武豫
	 * 创建时间：2019年3月11日 下午4:54:13    
	 * 修改人：杨晓宇       
	 * 修改时间：2019年3月11日 下午4:54:13    
	 * 修改备注： 
	 * @param path
	 * @param resp</pre>
	 */
	public static void imgRead(String path,HttpServletResponse resp) {
		File filePic = new File(path);
		if(filePic.exists()){
		    FileInputStream is = null;
		    OutputStream toClient =null;
			try {
				is = new FileInputStream(filePic);
				int i = is.available(); // 得到文件大小  
				byte data[] = new byte[i];  
				is.read(data); // 读数据  
				is.close();  
				resp.setContentType("image/*"); // 设置返回的文件类型  
				toClient = resp.getOutputStream(); // 得到向客户端输出二进制数据的对象  
				toClient.write(data); // 输出数据  
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					try {
						if(null!=is) {
							is.close();
						}
						if(null!= toClient) {
							toClient.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
}
