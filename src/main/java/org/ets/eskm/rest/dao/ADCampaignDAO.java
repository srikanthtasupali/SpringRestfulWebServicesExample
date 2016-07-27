package org.ets.eskm.rest.dao;

import java.util.Date;
import java.util.List;

import org.ets.eskm.rest.entity.AdCampaign;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ADCampaignDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Transactional(readOnly = true)
	public AdCampaign get(String partnerId) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		AdCampaign adCampaign =
				 (AdCampaign)session.createCriteria(AdCampaign.class)
				 .add(Restrictions.eq("partnerId", partnerId)).uniqueResult();
		if(new Date().compareTo(new Date(adCampaign.getCreated().getTime() + (adCampaign.getDuration()*1000))) > 0){
			throw new Exception("no live campaigns");
		}
		return adCampaign;
	}
	
	@Transactional(readOnly = true)
	public List<AdCampaign> getAll(){
		Session session = sessionFactory.getCurrentSession();
		return (List<AdCampaign>)session.createCriteria(AdCampaign.class)
					.list();
	}
	
	@Transactional
	public AdCampaign add(AdCampaign adCampaign) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		AdCampaign exisitingAdCampaign =
				 (AdCampaign)session.createCriteria(AdCampaign.class)
				 .add(Restrictions.eq("partnerId", adCampaign.getPartnerId())).uniqueResult();
		
		if(exisitingAdCampaign != null){
			throw new Exception("partner already exist---"+ adCampaign.getPartnerId());
		}
		
		adCampaign.setCreated(new Date());
		session.save(adCampaign);
		return adCampaign;
	}
}
