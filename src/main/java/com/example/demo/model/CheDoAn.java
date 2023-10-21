package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "chedoan")
public class CheDoAn implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(columnDefinition = "nvarchar(255) not null", name = "ten")
	private String ten;
	@Column(columnDefinition = "ntext", name = "mota")
	private String moTa;
	@Column(columnDefinition = "ntext", name = "huongdan")
	private String huongDan;
	@OneToMany(mappedBy = "cheDoAn", cascade = CascadeType.ALL)
	private List<CacThanhPhan> listCacThanhPhan = new ArrayList<>();
	@OneToMany(mappedBy = "cheDoAn", cascade = CascadeType.ALL)
	private List<ThongTinXDCheDoAn> listXDCheDoAn = new ArrayList<>();
}
