package com.example.demo.model.mapper;

import com.example.demo.model.MonTheThao;
import com.example.demo.model.dto.MonTheThaoDTO;

public class MonTheThaoMapper {
	public static MonTheThaoDTO toDTO(MonTheThao m, Integer calo) {
		MonTheThaoDTO x = new MonTheThaoDTO(m.getTen(), calo*60/m.getLuongCalotrenTieng(), m.getLink());
		System.out.println(x.getTen()+"-"+x.getThoigiantap());
		return x;
	}
}
