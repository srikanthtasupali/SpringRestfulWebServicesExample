package org.adcampaign.controller;
import java.util.List;

import org.ets.eskm.rest.dao.ADCampaignDAO;
import org.ets.eskm.rest.entity.AdCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class SpringRestController {
	
	@Autowired
	ADCampaignDAO dao;
	
 @RequestMapping(value = "/{name}", method = RequestMethod.GET)
 public String hello(@PathVariable String name) {
  String result="Hello "+name;  
  return result;
 }
 
 @RequestMapping(value = "/ad/{partnerid}", method = RequestMethod.GET)
	public AdCampaign getAdCampaign(@PathVariable final String partnerid) throws Exception{
	 return dao.get(partnerid);

	}
 
 	@RequestMapping(value = "/allAds", method = RequestMethod.GET)
	public List<AdCampaign> getAllAds() {		
		return dao.getAll();

	}
 
 	@RequestMapping(value = "/ad", method = RequestMethod.POST)
 	public AdCampaign createAdCampaign( @RequestBody AdCampaign adCampaign) throws Exception {
		return dao.add(adCampaign);
	}
}