package tn.gov.nashville.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import tn.gov.nashville.dao.LoginDAO;
import tn.gov.nashville.service.IdentityProofingService2Client;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterWithTNGov implements Serializable {
	
	
	private static final long serialVersionUID = -4543696653433102044L;

	public static Logger logger = Logger.getLogger(RegisterWithTNGov.class);

	
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private Date dateofBirth;
	private String last4ssn;
	private String phonenumber;
	private boolean lexisNexisVerified;
	private String lexisNexisErrormessage;
	
	
	private String securityQues1;
	private String securityQues2;
	private String securityQues3;
	private String securityQues4;
	private String securityQues5;
	
	private String securityAns1;
	private String securityAns2;
	private String securityAns3;
	private String securityAns4;
	private String securityAns5;
	
	
	public String getSecurityQues1() {
		return securityQues1;
	}

	public void setSecurityQues1(String securityQues1) {
		this.securityQues1 = securityQues1;
	}

	public String getSecurityQues2() {
		return securityQues2;
	}

	public void setSecurityQues2(String securityQues2) {
		this.securityQues2 = securityQues2;
	}

	public String getSecurityQues3() {
		return securityQues3;
	}

	public void setSecurityQues3(String securityQues3) {
		this.securityQues3 = securityQues3;
	}

	public String getSecurityQues4() {
		return securityQues4;
	}

	public void setSecurityQues4(String securityQues4) {
		this.securityQues4 = securityQues4;
	}

	public String getSecurityQues5() {
		return securityQues5;
	}

	public void setSecurityQues5(String securityQues5) {
		this.securityQues5 = securityQues5;
	}

	public String getSecurityAns1() {
		return securityAns1;
	}

	public void setSecurityAns1(String securityAns1) {
		this.securityAns1 = securityAns1;
	}

	public String getSecurityAns2() {
		return securityAns2;
	}

	public void setSecurityAns2(String securityAns2) {
		this.securityAns2 = securityAns2;
	}

	public String getSecurityAns3() {
		return securityAns3;
	}

	public void setSecurityAns3(String securityAns3) {
		this.securityAns3 = securityAns3;
	}

	public String getSecurityAns4() {
		return securityAns4;
	}

	public void setSecurityAns4(String securityAns4) {
		this.securityAns4 = securityAns4;
	}

	public String getSecurityAns5() {
		return securityAns5;
	}

	public void setSecurityAns5(String securityAns5) {
		this.securityAns5 = securityAns5;
	}

	
	
	
	

	public String getLexisNexisErrormessage() {
		return lexisNexisErrormessage;
	}

	public void setLexisNexisErrormessage(String lexisNexisErrormessage) {
		this.lexisNexisErrormessage = lexisNexisErrormessage;
	}

	@ManagedProperty(value="#{login}") 
	private Login login;
	
	
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getLast4ssn() {
		return last4ssn;
	}

	public void setLast4ssn(String last4ssn) {
		this.last4ssn = last4ssn;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	 public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	

	public boolean isLexisNexisVerified() {
		return lexisNexisVerified;
	}

	public void setLexisNexisVerified(boolean lexisNexisVerified) {
		this.lexisNexisVerified = lexisNexisVerified;
	}
	
	public void redirect() throws IOException {
	    // ...

	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect("https://tdecdev.tn.gov/customer/");
	}

	public String validateLexisNexis() {
		 
		
		 IdentityProofingService2Client identityProofingService2Client= new IdentityProofingService2Client();
		
			
			try {
				logger.info(" calling Crommerr services  ..... "  );
					boolean varifiedCustomer = identityProofingService2Client.callCrommerServices(this);
					// TODO  update user database
					boolean dbUpdate = false;
					if(varifiedCustomer)
					 dbUpdate = LoginDAO.insertOrUpdateUser(this);
					
					if (varifiedCustomer && dbUpdate) 
					{
						
						FacesMessage msg = new FacesMessage("Congratulation, we have sucessfully validated your Information.");
						msg.setSeverity(FacesMessage.SEVERITY_INFO);
						FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);	
						
						
						return "tdecDashboard";	
					}
					else{
					

						if(login.getLexisNexisAttempts()!=0)
							//for second time and onwards
							{
							int max_attempts = 2;
							int user_attempts = (Integer)login.getLexisNexisAttempts();
							user_attempts++;
							if(user_attempts==max_attempts){
								
	
								String errorMessage ="lexis Nexis condition failed 2 times redirecting to SSO " +user_attempts;
								logger.fatal(errorMessage);
								
								System.out.println("counting the Failed condition with lexis Nexis" +user_attempts);
								
							//	redirect();
								return "lexisFailureRedirect";	
							//	return	"https://tdecdev.tn.gov/customer/?faces-redirect=true";
						}
							
							
						login.setLexisNexisAttempts(new Integer(user_attempts));
						}
						else
						//for the first time
						{
						login.setLexisNexisAttempts(new Integer(1));
						}
							
							
						
						FacesMessage msg = new FacesMessage(" Input Information is not Valid.This is your FINAL ATTEMPT  Please Check the Input Information Carefully, if This fails you will be Exited from the STORMWATER");
						msg.setSeverity(FacesMessage.SEVERITY_FATAL);
						FacesContext.getCurrentInstance().addMessage("form:lexisNexisMsg", msg);	
						String errorMessage = msg.toString();
						logger.fatal(errorMessage);
						
					return "laxisNexisForm";	
					}
						
				} catch (Exception e) 
					{					
					FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
					
							msg.setSeverity(FacesMessage.SEVERITY_FATAL);
							FacesContext.getCurrentInstance().addMessage("form:lexisNexisMsg", msg);	
						
							return "lexisFailureRedirect";
					}	
			
		}	
}
