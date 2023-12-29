package ngoc.webbansach_backend.service.theloai;

import jakarta.transaction.Transactional;
import ngoc.webbansach_backend.dao.TheLoaiRepository;
import ngoc.webbansach_backend.entity.Sach;
import ngoc.webbansach_backend.entity.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.catalog.CatalogException;
import java.util.List;
import java.util.Optional;

@Service
public class TheLoaiService {
    @Autowired
    private TheLoaiRepository theLoaiRepository;

    public TheLoaiService(TheLoaiRepository theLoaiRepository) {
        this.theLoaiRepository = theLoaiRepository;
    }

    public List<TheLoai> layDanhSachTheLoai() {
        return theLoaiRepository.findAll();
    }

    @Transactional
    public TheLoai themTheLoai(TheLoai theLoaiMoi) {
        return theLoaiRepository.save(theLoaiMoi);
    }

    @Transactional
    public TheLoai update(int maTheLoai, TheLoai theLoai) {
        Optional<TheLoai> theLoaiUpdate = theLoaiRepository.findById(maTheLoai);
        if (theLoaiUpdate.isEmpty()) {
            throw new CatalogException("Mã sách" + theLoai + " không thể thực hien update!");
        }
        try {
            TheLoai theLoaiUpdateTheLoai = theLoaiUpdate.get();
            theLoaiUpdateTheLoai.setTenTheLoai(theLoai.getTenTheLoai());
            return theLoaiRepository.save(theLoaiUpdateTheLoai); // Save the updated object, not the original one
        } catch (Exception ex) {
            throw new RuntimeException("Sách không thể update");
        }
    }

    @Transactional
    public void delete(int maTheLoai){
        Optional<TheLoai> theLoaiDelete = theLoaiRepository.findById(maTheLoai);
        if(theLoaiDelete.isEmpty()){
            throw new CatalogException("Mã sách " + maTheLoai + " không tồn tại!");
        }
        try {
            theLoaiRepository.delete(theLoaiDelete.get());
        } catch (Exception ex){
            throw new RuntimeException("Sách không thể xóa");
        }
    }

}
