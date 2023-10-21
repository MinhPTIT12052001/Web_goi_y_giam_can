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
@Table(name = "cuongdoluyentap")
public class CuongDoLuyenTap implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(columnDefinition = "nvarchar(255) not null", name = "loai")
	private String loai;
	@OneToMany(mappedBy = "cuongDoLuyenTap", cascade = CascadeType.ALL)
	private List<MonTheThao> listMonTheThao = new ArrayList<>();
	@OneToMany(mappedBy = "cuongDoLuyenTap", cascade = CascadeType.ALL)
	private List<ThongTinXDCheDoTapLuyen> listXDCheDoTapLuyen = new ArrayList<>();
}
