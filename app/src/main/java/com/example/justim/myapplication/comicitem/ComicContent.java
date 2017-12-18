package com.example.justim.myapplication.comicitem;

import com.example.justim.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ComicContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ComicItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ComicItem> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createComicItem(i));
        }
    }

    private static void addItem(ComicItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ComicItem createComicItem(int position) {
        return new ComicItem(String.valueOf(position), makeTitle(position), makeDetails(position),
                makeNumLikes(position), false, makeImageID(position));
    }

    private static String makeTitle(int position) {
        String titles[] = {"死神", "食靈", "海賊王", "一拳超人"};
        return titles[position - 1];

    }

    private static String makeDetails(int position) {

        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    private static int makeNumLikes(int position) {
        int numlikes[] = {87, 43, 96, 178};
        return numlikes[position - 1];
    }

    private static int makeImageID(int position) {
        int imgIDs[] = {R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4};
        return imgIDs[position - 1];
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ComicItem {
        public final String id;
        public final String title;
        public final String details;
        public int numlikes;
        public boolean isFavoriate;
        public final int imgID;

        public ComicItem(String id, String title, String details, int numlikes, boolean isFavoriate, int imgID) {
            this.id = id;
            this.title = title;
            this.details = details;
            this.numlikes = numlikes;
            this.isFavoriate = isFavoriate;
            this.imgID = imgID;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
