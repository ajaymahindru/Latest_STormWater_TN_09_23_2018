package tn.gov.nashville.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.richfaces.application.push.Request;
import org.richfaces.application.push.Session;

import tn.gov.nashville.beans.CertifierPreview;
import tn.gov.nashville.beans.DashboardNoiListing;
import tn.gov.nashville.beans.Login;
import tn.gov.nashville.beans.Noi;
import tn.gov.nashville.util.DataConnect;





public class CertifierPreviewDAO {
	
	public static Logger logger = Logger.getLogger(CertifierPreviewDAO.class);
	
    static String noissoid;

  
	


	public static String getNoissoid() {
		return noissoid;
	}


	public static void setNoissoid(String noissoid) {
		CertifierPreviewDAO.noissoid = noissoid;
	}
	


	public static CertifierPreview selectNoiFormMaster11(CertifierPreview previewbean ){
				
		logger.info(" selectNoiRecord function..... "); 
		Connection con = null;
		PreparedStatement ps = null;
		boolean noiRecord = false;
   
		 

		try {
			
			
			con = DataConnect.getConnection();   
			logger.info(" database connection Sucess..... "); 

			
			//String query1 = "select * from BG_CROMERR.NOI_MASTER where ID = '" + previewbean.getPreview_autoId()+"'";
			String query1 = "select * from BG_CROMERR.NOI_MASTER where CURRENT_NPDES_ID = '" + previewbean.getPreview_npdesID()+"'";
			
		
			 ps = con.prepareStatement(query1);
			 
				logger.info(" query created, executing query ..... " +query1); 
				ResultSet rs1 = ps.executeQuery();		
				
				if (rs1.first()) {
					
				
				previewbean.setPreview_npdesPermitCoverage(rs1.getString("NPDES_PERMIT_COVERAGE"));
				previewbean.setPreview_npdesID(rs1.getString("CURRENT_NPDES_ID"));
				previewbean.setPreview_CGPAuthorized(rs1.getString("CGP_AUTHORIZED"));
				
				
				previewbean.setPreview_opprimaryPermitte(rs1.getString("PRIMARYPERMIT"));
				previewbean.setPreview_sosControlNumber(rs1.getString("SOSCN"));
				previewbean.setPreview_ownershipSelect(rs1.getString("OWNERSHIP"));
				previewbean.setPreview_siteOwnerFirstName(rs1.getString("CONT_FIRSTNAME"));
				previewbean.setPreview_siteOwnerMiddleName(rs1.getString("CONT_MIDDLE"));
				previewbean.setPreview_siteOwnerLastName(rs1.getString("CONT_LASTTNAME"));
				previewbean.setPreview_siteOwnerTitle(rs1.getString("CONT_TITLE"));
				previewbean.setPreview_siteOwnerCompany(rs1.getString("CONT_COMPANY"));
				previewbean.setPreview_siteOwnerAddress(rs1.getString("CONT_ADDRESS"));
				previewbean.setPreview_siteOwnerCity(rs1.getString("CONT_CITY"));
				previewbean.setPreview_siteOwnerstateSelect(rs1.getString("CONT_SELSTATE"));
				previewbean.setPreview_siteOwnerZip(rs1.getString("CONT_ZIP"));
				previewbean.setPreview_siteOwnerphone(rs1.getString("CONT_PHONE"));
				previewbean.setPreview_siteOwnerphoneEXT(rs1.getString("CONT_PHONE_EXT"));
				//this is the Certifier\Approver Email who will certify this document
				previewbean.setPreview_siteOwnerEmail(rs1.getString("CONT_EMAIL"));
				
				
				previewbean.setPreview_opocFirstName(rs1.getString("OPT_FIRSTNAME"));
				previewbean.setPreview_opocMiddleName(rs1.getString("OPT_MIDDLE"));
				previewbean.setPreview_opocLastName(rs1.getString("OPT_LASTTNAME"));
				previewbean.setPreview_opocTitle(rs1.getString("OPT_TITLE"));
				previewbean.setPreview_opocCompany(rs1.getString("OPT_COMPANY"));
				previewbean.setPreview_opocAddress(rs1.getString("OPT_ADDRESS"));
				previewbean.setPreview_opocCity(rs1.getString("OPT_CITY"));
				previewbean.setPreview_opocstateSelect(rs1.getString("OPT_SELSTATE"));
				previewbean.setPreview_opocZip(rs1.getString("OPT_ZIP"));
				previewbean.setPreview_opocPhone(rs1.getString("OPT_PHONE"));
				previewbean.setPreview_opocPhoneExt(rs1.getString("OPT_PHONE_EXT"));
				previewbean.setPreview_opocEmail(rs1.getString("OPT_EMAIL"));
			
				
				
				
				
				previewbean.setPreview_projName(rs1.getString("SITE_NAME"));
				previewbean.setPreview_projDescription(rs1.getString("DESCRIPTION"));
				previewbean.setPreview_projAddress(rs1.getString("ADDRESS"));
				previewbean.setPreview_projCity(rs1.getString("CITY"));
				previewbean.setPreview_projZip(rs1.getString("ZIP"));
				previewbean.setPreview_projCounty(rs1.getString("COUNTY"));
				previewbean.setPreview_projStartDate(rs1.getDate("START_DATE"));
				previewbean.setPreview_projEndDate(rs1.getDate("END_DATE"));
				previewbean.setPreview_projEADisturbed(rs1.getString("AREA_DISTURBED"));
				previewbean.setPreview_projTotalSiteAcres(rs1.getString("TOTALACRE"));
				
				
				previewbean.setPreview_selecSFResi(rs1.getString("SF_RESI"));
				previewbean.setPreview_selecMFResi(rs1.getString("MF_RESI"));	
				previewbean.setPreview_selecCommercial(rs1.getString("COMMERCIAL"));
				previewbean.setPreview_selecIndustrial(rs1.getString("INDUSTRIAL"));
				previewbean.setPreview_selecInstitutional(rs1.getString("INSTITUTIONAL"));
				previewbean.setPreview_selecHywayRoad(rs1.getString("HWY_ROAD"));
				previewbean.setPreview_selecUtility(rs1.getString("UTILITY"));
				previewbean.setPreview_selecOther(rs1.getString("OTHER"));
				
			   
				
				previewbean.setPreview_Latitude(rs1.getString("LATITUDE"));
				previewbean.setPreview_Longitude(rs1.getString("LONGITUDE"));
				
				
				previewbean.setPreview_DischargeMS4(rs1.getString("DISMS4"));
				previewbean.setPreview_Discharge50FtDisturbance(rs1.getString("DIS50FEET"));
				previewbean.setPreview_MS4Jurisdiction(rs1.getString("MS4JURISDICTION"));
				
				previewbean.setPreview_DischargeID(rs1.getString("DISDISCHARGEID"));
				previewbean.setPreview_DischargeReceavingWater(rs1.getString("DISRECIEVINGWATER"));
				previewbean.setPreview_DischargeDescription(rs1.getString("DISDESCRIPTION"));
				previewbean.setPreview_DischargeCWA(rs1.getString("DISCWA303"));
				previewbean.setPreview_DischargeTMDL(rs1.getString("DISTMDL"));
				
				
				
				previewbean.setPreview_swpppPreparedAdvance(rs1.getString("SWPPP_PREP_ADVANCE"));
				
	//			previewbean.setPreview_stateSelectOption("Tennessee");
				
				previewbean.setPreview_Status(rs1.getString("DISCWA303"));
				
			
					   
					     
				}
        
			
		} catch (SQLException ex) {
			
			logger.error(" call to the database table NOI_Master using unique ID FAILED ..... " + ex.getMessage());		
			
			ex.printStackTrace();
		} finally {
			DataConnect.close(con);
		
		}
		return previewbean;
	}
	
	

	
	public static boolean updateNoiOperatorRecord(Noi  noiform2) {
		Connection con = null;
		PreparedStatement ps = null;
		
		
		
		//Permit Information
				String npdesPermitCoverage11 = noiform2.getNpdesPermitSelect1();
				String currentNpdesId22 = noiform2.getNpdesID();
				String cgpAuthorized33 = noiform2.getNpdesPermitSelect2();
				
				
				//Contact Information
				String opprimaryPermitte44 = noiform2.getOpprimaryPermitte();
				String sosControlNumber55  = noiform2.getSosControlNumber();
				String ownershipSelect66   = noiform2.getOwnershipSelect();
				String siteOwnerFirstName77 = noiform2.getSiteOwnerFirstName();  
				String siteOwnerMiddleName88 = noiform2.getSiteOwnerMiddleName();
				String siteOwnerLastName99 = noiform2.getSiteOwnerLastName(); 
				String siteOwnerTitle100   = noiform2.getSiteOwnerTitle(); 
				String siteOwnerCompany111 = noiform2.getSiteOwnerCompany();
				String siteOwnerAddress122 = noiform2.getSiteOwnerAddress();
				String siteOwnerCity133    = noiform2.getSiteOwnerCity();
				String siteOwnerstateSelect144 = noiform2.getSiteOwnerstateSelect(); 
				String siteOwnerZip155     = noiform2.getSiteOwnerZip();
				String siteOwnerphone166   = noiform2.getSiteOwnerphone();
				String siteOwnerphoneEXT177 = noiform2.getSiteOwnerphoneEXT();
				String siteOwnerEmail188   = noiform2.getSiteOwnerEmail();
				
				String opecfirstname199 = noiform2.getOpocFirstName();
				String opecmiddle200 = noiform2.getOpocMiddleName();
				String opeclastname211 = noiform2.getOpocLastName();
				String opectitle222 = noiform2.getOpocTitle();
				String opocCompany233 = noiform2.getOpocCompany();
				String opocAddress244 = noiform2.getOpocAddress();
				String opocCity255 = noiform2.getOpocCity();
				String opocstateSelect266 = noiform2.getOpocstateSelect();
				String opocZip277 = noiform2.getOpocZip();		
				String opecphone288 = noiform2.getOpocPhone();
				String opecphoneext299 = noiform2.getOpocPhoneExt();
				String opecemail300 =noiform2.getOpocEmail();
				
				

				//operator Project Site Information		
				String sitename311 = noiform2.getProjName();
				String siteDescription322 = noiform2.getProjDescription();
				String projSiteaddress333 = noiform2.getProjAddress();
				String projSitecity344 = noiform2.getProjCity();
				//String projState35 = noiform2.getProjState();
				String projSitezip366 = noiform2.getProjZip();
				String county377 = noiform2.getProjCounty();		
				String startdate388 = noiform2.getProjStartDate().toString();
				String enddate399 = noiform2.getProjEndDate().toString();
				String areadisturbed400 = noiform2.getProjEADisturbed();
				
				String projTotalSiteAcres411 = noiform2.getProjTotalSiteAcres();

				//---------------------TODO
			/*	List selectedConstructionCheckBo = noiform2.getSelectedConstructionCheckBo();
				
				 for (String name:selectedConstructionCheckBo)
			        {
			           boolean projTOC_SingleFamilyResi42 = name.equalsIgnoreCase("Single-Family Residential");
			            	 
			           projTOC_SingleFamilyResi = "Single-Family Residential"
			            
			        }
				*/
				//---------------------
				String projTOC_SingleFamilyResi422 = "";
				String mf_resi433 = noiform2.getProjTOC_MultiFamilyResi();
				String commercial444 = noiform2.getProjTOC_Commercial();
				String industrial455 = noiform2.getProjTOC_Industrial();
				String institutional466 = noiform2.getProjTOC_Institutional();
				String hywayRoad477 = noiform2.getProjTOC_HYWY();
				String utility488 = noiform2.getProjTOC_Utility();
				String other499 = noiform2.getProjTOC_Other();
				
				
				
				
				
				//Latitude Longitude
				//String latlongsource31 = noiform2.getProjLatLongSource();
				//String datumsource32 = noiform2.getProjDatumSource();
				String latitude500 = noiform2.getProjLatitude();
				String longitude511 = noiform2.getProjLongitude();
				
				//Discharge Water  Information
				String disMS4522 = noiform2.getProjDischargeMS4();
				String dis50Feet533 = noiform2.getProjDischarge50FtDisturbance();
				String disDischargeID544 = noiform2.getProjDischargeID();
				String disRecievingWater555 = noiform2.getProjDischargeReceavingWater();
				String disDescription566 = noiform2.getProjDischargeDescription();
				String disCWA303577 = noiform2.getProjDischargeCWA();
				String disTMDL588 = noiform2.getProjDischargeTMDL();
				
				String discMS4Jurisdiction599 = noiform2.getProjMS4Jurisdiction();
				
				String swpp_PREP_ADVANCE677 = noiform2.getSwpppPreparedAdvance();
				
				String defaultState777 ="Tennessee";
				
				
				
				ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			    Login firstBean = (Login) elContext.getELResolver().getValue(elContext, null, "Login");
			    
			    String userid788 = firstBean.getUniqueId();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
				String lastupdated799 = ZonedDateTime.now().format(formatter);
		
	
		try {	
			con = DataConnect.getConnection();   
			String query  ="";
			
			
			
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
			                + ",OPT_EMAIL,='"+ opecemail300+"'"
			               
			                
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
							
							+ ",SWPPP_PREP_ADVANCE='"+ swpp_PREP_ADVANCE677+"'"
					
							+ ",LASTUPDATED='"+ lastupdated799+"'"
							+ ",DefaultSTATE='"+ defaultState777+"'"
							
							+ " WHERE USERID ='"+ userid788+"'";
			
		
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

	
	
	
	
	
	
	
	
}