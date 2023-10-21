package com.example.demo.model.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.example.demo.model.ThucPham;
import com.example.demo.model.dto.ThucPhamDTO;

public class ThucPhamMapper {
	public static ThucPhamDTO toDTO(ThucPham t, Integer luongCalo) {
		ThucPhamDTO tp = new ThucPhamDTO(t.getTen(), luongCalo*100/t.getLuongCalotrenKg());
		System.out.println(tp.getTen() + "-" + tp.getLuong());
		return tp;
	}
	
	public static List<ThucPhamDTO> toListDTO(List<ThucPham> l, Integer luongCalo) {
		List<ThucPhamDTO> list = new ArrayList<>();
		Set<Integer> s = new HashSet<>();
		int n = l.size()>4?5:l.size();
		Random rand = new Random();
		while(s.size()<n) {
            int ranNum = rand.nextInt(l.size());
            s.add(ranNum);
		}
		for (Integer i : s) {
			list.add(toDTO(l.get(i), luongCalo));
		}
		return list;
	}
}
