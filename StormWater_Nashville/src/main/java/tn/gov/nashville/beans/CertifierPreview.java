package tn.gov.nashville.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;


import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import tn.gov.nashville.dao.CertifierPreviewDAO;

@ManagedBean(name="certPreview")
@RequestScoped

@JsonIgnoreProperties(ignoreUnknown = true)
public class CertifierPreview implements Serializable {
	
	
	 @ManagedProperty(value="#{Login}") 
	  Login loginBean;
	
	
	public Login getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(Login loginBean) {
		this.loginBean = loginBean;
	}


	private static final long serialVersionUID = 0L;
	
	public static Logger logger = Logger.getLogger(CertifierPreview.class);
    
	private String preview_autoId;
	private String preview_npdesPermitCoverage;
	private String preview_CGPAuthorized;
	private String preview_npdesID;
	
	
	
	
	private String preview_opprimaryPermitte;
	private String preview_sosControlNumber;
	private String preview_ownershipSelect;
	private String preview_siteOwnerFirstName;
	private String preview_siteOwnerMiddleName;
	private String preview_siteOwnerLastName;
	private String preview_siteOwnerTitle;
	private String preview_siteOwnerCompany;
	private String preview_siteOwnerAddress;
	private String preview_siteOwnerCity;
	private String preview_siteOwnerstateSelect;
	private String preview_siteOwnerZip;
	private String preview_siteOwnerphone;
	private String preview_siteOwnerphoneEXT;
	private String preview_siteOwnerEmail;
	private String preview_opocFirstName;
	private String preview_opocMiddleName;
	private String preview_opocLastName;
	private String preview_opocTitle;
	private String preview_opocCompany;
	private String preview_opocAddress;
	private String preview_opocCity;
	private String preview_opocstateSelect;
	private String preview_opocZip;
	private String preview_opocPhone;
	private String preview_opocPhoneExt;
	private String preview_opocEmail;
	
	
	
	private String preview_projName;
	private String preview_projDescription;
	private String preview_projAddress;
	private String preview_projCity;
	private String preview_projState;
	private String preview_projZip;
	private String preview_projCounty;
	private Date   preview_projStartDate;
	private Date   preview_projEndDate;
	private String preview_projEADisturbed;
	private String preview_projTotalSiteAcres;
	
	private String preview_selecSFResi;
	private String preview_selecMFResi;
	private String preview_selecCommercial;
	private String preview_selecIndustrial;
	private String preview_selecInstitutional;
	private String preview_selecHywayRoad;
	private String preview_selecUtility;
	private String preview_selecOther;
	
	public String getPreview_selecSFResi() {
		return preview_selecSFResi;
	}
	public void setPreview_selecSFResi(String preview_selecSFResi) {
		this.preview_selecSFResi = preview_selecSFResi;
	}
	public String getPreview_selecMFResi() {
		return preview_selecMFResi;
	}
	public void setPreview_selecMFResi(String preview_selecMFResi) {
		this.preview_selecMFResi = preview_selecMFResi;
	}
	public String getPreview_selecCommercial() {
		return preview_selecCommercial;
	}
	public void setPreview_selecCommercial(String preview_selecCommercial) {
		this.preview_selecCommercial = preview_selecCommercial;
	}
	public String getPreview_selecIndustrial() {
		return preview_selecIndustrial;
	}
	public void setPreview_selecIndustrial(String preview_selecIndustrial) {
		this.preview_selecIndustrial = preview_selecIndustrial;
	}
	public String getPreview_selecInstitutional() {
		return preview_selecInstitutional;
	}
	public void setPreview_selecInstitutional(String preview_selecInstitutional) {
		this.preview_selecInstitutional = preview_selecInstitutional;
	}
	public String getPreview_selecHywayRoad() {
		return preview_selecHywayRoad;
	}
	public void setPreview_selecHywayRoad(String preview_selecHywayRoad) {
		this.preview_selecHywayRoad = preview_selecHywayRoad;
	}
	public String getPreview_selecUtility() {
		return preview_selecUtility;
	}
	public void setPreview_selecUtility(String preview_selecUtility) {
		this.preview_selecUtility = preview_selecUtility;
	}
	public String getPreview_selecOther() {
		return preview_selecOther;
	}
	public void setPreview_selecOther(String preview_selecOther) {
		this.preview_selecOther = preview_selecOther;
	}


	
	

	


