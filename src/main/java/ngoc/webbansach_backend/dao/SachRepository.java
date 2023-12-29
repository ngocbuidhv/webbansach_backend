package ngoc.webbansach_backend.dao;

import ngoc.webbansach_backend.entity.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RepositoryRestResource(path = "sach")
public interface SachRepository extends JpaRepository<Sach, Integer> {

    Page<Sach> findByTenSachContaining(@RequestParam("tenSach") String tenSach, Pageable pageable);

    Page<Sach> findByDanhSachTheLoai_MaTheLoai(@RequestParam("maTheLoai") int maTheLoai, Pageable pageable);

    Page<Sach> findByTenSachContainingAndDanhSachTheLoai_MaTheLoai(@RequestParam("tenSach") String tenSach, @RequestParam("maTheLoai") int maTheLoai, Pageable pageable);

    Page<Sach>findByMaSach(int maSach, Pageable pageable);


}
