package tn.gov.nashville.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import tn.gov.nashville.beans.Login;
import tn.gov.nashville.beans.Noi;
import tn.gov.nashville.beans.RegisterWithTNGov;
import tn.gov.nashville.util.DataConnect;


public class Noi_DAO {
	
	public static Logger logger = Logger.getLogger(Noi_DAO.class);
	
	


	public static boolean selectNoiRecord(Noi  noiform) {
		
		
		logger.info(" selectNoiRecord function..... "); 
		Connection con = null;
		PreparedStatement ps = null;
		boolean noiRecord = false;
		//String uniqueIdLoginService = loginReturnedValuesbySSO.getUniqueId();
		
		String uniqueId = "123Nashville";

		try {
			
			
			con = DataConnect.getConnection();   
			logger.info(" database connection Sucess..... "); 

			
			String query1 = "select CURRENT_NPDES_ID from BG_CROMERR.NOI_PERMIT_INFO where USERID = '" + uniqueId+"'";
			
		
			 ps = con.prepareStatement(query1);
			 
				logger.info(" query created, executing query ..... " +query1); 
				ResultSet rs1 = ps.executeQuery();
				
				if (rs1.next()) {
								
					logger.info(" Record Already Exist in the database..... " +query1);
						 
					noiRecord = true;	
					
				
				}
		} catch (SQLException ex) {
			
			logger.error(" call to the database table NOI_Permit using unique ID FAILED ..... " + ex.getMessage());		
			
		} finally {
			DataConnect.close(con);
		
		}
		return false;
	}
	
	
	public static boolean checkorInsertNOIPermit(Noi  noiform1){
		if(noiform1.isNoiUserExist())
			return selectNoiRecord(noiform1);
		else
			return insertNoiPermit(noiform1);
	}
	
	

public static boolean insertNoiPermit(Noi  noiform1) {
	     
		
		Connection con = null;
		PreparedStatement ps = null;
		String npdesPermitCoverage = noiform1.getNpdesPermitSelect1();
		String currentNpdesId = noiform1.getNpdesID();
		String cgpAuthorized = noiform1.getNpdesPermitSelect2();
		String ssoUserID =noiform1.getLoginSSOID();
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String lastupdated = ZonedDateTime.now().format(formatter);
		logger.info(" got the value from the Noi Form  ..... ");
	
		try {
			con = DataConnect.getConnection();   
	
				String query = "INSERT INTO NOI_PERMIT_INFO  (NPDES_PERMIT_COVERAGE,CURRENT_NPDES_ID,CGP_AUTHORIZED,USERID,LASTUPDATED)"
						+ "" + " VALUES('" + npdesPermitCoverage + "'" + "," + "'" + currentNpdesId
						+ "','" + cgpAuthorized + "','" + ssoUserID + "','" + lastupdated + "')";
				
				

				  
				
			    ps = con.prepareStatement(query);
			    
			    ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					return true;
				}
				
				logger.info(" NOI Permit info is added Sucess  ..... ");
				
				
		} catch (SQLException ex) {
			System.out.println("Error While Inserting Data -->" + ex.getMessage());
			
			return false;	
		} finally {
			DataConnect.close(con);
		}
	
		return false;	
	}
	
	
	public static boolean updateNoiPermitInfo(Noi  noiform) {
		Connection con = null;
		PreparedStatement ps = null;
		String npdesPermitCoverage = noiform.getNpdesPermitSelect1();
		String currentNpdesId = noiform.getNpdesID();
		String cgpAuthorized = noiform.getNpdesPermitSelect2();
		String ssoUserID ="64";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String lastupdated2 = ZonedDateTime.now().format(formatter);
		
		
		try {	
			con = DataConnect.getConnection();   
			String query  ="";
			query = "UPDATE BG_CROMERR.NOI_PERMIT_INFO SET NPDES_PERMIT_COVERAGE ='"+npdesPermitCoverage +"'"
							+ ",CURRENT_NPDES_ID ='"+currentNpdesId +"'"
									+ ",CGP_AUTHORIZED ='"+ cgpAuthorized+"'"
									+ ",LASTUPDATED ='"+lastupdated2+"'"
									+ " WHERE USERID ='"+ ssoUserID+"'";
					    ps = con.prepareStatement(query);
						ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					return true;
				}
			}		
		    catch (SQLException ex) {
			System.out.println("Error While Inserting Data -->" + ex.getMessage());
			return false;
			} finally {
				DataConnect.close(con);
			}
			return false;
	}
	
	
	
	
	
}