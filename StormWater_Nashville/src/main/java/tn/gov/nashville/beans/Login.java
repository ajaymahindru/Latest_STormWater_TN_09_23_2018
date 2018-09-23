package tn.gov.nashville.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import tn.gov.nashville.dao.LoginDAO;
import tn.gov.nashville.dao.NoiFormCommon_DAO;

import tn.gov.nashville.dao.Roles_DAO;
import tn.gov.nashville.service.LoginServiceClient;
import tn.gov.nashville.util.SessionUtils;

@ManagedBean
@SessionScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login implements Serializable {
	
	
	private static final long serialVersionUID = -2629777914204470797L;

	public static Logger logger = Logger.getLogger(Login.class);
	
  
	@JsonProperty("password")
	private String pwd;
	@JsonProperty("message")
	private String msg;
	@JsonProperty("username")
	private String user;
	@JsonProperty("uniqueId")
	private String uniqueId;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonIgnore
	private boolean userExist;
	
	private String userRoles;

	private boolean userRoleExist;
	private String preparer;
	private String certifier;
	private String business;
	private String admin;
	
	// for Roles
	private String selectedRole;
	private String inputPhone;
	
	
	private String certifier1;	

	private String preparer1;
	
	private String lexisnexisErrorMsgs;
	
	private int lexisNexisAttempts;
	
	

	public int getLexisNexisAttempts() {
		return lexisNexisAttempts;
	}

	public void setLexisNexisAttempts(int lexisNexisAttempts) {
		this.lexisNexisAttempts = lexisNexisAttempts;
	}

	public String getLexisnexisErrorMsgs() {
		return lexisnexisErrorMsgs;
	}

	public void setLexisnexisErrorMsgs(String lexisnexisErrorMsgs) {
		this.lexisnexisErrorMsgs = lexisnexisErrorMsgs;
	}

	public String getCertifier1() {
		return certifier1;
	}

	public void setCertifier1(String certifier1) {
		this.certifier1 = certifier1;
	}

	public String getPreparer1() {
		return preparer1;
	}

	public void setPreparer1(String preparer1) {
		this.preparer1 = preparer1;
	}



	
	public String getInputPhone() {
		return inputPhone;
	}

	public void setInputPhone(String inputPhone) {
		this.inputPhone = inputPhone;
	}

	
	public String getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
	}

	
	public String getPreparer() {
		return preparer;
	}

	public void setPreparer(String preparer) {
		this.preparer = preparer;
	}

	public String getCertifier() {
		return certifier;
	}

	public void setCertifier(String certifier) {
		this.certifier = certifier;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}


	
	
		
	public boolean isUserRoleExist() {
		return userRoleExist;
	}

	public void setUserRoleExist(boolean userRoleExist) {
		this.userRoleExist = userRoleExist;
	}

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	


	public boolean isUserExist() {
		return userExist;
	}

	public void setUserExist(boolean userExist) {
		this.userExist = userExist;
	}
	
	
	public String authenticateSsoUser() {
		
		logger.info(" Entered validateUsernamePassword  function ..... ");  
		LoginServiceClient loginServiceClient= new LoginServiceClient();
		String checkLoginAndRoles = "Error";
		if (this.getUser()== null ||this.getUser().equals("") || this.getPwd() == null || this.getPwd().equals("")){
			FacesContext.getCurrentInstance().addMessage("password",new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passwrd",
					"Please enter correct username and Password"));
			
			checkLoginAndRoles = "login";
			
		return checkLoginAndRoles;	
		}
	
		try{
				logger.info(" Calling SSO loginService Client ..... ");  
				Login loginReturnedValuesbySSO = loginServiceClient.callLoginService(this);
				
				this.setUniqueId(loginReturnedValuesbySSO.getUniqueId());
				this.setFirstName(loginReturnedValuesbySSO.getFirstName());
				this.setLastName(loginReturnedValuesbySSO.getLastName());
		     
				
				if( loginReturnedValuesbySSO.getUniqueId()!= null || this.getUniqueId() != ""  ) {
			
					int uniqueId = Integer.parseInt(loginReturnedValuesbySSO.getUniqueId());
					if(uniqueId !=0){
						
					
						logger.info(" Got Authenticated with SSO going to Roles Page..... "); 
						
						
						
						String rolesReturned = Roles_DAO.checkorInsert(this);
						//Noi noibean = new Noi();
					//	noibean.noiSSOid(loginReturnedValuesbySSO);
						
						String lexisNexisReturned = this.validateUsernamePassword(); 
						
						if (rolesReturned!=null && rolesReturned.equalsIgnoreCase("preparer")){
						
							
							checkLoginAndRoles = "tdecDashboard";	
							
						return 	checkLoginAndRoles;
						}
						
						// This will check the case when the SSO user has changed his first or Last Name  
						// and SSO has updated the flag in the LexisNexis Table to False
						if (rolesReturned!=null && rolesReturned.equalsIgnoreCase("certifier")&& lexisNexisReturned.equalsIgnoreCase("laxisNexisForm")){
						
							
							checkLoginAndRoles = "laxisNexisForm";	
							
						return 	checkLoginAndRoles;
						}
						
						if (rolesReturned!=null && rolesReturned.equalsIgnoreCase("certifier")){
						
							
							checkLoginAndRoles = "tdecDashboard";	
							
						return 	checkLoginAndRoles;
						}
						
						if (rolesReturned!=null && rolesReturned.equalsIgnoreCase("roles")){
						
							
							checkLoginAndRoles = "roles";	
							
						return 	checkLoginAndRoles;
						}

						
						
						
				//	return "roles";
					}
				}
			}catch(NumberFormatException exception){
								
				
				FacesMessage msg = new FacesMessage("Please check your SSO Credentials");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage("form:eventsrc", msg);
				
				
				exception.printStackTrace();
				
				logger.info(" +++++Got Exceptions authenticateSsoUser +++++++++ " + exception.getStackTrace()); 
				
				checkLoginAndRoles = "login";
				return checkLoginAndRoles;	
			  }	
		
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Incorrect Username and Password",
				"Please enter correct username and Password"));
	 
		checkLoginAndRoles = "login";
		
	return checkLoginAndRoles;			
	}
	
	
	
	public String validateUsernamePassword() {
		String returnRolesResponse = "roles";
		
	/*	logger.info(" Entered validateUsernamePassword  function ..... ");  
		LoginServiceClient loginServiceClient= new LoginServiceClient();
		boolean valid1 =  false;
		if (this.getUser()== null ||this.getUser().equals("") || this.getPwd() == null || this.getPwd().equals("")){
			FacesContext.getCurrentInstance().addMessage("password",new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd",
					"Please enter correct username and Password"));
		return "login";	
		}
	
		logger.info(" Calling SSO loginService Client ..... ");  
		Login loginReturnedValuesbySSO = loginServiceClient.callLoginService(this);
		
		this.setUniqueId(loginReturnedValuesbySSO.getUniqueId());	
		this.setFirstName(loginReturnedValuesbySSO.getFirstName());
		this.setLastName(loginReturnedValuesbySSO.getLastName());
		
		*/
		boolean valid1 =  false;
		String preparer1 = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("hidden1");
		
		String certifier1 = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("hidden2");
		
		this.setPreparer1(preparer1);
		this.setCertifier1(certifier1);
		
					
			try{
				
					logger.info(" Going to Roles with SSO Unique ID..... "); 
					
					valid1 =  true;
			
					
						logger.info(" Insert User ROLES Trail ..... "); 
						 String rolesReturned = Roles_DAO.checkorInsert(this);
						 
						 String noiUserID = this.getUniqueId();
						  NoiFormCommon_DAO.setNoissoid(noiUserID);
						 
						
					///	String rolesReturned = Roles_DAO.checkorInsert(this);
						
						 //Preparer Block
						 if (rolesReturned.equalsIgnoreCase("preparer")){
						
							 returnRolesResponse = "tdecDashboard";
							 
						 }
						 
						 
						 // Certifier Block
						 if (rolesReturned.equalsIgnoreCase("certifier")){
 
									valid1 = true;

									logger.info(" DataBase call to Find LexisNexis Validation ..... ");
									
									///-----------------
									valid1 = LoginDAO.validate(this);
									this.setUserExist(this.isUserExist()); 
									if (valid1) 
									{
										
										FacesMessage msg = new FacesMessage("Congratulation, Sucessfully validated your Information with STATE of TN.");
										msg.setSeverity(FacesMessage.SEVERITY_INFO);
										FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);
										
										returnRolesResponse ="tdecDashboard";
										
													
									}
									else{	
										
										returnRolesResponse ="laxisNexisForm";
									
									}
								
							  }
					 
								
			
					
			}catch(Exception exception){
								
				
				FacesMessage msg = new FacesMessage("There is an error in processing your request. Please contact the System Adminstrator.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage("form:eventsrc", msg);
				
				
				exception.printStackTrace();
			}				
		
		
		return 	returnRolesResponse;
	
	}
	
	
	public String logout() {
		
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		
		return "login";
	}

}
