package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CheDoAn;
import com.example.demo.model.ThongTinXDCheDoAn;
import com.example.demo.repository.CheDoAnRepository;
import com.example.demo.repository.ThongTinXDCheDoAnRepository;
import com.example.demo.service.ThongTinXDCheDoAnService;

@Service
public class ThongTinXDCheDoAnServiceImpl implements ThongTinXDCheDoAnService{
	@Autowired
	ThongTinXDCheDoAnRepository xdcda;
	@Autowired
	CheDoAnRepository cda;

	@Override
	public CheDoAn getCheDoAn(String mucdich, Integer huyetap, Integer tieuDuong, String stress, Integer bMI) {
		ThongTinXDCheDoAn t = xdcda.findCheDoAn(mucdich, huyetap, tieuDuong, stress, bMI);
		if(t!=null)
			return t.getCheDoAn();
		double a1 = (xdcda.countMucDich(mucdich, 1)*xdcda.countCaoHuyetAp(huyetap, 1)*xdcda.countTieuDuong(tieuDuong, 1)
				*xdcda.countStress(stress, 1)*xdcda.countBMI(bMI, 1))/(xdcda.count()*Math.pow(xdcda.countCheDoAn(1), 4));
		double a2 = (xdcda.countMucDich(mucdich, 2)*xdcda.countCaoHuyetAp(huyetap, 2)*xdcda.countTieuDuong(tieuDuong, 2)
				*xdcda.countStress(stress, 2)*xdcda.countBMI(bMI, 2))/(xdcda.count()*Math.pow(xdcda.countCheDoAn(2), 4));
		double a3 = (xdcda.countMucDich(mucdich, 3)*xdcda.countCaoHuyetAp(huyetap, 3)*xdcda.countTieuDuong(tieuDuong, 3)
				*xdcda.countStress(stress, 3)*xdcda.countBMI(bMI, 3))/(xdcda.count()*Math.pow(xdcda.countCheDoAn(1), 4));
		if(a1>=a2) {
			if(a1>=a3) return cda.getById(1);
			return cda.getById(3);
		}
		else {
			if(a2>=a3) return cda.getById(2);
			return cda.getById(3);
		}
	}
}
