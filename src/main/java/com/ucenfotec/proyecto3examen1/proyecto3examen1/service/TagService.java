package com.ucenfotec.proyecto3examen1.proyecto3examen1.service;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Tag;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Transactional(readOnly = true)
    public List<Tag> findAll() {
        return  tagRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Tag findById(Long idTask) {
        Optional<Tag> tag =  tagRepository.findById(idTask);
        return tag.isPresent() ? tag.get() : null;
    }

    @Transactional
    public Tag save(Tag tag) {
        Optional<Tag> tagTemp = tagRepository.findByName(tag.getName());
        return tagTemp.isPresent() ? tagTemp.get() : tagRepository.save(tag);
    }

    @Transactional
    public Tag update(Tag tag) {
        boolean isPresent = tagRepository.findById(tag.getId()).isPresent();
        return isPresent ? tagRepository.save(tag) : null;
    }
}
