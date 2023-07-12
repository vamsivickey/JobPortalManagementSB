package com.example.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registration.entity.JobApplication;
import com.example.registration.service.JobApplicationDao;

@RestController
public class JobApplicationController {

	
	@Autowired
	private JobApplicationDao JobApplicationDAO;
	
	
	@PostMapping("/registerJobApplication")
	public String registerApplication(@RequestBody JobApplication jobApplication) {
		JobApplicationDAO.registerJobApplication(jobApplication);
		return "User Registered Successfully";
	}
	
	
	
	//---------DB FIle-- references... 
	
//	@PostMapping("/registerJobApplication")
//	public ResponseEntity<JobApplication> registerJobApplication(@RequestBody JobApplication user) {
//		JobApplicationDAO.registerJobApplication(user);
//		return new ResponseEntity<>(user, HttpStatus.CREATED);
//	}
	
//  @PostMapping("/upload")
//  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
//    String message = "";
//    try {
//      storageService.store(file);
//
//      message = "Uploaded the file successfully: " + file.getOriginalFilename();
//      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//    } catch (Exception e) {
//      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//    }
//  }
	
	
	
	//-------Pasha 
	
//	@POST
//	@Path("/uploadImage")
//	@Consumes({MediaType.MULTIPART_FORM_DATA})
//	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream, @FormDataParam("Image") FormDataContentDisposition 
//    formDataContentDisposition, @FormDataParam("productName") String productName, @FormDataParam("description") String description, @FormDataParam("price") float price) throws IOException {
//		int read = 0;
//	    byte[] bytes = new byte[1024];
//	    
//		String path = this.getClass().getClassLoader().getResource("").getPath();
//    	String pathArr[] = path.split("/WEB-INF/classes/");
//    	
//// FileOutputStream out = new FileOutputStream(new File("C:/Users/tsuser/RESTAPI_9pm/RestAPI/src/main/webapp/image/", formDataContentDisposition.getFileName()));
//
//    	FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
//	    
//    	/* Return Value
//    	 * -------------
//    	The methods returns the total number of bytes read into the buffer, 
//    	or -1 if there is no more data to be read. */
//    	while ((read = fileInputStream.read(bytes)) != -1) {
//	    	out.write(bytes, 0, read);
//	    }
//	    out.flush();
//	    out.close();
//	    
//	    Product product = new Product();
//		product.setProductName(productName);
//		product.setDescription(description);
//		product.setPrice(price);
//	    product.setImageName(formDataContentDisposition.getFileName());
//	    ProductDAO productDao = new ProductDAO();
//	    productDao.addProduct(product);
//		//return Response.ok("Data Submitted Successfully.").build();	    
//	}
//	
//	 	@GET
//	    @Path("downloadImage")
//	    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//	    public Response downloadFileWithGet()// @QueryParam("file") String file) 
//	    		{
//	 		System.out.println("Inside download image");
//	 		File file = new File("C:/Users/tsuser/RESTAPI_9pm/RestAPI/src/main/webapp/image/hd_flowers_photo_04_hd_picture_169264.jpg");
//	        ResponseBuilder response = Response.ok((Object) file);
//	        response.header("Content-Disposition", "attachment;filename=" + "hd_flowers_photo_04_hd_picture_169264.jpg");
//	        System.out.println("Before return");
//	        return response.build();
//	    }
//
//  @PostMapping("/")
//  public void addUser(@RequestParam("resume") MultipartFile resume, @RequestParam("userName") String userName) throws IOException {
//      User user = new User();
//      user.setUserName(userName);
//      user.setResume(resume.getBytes());
//
//      userDao.addUser(user);
//  }
	
	
	
	@RequestMapping("/getAllJobApplications")
	public List<JobApplication> getAllJobApplications() {
		return JobApplicationDAO.getAllJobApplication();
	}
	
	@GetMapping("/getJobApplicationById/{applicationId}")
	public JobApplication getJobApplicationById(@PathVariable("applicationId") int applicationId) {
		JobApplication application = JobApplicationDAO.getJobApplicationById(applicationId);
		
		if (application != null)
			return application;
		
		return new JobApplication( "JobApplication Not Found!!!");
	}
		
	@PutMapping("/updateJobApplication")
	public String updateJobApplication(@RequestBody JobApplication application) {
		JobApplicationDAO.updateJobApplication(application);
		return "JobApplication Updated Successfully";
	}
	
	@DeleteMapping("/deleteJobApplication/{applicationId}")
	public String deleteJobApplication(@PathVariable("applicationId") int applicationId) {
		JobApplicationDAO.deleteJobApplication(applicationId);
		return "JobApplication " + applicationId + " Deleted Successfully!!!";
	}
	
}
