package tn.gov.nashville.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import tn.gov.nashville.beans.Login;
import tn.gov.nashville.beans.RegisterWithTNGov;
import tn.gov.nashville.util.DataConnect;


public class RecordActivityDAO {
	
	public static Logger logger = Logger.getLogger(RecordActivityDAO.class);
	
	String LexisNexisVarification;
	
	private String lexisnexisErrorMsgs;
	
	
	public String getLexisnexisErrorMsgs() {
		return lexisnexisErrorMsgs;
	}

	public void setLexisnexisErrorMsgs(String lexisnexisErrorMsgs) {
		this.lexisnexisErrorMsgs = lexisnexisErrorMsgs;
	}

	public String getLexisNexisVarification() {
		return LexisNexisVarification;
	}

	public void setLexisNexisVarification(String lexisNexisVarification) {
		LexisNexisVarification = lexisNexisVarification;
	}

   public  String recordMessage(String msg){
		
		String errorMessage = msg.toString();
		
		this.setLexisnexisErrorMsgs(errorMessage);
	return 	errorMessage;
	}	
	
	
	public  void recordActivity1(Login roles2){
		
		insertRoles(roles2);	
	}	

	

	
	
public  void insertRoles(Login roles) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		String uniqueId1 = roles.getUniqueId();
		
		String prepRole = roles.getPreparer1();
		String cerRole = roles.getCertifier1();
		
		String usernamessoEmail = roles.getUser();
		
		String rolePrepCertifier = "";
		
		
		//TODO 
		//String lexisnexisError ="" ;
		String error  = this.getLexisnexisErrorMsgs();
			
			
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		
		//TODO to get the username from Another Source (ADMIN\Business)
		//String userName = login.getUser(); 
		
		
		String lastupdated = ZonedDateTime.now().format(formatter);
		logger.info(" in the Record Activity   ..... ");
		
		

		try {
			con = DataConnect.getConnection();   
			
			//----------------------
			if(prepRole !=null && prepRole.equalsIgnoreCase("preparer")){
				
				
				logger.info(" Recording Preparer Activity  ..... ");
				
				String inputphone1 = roles.getInputPhone();
				
					String preparer = "Preparer";
					String certifier = "FALSE";
				//	String admin = "FALSE";
					String business = "FALSE";
					rolePrepCertifier = preparer;
					
					//String errorMessage = this.recordMessage(String);
				
				String query = "INSERT INTO BG_CROMERR.CRO_RECORD_ACTIVITY (USERID,USERNAME,PREPARER,CERTIFIER,BUSINESS,PHONENUMBER,LASTUPDATED)"
						+ "" + " VALUES('" + uniqueId1 + "'" + "," + "'" + usernamessoEmail
						+ "','" + preparer + "','" + certifier + "','" + business + "'" + "," + "'" + inputphone1
						+ "','" + lastupdated + "')";
				
			    ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				logger.info(" Recording Preparer Activity data is added Sucess  ..... ");
				
			//	rolePrepCertifier = "tdecDashboard";
				
				//return rolePrepCertifier;	
				
			}else if (cerRole !=null && cerRole.equalsIgnoreCase("certifier")){
				
				
				
				logger.info(" Recording certifier Activity  ..... ");
				
				String preparer = "FALSE";
				String certifier = "Certifier";
				//String admin = "FALSE";
				String business = "FALSE";
				rolePrepCertifier = certifier;
				String inputphone1 = "";
			String query = "INSERT INTO BG_CROMERR.CRO_RECORD_ACTIVITY (USERID,USERNAME,PREPARER,CERTIFIER,BUSINESS,PHONENUMBER,LASTUPDATED)"
					+ "" + " VALUES('" + uniqueId1 + "'" + "," + "'" + usernamessoEmail
					+ "','" + preparer + "','" + certifier + "','" + business + "'" + "," + "'" + inputphone1
					+ "','" + lastupdated + "')";
			
		    ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			logger.info(" Recording Certifier Activity data is added Sucess  ..... ");
			
			rolePrepCertifier = certifier;	
			}
		} catch (SQLException ex) {
			System.out.println("Error While Inserting Data -->" + ex.getMessage());
			logger.fatal(" Recording Certifier Activity data is added Sucess  ..... "+ex.getStackTrace());
		//	return "roles";	
		} finally {
			DataConnect.close(con);
		}
	
	//	return rolePrepCertifier;	
	}


	
}