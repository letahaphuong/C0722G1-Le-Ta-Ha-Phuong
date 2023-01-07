package com.example.testmodule5.restController;

import com.example.testmodule5.model.SanPham;
import com.example.testmodule5.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("san-pham")
@CrossOrigin("*")
public class SanPhamRestController {

    @Autowired
    ISanPhamService sanPhamService;

    @GetMapping
    public ResponseEntity<List<SanPham>> getAllSanPham() {
        List<SanPham> sanPhams = sanPhamService.findAll();
        if (sanPhams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sanPhams, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SanPham> save(@RequestBody SanPham sanPham) {
        sanPhamService.save(sanPham);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