	private String preview_SingleFamilyResi;
	private String preview_MultiFamilyResi;
	private String preview_Commercial;
	private String preview_Industrial;
	private String preview_Institutional;
	private String preview_HYWY;
	private String preview_Utility;
	private String preview_Other;
	
	
	
	
	
	private String preview_Latitude;
	private String preview_Longitude;	
	

	private String preview_DischargeMS4;
	private String preview_Discharge50FtDisturbance;
	private String preview_MS4Jurisdiction;
	
	

	private String preview_DischargeID;
	private String preview_DischargeReceavingWater;
	private String preview_DischargeDescription;
	private String preview_DischargeCWA;
	private String preview_DischargeTMDL;
	
	
	private String preview_swpppPreparedAdvance;
	private String preview_defaultState;
	
	public String getPreview_defaultState() {
		return preview_defaultState;
	}
	public void setPreview_defaultState(String preview_defaultState) {
		this.preview_defaultState = preview_defaultState;
	}


	private String preview_Status;
	

	private String loginSSOID;
	
	

	
	public String getPreview_npdesPermitCoverage() {
		return preview_npdesPermitCoverage;
	}
	public void setPreview_npdesPermitCoverage(String preview_npdesPermitCoverage) {
		this.preview_npdesPermitCoverage = preview_npdesPermitCoverage;
	}
	public String getPreview_CGPAuthorized() {
		return preview_CGPAuthorized;
	}
	public void setPreview_CGPAuthorized(String preview_CGPAuthorized) {
		this.preview_CGPAuthorized = preview_CGPAuthorized;
	}

