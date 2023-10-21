package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ThongTinXDCheDoTapLuyen;

@Repository
public interface ThongTinXDCheDoTapLuyenRepository extends JpaRepository<ThongTinXDCheDoTapLuyen, Integer>{
	@Query("SELECT t FROM ThongTinXDCheDoTapLuyen t WHERE t.tinhTrangTheChat LIKE ?1 and t.level LIKE ?2 and "
			+ "t.tocDoGiamCan LIKE ?3 and t.bMI=?4")
	public ThongTinXDCheDoTapLuyen findCuongDo(String thechat, String level, String tocdo, Integer bmi);
	
	@Query(value="select COUNT(1) from thongtinxdchedotapluyen t where t.tinhtrangthechat LIKE ?1 and t.cuongdoluyentapid=?2", nativeQuery = true)
	public Integer countTheChat(String tinhtrangthechat, Integer cuongdo);
	
	@Query(value="select COUNT(1) from thongtinxdchedotapluyen t where t.level LIKE ?1 and t.cuongdoluyentapid=?2", nativeQuery = true)
	public Integer countLevel(String level, Integer cuongdo);
	
	@Query(value="select COUNT(1) from thongtinxdchedotapluyen t where t.tocdogiamcan LIKE ?1 and t.cuongdoluyentapid=?2", nativeQuery = true)
	public Integer countTocDo(String tocdo, Integer cuongdo);
	
	@Query(value="select COUNT(1) from thongtinxdchedotapluyen t where t.bmi=?1 and t.cuongdoluyentapid=?2", nativeQuery = true)
	public Integer countBMI(Integer bmi, Integer cuongdo);
	
	@Query(value="select COUNT(1) from thongtinxdchedotapluyen t where t.cuongdoluyentapid=?1", nativeQuery = true)
	public Integer countCuongDo(Integer cuongdo);
}
