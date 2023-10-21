package com.example.demo.model.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Form1 {
	private int gioitinh; //0-nu, 1-nam
	private int tuoi;
	private int cannang;
	private int chieucao;
	private int thoigiantapluyen;
}
