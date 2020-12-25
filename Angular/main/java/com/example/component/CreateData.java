package com.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.model.NhanVien;
import com.example.repository.NhanVienRepository;

@Component
public class CreateData {
	
	@Autowired
	NhanVienRepository  nv;
	
	@EventListener
    public void doorBellEventListener() {
		NhanVien nhanvien = new NhanVien("001", "Nguyen Van Bao", "", "");
        nv.save(nhanvien);
    }

}
