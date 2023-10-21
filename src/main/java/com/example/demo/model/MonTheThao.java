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
@Table(name = "monthethao")
public class MonTheThao implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(columnDefinition = "nvarchar(255) not null", name = "ten")
	private String ten;
	@Column(name = "luongcalotrentieng", nullable = false)
	private int luongCalotrenTieng;
	@Column(columnDefinition = "nvarchar(255)", name = "link")
	private String link;
	@ManyToOne
	@JoinColumn(name="cuongdoluyentapid")
	private CuongDoLuyenTap cuongDoLuyenTap;
}
