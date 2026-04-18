package com.miyuudev.music_play.service;

import com.miyuudev.music_play.entity.Music;
import com.miyuudev.music_play.repository.MusicRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class MusicService {

    private final MusicRepository repository;

    public MusicService(MusicRepository repository) {
        this.repository = repository;
    }

    public Music salvar(MultipartFile file, String name, String artist) {
        String fileName = UUID.randomUUID() + "_" + java.util.Objects.requireNonNullElse(file.getOriginalFilename(), "file").replace(" ", "_");

        String uploadDir = "uploads/";
        try {
            Files.write(Paths.get(uploadDir + fileName), file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo");
        }

        Music music = new Music();
        music.setName(name);
        music.setArtist(artist);
        music.setFileUrl(uploadDir + fileName);

        return repository.save(music);
    }

    public List<Music> listar() {
        return repository.findAll();
    }
}