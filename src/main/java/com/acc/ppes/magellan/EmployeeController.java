package com.acc.ppes.magellan;
import java.net.HttpURLConnection;
import java.util.Collection;

import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	protected EmployeeService employeeService;
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@ApiResponses(value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain user"),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
	        @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
	})
	 @RequestMapping(method = RequestMethod.GET)
	    public @ResponseBody String index(){
			 System.out.println("we are in Get method------------");
	            return "Welcome to APP PES Employee API";

	    }
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ResponseEntity<Collection<Employee>> getAll() {
		  logger.info("fetching details from employee table ");
		Collection<Employee> emp = employeeService.getAllEmployee();
		ResponseEntity<Collection<Employee>> responseObj = new ResponseEntity<>(emp, HttpStatus.OK);
	    logger.info("HTTP status code-->"+responseObj.toString());
		 System.out.println("HTTP status code-->"+responseObj.toString());
	    return responseObj;	
		//return emp;
			

	}
	 
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Employee> insert(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);
		ResponseEntity<Employee> responseObj = new ResponseEntity<>(employee, HttpStatus.CREATED);
	    logger.info("HTTP Response-->"+responseObj.toString());
		 System.out.println("HTTP status code-->"+responseObj.toString());
	    return responseObj;	
		//return employee;

	}
	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> delete(@RequestBody Employee employee) {

				ResponseEntity<Employee> responseObj = new ResponseEntity<>(employee, HttpStatus.SERVICE_UNAVAILABLE);
	    logger.info("HTTP Response-->"+responseObj.toString());
	   System.out.println("HTTP status code-->"+responseObj.toString());
	    return responseObj;	
		//
	}
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {

				ResponseEntity<Employee> responseObj = new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
	    logger.info("HTTP Response-->"+responseObj.toString());
	   System.out.println("HTTP status code-->"+responseObj.toString());
	    return responseObj;	
		
	}
		@ExceptionHandler(DataException.class)
	public String DataExceptionErrorMessage(DataException e) {
		return "Deficient Quantity";
	}
	
	}
