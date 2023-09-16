package com.example.application;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.IconFactory;
import java.util.Locale;

@JsModule("./icons/my-icons-feather.js")
public enum MyIconsFeather implements IconFactory {
    ACTIVITY, AIRPLAY, ALERT_CIRCLE, ALERT_OCTAGON, ALERT_TRIANGLE, ALIGN_CENTER, ALIGN_JUSTIFY, ALIGN_LEFT, ALIGN_RIGHT, ANCHOR, APERTURE, ARCHIVE, ARROW_DOWN_CIRCLE, ARROW_DOWN_LEFT, ARROW_DOWN_RIGHT, ARROW_DOWN, ARROW_LEFT_CIRCLE, ARROW_LEFT, ARROW_RIGHT_CIRCLE, ARROW_RIGHT, ARROW_UP_CIRCLE, ARROW_UP_LEFT, ARROW_UP_RIGHT, ARROW_UP, AT_SIGN, AWARD, BAR_CHART_2, BAR_CHART, BATTERY_CHARGING, BATTERY, BELL_OFF, BELL, BLUETOOTH, BOLD, BOOK_OPEN, BOOK, BOOKMARK, BOX, BRIEFCASE, CALENDAR, CAMERA_OFF, CAMERA, CAST, CHECK_CIRCLE, CHECK_SQUARE, CHECK, CHEVRON_DOWN, CHEVRON_LEFT, CHEVRON_RIGHT, CHEVRON_UP, CHEVRONS_DOWN, CHEVRONS_LEFT, CHEVRONS_RIGHT, CHEVRONS_UP, CHROME, CIRCLE, CLIPBOARD, CLOCK, CLOUD_DRIZZLE, CLOUD_LIGHTNING, CLOUD_OFF, CLOUD_RAIN, CLOUD_SNOW, CLOUD, CODE, CODEPEN, CODESANDBOX, COFFEE, COLUMNS, COMMAND, COMPASS, COPY, CORNER_DOWN_LEFT, CORNER_DOWN_RIGHT, CORNER_LEFT_DOWN, CORNER_LEFT_UP, CORNER_RIGHT_DOWN, CORNER_RIGHT_UP, CORNER_UP_LEFT, CORNER_UP_RIGHT, CPU, CREDIT_CARD, CROP, CROSSHAIR, DATABASE, DELETE, DISC, DIVIDE_CIRCLE, DIVIDE_SQUARE, DIVIDE, DOLLAR_SIGN, DOWNLOAD_CLOUD, DOWNLOAD, DRIBBBLE, DROPLET, EDIT_2, EDIT_3, EDIT, EXTERNAL_LINK, EYE_OFF, EYE, FACEBOOK, FAST_FORWARD, FEATHER, FIGMA, FILE_MINUS, FILE_PLUS, FILE_TEXT, FILE, FILM, FILTER, FLAG, FOLDER_MINUS, FOLDER_PLUS, FOLDER, FRAMER, FROWN, GIFT, GIT_BRANCH, GIT_COMMIT, GIT_MERGE, GIT_PULL_REQUEST, GITHUB, GITLAB, GLOBE, GRID, HARD_DRIVE, HASH, HEADPHONES, HEART, HELP_CIRCLE, HEXAGON, HOME, IMAGE, INBOX, INFO, INSTAGRAM, ITALIC, KEY, LAYERS, LAYOUT, LIFE_BUOY, LINK_2, LINK, LINKEDIN, LIST, LOADER, LOCK, LOG_IN, LOG_OUT, MAIL, MAP_PIN, MAP, MAXIMIZE_2, MAXIMIZE, MEH, MENU, MESSAGE_CIRCLE, MESSAGE_SQUARE, MIC_OFF, MIC, MINIMIZE_2, MINIMIZE, MINUS_CIRCLE, MINUS_SQUARE, MINUS, MONITOR, MOON, MORE_HORIZONTAL, MORE_VERTICAL, MOUSE_POINTER, MOVE, MUSIC, NAVIGATION_2, NAVIGATION, OCTAGON, PACKAGE, PAPERCLIP, PAUSE_CIRCLE, PAUSE, PEN_TOOL, PERCENT, PHONE_CALL, PHONE_FORWARDED, PHONE_INCOMING, PHONE_MISSED, PHONE_OFF, PHONE_OUTGOING, PHONE, PIE_CHART, PLAY_CIRCLE, PLAY, PLUS_CIRCLE, PLUS_SQUARE, PLUS, POCKET, POWER, PRINTER, RADIO, REFRESH_CCW, REFRESH_CW, REPEAT, REWIND, ROTATE_CCW, ROTATE_CW, RSS, SAVE, SCISSORS, SEARCH, SEND, SERVER, SETTINGS, SHARE_2, SHARE, SHIELD_OFF, SHIELD, SHOPPING_BAG, SHOPPING_CART, SHUFFLE, SIDEBAR, SKIP_BACK, SKIP_FORWARD, SLACK, SLASH, SLIDERS, SMARTPHONE, SMILE, SPEAKER, SQUARE, STAR, STOP_CIRCLE, SUN, SUNRISE, SUNSET, TABLE, TABLET, TAG, TARGET, TERMINAL, THERMOMETER, THUMBS_DOWN, THUMBS_UP, TOGGLE_LEFT, TOGGLE_RIGHT, TOOL, TRASH_2, TRASH, TRELLO, TRENDING_DOWN, TRENDING_UP, TRIANGLE, TRUCK, TV, TWITCH, TWITTER, TYPE, UMBRELLA, UNDERLINE, UNLOCK, UPLOAD_CLOUD, UPLOAD, USER_CHECK, USER_MINUS, USER_PLUS, USER_X, USER, USERS, VIDEO_OFF, VIDEO, VOICEMAIL, VOLUME_1, VOLUME_2, VOLUME_X, VOLUME, WATCH, WIFI_OFF, WIFI, WIND, X_CIRCLE, X_OCTAGON, X_SQUARE, X, YOUTUBE, ZAP_OFF, ZAP, ZOOM_IN, ZOOM_OUT;

    public Icon create() {
        return new Icon(this.name().toLowerCase(Locale.ENGLISH).replace('_', '-').replaceAll("^-", ""));
    }

    public static final class Icon extends com.vaadin.flow.component.icon.Icon {
        Icon(String icon) {
            super("my-icons-feather", icon);
        }
    }
}