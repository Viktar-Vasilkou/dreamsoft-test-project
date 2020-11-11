package com.dreamsoft.vasilkou.test_project.controller;

import com.dreamsoft.vasilkou.test_project.model.SearchItem;
import com.dreamsoft.vasilkou.test_project.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@RequestMapping("/api")
public class ApiController {

    SearchService searchService;

    public ApiController(SearchService searchService) {
        this.searchService = searchService;
    }

    @ExceptionHandler({IOException.class})
    public ResponseEntity<Object> ioError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File not found");
    }

    @GetMapping("/history")
    public List<SearchItem> getAll() {
        return searchService.getAllOrderByTime();
    }

    @PostMapping("/search")
    public List<String> getStrings(@RequestBody SearchItem searchItem) throws IOException {
        if (StringUtils.isEmpty(searchItem.getFile()) || StringUtils.isEmpty(searchItem.getWord())) {
            return new ArrayList<>();
        }

        searchItem.setTime(new Date());
        searchService.save(searchItem);
        return searchService.getLinesContainsWord(searchItem);
    }
}