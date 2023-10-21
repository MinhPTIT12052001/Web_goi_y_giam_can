package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CacThanhPhan;
import com.example.demo.repository.CheDoAnRepository;
import com.example.demo.service.CheDoAnService;

@Service
public class CheDoAnServiceImpl implements CheDoAnService{
	@Autowired
	CheDoAnRepository c;

	@Override
	public List<CacThanhPhan> getListCacThanhPhan(Integer cheDoAnID) {
		return c.getById(cheDoAnID).getListCacThanhPhan();
	}
	
	
}
