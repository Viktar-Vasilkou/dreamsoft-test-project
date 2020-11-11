package com.dreamsoft.vasilkou.test_project.service;

import com.dreamsoft.vasilkou.test_project.model.SearchItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    private static final String TEST_FILE_PATH = System.getProperty("user.dir")
            + "/src/main/resources/static/Test.txt";

    @InjectMocks
    SearchService searchService;

    @Test
    void getLinesContainsWord_tryToGetLines_notEmpty() throws IOException {
        String fileName = TEST_FILE_PATH;
        String word = "слово";

        SearchItem searchItem = new SearchItem();
        searchItem.setFile(fileName);
        searchItem.setWord(word);

        Assert.notEmpty(searchService.getLinesContainsWord(searchItem));
    }
}