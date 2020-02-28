package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;;

@Controller
@RequestMapping("/docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	/**1.
	 * Show Upload Page
	 * Url:/show ,Type:GET
	 * function:showUploadPage
	 * viewName:Documents
	 */
	@RequestMapping("/show")
	public String showUploadPage(Model model) {
		List<Object[]> list=service.getFileIdAndName();
		model.addAttribute("list", list);
		return "Documents";
	}
	
	/**2.
	 * Upload data into DB
	 * click on Upload button
	 * Url:/upload ,Type:POST
	 * function:doUpload
	 * viewName:Documents
	 */
	@RequestMapping(value = "/upload" , method =POST)
	public String doUpload(
			   @RequestParam Integer fileId ,
			   @RequestParam CommonsMultipartFile fileOb,
			   Model model
			   ) {
		if(fileOb!=null) {
		      Document doc=new Document();
		      doc.setFileId(fileId);
		      doc.setFileName(fileOb.getOriginalFilename());
		      doc.setFileData(fileOb.getBytes());
		      service.saveDocument(doc);
		
		}
		return "redirect:show";
	}
	
	/**3.
	 * Download the Document based on Id
	 * click on Hyperlink download?fid=?
	 * url:/download , Type:Get
	 * function:doDownload
	 */
	@RequestMapping("/download")
	public void doDownload(
			@RequestParam Integer fid,
			HttpServletResponse resp
			) {
		//read object based on ID
		Document doc=service.getOneDocument(fid);
		//download name
		resp.addHeader("content-Disposition","attachment;fileName="+doc.getFileName());
		
		//copy data to OS
		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
