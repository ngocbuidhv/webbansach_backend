package ngoc.webbansach_backend.controller;

import ngoc.webbansach_backend.entity.NguoiDung;
import ngoc.webbansach_backend.service.nguoidung.NguoiDungService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;

    public NguoiDungController(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }

    @GetMapping("/nguoi-dung")
    public ResponseEntity<List<NguoiDung>> xemTatCaNguoiDung() {
        List<NguoiDung> danhSachNguoiDung= nguoiDungService.findListNguoiDung();
        return new ResponseEntity<>(danhSachNguoiDung, HttpStatus.OK);
    }

    @PutMapping("/update-nguoi-dung/{maNguoiDung}")
    public ResponseEntity<?> updateNguoiDung(@PathVariable("maNguoiDung") int maNguoiDung,
                                           @RequestBody NguoiDung nguoiDung){
        NguoiDung nguoiDungUpdate = new NguoiDung();
        BeanUtils.copyProperties(nguoiDung, nguoiDungUpdate);

        try {
            nguoiDungUpdate = nguoiDungService.updateNguoiDung(maNguoiDung, nguoiDungUpdate);
            nguoiDung.setMaNguoiDung(nguoiDungUpdate.getMaNguoiDung());
            return new ResponseEntity<>(nguoiDung, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete-nguoi-dung/{maNguoiDung}")
    public ResponseEntity<?> deleteNguoiDung(@PathVariable("maNguoiDung") int maNguoiDung){
        try {
            nguoiDungService.Delete(maNguoiDung);
            return new ResponseEntity<>("Sách với mã " + maNguoiDung + " đã được xóa thành công.", HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
