package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.CacThanhPhan;
import com.example.demo.model.CheDoAn;
import com.example.demo.model.CuongDoLuyenTap;
import com.example.demo.model.MonTheThao;
import com.example.demo.model.ThongTinXDCheDoAn;
import com.example.demo.model.ThucPham;
import com.example.demo.model.dto.CacThanhPhanDTO;
import com.example.demo.model.dto.MonTheThaoDTO;
import com.example.demo.model.mapper.CacThanhPhanMapper;
import com.example.demo.model.mapper.MonTheThaoMapper;
import com.example.demo.model.mapper.ThucPhamMapper;
import com.example.demo.model.question.Form1;
import com.example.demo.model.question.Form2;
import com.example.demo.repository.ThongTinXDCheDoAnRepository;
import com.example.demo.service.CacThanhPhanService;
import com.example.demo.service.CheDoAnService;
import com.example.demo.service.CuongDoLuyenTapService;
import com.example.demo.service.ThongTinXDCheDoAnService;
import com.example.demo.service.ThongTinXDCheDoTapLuyenService;

@Controller
@RequestMapping("/")
public class Test {
	private static int tdee;
	private static double bmr;
	private static int bmi;
	private static int luongcalogiamdi;
	private static double r;
	private static Form1 f1;
	private static Form2 f2;
	
	@Autowired
	ThongTinXDCheDoAnService t;
	@Autowired
	ThongTinXDCheDoTapLuyenService c;
	@Autowired
	CheDoAnService cda;
	@Autowired
	CacThanhPhanService tp;
	@Autowired
	CuongDoLuyenTapService cdlt;
	@Autowired
	ThongTinXDCheDoAnRepository thongTinXDCheDoAnRepository;
	@GetMapping("/")
	public String test(Model model) {
		model.addAttribute("form1", new Form1());
		return "Form1";
		
	}
	
	@PostMapping("/form1")
	public ModelAndView xulyForm1(ModelMap model, @ModelAttribute("form1") Form1 form1) {
		System.out.println(form1.getCannang()+" "+form1.getChieucao()+" "+form1.getGioitinh()+" "+form1.getThoigiantapluyen()+" "+form1.getTuoi());
		if( (form1.getCannang()<=0) || form1.getChieucao()<=0||form1.getThoigiantapluyen()<=0||form1.getTuoi()<=0) {
			model.addAttribute("mes", "Vui lòng nhập thông tin đầy đủ. Các ô Cân nặng, Chiều cao, Tuổi phải có giá trị >0");
			return new ModelAndView("Form1",model);
		}
		if(form1.getGioitinh()==0) {
			bmr = 447.593 + 9.247*form1.getCannang() + 3.098*form1.getChieucao() - 4.33*form1.getTuoi();
		}
		else {
			bmr = 88.362 + 13.397*form1.getCannang() + 4.799*form1.getChieucao() - 5.677*form1.getTuoi();
		}
		if(form1.getThoigiantapluyen()<4) r=1.375;
		else if(form1.getThoigiantapluyen()<6) r=1.55;
		else if(form1.getThoigiantapluyen()<8) r=1.725;
		else r=1.9;
		tdee = (int)Math.round(bmr*r);
		double x = (form1.getCannang()*10000)/(form1.getChieucao()*form1.getChieucao());
		String tinhTrang;
		if(x<18.5) {
			bmi=0;
			tinhTrang="Thiếu Cân";
		}
		else if(x<25) {
			bmi=3;
			tinhTrang="Cân Bằng";
		}
		else if(x<30) { 
			bmi=4;
			tinhTrang="Thừa Cân";
		}
		else {
			bmi=5;
			tinhTrang="Béo Phì";
		}
		
		f1=form1;
		if(bmi==0) {
			model.addAttribute("next",0);
		}
		else {
			model.addAttribute("next",1);
		}
		model.addAttribute("bmi",x);
		model.addAttribute("tinhTrang", tinhTrang);
		return new ModelAndView("BMI",model);
	}
	@RequestMapping("/form2")
	public String form2(Model model) {
		model.addAttribute("form2", new Form2());
		return "Form2";
	}
	@PostMapping("/xulyform2")
	public ModelAndView xulyForm2(ModelMap model, @ModelAttribute("form2") Form2 form2) {
		if( form2.getLevel()==null|| form2.getMucdich()==null||form2.getStress()==null||form2.getThechat()==null||form2.getTocdo()==null) {
			model.addAttribute("mes", "Vui lòng chọn đầy đủ thông tin.");
			return new ModelAndView("Form2",model);
		}
		if(form2.getTocdo().equalsIgnoreCase("nhanh")) {
			luongcalogiamdi=15;
		}
		else if(form2.getTocdo().equalsIgnoreCase("binh thuong")) {
			luongcalogiamdi=10;
		}
		else {
			luongcalogiamdi=5;
		}
		f2=form2;
		return new ModelAndView("redirect:/chedoan",model);
	}
	
	@GetMapping("/chedoan")
    public String menuThucPham(Model model){
		int tongcalo = tdee*(100-luongcalogiamdi)/100;
		CheDoAn x = t.getCheDoAn(f2.getMucdich(), f2.getHuyetap(), f2.getTieuduongvatim(), f2.getStress(),bmi);
		System.out.println(x.getId());
		List<CacThanhPhanDTO> list = new ArrayList<>();
		for (CacThanhPhan i : x.getListCacThanhPhan()) {
			System.out.println("***************************************************");
			System.out.println(i.getTenThanhPhan()+"-"+tongcalo*i.getPhanTram()/100);
			List<ThucPham> l = tp.getListThucPham(i.getId());
			list.add(CacThanhPhanMapper.toDTO(i.getTenThanhPhan(), ThucPhamMapper.toListDTO(l, tongcalo*i.getPhanTram()/100)));
		}
		model.addAttribute("menuchedoan", list);
		model.addAttribute("chedoan", x);
		System.out.println("\n\n"+x.getTen()+"\n\n");
		
		return "CheDoAn";
    }
	
	@GetMapping("/chedotapluyen")
    public String menuTheoThao(Model model){
		int calotap1buoi = (int)Math.round(bmr*(r-1.2)*7/f1.getThoigiantapluyen());
		CuongDoLuyenTap x = c.getCuongDoLuyenTap(f2.getThechat(), f2.getLevel(), f2.getTocdo(), bmi);
		System.out.println(x.getId());
		List<MonTheThaoDTO> list = new ArrayList<>();
		for (MonTheThao i : x.getListMonTheThao()) {
			list.add(MonTheThaoMapper.toDTO(i,calotap1buoi));
		}
		model.addAttribute("menuluyentap", list);
		model.addAttribute("chedotapluyen", x);
		String sobuoitap="";
		if(f1.getThoigiantapluyen()==14)sobuoitap="2 lần/ ngày";
		else sobuoitap=f1.getThoigiantapluyen()+" buổi/ tuần";
		model.addAttribute("sobuoitap", sobuoitap);
		System.out.println("so buoi tap: "+sobuoitap+"   thoigiantapluyen"+f1.getThoigiantapluyen());
		return "CheDoTapLuyen";
    }
}
