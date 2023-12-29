package ngoc.webbansach_backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import ngoc.webbansach_backend.entity.Sach;
import ngoc.webbansach_backend.service.MapValidationErrorService;
import ngoc.webbansach_backend.service.sach.SachService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class SachController {
    @Autowired
    private SachService sachService;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    public SachController(SachService sachService) {
        this.sachService = sachService;
    }

    @PutMapping ("/update-sach/{maSach}")
    public ResponseEntity<?> updateSach(@PathVariable("maSach") int maSach,
                                        @RequestBody Sach sach){
        Sach sachUpdate = new Sach();
        BeanUtils.copyProperties(sach, sachUpdate);

        try {
            sachUpdate = sachService.update(maSach, sachUpdate);
            sach.setMaSach(sachUpdate.getMaSach());
            return new ResponseEntity<>(sach, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete-sach/{maSach}")
    public ResponseEntity<?> deleteSach(@PathVariable("maSach") int maSach){
        try {
            sachService.delete(maSach);
            return new ResponseEntity<>("Sách với mã " + maSach + " đã được xóa thành công.", HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




}
