package ngoc.webbansach_backend.service;

import ngoc.webbansach_backend.dao.NguoiDungRepository;
import ngoc.webbansach_backend.entity.NguoiDung;
import ngoc.webbansach_backend.entity.ThongBao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    public ResponseEntity<?> dangKyNguoiDung(NguoiDung nguoiDung){
        // kiểm tra tên đăng nhập đã tồn tại chưa
        if(nguoiDungRepository.existsByTenDangNhap(nguoiDung.getTenDangNhap())){
            return ResponseEntity.badRequest().body(new ThongBao("Tên đăng nhập đã tồn tại"));
        }
        // kiểm tra tên email đã tồn tại chưa
        if(nguoiDungRepository.existsByEmail(nguoiDung.getEmail())){
            return ResponseEntity.badRequest().body(new ThongBao("Email đã tồn tại"));
        }

        // lưu người dùng vào csdl
        NguoiDung nguoiDung_daDangKy = nguoiDungRepository.save(nguoiDung);
        return ResponseEntity.ok("Đăng ký thành công");
    }
}
