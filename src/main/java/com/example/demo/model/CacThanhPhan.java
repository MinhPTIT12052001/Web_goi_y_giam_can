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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cacthanhphan")
public class CacThanhPhan implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(columnDefinition = "nvarchar(255) not null", name = "tenthanhphan")
	private String tenThanhPhan;
	@Column(name = "phantram", nullable = false)
	private int phanTram;
	@OneToMany(mappedBy = "cacThanhPhan", cascade = CascadeType.ALL)
	private List<ThucPham> listThucPham = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="chedoanid")
	private CheDoAn cheDoAn;
}
