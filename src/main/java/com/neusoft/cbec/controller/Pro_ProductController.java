package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.cbec.model.BrandModel;
import com.neusoft.cbec.model.Pro_PhotosModel;
import com.neusoft.cbec.result.ControllerResult;
import com.nuesoft.cbec.service.IPro_PhotosService;

@RestController
@RequestMapping("/photos")
public class Pro_ProductController {
	
	private IPro_PhotosService photosService =null;
	
	@Autowired
	public void setPhotosService(IPro_PhotosService photosService) {
		this.photosService = photosService;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ControllerResult add(Pro_PhotosModel photoModel,@RequestParam(required=false)MultipartFile photo) throws Exception{
		String fileName = photo.getOriginalFilename();
		String contentType = photo.getContentType();
		photoModel.setPhoto(photo.getBytes());
		photoModel.setPhotoFileName(fileName);
		photoModel.setPhotoContentType(contentType);
		/*System.out.println(photoModel.getProduct().getPro_id());*/
		photosService.add(photoModel);
		ControllerResult result = new ControllerResult();
		result.setStatus("ok");
		result.setMessage("增加员工成功!");
		
		return result;
	}
	//删除照片
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public String delete(Pro_PhotosModel photoModel) throws Exception{
		photosService.delete(photoModel);
		return "ok";
	}
	//修改照片
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public String modify(Pro_PhotosModel photoModel) throws Exception{
		photosService.modify(photoModel);
		return "ok";
	}
	
	
	

}
