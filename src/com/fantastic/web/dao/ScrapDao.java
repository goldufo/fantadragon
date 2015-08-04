package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Scrap;

public interface ScrapDao {
	
	public List<Scrap> getScrap(
			int page,
			String field,
			String query
			);
	
	public List<Scrap> getScrap(
			int page
			);
	
	public int addScrap(Scrap scrap);
	
	public List<Scrap> removeScrap(String memberId, String travelCode);

}
