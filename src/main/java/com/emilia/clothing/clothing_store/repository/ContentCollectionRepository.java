package com.emilia.clothing.clothing_store.repository;

import com.emilia.clothing.clothing_store.model.Content;
import com.emilia.clothing.clothing_store.model.Status;
import com.emilia.clothing.clothing_store.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(content -> content.getId().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content content = new Content(1,"Valorant Gameplay", "1v5", Status.IN_PROGRESS, Type.VIDEO, LocalDateTime.now(), LocalDateTime.now(), "youtube.com/anthonyvalo");
        contentList.add(content);
    }

    public void save(Content content){
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
       return contentList.stream().filter(content -> content.getId().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(content -> content.getId().equals(id));
    }
}
