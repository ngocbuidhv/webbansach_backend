package ngoc.webbansach_backend.dao;

import jakarta.transaction.Transactional;
import ngoc.webbansach_backend.entity.DonHang;
import ngoc.webbansach_backend.entity.NguoiDung;
import ngoc.webbansach_backend.entity.Quyen;
import ngoc.webbansach_backend.entity.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "nguoi-dung")
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    public boolean existsByTenDangNhap(String tenDangNhap);

    public boolean existsByEmail(String email);

    public NguoiDung findByTenDangNhap(String tenDangNhap);

    public NguoiDung findByEmail(String email);

//    ------------------------
    Page<NguoiDung> findByMaNguoiDung(int maNguoiDung, Pageable pageable);
}
