package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CuongDoLuyenTap;

@Repository
public interface CuongDoLuyenTapRepository extends JpaRepository<CuongDoLuyenTap, Integer>{

}
