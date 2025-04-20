package com.crimy.notepad.infrastructure.repository;

import com.crimy.notepad.domain.repository.NotepadRepository;
import com.crimy.notepad.infrastructure.entity.Notepad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DummyNotepadRepository implements NotepadRepository {
    @Override
    public Optional<Notepad> findById(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("should not be called");
        }
        return Optional.of(new Notepad(id, "notepad"));
    }
}
