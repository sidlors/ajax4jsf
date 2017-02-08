package com.sidlors.model;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

@CsvDataType()
public class ResultModel {

	/**
	 * 
	 */
	@CsvField(pos = 1)private static final long serialVersionUID = 578857834681625235L;

	@CsvField(pos = 2)private String sourcetable;

	@CsvField(pos = 3)private String fieldchanges;

	@CsvField(pos = 4)private String hitdate;

	@CsvField(pos = 5)private String accountnumber;

	@CsvField(pos = 6)private String fid;

	@CsvField(pos = 7)private String first;

	@CsvField(pos = 8)private String paternal;

	@CsvField(pos = 9)private String maternal;

	@CsvField(pos = 10)private String rfc;

	@CsvField(pos = 11)private String parent_id;

	@CsvField(pos = 12)private String companyname;

	@CsvField(pos = 13)private String type;

	public String getSourcetable() {
		return sourcetable;
	}

	public void setSourcetable(String sourcetable) {
		this.sourcetable = sourcetable;
	}

	public String getHitdate() {
		return hitdate;
	}

	public void setHitdate(String hitdate) {
		this.hitdate = hitdate;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getPaternal() {
		return paternal;
	}

	public void setPaternal(String paternal) {
		this.paternal = paternal;
	}

	public String getMaternal() {
		return maternal;
	}

	public void setMaternal(String maternal) {
		this.maternal = maternal;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFieldchanges() {
		return fieldchanges;
	}

	public void setFieldchanges(String fieldchanges) {
		this.fieldchanges = fieldchanges;
	}

	public ResultModel(String sourcetable, String fieldchanges, String hitdate, String accountnumber, String fid,
			String first, String paternal, String maternal, String rfc, String parent_id, String companyname,
			String type) {
		super();
		this.sourcetable = sourcetable;
		this.fieldchanges = fieldchanges;
		this.hitdate = hitdate;
		this.accountnumber = accountnumber;
		this.fid = fid;
		this.first = first;
		this.paternal = paternal;
		this.maternal = maternal;
		this.rfc = rfc;
		this.parent_id = parent_id;
		this.companyname = companyname;
		this.type = type;
	}

	@Override
	public String toString() {
		return fid + "," + fieldchanges + " , " + sourcetable + "," + hitdate + "," + accountnumber + "," + first + ","
				+ paternal + "," + maternal + "," + rfc + "," + parent_id + "," + companyname + "," + type + "\r\n";
	}
}
