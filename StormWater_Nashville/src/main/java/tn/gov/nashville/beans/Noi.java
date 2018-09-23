package tn.gov.nashville.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import tn.gov.nashville.dao.NoiFormCommon_DAO;
import tn.gov.nashville.dao.Noi_DAO;

import org.apache.log4j.Logger;

@ManagedBean(name="noi")
@SessionScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class Noi implements Serializable {
	
	
	 @ManagedProperty(value="#{Login}") 
	  Login loginBean;
	
	
	public Login getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(Login loginBean) {
		this.loginBean = loginBean;
	}


	private static final long serialVersionUID = 0L;
	
	public static Logger logger = Logger.getLogger(Noi.class);

	private String npdesPermitSelect1;
	private String npdesPermitSelect2;
	private String npdesID;
	
	
	
	
	private String opprimaryPermitte;
	private String sosControlNumber;
	private String ownershipSelect;
	private String siteOwnerFirstName;
	private String siteOwnerMiddleName;
	private String siteOwnerLastName;
	private String siteOwnerTitle;
	private String siteOwnerCompany;
	private String siteOwnerAddress;
	private String siteOwnerCity;
	private String siteOwnerstateSelect;
	private String siteOwnerZip;
	private String siteOwnerphone;
	private String siteOwnerphoneEXT;
	private String siteOwnerEmail;
	private String opocFirstName;
	private String opocMiddleName;
	private String opocLastName;
	private String opocTitle;
	private String opocCompany;
	private String opocAddress;
	private String opocCity;
	private String opocstateSelect;
	private String opocZip;
	private String opocPhone;
	private String opocPhoneExt;
	private String opocEmail;
	
	
	
	private String projName;
	private String projDescription;
	private String projAddress;
	private String projCity;
	private String projState;
	private String projZip;
	private String projCounty;
	private Date   projStartDate;
	private Date   projEndDate;
	private String projEADisturbed;
	private String projTotalSiteAcres;
	private String[] selectedConstructionCheckBo;
	

	
	public String[] getSelectedConstructionCheckBo() {
		return selectedConstructionCheckBo;
	}
	public void setSelectedConstructionCheckBo(String[] selectedConstructionCheckBo) {
		this.selectedConstructionCheckBo = selectedConstructionCheckBo;
	}


	private String projTOC_SingleFamilyResi ;
	private String projTOC_MultiFamilyResi;
	private String projTOC_Commercial;
	private String projTOC_Industrial;
	private String projTOC_Institutional;
	private String projTOC_HYWY;
	private String projTOC_Utility;
	private String projTOC_Other;
	
	
	
	
	
	private String projLatitude;
	private String projLongitude;	
	private String projLatLongSource;
	private String projDatumSource;
	
	
	
	

	
	private String projDischargeMS4;
	private String projDischarge50FtDisturbance;
	private String projMS4Jurisdiction;
	
	

	private String projDischargeID;
	private String projDischargeReceavingWater;
	private String projDischargeDescription;
	private String projDischargeCWA;
	private String projDischargeTMDL;
	
	
	/*private String swpppFirstName;
	private String swpppMiddleName;
	private String swpppLastName;
	private String swpppOrg;
	private String swpppTitle;
	private String swpppPhone;
	private String swpppPhoneExt;
	private String swpppEmail;
	*/
	private String swpppPreparedAdvance;
	
	/*private String espCriterion;
	private String espCriterionSummary;
	
	private String certInfoUserID;
	private String certInfoFirstName;
	private String certInfoMiddleName;
	private String certInfoLastName;
	private String certInfoOrganization;
	private String certInfoEmail;
	private String certInfoAddress;
	*/
	private String stateSelectOption;
	

	private boolean noiUserExist;
	
	private String loginSSOID;
	
	private String checkPreparer;
	private String checkCertifier;
	
	public String getCheckPreparer() {
		return checkPreparer;
	}
	public void setCheckPreparer(String checkPreparer) {
		this.checkPreparer = checkPreparer;
	}
	public String getCheckCertifier() {
		return checkCertifier;
	}
	public void setCheckCertifier(String checkCertifier) {
		this.checkCertifier = checkCertifier;
	}


	
	
	
	
	
	
	
	public String getProjMS4Jurisdiction() {
		return projMS4Jurisdiction;
	}
	public void setProjMS4Jurisdiction(String projMS4Jurisdiction) {
		this.projMS4Jurisdiction = projMS4Jurisdiction;
	}

	
	
	
	public String getLoginSSOID() {
		return loginSSOID;
	}
	public void setLoginSSOID(String loginSSOID) {
		this.loginSSOID = loginSSOID;
	}


	
	public boolean isNoiUserExist() {
		return noiUserExist;
	}
	public void setNoiUserExist(boolean noiUserExist) {
		this.noiUserExist = noiUserExist;
	}
	
	
	public String getOpocCompany() {
		return opocCompany;
	}
	public void setOpocCompany(String opocCompany) {
		this.opocCompany = opocCompany;
	}
	public String getOpocAddress() {
		return opocAddress;
	}
	public void setOpocAddress(String opocAddress) {
		this.opocAddress = opocAddress;
	}
	public String getOpocCity() {
		return opocCity;
	}
	public void setOpocCity(String opocCity) {
		this.opocCity = opocCity;
	}
	public String getOpocstateSelect() {
		return opocstateSelect;
	}
	public void setOpocstateSelect(String opocstateSelect) {
		this.opocstateSelect = opocstateSelect;
	}
	public String getOpocZip() {
		return opocZip;
	}
	public void setOpocZip(String opocZip) {
		this.opocZip = opocZip;
	}
	
	
	public String getStateSelectOption() {
		return stateSelectOption;
	}
	public void setStateSelectOption(String stateSelectOption) {
		this.stateSelectOption = stateSelectOption;
	}
	public String getProjDescription() {
		return projDescription;
	}
	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}
	public String getProjTotalSiteAcres() {
		return projTotalSiteAcres;
	}
	public void setProjTotalSiteAcres(String projTotalSiteAcres) {
		this.projTotalSiteAcres = projTotalSiteAcres;
	}
	
	
	/*public String [] getSelectedConstructionCheckBo() {
		return selectedConstructionCheckBo;
	}
	public void setSelectedConstructionCheckBo(String[] selectedConstructionCheckBo) {
		this.selectedConstructionCheckBo = selectedConstructionCheckBo;
	}
*/

	
	public String getOpprimaryPermitte() {
		return opprimaryPermitte;
	}
	public void setOpprimaryPermitte(String opprimaryPermitte) {
		this.opprimaryPermitte = opprimaryPermitte;
	}
	public String getSosControlNumber() {
		return sosControlNumber;
	}
	public void setSosControlNumber(String sosControlNumber) {
		this.sosControlNumber = sosControlNumber;
	}
	public String getOwnershipSelect() {
		return ownershipSelect;
	}
	public void setOwnershipSelect(String ownershipSelect) {
		this.ownershipSelect = ownershipSelect;
	}
	public String getSiteOwnerFirstName() {
		return siteOwnerFirstName;
	}
	public void setSiteOwnerFirstName(String siteOwnerFirstName) {
		this.siteOwnerFirstName = siteOwnerFirstName;
	}
	public String getSiteOwnerMiddleName() {
		return siteOwnerMiddleName;
	}
	public void setSiteOwnerMiddleName(String siteOwnerMiddleName) {
		this.siteOwnerMiddleName = siteOwnerMiddleName;
	}
	public String getSiteOwnerLastName() {
		return siteOwnerLastName;
	}
	public void setSiteOwnerLastName(String siteOwnerLastName) {
		this.siteOwnerLastName = siteOwnerLastName;
	}
	public String getSiteOwnerTitle() {
		return siteOwnerTitle;
	}
	public void setSiteOwnerTitle(String siteOwnerTitle) {
		this.siteOwnerTitle = siteOwnerTitle;
	}
	public String getSiteOwnerCompany() {
		return siteOwnerCompany;
	}
	public void setSiteOwnerCompany(String siteOwnerCompany) {
		this.siteOwnerCompany = siteOwnerCompany;
	}
	public String getSiteOwnerAddress() {
		return siteOwnerAddress;
	}
	public void setSiteOwnerAddress(String siteOwnerAddress) {
		this.siteOwnerAddress = siteOwnerAddress;
	}
	public String getSiteOwnerCity() {
		return siteOwnerCity;
	}
	public void setSiteOwnerCity(String siteOwnerCity) {
		this.siteOwnerCity = siteOwnerCity;
	}
	public String getSiteOwnerstateSelect() {
		return siteOwnerstateSelect;
	}
	public void setSiteOwnerstateSelect(String siteOwnerstateSelect) {
		this.siteOwnerstateSelect = siteOwnerstateSelect;
	}
	public String getSiteOwnerZip() {
		return siteOwnerZip;
	}
	public void setSiteOwnerZip(String siteOwnerZip) {
		this.siteOwnerZip = siteOwnerZip;
	}
	public String getSiteOwnerphone() {
		return siteOwnerphone;
	}
	public void setSiteOwnerphone(String siteOwnerphone) {
		this.siteOwnerphone = siteOwnerphone;
	}
	public String getSiteOwnerphoneEXT() {
		return siteOwnerphoneEXT;
	}
	public void setSiteOwnerphoneEXT(String siteOwnerphoneEXT) {
		this.siteOwnerphoneEXT = siteOwnerphoneEXT;
	}
	public String getSiteOwnerEmail() {
		return siteOwnerEmail;
	}
	public void setSiteOwnerEmail(String siteOwnerEmail) {
		this.siteOwnerEmail = siteOwnerEmail;
	}
	
	public String getProjTOC_MultiFamilyResi() {
		return projTOC_MultiFamilyResi;
	}
	public void setProjTOC_MultiFamilyResi(String projTOC_MultiFamilyResi) {
		this.projTOC_MultiFamilyResi = projTOC_MultiFamilyResi;
	}
	public String getProjTOC_SingleFamilyResi() {
		return projTOC_SingleFamilyResi;
	}
	public void setProjTOC_SingleFamilyResi(String projTOC_SingleFamilyResi) {
		this.projTOC_SingleFamilyResi = projTOC_SingleFamilyResi;
	}
	public String getProjTOC_Commercial() {
		return projTOC_Commercial;
	}
	public void setProjTOC_Commercial(String projTOC_Commercial) {
		this.projTOC_Commercial = projTOC_Commercial;
	}
	public String getProjTOC_Industrial() {
		return projTOC_Industrial;
	}
	public void setProjTOC_Industrial(String projTOC_Industrial) {
		this.projTOC_Industrial = projTOC_Industrial;
	}
	public String getProjTOC_Institutional() {
		return projTOC_Institutional;
	}
	public void setProjTOC_Institutional(String projTOC_Institutional) {
		this.projTOC_Institutional = projTOC_Institutional;
	}
	public String getProjTOC_HYWY() {
		return projTOC_HYWY;
	}
	public void setProjTOC_HYWY(String projTOC_HYWY) {
		this.projTOC_HYWY = projTOC_HYWY;
	}
	public String getProjTOC_Utility() {
		return projTOC_Utility;
	}
	public void setProjTOC_Utility(String projTOC_Utility) {
		this.projTOC_Utility = projTOC_Utility;
	}
	public String getProjTOC_Other() {
		return projTOC_Other;
	}
	public void setProjTOC_Other(String projTOC_Other) {
		this.projTOC_Other = projTOC_Other;
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
	public String getNpdesID() {
		return npdesID;
	}
	public void setNpdesID(String npdesID) {
		this.npdesID = npdesID;
	}
	
	public String getOpocFirstName() {
		return opocFirstName;
	}
	public void setOpocFirstName(String opocFirstName) {
		this.opocFirstName = opocFirstName;
	}
	public String getOpocTitle() {
		return opocTitle;
	}
	public void setOpocTitle(String opocTitle) {
		this.opocTitle = opocTitle;
	}
	public String getOpocMiddleName() {
		return opocMiddleName;
	}
	public void setOpocMiddleName(String opocMiddleName) {
		this.opocMiddleName = opocMiddleName;
	}
	public String getOpocLastName() {
		return opocLastName;
	}
	public void setOpocLastName(String opocLastName) {
		this.opocLastName = opocLastName;
	}
	public String getOpocPhone() {
		return opocPhone;
	}
	public void setOpocPhone(String opocPhone) {
		this.opocPhone = opocPhone;
	}
	public String getOpocPhoneExt() {
		return opocPhoneExt;
	}
	public void setOpocPhoneExt(String opocPhoneExt) {
		this.opocPhoneExt = opocPhoneExt;
	}
	public String getOpocEmail() {
		return opocEmail;
	}
	public void setOpocEmail(String opocEmail) {
		this.opocEmail = opocEmail;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getProjAddress() {
		return projAddress;
	}
	public void setProjAddress(String projAddress) {
		this.projAddress = projAddress;
	}
	public String getProjCity() {
		return projCity;
	}
	public void setProjCity(String projCity) {
		this.projCity = projCity;
	}
	public String getProjState() {
		return projState;
	}
	public void setProjState(String projState) {
		this.projState = projState;
	}
	public String getProjZip() {
		return projZip;
	}
	public void setProjZip(String proZip) {
		this.projZip = proZip;
	}
	public String getProjCounty() {
		return projCounty;
	}
	public void setProjCounty(String projCounty) {
		this.projCounty = projCounty;
	}
	public String getProjLatitude() {
		return projLatitude;
	}
	public void setProjLatitude(String projLatitude) {
		this.projLatitude = projLatitude;
	}
	public String getProjLongitude() {
		return projLongitude;
	}
	public void setProjLongitude(String projLongitude) {
		this.projLongitude = projLongitude;
	}
	public String getProjLatLongSource() {
		return projLatLongSource;
	}
	public void setProjLatLongSource(String projLatLongSource) {
		this.projLatLongSource = projLatLongSource;
	}
	public String getProjDatumSource() {
		return projDatumSource;
	}
	public void setProjDatumSource(String projDatumSource) {
		this.projDatumSource = projDatumSource;
	}
	public Date getProjStartDate() {
		return projStartDate;
	}
	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}
	public Date getProjEndDate() {
		return projEndDate;
	}
	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}
	public String getProjEADisturbed() {
		return projEADisturbed;
	}
	public void setProjEADisturbed(String projEADisturbed) {
		this.projEADisturbed = projEADisturbed;
	}
	
	public String getProjDischargeMS4() {
		return projDischargeMS4;
	}
	public void setProjDischargeMS4(String projDischargeMS4) {
		this.projDischargeMS4 = projDischargeMS4;
	}
	public String getProjDischarge50FtDisturbance() {
		return projDischarge50FtDisturbance;
	}
	public void setProjDischarge50FtDisturbance(String projDischarge50FtDisturbance) {
		this.projDischarge50FtDisturbance = projDischarge50FtDisturbance;
	}
	public String getProjDischargeID() {
		return projDischargeID;
	}
	public void setProjDischargeID(String projDischargeID) {
		this.projDischargeID = projDischargeID;
	}
	public String getProjDischargeReceavingWater() {
		return projDischargeReceavingWater;
	}
	public void setProjDischargeReceavingWater(String projDischargeReceavingWater) {
		this.projDischargeReceavingWater = projDischargeReceavingWater;
	}
	public String getProjDischargeDescription() {
		return projDischargeDescription;
	}
	public void setProjDischargeDescription(String projDischargeDescription) {
		this.projDischargeDescription = projDischargeDescription;
	}
	public String getProjDischargeCWA() {
		return projDischargeCWA;
	}
	public void setProjDischargeCWA(String projDischargeCWA) {
		this.projDischargeCWA = projDischargeCWA;
	}
	public String getProjDischargeTMDL() {
		return projDischargeTMDL;
	}
	public void setProjDischargeTMDL(String projDischargeTMDL) {
		this.projDischargeTMDL = projDischargeTMDL;
	}
	
	public String getSwpppPreparedAdvance() {
		return swpppPreparedAdvance;
	}
	public void setSwpppPreparedAdvance(String swpppPreparedAdvance) {
		this.swpppPreparedAdvance = swpppPreparedAdvance;
	}
	
	
	/*
	public String permitInformation() {
		 
			
			try {
				logger.info(" Inside PermitInformation  ..... "  );
					
					boolean dbUpdateNOI = false;
				
					dbUpdateNOI = Noi_DAO.checkorInsertNOIPermit(this);
					
					if (dbUpdateNOI) 
					{
						
						FacesMessage msg = new FacesMessage("Congratulation, Permit Information has been saved.");
						msg.setSeverity(FacesMessage.SEVERITY_INFO);
						FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);	
						
						
						return "noiForm";	
					}
					
				} catch (Exception e) 
					{					
					FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
					
							msg.setSeverity(FacesMessage.SEVERITY_FATAL);
							FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
						
							return "noiForm";	
					}	
			return "noiForm";	
	}
	
	
	public String operatorInformation() {
		 
		
		try {
			logger.info(" Inside operator Information  ..... "  );
				
				boolean dbUpdateNOI = false;
			
				dbUpdateNOI = NoiOperatorInfo_DAO.checkorInsertOperatorInfo(this);
				
				if (dbUpdateNOI) 
				{
					
					FacesMessage msg = new FacesMessage("Congratulation, Operator Information has been saved.");
					msg.setSeverity(FacesMessage.SEVERITY_INFO);
					FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);	
					
					
					return "noiForm";	
				}
				
			} catch (Exception e) 
				{					
				FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
				
						msg.setSeverity(FacesMessage.SEVERITY_FATAL);
						FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
					
						return "noiForm";	
				}	
		return "noiForm";	
}

	
public String projSiteInfo() {
		 
		
		try {
			logger.info(" Inside PojectSite Info  ..... "  );
				
				boolean dbUpdateNOI = false;
			
				dbUpdateNOI = NoiProjectSiteInfo_DAO.checkorInsertProjectSiteInfo(this);
				
				if (dbUpdateNOI) 
				{
					
					FacesMessage msg = new FacesMessage("Congratulation, Project Site Information has been saved.");
					msg.setSeverity(FacesMessage.SEVERITY_INFO);
					FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);	
					
					
					return "noiForm";	
				}
				
			} catch (Exception e) 
				{					
				FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
				
						msg.setSeverity(FacesMessage.SEVERITY_FATAL);
						FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
					
						return "noiForm";	
				}	
		return "noiForm";	
}	
	
	

public String projectSiteDischarge() {
	 
	
	try {
		logger.info(" Inside projectSite_Discharge Info  ..... "  );
			
			boolean dbUpdateNOI = false;
		
			dbUpdateNOI = NoiProjectSiteDischagreInfo_DAO.checkorInsertProjectSiteDischarge(this);
			
			if (dbUpdateNOI) 
			{
				
				FacesMessage msg = new FacesMessage("Congratulation, Project Site Discharge Information has been saved.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "noiForm";	
			}	
	return "noiForm";	
}	

public String projectSWPPP() {
	 
	
	try {
		logger.info(" Inside projectSite_Discharge Info  ..... "  );
			
			boolean dbUpdateNOI = false;
		
			dbUpdateNOI = NoiProjectSiteDischagreInfo_DAO.checkorInsertProjectSiteDischarge(this);
			
			if (dbUpdateNOI) 
			{
				
				FacesMessage msg = new FacesMessage("Congratulation, Project Site Discharge Information has been saved.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "noiForm";	
			}	
	return "noiForm";	
}	


public String projectESP() {
	 
	
	try {
		logger.info(" Inside project_ESP Info  ..... "  );
			
			boolean dbUpdateNOI = false;
		
			dbUpdateNOI = NoiProjectSiteDischagreInfo_DAO.checkorInsertProjectSiteDischarge(this);
			
			if (dbUpdateNOI) 
			{
				
				FacesMessage msg = new FacesMessage("Congratulation, Project Endagered Species Protection has been saved.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "noiForm";	
			}	
	return "noiForm";	
}	


*/
	
	public void noiSSOid(Login login) {
		
	String noiuniqueid = login.getUniqueId().toString();
	
	this.setLoginSSOID(noiuniqueid);
	//return	noiuniqueid;
	}


