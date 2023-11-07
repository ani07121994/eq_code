package model.validator;

import java.sql.SQLException;

import oracle.jbo.domain.Number;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;

import java.util.Locale;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.LocaleContext;
import oracle.jbo.common.DefLocaleContext;
import oracle.jbo.format.DefaultNumberFormatter;
import oracle.jbo.format.FormatErrorException;
import oracle.jbo.format.UnknownLocaleException;


public class NumberFormatter extends DefaultNumberFormatter {
   
    
    private static oracle.jbo.common.DefLocaleContext ctx = new DefLocaleContext(Locale.ENGLISH);
    private DecimalFormatSymbols mSymbols = new DecimalFormatSymbols(ctx.getLocale());

    public NumberFormatter() {
        super();
    }

    public String format(String mask, Object object) throws FormatErrorException {
        String formattedString = "";

        if (mask.compareTo("") == 0) {
            mask = " ";
        }
        
        DecimalFormat decimalFormat = getDecimalFormat();
        decimalFormat.applyPattern(mask);
        if (object != null && (object instanceof String) == false) {
            System.out.println("OBJECT TO FORMAT: " + object + ", TYPE: " + object.getClass());
            if (object instanceof oracle.jbo.domain.Number) {
                formattedString = decimalFormat.format(((oracle.jbo.domain.Number)object).doubleValue());
            } else {
                double value = Double.parseDouble(object.toString());
                try {
                    oracle.jbo.domain.Number formatThis = new oracle.jbo.domain.Number(value);
                    formattedString = decimalFormat.format(formatThis);
                } catch(SQLException sEx) {
                    throw new FormatErrorException(sEx.getMessage());
                }
            }            
            System.out.println("FORMATTED RESULT: " + formattedString);
        }
        return (formattedString);
    }

    public DecimalFormat getDecimalFormat() {
        return new DecimalFormat("", mSymbols);
    }
    
    public LocaleContext getLocale() {
        return super.getLocale();
    }

    public Object parse(String mask, String number) throws ParseException {
        System.out.println("OBJECT TO PARSE: " + number);
        Object obj = this.parseObj(mask, number);
        System.out.println("PARSED OBJECT: " + obj);
        //if the value wasn't parsed into a Number
        if (obj == null) {
            throw new RuntimeException("Please enter number with maximum 5 decimal points.");
        }

        int[] maskPrecisionAndScale = getPrecisionAndScale(mask, true);
        int[] numberPrecisionAndScale = getPrecisionAndScale(number, false);

        if (numberPrecisionAndScale[0] > maskPrecisionAndScale[0] ||
            numberPrecisionAndScale[1] > maskPrecisionAndScale[1]) {
            throw new RuntimeException("Please enter number with maximum 5 decimal points.");
        }
        return obj;
    }
    
    public Object parseObj(String formatString, String parseThisString) throws ParseException {
        if  ( formatString.compareTo("") == 0)
            formatString = " ";

        DecimalFormat format = getDecimalFormat();
        format.applyPattern(formatString);
        format.setParseBigDecimal(true);
        
        return (format.parse(parseThisString, new ParsePosition(0)));
    }


    private int[] getPrecisionAndScale(String value, boolean isMask) {
        //check the precision
        value = value.trim();
        value = value.replaceAll(",", ""); //removing groupping symbol
        if (value.startsWith("-") || value.startsWith("+")) {
            value = value.substring(1);
        }
        int[] digits = new int[] { value.length(), 0 };

        if (value.indexOf(".") > 0) {
            if (!isMask) {
                while (value.startsWith("0")) {
                    value = value.substring(1);
                }
                while (value.endsWith("0")) {
                    value = value.substring(0, value.length() - 1);
                }
            }

            digits[0] = value.indexOf(".");
            digits[1] = value.length() - value.indexOf(".") - 1;
        }
        return digits;
    }

    //ignoring user locale. defaulting to English
    public void setLocale(LocaleContext localeContext) throws UnknownLocaleException {
        super.setLocale(ctx);
    }
}
