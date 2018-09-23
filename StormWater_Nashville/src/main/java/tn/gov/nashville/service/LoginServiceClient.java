package tn.gov.nashville.service;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import tn.gov.nashville.beans.Login;


public class LoginServiceClient  {
	
	public static Logger logger = Logger.getLogger(LoginServiceClient.class);
	
	    public Login callLoginService(Login login) {
	    	
	    	logger.info("Entering callLoginService ..... ");
	        RestTemplate restTemplate = new RestTemplate();
	        List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
	        list.add(new MappingJacksonHttpMessageConverter());
	        restTemplate.setMessageConverters(list);
	       // restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	      //  String url = "https://tdecdev.tn.gov/SingleSignonService/api/cromerr";
	        
	        String url = "https://test.tdec.tn.gov/SingleSignonService/api/cromerr";
	    	logger.info("calling  SSO for Authentication ..... ");     
	        Login loginRetLogin= restTemplate.postForObject(url, login, Login.class);
	        System.out.println("++++++Unique ID+++++++++ " + loginRetLogin.getUniqueId());
	        logger.info(" Got Sucessfully Results from the SSO call ..... ");  
	        logger.info(" +++++Unique ID+++++++++ " + loginRetLogin.getUniqueId()); 
	        logger.info(" +++++UserName Entered+++++++++ " + loginRetLogin.getUser()); 
	        logger.info(" +++++FirstName+++++++++ " + loginRetLogin.getFirstName()); 
	        logger.info(" +++++LastName+++++++++ " + loginRetLogin.getLastName()); 
	        
	        
	        return loginRetLogin;
	    }  
	
	  /*  public static void main(String[] args) {
			Login login = new Login();
			login.setUser("ron.day@tn.gov");
			login.setPwd( "*Ron.day@tn.gov1");
			new LoginServiceClient().callLoginService(login);
		}
		*/
}
