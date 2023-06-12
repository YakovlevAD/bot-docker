package com.example.demo.Controllers;

import com.example.demo.Entities.TestDTO;
import com.example.demo.Services.MainService;
import com.example.demo.types.MainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    public MainService mainService;

    @GetMapping
    public ResponseEntity getMainJSON(@RequestParam(required = false) Integer errorCode) {
        return mainService.getResponse(errorCode);
    }

    @GetMapping("test")
    public ResponseEntity getTestJSON() {
        var testDto = new TestDTO();
        testDto.setNumber(Math.random() * 100);
        return ResponseEntity.ok(testDto);
    }
}
