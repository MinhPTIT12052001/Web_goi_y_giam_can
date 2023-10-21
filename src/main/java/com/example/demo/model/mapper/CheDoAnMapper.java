package com.example.demo.model.mapper;

import com.example.demo.model.CheDoAn;
import com.example.demo.model.dto.CheDoAnDTO;

public class CheDoAnMapper {
	public static CheDoAnDTO toDTO(CheDoAn c) {
		return new CheDoAnDTO(c.getTen(), c.getMoTa(), c.getHuongDan());
	}
}
