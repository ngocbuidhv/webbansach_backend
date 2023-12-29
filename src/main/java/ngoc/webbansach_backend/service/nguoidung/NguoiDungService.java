package ngoc.webbansach_backend.service.nguoidung;

import jakarta.transaction.Transactional;
import ngoc.webbansach_backend.dao.NguoiDungRepository;
import ngoc.webbansach_backend.dao.QuyenRepository;
import ngoc.webbansach_backend.entity.NguoiDung;
import ngoc.webbansach_backend.entity.Quyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.catalog.CatalogException;
import java.util.List;
import java.util.Optional;

@Service
public class NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    public NguoiDungService(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    public List<NguoiDung> findListNguoiDung() {
        return nguoiDungRepository.findAll();
    }

    @Transactional
    public NguoiDung updateNguoiDung(int maNguoiDung, NguoiDung nguoiDung) {
        Optional<NguoiDung> nguoiDungUpdate = nguoiDungRepository.findById(maNguoiDung);
        if (nguoiDungUpdate.isEmpty()) {
            throw new CatalogException("Mã sách" + maNguoiDung + " không thể thực hien update!");
        }
        try {
            NguoiDung nguoiDungUpdateNguoiDung = nguoiDungUpdate.get();
            nguoiDungUpdateNguoiDung.setHoDem(nguoiDung.getHoDem());
            return nguoiDungRepository.save(nguoiDungUpdateNguoiDung); // Save the updated object, not the original one
        } catch (Exception ex) {
            throw new RuntimeException("Sách không thể update");
        }
    }

    @Transactional
    public void Delete(int maNguoiDung) {
        Optional<NguoiDung> nguoiDungDelete = nguoiDungRepository.findById(maNguoiDung);
        if(nguoiDungDelete.isEmpty()){
            throw new CatalogException("Mã người dùng " + maNguoiDung + " không tồn tại!");
        }
            NguoiDung nguoiDung = nguoiDungDelete.get();
            for (Quyen quyen : nguoiDung.getDanhSachQuyen()) {
                quyen.getDanhSachNguoiDung().remove(nguoiDung);
            }
            nguoiDung.getDanhSachQuyen().clear();

            // Xóa NguoiDung
            nguoiDungRepository.delete(nguoiDung);

    }




}
