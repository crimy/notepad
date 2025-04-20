package com.crimy.notepad.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notepad {
    private Long id;
    private String content;
}
