package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ThongTinXDCheDoAn;

@Repository
public interface ThongTinXDCheDoAnRepository extends JpaRepository<ThongTinXDCheDoAn, Integer>{
	@Query("SELECT t FROM ThongTinXDCheDoAn t WHERE t.mucDichGiamCan LIKE ?1 and t.caoHuyetAp=?2 and "
			+ "t.tieuDuongvaTim=?3 and t.stress LIKE ?4 and t.bMI=?5")
	public ThongTinXDCheDoAn findCheDoAn(String mucDichGiamCan, Integer caoHuyetAp, Integer tieuDuongvaTim, String stress, Integer bMI);
	
	@Query(value="select COUNT(1) from thongtinxdchedoan t where t.mucdichgiamcan LIKE ?1 and t.chedoanid=?2", nativeQuery = true)
	public Integer countMucDich(String mucDichGiamCan, Integer chedo);
	
	@Query(value="select COUNT(1) from thongtinxdchedoan t where t.caohuyetap=?1 and t.chedoanid=?2", nativeQuery = true)
	public Integer countCaoHuyetAp(Integer caoHuyetAp, Integer chedo);
	
	@Query(value="select COUNT(1) from thongtinxdchedoan t where t.tieuduongvatim=?1 and t.chedoanid=?2", nativeQuery = true)
	public Integer countTieuDuong(Integer tieuDuongvaTim, Integer chedo);
	
	@Query(value="select COUNT(1) from thongtinxdchedoan t where t.bmi=?1 and t.chedoanid=?2", nativeQuery = true)
	public Integer countBMI(Integer bMI, Integer chedo);
	
	@Query(value="select COUNT(1) from thongtinxdchedoan t where t.stress LIKE ?1 and t.chedoanid=?2", nativeQuery = true)
	public Integer countStress(String stress, Integer chedo);
	
	@Query(value="select COUNT(1) from thongtinxdchedoan t where t.chedoanid=?1", nativeQuery = true)
	public Integer countCheDoAn(Integer chedo);
}
