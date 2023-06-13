package com.example.demo.Services;

import com.example.demo.types.MainDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MainService {

    public ResponseEntity getResponse(Integer errorNumber) {
        var mainDTO = new MainDTO();
        mainDTO.setNumber((int)(100*Math.random()));

        if (errorNumber == null ) {
            mainDTO.setInfo( "200 OK, additionally you can add GET parameter /?errorCode=404 (:");
            return ResponseEntity.status(HttpStatus.OK).body(mainDTO);
        }

        switch (errorNumber) {
            case 403:
                mainDTO.setInfo("403 forbidden ):");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mainDTO);
            case 500:
                mainDTO.setInfo("500 server error ):");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mainDTO);
            case 404:
                mainDTO.setInfo("404 not found ):");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mainDTO);
            default:
                mainDTO.setInfo("200 ok (:");
                return ResponseEntity.status(HttpStatus.OK).body(mainDTO);
        }
    }

}
