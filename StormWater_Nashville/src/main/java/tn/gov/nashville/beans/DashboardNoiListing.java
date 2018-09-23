package tn.gov.nashville.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import tn.gov.nashville.dao.CertifierCommon_DAO;
import tn.gov.nashville.dao.NoiFormCommon_DAO;
import tn.gov.nashville.dao.Noi_DAO;

import org.apache.log4j.Logger;


@ManagedBean(name="dashboardNoi")
@javax.faces.bean.ViewScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardNoiListing implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{login}")  
	  Login login;
	
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login loginBean) {
		this.login = login;
	}
	
	
	private String npdesPermitSelect1;
	private String npdesPermitSelect2;
	
	@ManagedProperty(value="#{npdesID3}")
	private String npdesID3;
	
	
	
	
	private String opprimaryPermitte4;
	private String sosControlNumber5;
	private String ownershipSelect6;
	private String siteOwnerFirstName7;
	private String siteOwnerMiddleName8;
	private String siteOwnerLastName9;
	private String siteOwnerTitle10;
	private String siteOwnerCompany11;
	private String siteOwnerAddress12;
	private String siteOwnerCity13;
	private String siteOwnerstateSelect14;
	private String siteOwnerZip15;
	private String siteOwnerphone16;
	private String siteOwnerphoneEXT17;
	private String siteOwnerEmail18;
	private String opocFirstName19;
	private String opocMiddleName20;
	private String opocLastName21;
	private String opocTitle22;
	private String opocCompany23;
	private String opocAddress24;
	private String opocCity25;
	private String opocstateSelect26;
	private String opocZip27;
	private String opocPhone28;
	private String opocPhoneExt29;
	private String opocEmail30;
	
	
	
	private String projName31;
	private String projDescription32;
	private String projAddress33;
	private String projCity34;
	private String projState35;
	private String projZip36;
	private String projCounty37;
	private Date   projStartDate38;
	private Date   projEndDate39;
	private String projEADisturbed40;
	private String projTotalSiteAcres41;
	private String[] selectedConstructionCheckBo42;
	

	

	private String projTOC_SingleFamilyResi43 ;
	private String projTOC_MultiFamilyResi44;
	private String projTOC_Commercial45;
	private String projTOC_Industrial46;
	private String projTOC_Institutional47;
	private String projTOC_HYWY48;
	private String projTOC_Utility49;
	private String projTOC_Other50;
	
	
	
	
	
	private String projLatitude51;
	private String projLongitude52;	
	private String projLatLongSource53;
	private String projDatumSource54;
	
	
	
	

	
	private String projDischargeMS455;
	private String projDischarge50FtDisturbance56;
	private String projMS4Jurisdiction57;
	
	

	private String projDischargeID58;
	private String projDischargeReceavingWater59;
	private String projDischargeDescription60;
	private String projDischargeCWA61;
	private String projDischargeTMDL62;
	

	private String swpppPreparedAdvance63;
	
	
	private String stateSelectOption64;
	

	private boolean noiUserExist65;
	
	private String loginSSOID66;
	
	private String checkPreparer67;
	private String checkCertifier68;
	private String status69;
	
	
	private String lastUpdated70;
	
	private String noiMasterID;
	
	private String twofactorSecurityQuestion;
	private String twofactorSecurityAns;
	
	
	public String getTwofactorSecurityQuestion() {
		return twofactorSecurityQuestion;
	}
	public void setTwofactorSecurityQuestion(String twofactorSecurityQuestion) {
		this.twofactorSecurityQuestion = twofactorSecurityQuestion;
	}
	public String getTwofactorSecurityAns() {
		return twofactorSecurityAns;
	}
	public void setTwofactorSecurityAns(String twofactorSecurityAns) {
		this.twofactorSecurityAns = twofactorSecurityAns;
	}


	
	
	
	public String getNoiMasterID() {
		return noiMasterID;
	}
	public void setNoiMasterID(String noiMasterID) {
		this.noiMasterID = noiMasterID;
	}
	
	
	
	public String getNpdesPermitSelect1() {
		return npdesPermitSelect1;
	}
	public void setNpdesPermitSelect1(String npdesPermitSelect1) {
		this.npdesPermitSelect1 = npdesPermitSelect1;
	}
	public String getNpdesPermitSelect2() {
		return npdesPermitSelect2;
	}
	public void setNpdesPermitSelect2(String npdesPermitSelect2) {
		this.npdesPermitSelect2 = npdesPermitSelect2;
	}
	public String getNpdesID3() {
		return npdesID3;
	}
	public void setNpdesID3(String npdesID3) {
		this.npdesID3 = npdesID3;
	}
	public String getOpprimaryPermitte4() {
		return opprimaryPermitte4;
	}
	public void setOpprimaryPermitte4(String opprimaryPermitte4) {
		this.opprimaryPermitte4 = opprimaryPermitte4;
	}
	public String getSosControlNumber5() {
		return sosControlNumber5;
	}
	public void setSosControlNumber5(String sosControlNumber5) {
		this.sosControlNumber5 = sosControlNumber5;
	}
	public String getOwnershipSelect6() {
		return ownershipSelect6;
	}
	public void setOwnershipSelect6(String ownershipSelect6) {
		this.ownershipSelect6 = ownershipSelect6;
	}
	public String getSiteOwnerFirstName7() {
		return siteOwnerFirstName7;
	}
	public void setSiteOwnerFirstName7(String siteOwnerFirstName7) {
		this.siteOwnerFirstName7 = siteOwnerFirstName7;
	}
	public String getSiteOwnerMiddleName8() {
		return siteOwnerMiddleName8;
	}
	public void setSiteOwnerMiddleName8(String siteOwnerMiddleName8) {
		this.siteOwnerMiddleName8 = siteOwnerMiddleName8;
	}
	public String getSiteOwnerLastName9() {
		return siteOwnerLastName9;
	}
	public void setSiteOwnerLastName9(String siteOwnerLastName9) {
		this.siteOwnerLastName9 = siteOwnerLastName9;
	}
	public String getSiteOwnerTitle10() {
		return siteOwnerTitle10;
	}
	public void setSiteOwnerTitle10(String siteOwnerTitle10) {
		this.siteOwnerTitle10 = siteOwnerTitle10;
	}
	public String getSiteOwnerCompany11() {
		return siteOwnerCompany11;
	}
	public void setSiteOwnerCompany11(String siteOwnerCompany11) {
		this.siteOwnerCompany11 = siteOwnerCompany11;
	}
	public String getSiteOwnerAddress12() {
		return siteOwnerAddress12;
	}
	public void setSiteOwnerAddress12(String siteOwnerAddress12) {
		this.siteOwnerAddress12 = siteOwnerAddress12;
	}
	public String getSiteOwnerCity13() {
		return siteOwnerCity13;
	}
	public void setSiteOwnerCity13(String siteOwnerCity13) {
		this.siteOwnerCity13 = siteOwnerCity13;
	}
	public String getSiteOwnerstateSelect14() {
		return siteOwnerstateSelect14;
	}
	public void setSiteOwnerstateSelect14(String siteOwnerstateSelect14) {
		this.siteOwnerstateSelect14 = siteOwnerstateSelect14;
	}
	public String getSiteOwnerZip15() {
		return siteOwnerZip15;
	}
	public void setSiteOwnerZip15(String siteOwnerZip15) {
		this.siteOwnerZip15 = siteOwnerZip15;
	}
	public String getSiteOwnerphone16() {
		return siteOwnerphone16;
	}
	public void setSiteOwnerphone16(String siteOwnerphone16) {
		this.siteOwnerphone16 = siteOwnerphone16;
	}
	public String getSiteOwnerphoneEXT17() {
		return siteOwnerphoneEXT17;
	}
	public void setSiteOwnerphoneEXT17(String siteOwnerphoneEXT17) {
		this.siteOwnerphoneEXT17 = siteOwnerphoneEXT17;
	}
	public String getSiteOwnerEmail18() {
		return siteOwnerEmail18;
	}
	public void setSiteOwnerEmail18(String siteOwnerEmail18) {
		this.siteOwnerEmail18 = siteOwnerEmail18;
	}
	public String getOpocFirstName19() {
		return opocFirstName19;
	}
	public void setOpocFirstName19(String opocFirstName19) {
		this.opocFirstName19 = opocFirstName19;
	}
	public String getOpocMiddleName20() {
		return opocMiddleName20;
	}
	public void setOpocMiddleName20(String opocMiddleName20) {
		this.opocMiddleName20 = opocMiddleName20;
	}
	public String getOpocLastName21() {
		return opocLastName21;
	}
	public void setOpocLastName21(String opocLastName21) {
		this.opocLastName21 = opocLastName21;
	}
	public String getOpocTitle22() {
		return opocTitle22;
	}
	public void setOpocTitle22(String opocTitle22) {
		this.opocTitle22 = opocTitle22;
	}
	public String getOpocCompany23() {
		return opocCompany23;
	}
	public void setOpocCompany23(String opocCompany23) {
		this.opocCompany23 = opocCompany23;
	}
	public String getOpocAddress24() {
		return opocAddress24;
	}
	public void setOpocAddress24(String opocAddress24) {
		this.opocAddress24 = opocAddress24;
	}
	public String getOpocCity25() {
		return opocCity25;
	}
	public void setOpocCity25(String opocCity25) {
		this.opocCity25 = opocCity25;
	}
	public String getOpocstateSelect26() {
		return opocstateSelect26;
	}
	public void setOpocstateSelect26(String opocstateSelect26) {
		this.opocstateSelect26 = opocstateSelect26;
	}
	public String getOpocZip27() {
		return opocZip27;
	}
	public void setOpocZip27(String opocZip27) {
		this.opocZip27 = opocZip27;
	}
	public String getOpocPhone28() {
		return opocPhone28;
	}
	public void setOpocPhone28(String opocPhone28) {
		this.opocPhone28 = opocPhone28;
	}
	public String getOpocPhoneExt29() {
		return opocPhoneExt29;
	}
	public void setOpocPhoneExt29(String opocPhoneExt29) {
		this.opocPhoneExt29 = opocPhoneExt29;
	}
	public String getOpocEmail30() {
		return opocEmail30;
	}
	public void setOpocEmail30(String opocEmail30) {
		this.opocEmail30 = opocEmail30;
	}
	public String getProjName31() {
		return projName31;
	}
	public void setProjName31(String projName31) {
		this.projName31 = projName31;
	}
	public String getProjDescription32() {
		return projDescription32;
	}
	public void setProjDescription32(String projDescription32) {
		this.projDescription32 = projDescription32;
	}
	public String getProjAddress33() {
		return projAddress33;
	}
	public void setProjAddress33(String projAddress33) {
		this.projAddress33 = projAddress33;
	}
	public String getProjCity34() {
		return projCity34;
	}
	public void setProjCity34(String projCity34) {
		this.projCity34 = projCity34;
	}
	public String getProjState35() {
		return projState35;
	}
	public void setProjState35(String projState35) {
		this.projState35 = projState35;
	}
	public String getProjZip36() {
		return projZip36;
	}
	public void setProjZip36(String projZip36) {
		this.projZip36 = projZip36;
	}
	public String getProjCounty37() {
		return projCounty37;
	}
	public void setProjCounty37(String projCounty37) {
		this.projCounty37 = projCounty37;
	}
	public Date getProjStartDate38() {
		return projStartDate38;
	}
	public void setProjStartDate38(Date projStartDate38) {
		this.projStartDate38 = projStartDate38;
	}
	public Date getProjEndDate39() {
		return projEndDate39;
	}
	public void setProjEndDate39(Date projEndDate39) {
		this.projEndDate39 = projEndDate39;
	}
	public String getProjEADisturbed40() {
		return projEADisturbed40;
	}
	public void setProjEADisturbed40(String projEADisturbed40) {
		this.projEADisturbed40 = projEADisturbed40;
	}
	public String getProjTotalSiteAcres41() {
		return projTotalSiteAcres41;
	}
	public void setProjTotalSiteAcres41(String projTotalSiteAcres41) {
		this.projTotalSiteAcres41 = projTotalSiteAcres41;
	}
	public String[] getSelectedConstructionCheckBo42() {
		return selectedConstructionCheckBo42;
	}
	public void setSelectedConstructionCheckBo42(
			String[] selectedConstructionCheckBo42) {
		this.selectedConstructionCheckBo42 = selectedConstructionCheckBo42;
	}
	public String getProjTOC_SingleFamilyResi43() {
		return projTOC_SingleFamilyResi43;
	}
	public void setProjTOC_SingleFamilyResi43(String projTOC_SingleFamilyResi43) {
		this.projTOC_SingleFamilyResi43 = projTOC_SingleFamilyResi43;
	}
	public String getProjTOC_MultiFamilyResi44() {
		return projTOC_MultiFamilyResi44;
	}
	public void setProjTOC_MultiFamilyResi44(String projTOC_MultiFamilyResi44) {
		this.projTOC_MultiFamilyResi44 = projTOC_MultiFamilyResi44;
	}
	public String getProjTOC_Commercial45() {
		return projTOC_Commercial45;
	}
	public void setProjTOC_Commercial45(String projTOC_Commercial45) {
		this.projTOC_Commercial45 = projTOC_Commercial45;
	}
	public String getProjTOC_Industrial46() {
		return projTOC_Industrial46;
	}
	public void setProjTOC_Industrial46(String projTOC_Industrial46) {
		this.projTOC_Industrial46 = projTOC_Industrial46;
	}
	public String getProjTOC_Institutional47() {
		return projTOC_Institutional47;
	}
	public void setProjTOC_Institutional47(String projTOC_Institutional47) {
		this.projTOC_Institutional47 = projTOC_Institutional47;
	}
	public String getProjTOC_HYWY48() {
		return projTOC_HYWY48;
	}
	public void setProjTOC_HYWY48(String projTOC_HYWY48) {
		this.projTOC_HYWY48 = projTOC_HYWY48;
	}
	public String getProjTOC_Utility49() {
		return projTOC_Utility49;
	}
	public void setProjTOC_Utility49(String projTOC_Utility49) {
		this.projTOC_Utility49 = projTOC_Utility49;
	}
	public String getProjTOC_Other50() {
		return projTOC_Other50;
	}
	public void setProjTOC_Other50(String projTOC_Other50) {
		this.projTOC_Other50 = projTOC_Other50;
	}
	public String getProjLatitude51() {
		return projLatitude51;
	}
	public void setProjLatitude51(String projLatitude51) {
		this.projLatitude51 = projLatitude51;
	}
	public String getProjLongitude52() {
		return projLongitude52;
	}
	public void setProjLongitude52(String projLongitude52) {
		this.projLongitude52 = projLongitude52;
	}
	public String getProjLatLongSource53() {
		return projLatLongSource53;
	}
	public void setProjLatLongSource53(String projLatLongSource53) {
		this.projLatLongSource53 = projLatLongSource53;
	}
	public String getProjDatumSource54() {
		return projDatumSource54;
	}
	public void setProjDatumSource54(String projDatumSource54) {
		this.projDatumSource54 = projDatumSource54;
	}
	public String getProjDischargeMS455() {
		return projDischargeMS455;
	}
	public void setProjDischargeMS455(String projDischargeMS455) {
		this.projDischargeMS455 = projDischargeMS455;
	}
	public String getProjDischarge50FtDisturbance56() {
		return projDischarge50FtDisturbance56;
	}
	public void setProjDischarge50FtDisturbance56(
			String projDischarge50FtDisturbance56) {
		this.projDischarge50FtDisturbance56 = projDischarge50FtDisturbance56;
	}
	public String getProjMS4Jurisdiction57() {
		return projMS4Jurisdiction57;
	}
	public void setProjMS4Jurisdiction57(String projMS4Jurisdiction57) {
		this.projMS4Jurisdiction57 = projMS4Jurisdiction57;
	}
	public String getProjDischargeID58() {
		return projDischargeID58;
	}
	public void setProjDischargeID58(String projDischargeID58) {
		this.projDischargeID58 = projDischargeID58;
	}
	public String getProjDischargeReceavingWater59() {
		return projDischargeReceavingWater59;
	}
	public void setProjDischargeReceavingWater59(
			String projDischargeReceavingWater59) {
		this.projDischargeReceavingWater59 = projDischargeReceavingWater59;
	}
	public String getProjDischargeDescription60() {
		return projDischargeDescription60;
	}
	public void setProjDischargeDescription60(String projDischargeDescription60) {
		this.projDischargeDescription60 = projDischargeDescription60;
	}
	public String getProjDischargeCWA61() {
		return projDischargeCWA61;
	}
	public void setProjDischargeCWA61(String projDischargeCWA61) {
		this.projDischargeCWA61 = projDischargeCWA61;
	}
	public String getProjDischargeTMDL62() {
		return projDischargeTMDL62;
	}
	public void setProjDischargeTMDL62(String projDischargeTMDL62) {
		this.projDischargeTMDL62 = projDischargeTMDL62;
	}
	public String getSwpppPreparedAdvance63() {
		return swpppPreparedAdvance63;
	}
	public void setSwpppPreparedAdvance63(String swpppPreparedAdvance63) {
		this.swpppPreparedAdvance63 = swpppPreparedAdvance63;
	}
	public String getStateSelectOption64() {
		return stateSelectOption64;
	}
	public void setStateSelectOption64(String stateSelectOption64) {
		this.stateSelectOption64 = stateSelectOption64;
	}
	public boolean isNoiUserExist65() {
		return noiUserExist65;
	}
	public void setNoiUserExist65(boolean noiUserExist65) {
		this.noiUserExist65 = noiUserExist65;
	}
	public String getLoginSSOID66() {
		return loginSSOID66;
	}
	public void setLoginSSOID66(String loginSSOID66) {
		this.loginSSOID66 = loginSSOID66;
	}
	public String getCheckPreparer67() {
		return checkPreparer67;
	}
	public void setCheckPreparer67(String checkPreparer67) {
		this.checkPreparer67 = checkPreparer67;
	}
	public String getCheckCertifier68() {
		return checkCertifier68;
	}
	public void setCheckCertifier68(String checkCertifier68) {
		this.checkCertifier68 = checkCertifier68;
	}
	public String getStatus69() {
		return status69;
	}
	public void setStatus69(String status69) {
		this.status69 = status69;
	}
	
	public String getLastUpdated70() {
		return lastUpdated70;
	}
	public void setLastUpdated70(String lastUpdated70) {
		this.lastUpdated70 = lastUpdated70;
	}
    @PostConstruct
    public void searchCerifierReport() {
    	Map parMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String noiMasterID = (String)parMap.get("noiMasterID");
		this.setNoiMasterID(noiMasterID);
		 CertifierCommon_DAO.selectNoiById(this);
		 //CertifierCommon_DAO.updateNoiCertifyRecord(this);
		 
		// updateNoiCertify();
				
	}
    
    

