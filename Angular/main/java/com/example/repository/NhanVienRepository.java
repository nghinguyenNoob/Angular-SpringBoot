/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.NhanVien;

/**
 * @author nc_nghi
 *
 */
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

}
