package ngoc.webbansach_backend.service.user;

import jakarta.transaction.Transactional;
import ngoc.webbansach_backend.entity.NguoiDung;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public NguoiDung findByUsername(String tenDangNhap);


}
