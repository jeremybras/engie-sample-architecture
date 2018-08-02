package com.octo.archiexampleengie.android.common;

import android.support.annotation.NonNull;

import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.Locale;

import javax.inject.Inject;

public class DateFormatter {

    private final DateTimeFormatter smallFormatter;

    @Inject
    public DateFormatter() {
        smallFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE);
    }

    public String formatDate(@NonNull  ZonedDateTime localDateTime) {
        return localDateTime.format(smallFormatter);
    }
}
