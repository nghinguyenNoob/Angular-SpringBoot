package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.repository.NhanVienRepository;

@Controller
public class NhanVienController {

	@Autowired
	private NhanVienRepository nvRepo;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String index(Model model) {
		model.addAttribute("message", nvRepo.findAll().get(0).getTenNhanVien());
		return "listnhanvien";
	}
}
