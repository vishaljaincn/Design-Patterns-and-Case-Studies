package org.example.java8practicequestions;

import java.util.*;

/**
 * This class demonstrates a song playlist shuffling feature similar to music players.
 * It creates a copy of the original playlist and shuffles it randomly before playback.
 */
public class ShuffleSongs {

    public static void main(String[] args) {
        // Create a sample playlist of songs
        List<String> originalPlaylist = Arrays.asList(
                "Song A", "Song B", "Song C", "Song D", "Song E"
        );

        // Display the original order of songs
        System.out.println("Original song list: " + originalPlaylist);

        // Play the shuffled songs once
        playShuffledSongs(originalPlaylist);

        // Play the songs with a new shuffle pattern
        System.out.println("\nPlaying again with a new shuffle:");
        playShuffledSongs(originalPlaylist);
    }

    /**
     * Creates a copy of the original playlist, shuffles it randomly, and simulates playback.
     * Using a copy ensures the original playlist remains unchanged.
     *
     * @param songs The original list of songs to be shuffled and played
     */
    public static void playShuffledSongs(List<String> songs) {
        // Create a copy of the original playlist to avoid modifying it
        List<String> shuffledPlaylist = new ArrayList<>(songs);

        // Shuffle the copy with a new random seed each time to ensure variety
        Collections.shuffle(shuffledPlaylist);

        // Display the shuffled order
        System.out.println("Shuffled order: " + shuffledPlaylist);

        // Simulate playing each song in the shuffled order
        System.out.println("Playing shuffled songs:");
        for (String song : shuffledPlaylist) {
            System.out.println("  ► Playing: " + song);
        }
    }
}