	public String getPreview_npdesID() {
		return preview_npdesID;
	}
	public void setPreview_npdesID(String preview_npdesID) {
		this.preview_npdesID = preview_npdesID;
	}
	public String getPreview_opprimaryPermitte() {
		return preview_opprimaryPermitte;
	}
	public void setPreview_opprimaryPermitte(String preview_opprimaryPermitte) {
		this.preview_opprimaryPermitte = preview_opprimaryPermitte;
	}
	public String getPreview_sosControlNumber() {
		return preview_sosControlNumber;
	}
	public void setPreview_sosControlNumber(String preview_sosControlNumber) {
		this.preview_sosControlNumber = preview_sosControlNumber;
	}
	public String getPreview_ownershipSelect() {
		return preview_ownershipSelect;
	}
	public void setPreview_ownershipSelect(String preview_ownershipSelect) {
		this.preview_ownershipSelect = preview_ownershipSelect;
	}
	public String getPreview_siteOwnerFirstName() {
		return preview_siteOwnerFirstName;
	}
	public void setPreview_siteOwnerFirstName(String preview_siteOwnerFirstName) {
		this.preview_siteOwnerFirstName = preview_siteOwnerFirstName;
	}
	public String getPreview_siteOwnerMiddleName() {
		return preview_siteOwnerMiddleName;
	}
	public void setPreview_siteOwnerMiddleName(String preview_siteOwnerMiddleName) {
		this.preview_siteOwnerMiddleName = preview_siteOwnerMiddleName;
	}
	public String getPreview_siteOwnerLastName() {
		return preview_siteOwnerLastName;
	}
	public void setPreview_siteOwnerLastName(String preview_siteOwnerLastName) {
		this.preview_siteOwnerLastName = preview_siteOwnerLastName;
	}
	public String getPreview_siteOwnerTitle() {
		return preview_siteOwnerTitle;
	}
	public void setPreview_siteOwnerTitle(String preview_siteOwnerTitle) {
		this.preview_siteOwnerTitle = preview_siteOwnerTitle;
	}
	public String getPreview_siteOwnerCompany() {
		return preview_siteOwnerCompany;
	}
	public void setPreview_siteOwnerCompany(String preview_siteOwnerCompany) {
		this.preview_siteOwnerCompany = preview_siteOwnerCompany;
	}
	public String getPreview_siteOwnerAddress() {
		return preview_siteOwnerAddress;
	}
	public void setPreview_siteOwnerAddress(String preview_siteOwnerAddress) {
		this.preview_siteOwnerAddress = preview_siteOwnerAddress;
	}
	public String getPreview_siteOwnerCity() {
		return preview_siteOwnerCity;
	}
	public void setPreview_siteOwnerCity(String preview_siteOwnerCity) {
		this.preview_siteOwnerCity = preview_siteOwnerCity;
	}
	public String getPreview_siteOwnerstateSelect() {
		return preview_siteOwnerstateSelect;
	}
	public void setPreview_siteOwnerstateSelect(String preview_siteOwnerstateSelect) {
		this.preview_siteOwnerstateSelect = preview_siteOwnerstateSelect;
	}
	public String getPreview_siteOwnerZip() {
		return preview_siteOwnerZip;
	}
	public void setPreview_siteOwnerZip(String preview_siteOwnerZip) {
		this.preview_siteOwnerZip = preview_siteOwnerZip;
	}
	public String getPreview_siteOwnerphone() {
		return preview_siteOwnerphone;
	}
	public void setPreview_siteOwnerphone(String preview_siteOwnerphone) {
		this.preview_siteOwnerphone = preview_siteOwnerphone;
	}
	public String getPreview_siteOwnerphoneEXT() {
		return preview_siteOwnerphoneEXT;
	}
	public void setPreview_siteOwnerphoneEXT(String preview_siteOwnerphoneEXT) {
		this.preview_siteOwnerphoneEXT = preview_siteOwnerphoneEXT;
	}
	public String getPreview_siteOwnerEmail() {
		return preview_siteOwnerEmail;
	}
	public void setPreview_siteOwnerEmail(String preview_siteOwnerEmail) {
		this.preview_siteOwnerEmail = preview_siteOwnerEmail;
	}
	public String getPreview_opocFirstName() {
		return preview_opocFirstName;
	}
	public void setPreview_opocFirstName(String preview_opocFirstName) {
		this.preview_opocFirstName = preview_opocFirstName;
	}
	public String getPreview_opocMiddleName() {
		return preview_opocMiddleName;
	}
	public void setPreview_opocMiddleName(String preview_opocMiddleName) {
		this.preview_opocMiddleName = preview_opocMiddleName;
	}
	public String getPreview_opocLastName() {
		return preview_opocLastName;
	}
	public void setPreview_opocLastName(String preview_opocLastName) {
		this.preview_opocLastName = preview_opocLastName;
	}
	public String getPreview_opocTitle() {
		return preview_opocTitle;
	}
	public void setPreview_opocTitle(String preview_opocTitle) {
		this.preview_opocTitle = preview_opocTitle;
	}
	public String getPreview_opocCompany() {
		return preview_opocCompany;
	}
	public void setPreview_opocCompany(String preview_opocCompany) {
		this.preview_opocCompany = preview_opocCompany;
	}
	public String getPreview_opocAddress() {
		return preview_opocAddress;
	}
	public void setPreview_opocAddress(String preview_opocAddress) {
		this.preview_opocAddress = preview_opocAddress;
	}
	public String getPreview_opocCity() {
		return preview_opocCity;
	}
	public void setPreview_opocCity(String preview_opocCity) {
		this.preview_opocCity = preview_opocCity;
	}
	public String getPreview_opocstateSelect() {
		return preview_opocstateSelect;
	}
	public void setPreview_opocstateSelect(String preview_opocstateSelect) {
		this.preview_opocstateSelect = preview_opocstateSelect;
	}
	public String getPreview_opocZip() {
		return preview_opocZip;
	}
	public void setPreview_opocZip(String preview_opocZip) {
		this.preview_opocZip = preview_opocZip;
	}
	public String getPreview_opocPhone() {
		return preview_opocPhone;
	}
	public void setPreview_opocPhone(String preview_opocPhone) {
		this.preview_opocPhone = preview_opocPhone;
	}
	public String getPreview_opocPhoneExt() {
		return preview_opocPhoneExt;
	}
	public void setPreview_opocPhoneExt(String preview_opocPhoneExt) {
		this.preview_opocPhoneExt = preview_opocPhoneExt;
	}
	public String getPreview_opocEmail() {
		return preview_opocEmail;
	}
	public void setPreview_opocEmail(String preview_opocEmail) {
		this.preview_opocEmail = preview_opocEmail;
	}
	public String getPreview_projName() {
		return preview_projName;
	}
	public void setPreview_projName(String preview_projName) {
		this.preview_projName = preview_projName;
	}
	public String getPreview_projDescription() {
		return preview_projDescription;
	}
	public void setPreview_projDescription(String preview_projDescription) {
		this.preview_projDescription = preview_projDescription;
	}
	public String getPreview_projAddress() {
		return preview_projAddress;
	}
	public void setPreview_projAddress(String preview_projAddress) {
		this.preview_projAddress = preview_projAddress;
	}
	public String getPreview_projCity() {
		return preview_projCity;
	}
	public void setPreview_projCity(String preview_projCity) {
		this.preview_projCity = preview_projCity;
	}
	public String getPreview_projState() {
		return preview_projState;
	}
	public void setPreview_projState(String preview_projState) {
		this.preview_projState = preview_projState;
	}
	public String getPreview_projZip() {
		return preview_projZip;
	}
	public void setPreview_projZip(String preview_projZip) {
		this.preview_projZip = preview_projZip;
	}
	public String getPreview_projCounty() {
		return preview_projCounty;
	}
	public void setPreview_projCounty(String preview_projCounty) {
		this.preview_projCounty = preview_projCounty;
	}
	public Date getPreview_projStartDate() {
		return preview_projStartDate;
	}
	public void setPreview_projStartDate(Date preview_projStartDate) {
		this.preview_projStartDate = preview_projStartDate;
	}
	public Date getPreview_projEndDate() {
		return preview_projEndDate;
	}
	public void setPreview_projEndDate(Date preview_projEndDate) {
		this.preview_projEndDate = preview_projEndDate;
	}
	public String getPreview_projEADisturbed() {
		return preview_projEADisturbed;
	}
	public void setPreview_projEADisturbed(String preview_projEADisturbed) {
		this.preview_projEADisturbed = preview_projEADisturbed;
	}
	public String getPreview_projTotalSiteAcres() {
		return preview_projTotalSiteAcres;
	}
	public void setPreview_projTotalSiteAcres(String preview_projTotalSiteAcres) {
		this.preview_projTotalSiteAcres = preview_projTotalSiteAcres;
	}
	
