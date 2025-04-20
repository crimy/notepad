package com.crimy.notepad.application.service

import com.crimy.notepad.domain.repository.NotepadRepository
import com.crimy.notepad.infrastructure.entity.Notepad
import spock.lang.Specification

class NotepadServiceTest extends Specification {
    NotepadRepository notepadRepository = Mock()
    NotepadService notepadService = new NotepadService(notepadRepository)

    def "orElse test : return present"() {
        given:
        def id = 1L

        when:
        def result = notepadService.getNotepadOrElse(id)

        then:
        notepadRepository.findById(1L) >> Optional.of(new Notepad(1L, "test1"))
        1 * notepadRepository.findById(null) >> Optional.of(new Notepad(2L, "test2"))
        result == "test1"
    }

    def "orElseTest : return empty"() {
        given:
        def id = 1L

        when:
        def result = notepadService.getNotepadOrElse(id)

        then:
        notepadRepository.findById(1L) >> Optional.empty()
        1 * notepadRepository.findById(null) >> Optional.of(new Notepad(2L, "test2"))
        result == "test2"
    }

    def "orElseGetTest : return present"() {
        given:
        def id = 1L

        when:
        def result = notepadService.getNotepadOrElseGet(id)

        then:
        notepadRepository.findById(1L) >> Optional.of(new Notepad(1L, "test1"))
        0 * notepadRepository.findById(null) >> Optional.of(new Notepad(2L, "test2"))
        result == "test1"
    }

    def "orElseGetTest : return empty"() {
        given:
        def id = 1L

        when:
        def result = notepadService.getNotepadOrElseGet(id)

        then:
        notepadRepository.findById(1L) >> Optional.empty()
        1 * notepadRepository.findById(null) >> Optional.of(new Notepad(2L, "test2"))
        result == "test2"
    }


}
