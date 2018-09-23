package tn.gov.nashville.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import tn.gov.nashville.beans.Login;
import tn.gov.nashville.beans.Noi;
import tn.gov.nashville.util.DataConnect;





public class NoiFormCommon_DAO {
	
	public static Logger logger = Logger.getLogger(NoiFormCommon_DAO.class);
	
static String noissoid;
	

	public static String getNoissoid() {
		return noissoid;
	}


	public static void setNoissoid(String noissoid) {
		NoiFormCommon_DAO.noissoid = noissoid;
	}
	


	public static boolean selectNoiFormMaster(Noi  noiform) {
		
		String abcid = getNoissoid();
		
		
		logger.info(" selectNoiRecord function..... "); 
		Connection con = null;
		PreparedStatement ps = null;
		boolean noiRecord = false;

		
		String uniqueId = abcid;
		

	

		try {
			
			
			con = DataConnect.getConnection();   
			logger.info(" database connection Sucess..... "); 

			
			String query1 = "select CURRENT_NPDES_ID  from BG_CROMERR.NOI_MASTER where USERID = '" + uniqueId+"'";
			
		
			 ps = con.prepareStatement(query1);
			 
				logger.info(" query created, executing query ..... " +query1); 
				ResultSet rs1 = ps.executeQuery();
				
				if (rs1.next()) {
					
					String npdesID = rs1.getString("CURRENT_NPDES_ID");
					if (npdesID.equalsIgnoreCase(noiform.getNpdesID()))
						
					{	
						
					logger.error(" Record Already Exist for this CURRENT_NPDES_ID please use the Different NPDES_ID Number..... " +query1);
						 
					noiRecord = true;
					}else{
					
					 noiRecord = false;	
					}
					
					
				return noiRecord;
				}
		} catch (SQLException ex) {
			
			logger.error(" call to the database table NOI_Master using unique ID FAILED ..... " + ex.getMessage());		
		return false;	
		} finally {
			DataConnect.close(con);
		
		}
		return false;
	}
	
	
	public static boolean checkorInsertNoiFormCommon(Noi  noiform1){
		
	boolean  xyz =	selectNoiFormMaster(noiform1);
		
		if(xyz){
			
		return false;
		}else{
			boolean  abc =  insertNoiFormMaster(noiform1);
		
			if(abc){
		return true	;
			}
		}
         return false; 		
	    }
		
	
	

public static boolean insertNoiFormMaster(Noi  noiform1) {
	
	
	String abcid11 = getNoissoid();
	     
		
		Connection con = null;
		PreparedStatement ps = null;
		
		//Permit Information
		String npdesPermitCoverage1 = noiform1.getNpdesPermitSelect1();
		String currentNpdesId2 = noiform1.getNpdesID();
		String cgpAuthorized3 = noiform1.getNpdesPermitSelect2();
		
		
		//Contact Information
		String opprimaryPermitte4 = noiform1.getOpprimaryPermitte();
		String sosControlNumber5  = noiform1.getSosControlNumber();
		String ownershipSelect6   = noiform1.getOwnershipSelect();
		String siteOwnerFirstName7 = noiform1.getSiteOwnerFirstName();  
		String siteOwnerMiddleName8 = noiform1.getSiteOwnerMiddleName();
		String siteOwnerLastName9 = noiform1.getSiteOwnerLastName(); 
		String siteOwnerTitle10   = noiform1.getSiteOwnerTitle();// coming Null 
		String siteOwnerCompany11 = noiform1.getSiteOwnerCompany();//coming Null
		String siteOwnerAddress12 = noiform1.getSiteOwnerAddress();//coming Null
		String siteOwnerCity13    = noiform1.getSiteOwnerCity();
		String siteOwnerstateSelect14 = noiform1.getSiteOwnerstateSelect(); 
		String siteOwnerZip15     = noiform1.getSiteOwnerZip();
		String siteOwnerphone16   = noiform1.getSiteOwnerphone();
		String siteOwnerphoneEXT17 = noiform1.getSiteOwnerphoneEXT();
		String siteOwnerEmail18   = noiform1.getSiteOwnerEmail();
		
		String opecfirstname19 = noiform1.getOpocFirstName();
		String opecmiddle20 = noiform1.getOpocMiddleName();
		String opeclastname21 = noiform1.getOpocLastName();
		String opectitle22 = noiform1.getOpocTitle();
		String opocCompany23 = noiform1.getOpocCompany();
		String opocAddress24 = noiform1.getOpocAddress();
		String opocCity25 = noiform1.getOpocCity();
		String opocstateSelect26 = noiform1.getOpocstateSelect(); //coming Null
		String opocZip27 = noiform1.getOpocZip();		
		String opecphone28 = noiform1.getOpocPhone();
		String opecphoneext29 = noiform1.getOpocPhoneExt();
		String opecemail30 =noiform1.getOpocEmail();
		
		

		//operator Project Site Information		
		String sitename31 = noiform1.getProjName();
		String siteDescription32 = noiform1.getProjDescription();
		String projSiteaddress33 = noiform1.getProjAddress();
		String projSitecity34 = noiform1.getProjCity();
		//String projState35 = noiform1.getProjState();
		String projSitezip36 = noiform1.getProjZip();
		String county37 = noiform1.getProjCounty();		
		String startdate38 = noiform1.getProjStartDate().toString();
		String enddate39 = noiform1.getProjEndDate().toString();
		String areadisturbed40 = noiform1.getProjEADisturbed();
		
		String projTotalSiteAcres41 = noiform1.getProjTotalSiteAcres();

		//---------------------TODO
	/*	List selectedConstructionCheckBo = noiform1.getSelectedConstructionCheckBo();
		
		 for (String name:selectedConstructionCheckBo)
	        {
	           boolean projTOC_SingleFamilyResi42 = name.equalsIgnoreCase("Single-Family Residential");
	            	 
	           projTOC_SingleFamilyResi = "Single-Family Residential"
	            
	        }
		*/
		//---------------------
		String projTOC_SingleFamilyResi42 = "";
		String mf_resi43 = noiform1.getProjTOC_MultiFamilyResi();
		String commercial44 = noiform1.getProjTOC_Commercial();
		String industrial45 = noiform1.getProjTOC_Industrial();
		String institutional46 = noiform1.getProjTOC_Institutional();
		String hywayRoad47 = noiform1.getProjTOC_HYWY();
		String utility48 = noiform1.getProjTOC_Utility();
		String other49 = noiform1.getProjTOC_Other();
		
		
		
		
		
		//Latitude Longitude
		//String latlongsource31 = noiform1.getProjLatLongSource();
		//String datumsource32 = noiform1.getProjDatumSource();
		String latitude50 = noiform1.getProjLatitude();
		String longitude51 = noiform1.getProjLongitude();
		
		//Discharge Water  Information
		String disMS452 = noiform1.getProjDischargeMS4();
		String dis50Feet53 = noiform1.getProjDischarge50FtDisturbance();
		String disDischargeID54 = noiform1.getProjDischargeID();
		String disRecievingWater55 = noiform1.getProjDischargeReceavingWater();
		String disDescription56 = noiform1.getProjDischargeDescription();
		String disCWA30357 = noiform1.getProjDischargeCWA();
		String disTMDL58 = noiform1.getProjDischargeTMDL();
		
		String discMS4Jurisdiction59 = noiform1.getProjMS4Jurisdiction();
		
		//SWPPP Information
	/*	String swppFIRST_NAME59 = noiform1.getSwpppFirstName();
		String swppMIDDLE60 = noiform1.getSwpppMiddleName();
		String swppLAST_NAME61 = noiform1.getSwpppLastName();
		String swppORG62 = noiform1.getSwpppOrg();
		String swppTITLE63 = noiform1.getSwpppTitle();
		String swppPHONE64 = noiform1.getSwpppPhone();
		String swppPHONE_EXT65 = noiform1.getSwpppPhoneExt();
		String swppEMAIL66 = noiform1.getSwpppEmail();
	*/
		String swpp_PREP_ADVANCE67 = noiform1.getSwpppPreparedAdvance();
		
		
		//ESP info
	/*	String espcriterion68 = noiform1.getEspCriterion();
		String espsummary69 = noiform1.getEspCriterionSummary();
	*/
		
		
		// Certification Info
	/*	
		String certUserID70 = noiform1.getCertInfoUserID();
		String certfirstName71 = noiform1.getCertInfoFirstName();
		String certmiddleName72 = noiform1.getCertInfoMiddleName();
		String certlastName73 = noiform1.getCertInfoLastName();
		String certOrg74 = noiform1.getCertInfoOrganization();
		String certEmail75 = noiform1.getCertInfoEmail();
		String certAddress76 = noiform1.getCertInfoAddress();
	*/	
		
		String defaultState77 ="Tennessee";
		String defaultStatus = "Draft";
		
		
	//	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	//    Login firstBean = (Login) elContext.getELResolver().getValue(elContext, null, "Login");
	    
	//    String userid78 = firstBean.getUniqueId();
		
		String userid78 = abcid11;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String lastupdated79 = ZonedDateTime.now().format(formatter);
		
		
		
		
		
		logger.info(" got the values from the Noi Operator form  ..... ");
	
		try {
			con = DataConnect.getConnection();
	
				String query = "INSERT INTO BG_CROMERR.NOI_MASTER (NPDES_PERMIT_COVERAGE,CURRENT_NPDES_ID,CGP_AUTHORIZED,"
						 
				+ "PRIMARYPERMIT,SOSCN,OWNERSHIP,CONT_FIRSTNAME,CONT_MIDDLE,CONT_LASTTNAME,CONT_TITLE,CONT_COMPANY,"
				+ "CONT_ADDRESS,CONT_CITY,CONT_SELSTATE,CONT_ZIP,CONT_PHONE,CONT_PHONE_EXT,CONT_EMAIL,"
            + "OPT_FIRSTNAME,OPT_MIDDLE,OPT_LASTTNAME,OPT_TITLE,OPT_COMPANY,OPT_ADDRESS,OPT_CITY,OPT_SELSTATE,OPT_ZIP,OPT_PHONE,OPT_PHONE_EXT,OPT_EMAIL,"

          
				+"site_name,Description,address,city,zip,county,start_date,end_date,area_disturbed,totalacre,"
				+ "sf_resi,mf_resi,commercial,industrial,institutional,hwy_road,utility,other,"
				
				
				+"latitude, longitude,"
				

				+ "disMS4,dis50Feet,disDischargeID,disRecievingWater,disDescription,disCWA303,disTMDL,"

			//	+"swppFIRST_NAME,swppMIDDLE,swppLAST_NAME,swppORGANIZATION,swppTITLE,swppPHONE,swppPHONE_EXT,swppEMAIL,SWPPP_PREP_ADVANCE,"
			
				+"MS4Jurisdiction,SWPPP_PREP_ADVANCE,"

			//	+"ESP_CRITERION,ESP_SUMMARY,"

			//	+"CERT_USERID,CERT_FIRSTNAME,CERT_MIDDLE,CERT_LASTNAME,CERT_ORG,CERT_EMAIL,CERT_ADDRESS,"
				
				+ "USERID,LASTUPDATED,DefaultSTATE,STATUS)"

				+ "" + " VALUES('" + npdesPermitCoverage1 + "'" + "," + "'" + currentNpdesId2 + "','" + cgpAuthorized3 
					
+ "','" + opprimaryPermitte4 + "','" + sosControlNumber5 + "','" + ownershipSelect6 + "','" + siteOwnerFirstName7 + "'" + "," + "'" + siteOwnerMiddleName8
+ "','" + siteOwnerLastName9 + "','" + siteOwnerTitle10 + "','" + siteOwnerCompany11 + "','" + siteOwnerAddress12 + "'" + "," + "'" + siteOwnerCity13
+ "','" + siteOwnerstateSelect14 + "','" + siteOwnerZip15 + "','" + siteOwnerphone16 + "','" + siteOwnerphoneEXT17 + "'" + "," + "'" + siteOwnerEmail18
+ "','" + opecfirstname19 + "','" + opecmiddle20 + "','" + opeclastname21 + "','" + opectitle22 + "'" + "," + "'" + opocCompany23
+ "','" + opocAddress24 + "','" + opocCity25 + "','" + opocstateSelect26 + "','" + opocZip27 + "'" + "," + "'" + opecphone28
+ "','" + opecphoneext29 + "','" + opecemail30



+ "','" + sitename31 + "','" + siteDescription32 + "','" + projSiteaddress33 + "','" + projSitecity34 + "'" + "," + "'" + projSitezip36
+ "','" + county37 + "','" + startdate38 + "','" + enddate39 + "','" + areadisturbed40 + "'" + "," + "'" + projTotalSiteAcres41
+ "','" + projTOC_SingleFamilyResi42 + "','" + mf_resi43 + "','" + commercial44 + "','" + industrial45 + "'" + "," + "'" + institutional46
				+ "','" + hywayRoad47 + "','" + utility48 + "','" + other49 
			
				
				+ "','" + latitude50 + "','" + longitude51 
			
				
				+ "','" + disMS452 + "','" + dis50Feet53 + "','" + disDischargeID54 + "','" + disRecievingWater55 + "'" + "," + "'" + disDescription56
				+ "','" + disCWA30357 + "','" + disTMDL58 
				
				
				+ "','" + discMS4Jurisdiction59 + "','" + swpp_PREP_ADVANCE67 
			
		//	+ "','" + swppFIRST_NAME59 + "','" + swppMIDDLE60 + "','" + swppLAST_NAME61 + "','" + swppORG62 + "'" + "," + "'" + swppTITLE63
		//		+ "','" + swppPHONE64 + "','" + swppPHONE_EXT65 + "','" + swppEMAIL66 + "','" + swpp_PREP_ADVANCE67 
				
				
				
			//	+ "','" + espcriterion68 + "','" + espsummary69  
				
				
				
				
			//	+ "','" + certUserID70 + "','" + certfirstName71 + "','" + certmiddleName72 + "','" + certlastName73 + "'" + "," + "'" + certOrg74
			//	+ "','" + certEmail75 + "','" + certAddress76
				
				
				
				+ "','" + userid78 + "','" + lastupdated79 + "','" + defaultState77 + "','" + defaultStatus + "')";
				
				
				
		
				
				
				
				
				
				
				
				
			    ps = con.prepareStatement(query);
			    
			    ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					return true;
				}
				
				logger.info(" NOI Operator info is added Sucess  ..... ");
				
				
		} catch (SQLException ex) {
			System.out.println("Error While Adding data to NOI Master Table -->" + ex.getMessage());
			
			return false;	
		} finally {
			DataConnect.close(con);
		}
	
