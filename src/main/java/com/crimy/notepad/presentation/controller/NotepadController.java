package com.crimy.notepad.presentation.controller;

import com.crimy.notepad.application.service.NotepadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/notepad")
public class NotepadController {
    private final NotepadService notepadService;
    @GetMapping
    public String getNotepad() {
        return notepadService.getNotepadOrElse(1L);
    }
}
