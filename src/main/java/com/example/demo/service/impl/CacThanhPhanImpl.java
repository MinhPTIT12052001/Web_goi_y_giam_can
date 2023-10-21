package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ThucPham;
import com.example.demo.repository.CacThanhPhanRepository;
import com.example.demo.service.CacThanhPhanService;

@Service
public class CacThanhPhanImpl implements CacThanhPhanService{
	@Autowired
	CacThanhPhanRepository c;

	@Override
	public List<ThucPham> getListThucPham(Integer thanhPhanID) {
		return c.getById(thanhPhanID).getListThucPham();
	}
	

}
