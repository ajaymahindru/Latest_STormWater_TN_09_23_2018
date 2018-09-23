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


public class LoginDAO {
	
	public static Logger logger = Logger.getLogger(LoginDAO.class);
	
	String LexisNexisVarification;

	public String getLexisNexisVarification() {
		return LexisNexisVarification;
	}

	public void setLexisNexisVarification(String lexisNexisVarification) {
		LexisNexisVarification = lexisNexisVarification;
	}

	public static boolean validate(Login  loginReturnedValuesbySSO) {
		
		logger.info(" Inside validate function..... "); 
		Connection con = null;
		PreparedStatement ps = null;
		boolean valid = false;
		String uniqueIdLoginService = loginReturnedValuesbySSO.getUniqueId();

		try {
			
			logger.info(" Making a call to the database ..... "); 
			con = DataConnect.getConnection();   
			logger.info(" database connection Sucess..... "); 
			 
		   
			
			// ----- Checking Lexis Nexis Validation END ---
		    String query = "select  LEXISNEXISVERIFIED from BG_CROMERR.CRO_USERINFO_LEXISNEXIS where USERID = '" + uniqueIdLoginService+"'";
		    ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			logger.info(" got results from the Database about LexisNexis is already validated or Not..... ");

			if (rs.next()) {
				loginReturnedValuesbySSO.setUserExist(true);
				String lexisNexis = rs.getString("LEXISNEXISVERIFIED");
				logger.info(" sql query execute sucessfully Got the reults back based on Unique ID of SSO..... " +query);
				 if (lexisNexis.equalsIgnoreCase("True") )				
				{
					 valid = true;	
				}
			
			}
			
			// ----- Checking Lexis Nexis Validation END ---
		} catch (SQLException ex) {
			
			logger.error(" Making a call to the database using unique ID FAILED ..... " + ex.getMessage());
			//System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			DataConnect.close(con);
		
		}
		return valid;
	}
	
	public static boolean insertUser(RegisterWithTNGov  register) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		String uniqueId = register.getLogin().getUniqueId();
		String firstName = register.getLogin().getFirstName();
		String lastName = register.getLogin().getLastName();
		
		String address1 = register.getAddress1();
		String address2 = register.getAddress2();
		String city = register.getCity();
		
		String state = register.getState();
		String zipcode = register.getZipcode();
		String phonenumber = register.getPhonenumber();
		//String last4ssn = register.getLast4ssn();
	//	ZonedDateTime dob = ZonedDateTime.ofInstant((register.getDateofBirth().toInstant()),ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		//String dateString = dob.format(formatter);
		String emailID = register.getLogin().getUser(); 
		String lastupdated = ZonedDateTime.now().format(formatter);
		logger.info(" got the value from the LexisNexis Form  ..... ");
		boolean lexisnexisVerified = register.isLexisNexisVerified();
		
		
		String secu_Q1  = register.getSecurityQues1();
		String secu_Q2  = register.getSecurityQues2();
		String secu_Q3  = register.getSecurityQues3();
		String secu_Q4  = register.getSecurityQues4();
		String secu_Q5  = register.getSecurityQues5();
		
		String secu_Ans1 = register.getSecurityAns1();
		String secu_Ans2 = register.getSecurityAns2();
		String secu_Ans3 = register.getSecurityAns3();
		String secu_Ans4 = register.getSecurityAns4();
		String secu_Ans5 = register.getSecurityAns5();
		
		

