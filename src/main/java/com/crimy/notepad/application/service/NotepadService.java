package com.crimy.notepad.application.service;

import com.crimy.notepad.domain.repository.NotepadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotepadService {
    private final NotepadRepository notepadRepository;

    public String getNotepadOrElse(Long id) {
        return notepadRepository.findById(id)
                .orElse(notepadRepository.findById(null).get()).getContent();
    }

    public String getNotepadOrElseGet(Long id) {
        return notepadRepository.findById(id)
                .orElseGet(() -> notepadRepository.findById(null).get()).getContent();
    }
}
