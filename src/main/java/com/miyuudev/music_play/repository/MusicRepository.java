package com.miyuudev.music_play.repository;

import com.miyuudev.music_play.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MusicRepository extends JpaRepository<Music, UUID> {

}