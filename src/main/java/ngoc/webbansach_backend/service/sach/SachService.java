package ngoc.webbansach_backend.service.sach;

import jakarta.transaction.Transactional;
import ngoc.webbansach_backend.dao.SachRepository;
import ngoc.webbansach_backend.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.catalog.CatalogException;
import java.util.Optional;

@Service
public class SachService {
    @Autowired
    private SachRepository sachRepository;

    @Transactional
    public Sach save(Sach sach) {
        return sachRepository.save(sach);
    }

    @Transactional
    public Sach update(int maSach, Sach sach) {
        Optional<Sach> sachUpdate = sachRepository.findById(maSach);
        if (sachUpdate.isEmpty()) {
            throw new CatalogException("Mã sách" + maSach + " không thể thực hien update!");
        }
        try {
            Sach sachUpdateSach = sachUpdate.get();
            sachUpdateSach.setTenSach(sach.getTenSach());
            sachUpdateSach.setNamXB(sach.getNamXB());
            sachUpdateSach.setISBN(sach.getISBN());
            sachUpdateSach.setNgonNgu(sach.getNgonNgu());
            sachUpdateSach.setSoTrang(sach.getSoTrang());
            sachUpdateSach.setSoLuong(sach.getSoLuong());
            sachUpdateSach.setMoTa(sach.getMoTa());
            sachUpdateSach.setGiaBan(sach.getGiaBan());
            sachUpdateSach.setTenTacGia(sach.getTenTacGia());
            sachUpdateSach.setGiaNiemYet(sach.getGiaNiemYet());
            sachUpdateSach.setTrungBinhXepHang(sach.getTrungBinhXepHang());
            sachUpdateSach.setMoTaChiTiet(sach.getMoTaChiTiet());

            return sachRepository.save(sachUpdateSach); // Save the updated object, not the original one
        } catch (Exception ex) {
            throw new RuntimeException("Sách không thể update");
        }
    }

    @Transactional
    public void delete(int maSach){
        Optional<Sach> sachDelete = sachRepository.findById(maSach);
        if(sachDelete.isEmpty()){
            throw new CatalogException("Mã sách " + maSach + " không tồn tại!");
        }
        try {
            sachRepository.delete(sachDelete.get());
        } catch (Exception ex){
            throw new RuntimeException("Sách không thể xóa");
        }
    }

}
