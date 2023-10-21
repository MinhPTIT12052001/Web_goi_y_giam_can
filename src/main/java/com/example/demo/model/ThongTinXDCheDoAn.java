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
@Table(name = "thongtinxdchedoan")
public class ThongTinXDCheDoAn implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(columnDefinition = "nvarchar(255) not null", name = "mucdichgiamcan")
	private String mucDichGiamCan;
	@Column(name = "caohuyetap", nullable = false)
	private int caoHuyetAp;
	@Column(name = "tieuduongvatim", nullable = false)
	private int tieuDuongvaTim;
	@Column(columnDefinition = "nvarchar(255) not null", name = "stress")
	private String stress;
	@Column(name = "bmi", nullable = false)
	private int bMI;
	@ManyToOne
	@JoinColumn(name="chedoanid")
	private CheDoAn cheDoAn;
}
