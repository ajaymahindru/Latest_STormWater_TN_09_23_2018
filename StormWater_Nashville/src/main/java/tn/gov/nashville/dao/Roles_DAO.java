package tn.gov.nashville.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import tn.gov.nashville.beans.Login;
import tn.gov.nashville.util.DataConnect;


public class Roles_DAO {
	
	public static Logger logger = Logger.getLogger(Roles_DAO.class);
	
	String LexisNexisVarification;

	public String getLexisNexisVarification() {
		return LexisNexisVarification;
	}

	public void setLexisNexisVarification(String lexisNexisVarification) {
		LexisNexisVarification = lexisNexisVarification;
	}

	public static String selectRoles(Login  loginReturnedValuesbySSO) {
		
		logger.info(" Inside validate function..... "); 
		Connection con = null;
		PreparedStatement ps = null;
		String   roles1 = "NoRole";
		String uniqueIdLoginService = loginReturnedValuesbySSO.getUniqueId();

		try {
			
			logger.info(" Making a call to the database for Roles ..... "); 
			con = DataConnect.getConnection();   
			logger.info(" database connection Sucess..... "); 

			
			String query1 = "select PREPARER,CERTIFIER,BUSINESS,ADMIN  from BG_CROMERR.CRO_ROLES where USERID = '" + uniqueIdLoginService+"'";
			
		
			 ps = con.prepareStatement(query1);
			 
				logger.info(" query created, executing query ..... " +query1); 
				ResultSet rs1 = ps.executeQuery();
				
			if (rs1.next()) {
				//loginReturnedValuesbySSO.setUserRoles("true");
				String preparer = rs1.getString("PREPARER");
				String certifier = rs1.getString("CERTIFIER");
				String business = rs1.getString("BUSINESS");
				String admin = rs1.getString("ADMIN");
			
				loginReturnedValuesbySSO.setAdmin(preparer);
				loginReturnedValuesbySSO.setCertifier(certifier);
				loginReturnedValuesbySSO.setBusiness(business);
				loginReturnedValuesbySSO.setAdmin(admin);
				
				logger.info(" sql query  for Roles executed sucessfully Got the reults back based on Unique ID of SSO..... " +query1);
				 if (preparer.equalsIgnoreCase("preparer"))				
				{
					 roles1 = "preparer";	
				}
				 if (certifier.equalsIgnoreCase("certifier")){
			
					 roles1 = "certifier";
			     }

			}
		} catch (SQLException ex) {
			
			logger.error(" Making a call to the database  for Roles using unique ID FAILED ..... " + ex.getMessage());		
			
		} finally {
			DataConnect.close(con);
		
		}
		return roles1;
	}
	
	
	public static String checkorInsert(Login roles2){
		RecordActivityDAO record = new RecordActivityDAO();
		record.recordActivity1(roles2);
		
		String roles3 = selectRoles ( roles2);
		if(roles3.equalsIgnoreCase("preparer")){
		
			roles3  = "preparer";
			
		}if(roles3.equalsIgnoreCase("certifier")){
			
			roles3  = "certifier";
		}
		
		
		if (roles3.equalsIgnoreCase("NoRole"))
		{
			
			
		 roles3 =  insertRoles(roles2);
		  
		 if (roles3.equalsIgnoreCase("certifier"))
		 {
		 roles3 = "certifier";	 
		 }
		 
		 if (roles3.equalsIgnoreCase("preparer"))
		 {
		 roles3 = "preparer";	 
		 }
		 
		}
		
		if (roles3 == null || roles3.equalsIgnoreCase("")|| roles3.equalsIgnoreCase("error"))
		{
			
			
		 roles3 =  "roles";
		}
	return  roles3;	
	}

	
	
public static String insertRoles(Login  roles) {
	     
		
		Connection con = null;
		PreparedStatement ps = null;
		String uniqueId1 = roles.getUniqueId();
		
		String prepRole = roles.getPreparer1();
		String cerRole = roles.getCertifier1();
		
		String usernamessoEmail = roles.getUser();
		
		String rolePrepCertifier = "";
			
			
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		
		//TODO to get the username from Another Source (ADMIN\Business)
		//String userName = login.getUser(); 
		
		
		String lastupdated = ZonedDateTime.now().format(formatter);
		logger.info(" got the value from the Roles Form  ..... ");
		
		

		try {
			con = DataConnect.getConnection();   
			
			//----------------------
			if(prepRole !=null && prepRole.equalsIgnoreCase("preparer")){
				
				
				logger.info(" Inside Preparer Block  ..... ");
				
				String inputphone1 = roles.getInputPhone();
				
					String preparer = "Preparer";
					String certifier = "FALSE";
					String admin = "FALSE";
					String business = "FALSE";
					//rolePrepCertifier = preparer;
				
				String query = "INSERT INTO BG_CROMERR.CRO_ROLES (USERID,USERNAME,PREPARER,CERTIFIER,ADMIN,BUSINESS,PHONENUMBER,LASTUPDATED)"
						+ "" + " VALUES('" + uniqueId1 + "'" + "," + "'" + usernamessoEmail
						+ "','" + preparer + "','" + certifier + "','" + admin + "','" + business + "'" + "," + "'" + inputphone1
						+ "','" + lastupdated + "')";
				
			    ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				logger.info(" Preparer data is added Sucess  ..... ");
				
				rolePrepCertifier = preparer;
				
			//	return rolePrepCertifier;	
				
			}else if (cerRole !=null && cerRole.equalsIgnoreCase("certifier")){
				
				
				
				logger.info(" Inside certifier Block  ..... ");
				
				String preparer = "FALSE";
				String certifier = "Certifier";
				String admin = "FALSE";
				String business = "FALSE";
				//rolePrepCertifier = certifier;
				String inputphone1 = "";
			String query = "INSERT INTO BG_CROMERR.CRO_ROLES (USERID,USERNAME,PREPARER,CERTIFIER,ADMIN,BUSINESS,PHONENUMBER,LASTUPDATED)"
					+ "" + " VALUES('" + uniqueId1 + "'" + "," + "'" + usernamessoEmail
					+ "','" + preparer + "','" + certifier + "','" + admin + "','" + business + "'" + "," + "'" + inputphone1
					+ "','" + lastupdated + "')";
			
		    ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			logger.info(" Certifier data is added Sucess  ..... ");
			
			rolePrepCertifier = certifier;	
			}
		} catch (SQLException ex) {
			System.out.println("Error While Inserting Data -->" + ex.getMessage());
			
			return "roles";	
		} finally {
			DataConnect.close(con);
		}
	
		return rolePrepCertifier;	
	}
	
	
	public static boolean updateRoles(Login  roles) {
		Connection con = null;
		PreparedStatement ps = null;
		String uniqueId2 = roles.getUniqueId();
		String inputphone2 = roles.getInputPhone();
		String roles2 = roles.getSelectedRole();
		String usernamessoEmail2 = roles.getUser();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String lastupdated2 = ZonedDateTime.now().format(formatter);
		
		
		try {
			
			if(roles2.equalsIgnoreCase("preparer")){
				
				String preparer2 = "TRUE";
				String certifier2 = "FALSE";
				String admin2 = "FALSE";
				String business2 = "FALSE";
				
			con = DataConnect.getConnection();   
			String query  ="";
			query = "UPDATE BG_CROMERR.CRO_ROLES SET USERID ='"+uniqueId2 +"'"
							+ ",USERNAME ='"+usernamessoEmail2 +"'"
									+ ",PREPARER ='"+ preparer2+"'"
									+ ",CERTIFIER ='"+ certifier2+"'"
									+ ",ADMIN ='"+admin2+"'"
									+ ",BUSINESS ='"+ business2+"'"
									+ ",PHONENUMBER ='"+ inputphone2+"'"
									+ ",LASTUPDATED ='"+lastupdated2+"'"
									+ " WHERE USERID ='"+ uniqueId2+"'";
					    ps = con.prepareStatement(query);
						ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					return true;
				}
			}else if(roles2.equalsIgnoreCase("certifier")){
				
				String preparer3 = "FALSE";
				String certifier3 = "TRUE";
				String admin3 = "FALSE";
				String business3 = "FALSE";
				
				String inputphone3 = "";
				
			con = DataConnect.getConnection();   
			String query  ="";
			query = "UPDATE BG_CROMERR.CRO_ROLES SET USERID ='"+uniqueId2 +"'"
					+ ",USERNAME ='"+usernamessoEmail2 +"'"
							+ ",PREPARER ='"+ preparer3+"'"
							+ ",CERTIFIER ='"+ certifier3+"'"
							+ ",ADMIN ='"+admin3+"'"
							+ ",BUSINESS ='"+ business3+"'"
							+ ",PHONENUMBER ='"+ inputphone3+"'"
							+ ",LASTUPDATED ='"+lastupdated2+"'"
							+ " WHERE USERID ='"+ uniqueId2+"'";
					    ps = con.prepareStatement(query);
						ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					return true;
				}
				
			}		
		} catch (SQLException ex) {
			System.out.println("Error While Inserting Data -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	
	
	
	
	
}