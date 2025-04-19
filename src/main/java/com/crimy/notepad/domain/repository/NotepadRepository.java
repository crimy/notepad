package com.crimy.notepad.domain.repository;

import com.crimy.notepad.infrastructure.entity.Notepad;

import java.util.Optional;

public interface NotepadRepository {
    Optional<Notepad> findById(Long id);
}
