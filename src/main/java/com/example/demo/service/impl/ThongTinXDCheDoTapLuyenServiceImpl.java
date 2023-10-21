package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CuongDoLuyenTap;
import com.example.demo.model.ThongTinXDCheDoTapLuyen;
import com.example.demo.repository.CuongDoLuyenTapRepository;
import com.example.demo.repository.ThongTinXDCheDoTapLuyenRepository;
import com.example.demo.service.ThongTinXDCheDoTapLuyenService;

@Service
public class ThongTinXDCheDoTapLuyenServiceImpl implements ThongTinXDCheDoTapLuyenService{
	@Autowired
	ThongTinXDCheDoTapLuyenRepository xdcdtl;
	@Autowired
	CuongDoLuyenTapRepository cdlt;
	@Override
	public CuongDoLuyenTap getCuongDoLuyenTap(String thechat, String level, String tocdo, Integer bmi) {
		ThongTinXDCheDoTapLuyen t = xdcdtl.findCuongDo(thechat, level, tocdo, bmi);
		if(t!=null)
			return t.getCuongDoLuyenTap();
		double a1 = (xdcdtl.countTheChat(thechat, 1)*xdcdtl.countLevel(level, 1)*xdcdtl.countTocDo(tocdo, 1)
				*xdcdtl.countBMI(bmi, 1))/(xdcdtl.count()*Math.pow(xdcdtl.countCuongDo(1), 3));
		double a2 = (xdcdtl.countTheChat(thechat, 2)*xdcdtl.countLevel(level, 2)*xdcdtl.countTocDo(tocdo, 2)
				*xdcdtl.countBMI(bmi, 2))/(xdcdtl.count()*Math.pow(xdcdtl.countCuongDo(2), 3));
		double a3 = (xdcdtl.countTheChat(thechat, 3)*xdcdtl.countLevel(level, 3)*xdcdtl.countTocDo(tocdo, 3)
				*xdcdtl.countBMI(bmi, 3))/(xdcdtl.count()*Math.pow(xdcdtl.countCuongDo(1), 3));
		if(a1>=a2) {
			if(a1>=a3) return cdlt.getById(1);
			return cdlt.getById(3);
		}
		else {
			if(a2>=a3) return cdlt.getById(2);
			return cdlt.getById(3);
		}
	}
	
	
}