		return false;	
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
				//SWPPP Information
			/*	String swppFIRST_NAME599 = noiform2.getSwpppFirstName();
				String swppMIDDLE600 = noiform2.getSwpppMiddleName();
				String swppLAST_NAME611 = noiform2.getSwpppLastName();
				String swppORG622 = noiform2.getSwpppOrg();
				String swppTITLE633 = noiform2.getSwpppTitle();
				String swppPHONE644 = noiform2.getSwpppPhone();
				String swppPHONE_EXT655 = noiform2.getSwpppPhoneExt();
				String swppEMAIL666 = noiform2.getSwpppEmail();
				*/
				String swpp_PREP_ADVANCE677 = noiform2.getSwpppPreparedAdvance();
				
				
				//ESP info
			/*	String espcriterion688 = noiform2.getEspCriterion();
				String espsummary699 = noiform2.getEspCriterionSummary();
				
				// Certification Info
				
				String certUserID700 = noiform2.getCertInfoUserID();
				String certfirstName711 = noiform2.getCertInfoFirstName();
				String certmiddleName722 = noiform2.getCertInfoMiddleName();
				String certlastName733 = noiform2.getCertInfoLastName();
				String certOrg744 = noiform2.getCertInfoOrganization();
				String certEmail755 = noiform2.getCertInfoEmail();
				String certAddress766 = noiform2.getCertInfoAddress();
			*/	
				
				String defaultState777 ="Tennessee";
				
				
				
				ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			    Login firstBean = (Login) elContext.getELResolver().getValue(elContext, null, "Login");
			    
			    String userid788 = firstBean.getUniqueId();
				
				//String userid78 = "64";
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
				String lastupdated799 = ZonedDateTime.now().format(formatter);
		
	//	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		//String lastupdated2 = ZonedDateTime.now().format(formatter2);
		
		
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
				
				if (rs1.next()) {
					
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