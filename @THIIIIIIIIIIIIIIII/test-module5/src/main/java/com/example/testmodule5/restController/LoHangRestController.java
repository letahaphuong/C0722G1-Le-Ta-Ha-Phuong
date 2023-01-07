package com.example.testmodule5.restController;

import com.example.testmodule5.dto.LoHangDto;
import com.example.testmodule5.dto.LoHangView;
import com.example.testmodule5.model.LoHang;
import com.example.testmodule5.service.ILoHangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("lo-hang")
@CrossOrigin("*")
public class LoHangRestController {

    @Autowired
    ILoHangService loHangService;

    @GetMapping()
    public ResponseEntity<Page<LoHangView>> getAll(@PageableDefault(size = 5)Pageable pageable) {
        Page<LoHangView> loHangViews = loHangService.getAllView(pageable);
        if (loHangViews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(loHangViews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LoHangDto> save(@RequestBody LoHangDto loHangDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LoHang loHang = new LoHang();
        BeanUtils.copyProperties(loHangDto, loHang);
        loHangService.save(loHang);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<LoHang> delete(@PathVariable("id") Long id) {
        LoHang loHang = loHangService.finById(id);
        if (loHang == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        loHangService.removeFlag(id);
        return new ResponseEntity<>(loHang, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<LoHang> findById(@PathVariable("id") Long id) {
        LoHang loHang = loHangService.finById(id);
        if (loHang == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(loHang, HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<LoHang> update(@RequestBody LoHang loHang, @PathVariable("id") Long id) {
        Optional<LoHang> optionalLoHang = loHangService.findById(id);
        if (!optionalLoHang.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        loHang.setId(optionalLoHang.get().getId());
        loHangService.save(loHang);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
