package com.emilia.clothing.clothing_store.controller;

import com.emilia.clothing.clothing_store.model.Content;
import com.emilia.clothing.clothing_store.model.Status;
import com.emilia.clothing.clothing_store.model.Type;
import com.emilia.clothing.clothing_store.repository.ContentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/content")
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/filter/{filter}")
    public List<Content> filterTitle(@PathVariable String filter) {
        return repository.findAllByTitleContains(filter);
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable Integer id) throws Exception {
        Optional c = repository.findById(id);
        if (c.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        return c;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void save(@Valid @RequestBody Content content) {
       repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Content id) {
        repository.delete(id);
    }

    @PostConstruct
    private void init(){
        Content content = new Content(1,"Valorant Gameplay", "1v5", Status.IN_PROGRESS, Type.VIDEO, LocalDateTime.now(), LocalDateTime.now(), "youtube.com/anthonyvalo");
        repository.save(content);
    }
}
