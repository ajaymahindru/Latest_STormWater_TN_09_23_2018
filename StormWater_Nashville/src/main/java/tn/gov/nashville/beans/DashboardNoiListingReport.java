package tn.gov.nashville.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import tn.gov.nashville.dao.CertifierCommon_DAO;
import tn.gov.nashville.dao.NoiFormCommon_DAO;
import tn.gov.nashville.dao.Noi_DAO;

import org.apache.log4j.Logger;

@ManagedBean(name="dashboardNoiReport")
@ViewScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardNoiListingReport implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	//@ManagedProperty("#{dashboardNoi}")
	//private DashboardNoiListing reportList1;
	
	// String abc = reportList1.
	
	List<DashboardNoiListing> reportList;
	@ManagedProperty(value="#{login}") 
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	public List<DashboardNoiListing> getReportList() {
		
		
		return reportList;
	}


	public void setReportList(List<DashboardNoiListing> reportList) {
	
		this.reportList = reportList;
	}
	@PostConstruct
	public void searchCerifierReport() {
		
		this.reportList = CertifierCommon_DAO.selectNoiListFormMaster(login.getUniqueId());
				
	}

	
	
}
