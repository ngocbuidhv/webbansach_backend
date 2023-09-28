package ngoc.webbansach_backend.dao;

import ngoc.webbansach_backend.entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, Long> {
}
