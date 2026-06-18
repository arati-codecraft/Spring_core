package org.model;

public class MSME {
	private Company company;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void showCompanyDetails() {
		System.out.println(company.getName()+"\t"+company.getTAN()+"\t"+company.getPAN());
	}

}
