package com.dreamsoft.vasilkou.test_project.service;

import com.dreamsoft.vasilkou.test_project.model.SearchItem;
import com.dreamsoft.vasilkou.test_project.repository.SearchItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchService {

    private final SearchItemRepository searchItemRepository;

    public SearchService(SearchItemRepository searchItemRepository) {
        this.searchItemRepository = searchItemRepository;
    }

    public void save(SearchItem item) {
        searchItemRepository.save(item);
    }

    public List<SearchItem> getAllOrderByTime() {
        return searchItemRepository.findByOrderByTimeDesc();
    }

    public List<String> getLinesContainsWord(SearchItem searchItem) throws IOException {
        String file = searchItem.getFile();
        String word = searchItem.getWord();

        return Files.lines(Paths.get(file))
                .map(String::trim)
                .filter(p -> p.contains(word))
                .collect(Collectors.toList());
    }
}
