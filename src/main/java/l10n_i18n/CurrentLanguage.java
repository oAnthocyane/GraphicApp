package l10n_i18n;

import java.util.ResourceBundle;

public class CurrentLanguage {
    private static ResourceBundle currentLanguage = Languages.ru;

    private static String currentLanguageString = "ru";

    public static String getCurrentLanguageString() {
        return currentLanguageString;
    }

    public static void setCurrentLanguageString(String currentLanguageString) {
        CurrentLanguage.currentLanguageString = currentLanguageString;
    }

    public static ResourceBundle getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setCurrentLanguage(ResourceBundle currentLanguage) {
        CurrentLanguage.currentLanguage = currentLanguage;
    }
}
