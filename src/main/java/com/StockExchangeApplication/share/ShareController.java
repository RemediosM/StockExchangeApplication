package com.StockExchangeApplication.share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/share")
@CrossOrigin(origins = "http://localhost:4200")
public class ShareController {

    @Autowired
    ShareService shareService;

    @GetMapping(value = "/shares")
    public ResponseEntity<List<ShareDto>> getShares() {
        return ResponseEntity.ok(shareService.getAll());
    }

    @GetMapping(value = "/edit/{id}")
    public ResponseEntity<ShareDto> getShare(@PathVariable("id") int id) {
        ShareDto shareDto = shareService.getById(id);
        if (shareDto != null) {
            return ResponseEntity.ok(shareDto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Share> updateShare(@RequestBody ShareDto shareDto) {
        try {
            return new ResponseEntity<>(shareService.save(shareDto), HttpStatus.CREATED);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Share> saveShare(@RequestBody ShareDto shareDto) {
        try {
            return new ResponseEntity<>(shareService.save(shareDto), HttpStatus.CREATED);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<HttpStatus> deleteShare(@RequestParam int id) {
        try {
            shareService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