	public String getPreview_SingleFamilyResi() {
		return preview_SingleFamilyResi;
	}
	public void setPreview_SingleFamilyResi(String preview_SingleFamilyResi) {
		this.preview_SingleFamilyResi = preview_SingleFamilyResi;
	}
	public String getPreview_MultiFamilyResi() {
		return preview_MultiFamilyResi;
	}
	public void setPreview_MultiFamilyResi(String preview_MultiFamilyResi) {
		this.preview_MultiFamilyResi = preview_MultiFamilyResi;
	}
	public String getPreview_Commercial() {
		return preview_Commercial;
	}
	public void setPreview_Commercial(String preview_Commercial) {
		this.preview_Commercial = preview_Commercial;
	}
	public String getPreview_Industrial() {
		return preview_Industrial;
	}
	public void setPreview_Industrial(String preview_Industrial) {
		this.preview_Industrial = preview_Industrial;
	}
	public String getPreview_Institutional() {
		return preview_Institutional;
	}
	public void setPreview_Institutional(String preview_Institutional) {
		this.preview_Institutional = preview_Institutional;
	}
	public String getPreview_HYWY() {
		return preview_HYWY;
	}
	public void setPreview_HYWY(String preview_HYWY) {
		this.preview_HYWY = preview_HYWY;
	}
	public String getPreview_Utility() {
		return preview_Utility;
	}
	public void setPreview_Utility(String preview_Utility) {
		this.preview_Utility = preview_Utility;
	}
	public String getPreview_Other() {
		return preview_Other;
	}
	public void setPreview_Other(String preview_Other) {
		this.preview_Other = preview_Other;
	}
	public String getPreview_Latitude() {
		return preview_Latitude;
	}
	public void setPreview_Latitude(String preview_Latitude) {
		this.preview_Latitude = preview_Latitude;
	}
	public String getPreview_Longitude() {
		return preview_Longitude;
	}
	public void setPreview_Longitude(String preview_Longitude) {
		this.preview_Longitude = preview_Longitude;
	}
	public String getPreview_DischargeMS4() {
		return preview_DischargeMS4;
	}
	public void setPreview_DischargeMS4(String preview_DischargeMS4) {
		this.preview_DischargeMS4 = preview_DischargeMS4;
	}
	public String getPreview_Discharge50FtDisturbance() {
		return preview_Discharge50FtDisturbance;
	}
	public void setPreview_Discharge50FtDisturbance(
			String preview_Discharge50FtDisturbance) {
		this.preview_Discharge50FtDisturbance = preview_Discharge50FtDisturbance;
	}
	public String getPreview_MS4Jurisdiction() {
		return preview_MS4Jurisdiction;
	}
	public void setPreview_MS4Jurisdiction(String preview_MS4Jurisdiction) {
		this.preview_MS4Jurisdiction = preview_MS4Jurisdiction;
	}
	public String getPreview_DischargeID() {
		return preview_DischargeID;
	}
	public void setPreview_DischargeID(String preview_DischargeID) {
		this.preview_DischargeID = preview_DischargeID;
	}
	public String getPreview_DischargeReceavingWater() {
		return preview_DischargeReceavingWater;
	}
	public void setPreview_DischargeReceavingWater(
			String preview_DischargeReceavingWater) {
		this.preview_DischargeReceavingWater = preview_DischargeReceavingWater;
	}
	public String getPreview_DischargeDescription() {
		return preview_DischargeDescription;
	}
	public void setPreview_DischargeDescription(String preview_DischargeDescription) {
		this.preview_DischargeDescription = preview_DischargeDescription;
	}
	public String getPreview_DischargeCWA() {
		return preview_DischargeCWA;
	}
	public void setPreview_DischargeCWA(String preview_DischargeCWA) {
		this.preview_DischargeCWA = preview_DischargeCWA;
	}
	public String getPreview_DischargeTMDL() {
		return preview_DischargeTMDL;
	}
	public void setPreview_DischargeTMDL(String preview_DischargeTMDL) {
		this.preview_DischargeTMDL = preview_DischargeTMDL;
	}
	public String getPreview_swpppPreparedAdvance() {
		return preview_swpppPreparedAdvance;
	}
	public void setPreview_swpppPreparedAdvance(String preview_swpppPreparedAdvance) {
		this.preview_swpppPreparedAdvance = preview_swpppPreparedAdvance;
	}
	
	public String getPreview_Status() {
		return preview_Status;
	}
	public void setPreview_Status(String preview_Status) {
		this.preview_Status = preview_Status;
	}
	public String getLoginSSOID() {
		return loginSSOID;
	}
	public void setLoginSSOID(String loginSSOID) {
		this.loginSSOID = loginSSOID;
	}


	public String getPreview_autoId() {
		return preview_autoId;
	}
	public void setPreview_autoId(String preview_autoId) {
		this.preview_autoId = preview_autoId;
	}
	public String loadNoiPreview(){
		
		CertifierPreviewDAO.selectNoiFormMaster11(this);
		return "viewNoi";
		
	}
	
	
}