public String projectNoi() {
	 
	
	try {
		logger.info(" Inside project_Noi Info  ..... "  );
			
			boolean dbUpdateNOI = false;
			
		
		//	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		//	Login loginBean = (Login) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, "Login");
			
		//	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		 //   Login firstBean = (Login) elContext.getELResolver().getValue(elContext, null, "Login");
			
	/*		
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			Login loginBean11  = (Login) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, "Login");
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Login loginBean12 = (Login)facesContext.getApplication() .createValueBinding("#{loginBean}").getValue(facesContext);
			
			
			FacesContext facesContext111 = FacesContext.getCurrentInstance();
			Login loginBean1111
			    = (Login) facesContext.getApplication()
			    .getVariableResolver().resolveVariable(facesContext, "loginBean");
		    
		  //  loginSSOID = loginBean.getUniqueId();
		*/    
		
			dbUpdateNOI = NoiFormCommon_DAO.checkorInsertNoiFormCommon(this);
			
			if (dbUpdateNOI) 
			{
				
				FacesMessage msg = new FacesMessage("Congratulation, Your NOI Info Has been Submitted to the Certifier Sucessfully.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:sucessDashMsg", msg);	
				
				
				return "tdecDashboard";	
			}else
			{
				FacesMessage msg = new FacesMessage("There is an Input Error Please check your Input Fields");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "noiForm";	
			}	
	//return "noiForm";	
}	
	

public String checkPrep_Certifier() {
	 
	
	try {
		logger.info(" Inside project_Noi checkPrep_Certifier to check their emails  ..... "  );
			
			boolean dbUpdateNOI1= false;
			
	//		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	//	    Login firstBean = (Login) elContext.getELResolver().getValue(elContext, null, "Login");
		    
	//	    loginSSOID = firstBean.getUniqueId();
		
			dbUpdateNOI1 = NoiFormCommon_DAO.checkCertifierRolesEmail(this);
			
			if (dbUpdateNOI1) 
			{
				
				FacesMessage msg = new FacesMessage("Congratulation, Cerifier email exist.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}else
			{
				FacesMessage msg = new FacesMessage("This email doesnot have Certifier Role");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "noiForm";	
			}	
	//return "noiForm";	
}	

public String checkPrep_Preparer() {
	 
	
	try {
		logger.info(" Inside project_Noi checkPrep_Preparer to check their emails  ..... "  );
			
			boolean dbUpdateNOI2= false;
			
	//		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	//	    Login firstBean = (Login) elContext.getELResolver().getValue(elContext, null, "Login");
		    
	//	    loginSSOID = firstBean.getUniqueId();
		
			dbUpdateNOI2 = NoiFormCommon_DAO.checkPreparerRolesEmail(this);
			
			if (dbUpdateNOI2) 
			{
				
				FacesMessage msg = new FacesMessage("Congratulation, Preparer email exist.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}else
			{
				FacesMessage msg = new FacesMessage("This email doesnot have Preparer Role");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
				
				return "noiForm";	
			}
			
		} catch (Exception e) 
			{					
			FacesMessage msg = new FacesMessage("We encountered the System Error. Please try again. If the problem persist please contact HelpDesk (888) 891-TDEC (8332) ");
			
					msg.setSeverity(FacesMessage.SEVERITY_FATAL);
					FacesContext.getCurrentInstance().addMessage("form:noiMsg", msg);	
				
					return "noiForm";	
			}	
	//return "noiForm";	
}	








	
	
	
}
