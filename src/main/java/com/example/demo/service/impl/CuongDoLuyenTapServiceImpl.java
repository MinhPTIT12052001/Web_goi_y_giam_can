package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MonTheThao;
import com.example.demo.repository.CuongDoLuyenTapRepository;
import com.example.demo.service.CuongDoLuyenTapService;

@Service
public class CuongDoLuyenTapServiceImpl implements CuongDoLuyenTapService{
	@Autowired
	CuongDoLuyenTapRepository c;
	
	@Override
	public List<MonTheThao> getListMonTheThao(Integer cuongDoID) {
		return c.getById(cuongDoID).getListMonTheThao();
	}
	
}
