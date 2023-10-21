package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "thongtinxdchedotapluyen")
public class ThongTinXDCheDoTapLuyen implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(columnDefinition = "nvarchar(255) not null", name = "tinhtrangthechat")
	private String tinhTrangTheChat;
	@Column(columnDefinition = "nvarchar(255) not null", name = "level")
	private String level;
	@Column(columnDefinition = "nvarchar(255) not null", name = "tocdogiamcan")
	private String tocDoGiamCan;
	@Column(name = "bmi", nullable = false)
	private int bMI;
	@ManyToOne
	@JoinColumn(name="cuongdoluyentapid")
	private CuongDoLuyenTap cuongDoLuyenTap;
}
