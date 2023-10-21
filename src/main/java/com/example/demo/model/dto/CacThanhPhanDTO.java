package com.example.demo.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CacThanhPhanDTO {
	private String ten;
	private List<ThucPhamDTO> listTP;
}
