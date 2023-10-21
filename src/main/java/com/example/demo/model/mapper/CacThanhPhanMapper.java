package com.example.demo.model.mapper;

import java.util.List;

import com.example.demo.model.dto.CacThanhPhanDTO;
import com.example.demo.model.dto.ThucPhamDTO;

public class CacThanhPhanMapper {
	public static CacThanhPhanDTO toDTO(String ten, List<ThucPhamDTO> l) {
		return new CacThanhPhanDTO(ten, l);
	}
	
}
