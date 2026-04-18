package com.miyuudev.music_play.controller;

import com.miyuudev.music_play.entity.Music;
import com.miyuudev.music_play.service.MusicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/musics")
public class MusicController {

    private final MusicService service;

    public MusicController(MusicService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public Music upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam String nome,
            @RequestParam String artist
    ) {
        return service.salvar(file, nome, artist);
    }

    @GetMapping
    public List<Music> listar() {
        return service.listar();
    }
}