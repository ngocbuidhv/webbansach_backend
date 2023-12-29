package ngoc.webbansach_backend.dao;

import ngoc.webbansach_backend.entity.DonHang;
import ngoc.webbansach_backend.entity.Quyen;
import ngoc.webbansach_backend.entity.Sach;
import ngoc.webbansach_backend.entity.TheLoai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "the-loai")
public interface TheLoaiRepository extends JpaRepository<TheLoai, Integer> {
    public TheLoai findByTenTheLoai(String tenTheLoai);

    Page<TheLoai> findByMaTheLoai(int maTheLoai, Pageable pageable);
}
