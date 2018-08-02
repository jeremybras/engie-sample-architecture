package com.octo.archiexampleengie.android.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;
import java.util.Locale;

import javax.inject.Inject;

public class CurrencyFormatter {

    private static final String NC = "NC";
    private final DecimalFormat numberFormat;

    @Inject
    public CurrencyFormatter() {
        numberFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.FRANCE);
        numberFormat.applyPattern("###,###.## ¤");
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRANCE);
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator(' ');
        symbols.setMinusSign('-');
        symbols.setCurrency(Currency.getInstance("EUR"));
        numberFormat.setDecimalFormatSymbols(symbols);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
    }

    public String format(final BigDecimal value) {
        if (value == null) {
            return NC;
        }
        return numberFormat.format(value);
    }

    public String formatWithoutCurrency(final String amount) {
        return amount.replace(",", ".").replace("€", "")
                     .replaceAll("\\s+", "");
    }

}
