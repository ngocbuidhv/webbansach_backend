package ngoc.webbansach_backend.controller;

import ngoc.webbansach_backend.dao.TheLoaiRepository;
import ngoc.webbansach_backend.entity.Sach;
import ngoc.webbansach_backend.entity.TheLoai;
import ngoc.webbansach_backend.service.theloai.TheLoaiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class TheLoaiController {
    @Autowired
    TheLoaiService theLoaiService;

    public TheLoaiController(TheLoaiService theLoaiService) {
        this.theLoaiService = theLoaiService;
    }

    @PostMapping("/them-the-loai")
    public ResponseEntity<TheLoai> themTheLoai(@RequestBody TheLoai theLoai) {
        TheLoai theLoaimoi = theLoaiService.themTheLoai(theLoai);
        return new ResponseEntity<>(theLoaimoi, HttpStatus.CREATED);
    }

    @PutMapping("/update-the-loai/{maTheLoai}")
    public ResponseEntity<?> updateTheLoai(@PathVariable("maTheLoai") int maTheLoai,
                                        @RequestBody TheLoai theLoai){
        TheLoai theLoaiUpdate = new TheLoai();
        BeanUtils.copyProperties(theLoai, theLoaiUpdate);

        try {
            theLoaiUpdate = theLoaiService.update(maTheLoai, theLoaiUpdate);
            theLoai.setMaTheLoai(theLoaiUpdate.getMaTheLoai());
            return new ResponseEntity<>(theLoai, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete-the-loai/{maTheLoai}")
    public ResponseEntity<?> deleteSach(@PathVariable("maTheLoai") int maTheLoai){
        try {
            theLoaiService.delete(maTheLoai);
            return new ResponseEntity<>("Sách với mã " + maTheLoai + " đã được xóa thành công.", HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
