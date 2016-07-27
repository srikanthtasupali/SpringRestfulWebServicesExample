package org.ets.eskm.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "AD_CAMPAIGN")
public class AdCampaign {

	
	private Integer _id;
	private String _partnerId;
	private String _adContent;
	private int _duration;
	private Date _created;
	
	public AdCampaign(int id, String partnerId, String adContent, int duration){
		_id = id;
		_partnerId = partnerId;
		_adContent = adContent;
		_duration = duration;
		
	}
	public AdCampaign(){};
	@Id @Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return _id;
	}
	
	public void setId(Integer id) {
		_id = id;
	}
	
	@Column(name = "PARTNER_ID")
	public String getPartnerId() {
		return _partnerId;
	}
	public void setPartnerId(String partnerId) {
		_partnerId = partnerId;
	}
	
	@Column(name = "AD_CONTENT")
	public String getAdContent() {
		return _adContent;
	}
	public void setAdContent(String adContent) {
		_adContent = adContent;
	}
	
	@Column(name = "DURATION")
	public int getDuration() {
		return _duration;
	}
	public void setDuration(int duration) {
		_duration = duration;
	}

	@Column(name = "CRET_DTM")
	public Date getCreated() {
		return _created;
	}
	public void setCreated(Date created) {
		_created = created;
	}

}
