package com.muhammet.stoktakipotomasyon.controller;

import com.muhammet.stoktakipotomasyon.dto.request.AddMarkaRequestDto;
import com.muhammet.stoktakipotomasyon.dto.response.ResponseDto;
import com.muhammet.stoktakipotomasyon.entity.Marka;
import com.muhammet.stoktakipotomasyon.service.MarkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marka")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MarkaController {
    private final MarkaService markaService;
    @PostMapping("/add-marka")
    public ResponseEntity<ResponseDto<Boolean>> addMarka(@RequestBody AddMarkaRequestDto dto) {
        markaService.save(Marka.builder()
                        .acikAdres(dto.acikAdres())
                        .aciklama(dto.aciklama())
                        .ad(dto.ad())
                        .iletisimTel(dto.iletisimTel())
                        .yetkili(dto.yetkili())
                .build());
        return ResponseEntity.ok(ResponseDto.<Boolean>builder()
                        .code(200)
                        .message("Marka eklendi")
                        .data(true)
                .build());
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseDto<List<Marka>>> getAll(){
        return ResponseEntity.ok(ResponseDto.<List<Marka>>builder()
                    .code(200)
                    .message("Ok")
                    .data(markaService.findAll())
                .build());
    }
}
