package ngoc.webbansach_backend.dao;

import ngoc.webbansach_backend.entity.DonHang;
import ngoc.webbansach_backend.entity.HinhThucGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface HinhThucGiaoHangRepository extends JpaRepository<HinhThucGiaoHang, Integer> {
}
