package ngoc.webbansach_backend.controller;

import ngoc.webbansach_backend.entity.NguoiDung;
import ngoc.webbansach_backend.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tai-khoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKyNguoiDung(@Validated  @RequestBody NguoiDung nguoiDung){
        ResponseEntity<?> response = taiKhoanService.dangKyNguoiDung(nguoiDung);
        return response;
    }
}
