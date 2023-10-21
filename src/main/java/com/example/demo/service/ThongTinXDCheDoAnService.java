package com.example.demo.service;

import com.example.demo.model.CheDoAn;

public interface ThongTinXDCheDoAnService {

	CheDoAn getCheDoAn(String mucdich, Integer huyetap, Integer tieuDuong, String stress, Integer bMI);
}
