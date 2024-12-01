package org.example.java8practicequestions;

import java.util.*;

public class ShuffleSongs {

    public static void main(String[] args) {
        List<String> songs = Arrays.asList(
                "Song A", "Song B", "Song C", "Song D", "Song E"
        );

        playShuffledSongs(songs);
    }

    public static void playShuffledSongs(List<String> songs) {
        List<String> songList = new ArrayList<>(songs);

        // Shuffle with a new random seed each time to ensure variety
        Collections.shuffle(songList);

        System.out.println("Playing shuffled songs:");
        for (String song : songList) {
            System.out.println("Playing: " + song);
        }
    }
}