public String updateNoiCertify() {
	 
	
	try {
		//logger.info(" Inside project_Noi Info  ..... "  );
			
			boolean dbUpdateNOI = false;
			
		
			dbUpdateNOI = CertifierCommon_DAO.updateNoiCertifyRecord(this);
			
			if (dbUpdateNOI) 
			{
				
				FacesMessage msg = new FacesMessage("Congratulation, Your NOI Info Has been Updated Sucessfully.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);	
				
				
				return "tdecDashboard";	
			}else
			{
				FacesMessage msg = new FacesMessage("There is an Input Error Please check your Input Fields");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "previewNOIForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "previewNOIForm";	
			}	
	//return "noiForm";	
}	
	
	




public String validatesecurityQuestion() {
	 
	
	try {
		
			boolean dbUpdateNOI = false;
			
			dbUpdateNOI = CertifierCommon_DAO.validateSecurity(this);
		
		//	dbUpdateNOI = CertifierCommon_DAO.checkCertifierRolesEmail();
			
			if (dbUpdateNOI) 
			{
				
				FacesMessage msg = new FacesMessage("Thanks For validating your Security Question.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);	
				
				
				return "payment";	
			}else
			{
				FacesMessage msg = new FacesMessage("we are unable to validate your Identity ");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "previewNOIForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "previewNOIForm";	
			}	
	//return "noiForm";	
}	
	
	
	
	
	
	
}
