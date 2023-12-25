package ngoc.webbansach_backend.service.nguoidung;

import jakarta.transaction.Transactional;
import ngoc.webbansach_backend.entity.NguoiDung;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public NguoiDung findByUsername(String tenDangNhap);

    List<NguoiDung> findListNguoiDung();

    @Transactional
    NguoiDung themNguoiDung(NguoiDung nguoiDung);

    @Transactional
    NguoiDung updateNguoiDung(int maNguoiDung, NguoiDung nguoiDung);

    @Transactional
    void Delete(int maNguoiDung);
}
