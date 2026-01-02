package com.example.mylibrary;

public final class Categories {

    private Categories() {}

    public static final String LITERARY = "Λογοτεχνική μυθοπλασία";
    public static final String SOCIAL_POLITICAL = "Κοινωνικό & πολιτικό μυθιστόρημα";
    public static final String HISTORICAL = "Ιστορική λογοτεχνία";
    public static final String MODERN = "Σύγχρονη λογοτεχνία";
    public static final String POETRY = "Ποίηση";
    public static final String ESSAYS = "Δοκίμιο / Μελέτη";

    public static String[] all() {
        return new String[]{LITERARY, SOCIAL_POLITICAL, HISTORICAL, MODERN, POETRY, ESSAYS};
    }
}