		try {
			con = DataConnect.getConnection();   
			
		
			
			String query = "INSERT INTO BG_CROMERR.CRO_USERINFO_LEXISNEXIS (FIRSTNAME,LASTNAME,MIDDLEINITIAL,MAILINGADDRESS1,MAILINGADDRESS2,"
					+ "CITY,STATE,ZIP,PHONE,USERID,LEXISNEXISVERIFIED,EMAILADDRESS,LASTUPDATED,SECU_Q1,SECU_Q2,SECU_Q3,SECU_Q4,SECU_Q5,SECU_ANS1,SECU_ANS2,SECU_ANS3,SECU_ANS4,SECU_ANS5)"
					+ "" + " VALUES('" + firstName + "'" + "," + "'" + lastName + "'" + ",'" + "" + "','" + address1 + "','" + address2
					+ "','" + city + "','" + state + "','" + zipcode + "','" + phonenumber + "','" + uniqueId + "','" + lexisnexisVerified + "'" + "," + "'" + emailID
					
					+ "','" + lastupdated
					
					+ "','" + secu_Q1 + "','" + secu_Q2 + "','" + secu_Q3 + "','" + secu_Q4 + "','" + secu_Q5 
					+ "','" + secu_Ans1 + "','" + secu_Ans2 + "','" + secu_Ans3 + "','" + secu_Ans4 + "','" + secu_Ans5 + "')";
					
					
					//+ "','" + lastupdated + "')";
			
		    ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error While Inserting Data -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	
	
	public static boolean updateUser(RegisterWithTNGov  register) {
		Connection con = null;
		PreparedStatement ps = null;
		String uniqueId = register.getLogin().getUniqueId();
		String firstName = register.getLogin().getFirstName();
		String lastName = register.getLogin().getLastName();
		String emailID = register.getLogin().getUser();
		String address1 = register.getAddress1();
		String address2 = register.getAddress2();
		String city = register.getCity();
	//	String last4ssn = register.getLast4ssn();
		String state = register.getState();
		String zipcode = register.getZipcode();
		String phonenumber = register.getPhonenumber();
	//	ZonedDateTime dob = ZonedDateTime.ofInstant((register.getDateofBirth().toInstant()),ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	//	String dateString = dob.format(formatter);
		boolean lexisnexisVerified = register.isLexisNexisVerified();
		String lastupdated = ZonedDateTime.now().format(formatter);
		
		String secu_Q1_update  = register.getSecurityQues1();
		String secu_Q2_update  = register.getSecurityQues2();
		String secu_Q3_update  = register.getSecurityQues3();
		String secu_Q4_update  = register.getSecurityQues4();
		String secu_Q5_update  = register.getSecurityQues5();
		
		String secu_Ans1_update = register.getSecurityAns1();
		String secu_Ans2_update = register.getSecurityAns2();
		String secu_Ans3_update = register.getSecurityAns3();
		String secu_Ans4_update = register.getSecurityAns4();
		String secu_Ans5_update = register.getSecurityAns5(); 
		
		
		try {
			con = DataConnect.getConnection();   
			String query  ="";
			query = "UPDATE BG_CROMERR.CRO_USERINFO_LEXISNEXIS SET FIRSTNAME ='"+firstName +"'"
							+ ",LASTNAME ='"+lastName +"'"
							+ ",MIDDLEINITIAL = ' ' "
									+ ",MAILINGADDRESS1 ='"+ address1+"'"
									+ ",MAILINGADDRESS2 ='"+ address2+"'"
									+ ",CITY ='"+ city+"'"
									+ ",STATE ='"+ state+"'"
									+ ",ZIP ='"+zipcode+"'"
									+ ",PHONE ='"+ phonenumber+"'"
									+ ",USERID ='"+ uniqueId+"'"
									+ ",LEXISNEXISVERIFIED ='"+ lexisnexisVerified+"'"
									+ ",EMAILADDRESS ='"+ emailID+"'"
									+ ",LASTUPDATED ='"+lastupdated+"'"
									
									+ ",SECU_Q1 ='"+secu_Q1_update+"'"
									+ ",SECU_Q2 ='"+secu_Q2_update+"'"
									+ ",SECU_Q3 ='"+secu_Q3_update+"'"
									+ ",SECU_Q4 ='"+secu_Q4_update+"'"
									+ ",SECU_Q5 ='"+secu_Q5_update+"'"
									
									+ ",SECU_ANS1 ='"+secu_Ans1_update+"'"
									+ ",SECU_ANS2 ='"+secu_Ans2_update+"'"
									+ ",SECU_ANS3 ='"+secu_Ans3_update+"'"
									+ ",SECU_ANS4 ='"+secu_Ans4_update+"'"
									+ ",SECU_ANS5 ='"+secu_Ans5_update+"'"
									
									
									+ " WHERE USERID ='"+ uniqueId+"'";
			
			
		    ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error While Updating  Data -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	
	public static boolean insertOrUpdateUser(RegisterWithTNGov  register){
		if(register.getLogin().isUserExist())
			return updateUser(register);
		else
			return insertUser(register);
	}
}