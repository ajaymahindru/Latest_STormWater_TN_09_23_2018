package tn.gov.nashville.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import java.util.Random;

import org.apache.log4j.Logger;

import tn.gov.nashville.beans.CertifierPreview;
import tn.gov.nashville.beans.DashboardNoiListing;
import tn.gov.nashville.beans.Login;
import tn.gov.nashville.beans.Noi;
import tn.gov.nashville.util.DataConnect;





public class CertifierCommon_DAO {
	
	public static Logger logger = Logger.getLogger(CertifierCommon_DAO.class);
	
    static String noissoid;

  
	


	public static String getNoissoid() {
		return noissoid;
	}


	public static void setNoissoid(String noissoid) {
		CertifierCommon_DAO.noissoid = noissoid;
	}
	


	public static List<DashboardNoiListing> selectNoiListFormMaster(String userid ) {
		
		//String abcid = getNoissoid();
		
		
		logger.info(" selectNoiRecord function..... "); 
		Connection con = null;
		PreparedStatement ps = null;
		boolean noiRecord = false;
   
		
		String uniqueId = userid;
		

		List <DashboardNoiListing> beans = new ArrayList<DashboardNoiListing>();  

		try {
			
			
			con = DataConnect.getConnection();   
			logger.info(" database connection Sucess..... "); 

			
			
			String query1 = "select CURRENT_NPDES_ID,CONT_EMAIL,SITE_NAME,CONT_FIRSTNAME,STATUS,LASTUPDATED,NOI_MASTER_ID  from BG_CROMERR.NOI_MASTER where USERID = '" + uniqueId+"' ORDER BY NOI_MASTER_ID DESC";

			
		
			 ps = con.prepareStatement(query1);
			 
				logger.info(" query created, executing query ..... " +query1); 
				ResultSet rs1 = ps.executeQuery();
				
			
				
				while (rs1.next()) {
					
					
					
					
					DashboardNoiListing bean = new DashboardNoiListing();
					     
					                bean.setNpdesID3(rs1.getString("CURRENT_NPDES_ID"));
					                bean.setSiteOwnerEmail18(rs1.getString("CONT_EMAIL"));
					                bean.setProjName31(rs1.getString("SITE_NAME"));
					                bean.setSiteOwnerFirstName7(rs1.getString("CONT_FIRSTNAME"));
					                bean.setStatus69(rs1.getString("STATUS"));
					                bean.setLastUpdated70(rs1.getString("LASTUPDATED"));
					                bean.setNoiMasterID(rs1.getString("NOI_MASTER_ID"));
					   
					 
					    beans.add(bean);
					
					     
				}
        
			
		} catch (SQLException ex) {
			
			logger.error(" call to the database table NOI_Master using unique ID FAILED ..... " + ex.getMessage());		
			
			ex.printStackTrace();
		} finally {
			DataConnect.close(con);
		
		}
		return beans;
	}
	
	

	
	
	
	
public static boolean checkCertifierRolesEmail(Noi  noiform) {
		
		logger.info(" checkCertifierRolesEmail function..... "); 
		Connection con = null;
		PreparedStatement ps = null;
		boolean noiRecord = false;
		
		String certifierEmail = noiform.getCheckCertifier();
	
		try {
			
			
			con = DataConnect.getConnection();   
			logger.info(" database connection Sucess..... "); 

			
			String query1 = "select CERTIFIER  from BG_CROMERR.CRO_ROLES where USERNAME = '" + certifierEmail+"'";
			
		// TODO compare the CURRENT_NPDES_ID Number  with existing 
			 ps = con.prepareStatement(query1);
			 
				logger.info(" query created, executing query ..... " +query1); 
				ResultSet rs1 = ps.executeQuery();
				
				
			/*	 while (rs4.next()) {
				        sids.add(rs4.getString(1));
				        lids.add(rs4.getString(2));
				    }
		      */
				while (rs1.next()) {
					
					String preparer = rs1.getString("CERTIFIER");
					if (preparer.equalsIgnoreCase("FALSE"))
					{
						noiRecord = false;	
					}
					
					logger.error(" Preparer Exist for this Email..... " +query1);
					
					if (preparer.equalsIgnoreCase("Certifier"))
					{
						noiRecord = true;
					}	
					
	
					
				return noiRecord;
				}
		} catch (SQLException ex) {
			
			logger.error(" call to the database table CRO_ROLES FAILED ..... " + ex.getMessage());		
		return false;	
		} finally {
			DataConnect.close(con);
		
		}
		return false;
	}



public static boolean checkPreparerRolesEmail(Noi  noiform) {
	
	logger.info(" checkPreparerRolesEmail function..... "); 
	Connection con = null;
	PreparedStatement ps = null;
	boolean noiRecord = false;
	
	String preparerEmail = noiform.getCheckPreparer();

	try {
		
		
		con = DataConnect.getConnection();   
		logger.info(" database connection Sucess..... "); 

		
		String query1 = "select PREPARER  from BG_CROMERR.CRO_ROLES where USERNAME = '" + preparerEmail+"'";
		
	// TODO compare the CURRENT_NPDES_ID Number  with existing 
		 ps = con.prepareStatement(query1);
		 
			logger.info(" query created, executing query ..... " +query1); 
			ResultSet rs1 = ps.executeQuery();
			
			if (rs1.next()) {
				
				
				String preparer = rs1.getString("PREPARER");
				if (preparer.equalsIgnoreCase("FALSE"))
				{
					noiRecord = false;	
				}
				
				logger.error(" Preparer Exist for this Email..... " +query1);
				
				if (preparer.equalsIgnoreCase("Preparer"))
				{
					noiRecord = true;
				}
				
					
				
			return noiRecord;
			}
	} catch (SQLException ex) {
		
		logger.error(" call to the database table CRO_ROLES FAILED ..... " + ex.getMessage());		
	return false;	
	} finally {
		DataConnect.close(con);
	
	}
	return false;
}


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

public static DashboardNoiListing selectNoiById(DashboardNoiListing previewbean ){
	
	logger.info(" selectNoiRecord function..... "); 
	Connection con = null;
	PreparedStatement ps = null;
	boolean noiRecord = false;

	 

	try {
		
		
		con = DataConnect.getConnection();   
		logger.info(" database connection Sucess..... "); 

		
		//String query1 = "select * from BG_CROMERR.NOI_MASTER where ID = '" + previewbean.getPreview_autoId()+"'";
		String query1 = "select * from BG_CROMERR.NOI_MASTER where NOI_MASTER_ID = '" + previewbean.getNoiMasterID()+"'";
		
	
		 ps = con.prepareStatement(query1);
		 
			logger.info(" query created, executing query ..... " +query1); 
			ResultSet rs1 = ps.executeQuery();		
			
			if (rs1.next()) {
				
		    previewbean.setNoiMasterID(rs1.getString("NOI_MASTER_ID"));
			previewbean.setNpdesPermitSelect1(rs1.getString("NPDES_PERMIT_COVERAGE"));
			previewbean.setNpdesID3(rs1.getString("CURRENT_NPDES_ID"));
			previewbean.setNpdesPermitSelect2(rs1.getString("CGP_AUTHORIZED"));
			
			
			previewbean.setOpprimaryPermitte4(rs1.getString("PRIMARYPERMIT"));
			previewbean.setSosControlNumber5(rs1.getString("SOSCN"));
			previewbean.setOwnershipSelect6(rs1.getString("OWNERSHIP"));
			previewbean.setSiteOwnerFirstName7(rs1.getString("CONT_FIRSTNAME"));
			previewbean.setSiteOwnerMiddleName8(rs1.getString("CONT_MIDDLE"));
			previewbean.setSiteOwnerLastName9(rs1.getString("CONT_LASTTNAME"));
			previewbean.setSiteOwnerTitle10(rs1.getString("CONT_TITLE"));
			previewbean.setSiteOwnerCompany11(rs1.getString("CONT_COMPANY"));
			previewbean.setSiteOwnerAddress12(rs1.getString("CONT_ADDRESS"));
			previewbean.setSiteOwnerCity13(rs1.getString("CONT_CITY"));
			previewbean.setSiteOwnerstateSelect14(rs1.getString("CONT_SELSTATE"));
			previewbean.setSiteOwnerZip15(rs1.getString("CONT_ZIP"));
			previewbean.setSiteOwnerphone16(rs1.getString("CONT_PHONE"));
			previewbean.setSiteOwnerphoneEXT17(rs1.getString("CONT_PHONE_EXT"));
			
			//this is the Certifier\Approver Email who will certify this document
			previewbean.setSiteOwnerEmail18(rs1.getString("CONT_EMAIL"));
			
			
			previewbean.setOpocFirstName19(rs1.getString("OPT_FIRSTNAME"));
			previewbean.setOpocMiddleName20(rs1.getString("OPT_MIDDLE"));
			previewbean.setOpocLastName21(rs1.getString("OPT_LASTTNAME"));
			previewbean.setOpocTitle22(rs1.getString("OPT_TITLE"));
			previewbean.setOpocCompany23(rs1.getString("OPT_COMPANY"));
			previewbean.setOpocAddress24(rs1.getString("OPT_ADDRESS"));
			previewbean.setOpocCity25(rs1.getString("OPT_CITY"));
			previewbean.setOpocstateSelect26(rs1.getString("OPT_SELSTATE"));
			previewbean.setOpocZip27(rs1.getString("OPT_ZIP"));
			previewbean.setOpocPhone28(rs1.getString("OPT_PHONE"));
			previewbean.setOpocPhoneExt29(rs1.getString("OPT_PHONE_EXT"));
			previewbean.setOpocEmail30(rs1.getString("OPT_EMAIL"));
		
			
			
			
			
			previewbean.setProjName31(rs1.getString("SITE_NAME"));
			previewbean.setProjDescription32(rs1.getString("DESCRIPTION"));
			previewbean.setProjAddress33(rs1.getString("ADDRESS"));
			previewbean.setProjCity34(rs1.getString("CITY"));
			previewbean.setProjZip36(rs1.getString("ZIP"));
			previewbean.setProjCounty37(rs1.getString("COUNTY"));
		//	previewbean.setProjStartDate38(rs1.getDate("START_DATE"));
		//	previewbean.setProjEndDate39(rs1.getDate("END_DATE"));
			previewbean.setProjEADisturbed40(rs1.getString("AREA_DISTURBED"));
			previewbean.setProjTotalSiteAcres41(rs1.getString("TOTALACRE"));
			
			/*
			previewbean.setSelecSFResi(rs1.getString("SF_RESI"));
			previewbean.setselecMFResi(rs1.getString("MF_RESI"));	
			previewbean.setselecCommercial(rs1.getString("COMMERCIAL"));
			previewbean.setPreview_selecIndustrial(rs1.getString("INDUSTRIAL"));
			previewbean.setPreview_selecInstitutional(rs1.getString("INSTITUTIONAL"));
			previewbean.setPreview_selecHywayRoad(rs1.getString("HWY_ROAD"));
			previewbean.setPreview_selecUtility(rs1.getString("UTILITY"));
			previewbean.setPreview_selecOther(rs1.getString("OTHER"));
			*/
		   
			
			previewbean.setProjLatitude51(rs1.getString("LATITUDE"));
			previewbean.setProjLongitude52(rs1.getString("LONGITUDE"));
			
			
			previewbean.setProjDischargeMS455(rs1.getString("DISMS4"));
			previewbean.setProjDischarge50FtDisturbance56(rs1.getString("DIS50FEET"));
			previewbean.setProjMS4Jurisdiction57(rs1.getString("MS4JURISDICTION"));
			
			previewbean.setProjDischargeID58(rs1.getString("DISDISCHARGEID"));
			previewbean.setProjDischargeReceavingWater59(rs1.getString("DISRECIEVINGWATER"));
			previewbean.setProjDischargeDescription60(rs1.getString("DISDESCRIPTION"));
			previewbean.setProjDischargeCWA61(rs1.getString("DISCWA303"));
			previewbean.setProjDischargeTMDL62(rs1.getString("DISTMDL"));
			
			
			
			previewbean.setSwpppPreparedAdvance63(rs1.getString("SWPPP_PREP_ADVANCE"));
			
//			previewbean.setPreview_stateSelectOption("Tennessee");
			
			//previewbean.setPreview_Status(rs1.getString("DISCWA303"));
			
		
				   
				     
			}
    
		
	} catch (SQLException ex) {
		
		logger.error(" call to the database table NOI_Master using unique ID FAILED ..... " + ex.getMessage());		
		
		ex.printStackTrace();
	} finally {
		DataConnect.close(con);
	
	}
	return previewbean;
}




public static boolean updateNoiCertifyRecord(DashboardNoiListing previewbeanUpdate) {
	Connection con = null;
	PreparedStatement ps = null;
	
	
	
	//Permit Information
	        String noiMasterId = previewbeanUpdate.getNoiMasterID();
			String npdesPermitCoverage11 = previewbeanUpdate.getNpdesPermitSelect1();
			String currentNpdesId22 = previewbeanUpdate.getNpdesID3();
			String cgpAuthorized33 = previewbeanUpdate.getNpdesPermitSelect2();
			
			
			//Contact Information
			String opprimaryPermitte44 = previewbeanUpdate.getOpprimaryPermitte4();
			String sosControlNumber55  = previewbeanUpdate.getSosControlNumber5();
			String ownershipSelect66   = previewbeanUpdate.getOwnershipSelect6();
			String siteOwnerFirstName77 = previewbeanUpdate.getSiteOwnerFirstName7();  
			String siteOwnerMiddleName88 = previewbeanUpdate.getSiteOwnerMiddleName8();
			String siteOwnerLastName99 = previewbeanUpdate.getSiteOwnerLastName9(); 
			String siteOwnerTitle100   = previewbeanUpdate.getSiteOwnerTitle10(); 
			String siteOwnerCompany111 = previewbeanUpdate.getSiteOwnerCompany11();
			String siteOwnerAddress122 = previewbeanUpdate.getSiteOwnerAddress12();
			String siteOwnerCity133    = previewbeanUpdate.getSiteOwnerCity13();
			String siteOwnerstateSelect144 = previewbeanUpdate.getSiteOwnerstateSelect14(); 
			String siteOwnerZip155     = previewbeanUpdate.getSiteOwnerZip15();
			String siteOwnerphone166   = previewbeanUpdate.getSiteOwnerphone16();
			String siteOwnerphoneEXT177 = previewbeanUpdate.getSiteOwnerphoneEXT17();
			String siteOwnerEmail188   = previewbeanUpdate.getSiteOwnerEmail18();
			
			String opecfirstname199 = previewbeanUpdate.getOpocFirstName19();
			String opecmiddle200 = previewbeanUpdate.getOpocMiddleName20();
			String opeclastname211 = previewbeanUpdate.getOpocLastName21();
			String opectitle222 = previewbeanUpdate.getOpocTitle22();
			String opocCompany233 = previewbeanUpdate.getOpocCompany23();
			String opocAddress244 = previewbeanUpdate.getOpocAddress24();
			String opocCity255 = previewbeanUpdate.getOpocCity25();
			String opocstateSelect266 = previewbeanUpdate.getOpocstateSelect26();
			String opocZip277 = previewbeanUpdate.getOpocZip27();		
			String opecphone288 = previewbeanUpdate.getOpocPhone28();
			String opecphoneext299 = previewbeanUpdate.getOpocPhoneExt29();
			String opecemail300 =previewbeanUpdate.getOpocEmail30();
			
			

			//operator Project Site Information		
			String sitename311 = previewbeanUpdate.getProjName31();
			String siteDescription322 = previewbeanUpdate.getProjDescription32();
			String projSiteaddress333 = previewbeanUpdate.getProjAddress33();
			String projSitecity344 = previewbeanUpdate.getProjCity34();
			//String projState35 = previewbeanUpdate.getProjState();
			String projSitezip366 = previewbeanUpdate.getProjZip36();
			String county377 = previewbeanUpdate.getProjCounty37();		
			String startdate388 = previewbeanUpdate.getProjStartDate38().toString();
			String enddate399 = previewbeanUpdate.getProjEndDate39().toString();
			String areadisturbed400 = previewbeanUpdate.getProjEADisturbed40();
			
			String projTotalSiteAcres411 = previewbeanUpdate.getProjTotalSiteAcres41();

			//---------------------TODO
		/*	List selectedConstructionCheckBo = previewbeanUpdate.getSelectedConstructionCheckBo();
			
			 for (String name:selectedConstructionCheckBo)
		        {
		           boolean projTOC_SingleFamilyResi42 = name.equalsIgnoreCase("Single-Family Residential");
		            	 
		           projTOC_SingleFamilyResi = "Single-Family Residential"
		            
		        }
			*/
			//---------------------
			String projTOC_SingleFamilyResi422 = "";
			String mf_resi433 = previewbeanUpdate.getProjTOC_MultiFamilyResi44();
			String commercial444 = previewbeanUpdate.getProjTOC_Commercial45();
			String industrial455 = previewbeanUpdate.getProjTOC_Industrial46();
			String institutional466 = previewbeanUpdate.getProjTOC_Institutional47();
			String hywayRoad477 = previewbeanUpdate.getProjTOC_HYWY48();
			String utility488 = previewbeanUpdate.getProjTOC_Utility49();
			String other499 = previewbeanUpdate.getProjTOC_Other50();
			
			
			
			
			
			//Latitude Longitude
			//String latlongsource31 = previewbeanUpdate.getProjLatLongSource();
			//String datumsource32 = previewbeanUpdate.getProjDatumSource();
			String latitude500 = previewbeanUpdate.getProjLatitude51();
			String longitude511 = previewbeanUpdate.getProjLongitude52();
			
			//Discharge Water  Information
			String disMS4522 = previewbeanUpdate.getProjDischargeMS455();
			String dis50Feet533 = previewbeanUpdate.getProjDischarge50FtDisturbance56();
			String disDischargeID544 = previewbeanUpdate.getProjDischargeID58();
			String disRecievingWater555 = previewbeanUpdate.getProjDischargeReceavingWater59();
			String disDescription566 = previewbeanUpdate.getProjDischargeDescription60();
			String disCWA303577 = previewbeanUpdate.getProjDischargeCWA61();
			String disTMDL588 = previewbeanUpdate.getProjDischargeTMDL62();
			
			String discMS4Jurisdiction599 = previewbeanUpdate.getProjMS4Jurisdiction57();
			//SWPPP Information
		/*	String swppFIRST_NAME599 = previewbeanUpdate.getSwpppFirstName();
			String swppMIDDLE600 = previewbeanUpdate.getSwpppMiddleName();
			String swppLAST_NAME611 = previewbeanUpdate.getSwpppLastName();
			String swppORG622 = previewbeanUpdate.getSwpppOrg();
			String swppTITLE633 = previewbeanUpdate.getSwpppTitle();
			String swppPHONE644 = previewbeanUpdate.getSwpppPhone();
			String swppPHONE_EXT655 = previewbeanUpdate.getSwpppPhoneExt();
			String swppEMAIL666 = previewbeanUpdate.getSwpppEmail();
			*/
			String swpp_PREP_ADVANCE677 = previewbeanUpdate.getSwpppPreparedAdvance63();
			
			
			//ESP info
		/*	String espcriterion688 = previewbeanUpdate.getEspCriterion();
			String espsummary699 = previewbeanUpdate.getEspCriterionSummary();
			
			// Certification Info
			
			String certUserID700 = previewbeanUpdate.getCertInfoUserID();
			String certfirstName711 = previewbeanUpdate.getCertInfoFirstName();
			String certmiddleName722 = previewbeanUpdate.getCertInfoMiddleName();
			String certlastName733 = previewbeanUpdate.getCertInfoLastName();
			String certOrg744 = previewbeanUpdate.getCertInfoOrganization();
			String certEmail755 = previewbeanUpdate.getCertInfoEmail();
			String certAddress766 = previewbeanUpdate.getCertInfoAddress();
		*/	
			
			String defaultState777 ="Tennessee";
			
			//String userid788 = previewbeanUpdate.getLogin().getUniqueId();
			
		//	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		 //   Login firstBean = (Login) elContext.getELResolver().getValue(elContext, null, "Login");
		    
		 //   String userid788 = firstBean.getUniqueId();
			
			//String userid78 = "64";
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
			String lastupdated799 = ZonedDateTime.now().format(formatter);
	
//	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	//String lastupdated2 = ZonedDateTime.now().format(formatter2);
	
	
	try {	
		con = DataConnect.getConnection();   
		String query  ="";
		
		String  certifierStatus = "Certified";
		
		query = "UPDATE BG_CROMERR.NOI_MASTER SET NPDES_PERMIT_COVERAGE ='"+npdesPermitCoverage11 +"'"
				
				
						+ ",CURRENT_NPDES_ID ='"+currentNpdesId22 +"'"
						+ ",CGP_AUTHORIZED ='"+ cgpAuthorized33+"'"
						
						
						+ ",PRIMARYPERMIT ='"+ opprimaryPermitte44+"'"
						+ ",SOSCN ='"+ sosControlNumber55+"'"
						+ ",OWNERSHIP ='"+ ownershipSelect66+"'"
						+ ",CONT_FIRSTNAME ='"+siteOwnerFirstName77+"'"
						+ ",CONT_MIDDLE ='"+ siteOwnerMiddleName88+"'"
						+ ",CONT_LASTTNAME ='"+ siteOwnerLastName99+"'"
						+ ",CONT_TITLE ='"+ siteOwnerTitle100+"'"
						+ ",CONT_COMPANY ='"+ siteOwnerCompany111+"'"
						+ ",CONT_ADDRESS ='"+siteOwnerAddress122+"'"							
						+ ",CONT_CITY ='"+siteOwnerCity133+"'"
						+ ",CONT_SELSTATE ='"+ siteOwnerstateSelect144+"'"
						+ ",CONT_ZIP ='"+ siteOwnerZip155+"'"
						+ ",CONT_PHONE ='"+ siteOwnerphone166+"'"
						+ ",CONT_PHONE_EXT ='"+ siteOwnerphoneEXT177+"'"
						+ ",CONT_EMAIL ='"+siteOwnerEmail188+"'"
						
		                + ",OPT_FIRSTNAME='"+ opecfirstname199+"'"
		                + ",OPT_MIDDLE='"+ opecmiddle200+"'"
		                + ",OPT_LASTTNAME='"+ opeclastname211+"'"
		                + ",OPT_TITLE='"+ opectitle222+"'"
		                + ",OPT_COMPANY='"+ opocCompany233+"'"
		                + ",OPT_ADDRESS='"+ opocAddress244+"'"
		                + ",OPT_CITY='"+ opocCity255+"'"
		                + ",OPT_SELSTATE='"+ opocstateSelect266+"'"
		                + ",OPT_ZIP='"+ opocZip277+"'"
		                + ",OPT_PHONE='"+ opecphone288+"'"
		                + ",OPT_PHONE_EXT='"+ opecphoneext299+"'"
		                + ",OPT_EMAIL='"+ opecemail300+"'"
		               
		                
		                +",site_name='"+ sitename311+"'"			 
		                + ",Description='"+ siteDescription322+"'"
		                + ",address='"+ projSiteaddress333+"'"
		                + ",city='"+ projSitecity344+"'"
		                + ",zip='"+ projSitezip366+"'"
		                + ",county='"+ county377+"'"
		                + ",start_date='"+ startdate388+"'"
		                + ",end_date='"+ enddate399+"'"
		                + ",area_disturbed='"+ areadisturbed400+"'"
		                + ",totalacre='"+ projTotalSiteAcres411+"'"
			            + ",sf_resi='"+ projTOC_SingleFamilyResi422+"'"
			            + ",mf_resi='"+ mf_resi433+"'"
			            + ",commercial='"+ commercial444+"'"
			            + ",industrial='"+ industrial455+"'"
			            + ",institutional='"+ institutional466+"'"
			            + ",hwy_road='"+ hywayRoad477+"'"
			            + ",utility='"+ utility488+"'"
			            + ",other='"+ other499+"'"
		
			            
			            
			            + ",latitude='"+ latitude500+"'"
			            + ", longitude='"+ longitude511+"'"
			

						+ ",disMS4='"+ disMS4522+"'"
						+ ",dis50Feet='"+ dis50Feet533+"'"
						+ ",disDischargeID='"+ disDischargeID544+"'"
						+ ",disRecievingWater='"+ disRecievingWater555+"'"
						+ ",disDescription='"+ disDescription566+"'"
						+ ",disCWA303='"+ disCWA303577+"'"
						+ ",disTMDL='"+ disTMDL588+"'"

						+ ",MS4Jurisdiction='"+ discMS4Jurisdiction599+"'"
			/*			+ ",swppMIDDLE='"+ swppMIDDLE600+"'"
						+ ",swppLAST_NAME='"+ swppLAST_NAME611+"'"
						+ ",swppORGANIZATION='"+ swppORG622+"'"
						+ ",swppTITLE='"+ swppTITLE633+"'"
						+ ",swppPHONE='"+ swppPHONE644+"'"
						+ ",swppPHONE_EXT='"+ swppPHONE_EXT655+"'"
						+ ",swppEMAIL='"+ swppEMAIL666+"'"
			*/			
						+ ",SWPPP_PREP_ADVANCE='"+ swpp_PREP_ADVANCE677+"'"
						
				/*		+ ",ESP_CRITERION='"+ espcriterion688+"'"
						+ ",ESP_SUMMARY='"+ espsummary699+"'"

						+ ",CERT_USERID='"+ certUserID700+"'"
						+ ",CERT_FIRSTNAME='"+ certfirstName711+"'"
						+ ",CERT_MIDDLE='"+ certmiddleName722+"'"
						+ ",CERT_LASTNAME='"+ certlastName733+"'"
						+ ",CERT_ORG='"+ certOrg744+"'"
						+ ",CERT_EMAIL='"+ certEmail755+"'"
						+ ",CERT_ADDRESS='"+ certAddress766+"'"														
				  */
						+ ",LASTUPDATED='"+ lastupdated799+"'"
						+ ",DefaultSTATE='"+ defaultState777+"'"
						+",STATUS='"+ certifierStatus+"'"
						
						+ " WHERE NOI_MASTER_ID ="+ noiMasterId;
		
	
		
		
		
		
		
		
		
		
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

	


public static boolean validateSecurity(DashboardNoiListing security) {
	
	logger.info(" checkCertifierRolesEmail function..... "); 
	Connection con = null;
	PreparedStatement ps = null;
	boolean noiRecord = false;
	
	//String certifierEmail = noiform.getCheckCertifier();
	
	
	  
	Random rand = new Random(); 
	int value = rand.nextInt(4);
	System.out.println ("++++++++++RandomNumber++++++++++" +value);
	
	

	try {
		
		
		con = DataConnect.getConnection();   
		logger.info(" database connection Sucess..... "); 
		
	//	String userid = Login.getUserid("64");
		
		
		String rolecertifier = "select USERNAME, CERTIFIER  from BG_CROMERR.CRO_ROLES where  USERID = " + security.getLoginSSOID66() ;
		
		
		
		
	// TODO compare the CURRENT_NPDES_ID Number  with existing 
		 ps = con.prepareStatement(rolecertifier);
		 
			logger.info(" Checking Roles for TWO Factor Authentications..... " +rolecertifier); 
			ResultSet rscertifier = ps.executeQuery();
			
			
				while (rscertifier.next()) {
				
				String rolecheck = rscertifier.getString("CERTIFIER");
				if (rolecheck.equalsIgnoreCase("Certifier"))					
				{
					String querysecurity = "";
					if( value == 0)
					{
						querysecurity = "select SECU_Q1,SECU_ANS1  from BG_CROMERR.CRO_USERINFO_LEXISNEXIS"; 
					}
					if( value == 1)
					{
						querysecurity = "select SECU_Q2,SECU_ANS2  from BG_CROMERR.CRO_USERINFO_LEXISNEXIS"; 
					}
					if( value == 2)
					{
						querysecurity = "select SECU_Q3,SECU_ANS3  from BG_CROMERR.CRO_USERINFO_LEXISNEXIS"; 
					}
					if( value == 3)
					{
						querysecurity = "select SECU_Q4,SECU_ANS4  from BG_CROMERR.CRO_USERINFO_LEXISNEXIS"; 
					}
					if( value == 4)
					{
						querysecurity = "select SECU_Q5,SECU_ANS5  from BG_CROMERR.CRO_USERINFO_LEXISNEXIS"; 
					}
					
					 ps = con.prepareStatement(querysecurity);
					 
						logger.info(" Random Security Question, Answers Choosen..... " +querysecurity); 
						ResultSet securityqnsans = ps.executeQuery();
				return true;
				}
				else {
					
				return false ;	
				}
				

				
			//return noiRecord;
			}
	} catch (SQLException ex) {
		
		logger.error(" call to the database table CRO_ROLES FAILED ..... " + ex.getMessage());		
	return false;	
	} finally {
		DataConnect.close(con);
	
	}
			
			
			
		

			
	return false;
}




	
	
	
	
	
	
	
}