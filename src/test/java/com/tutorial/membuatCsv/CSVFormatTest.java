package com.tutorial.membuatCsv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

@Slf4j
public class CSVFormatTest {

    /**
     * CSV Format
     * ● Secara default, format file CSV itu dipisahkan menggunakan , (koma)
     * ● Tapi kadang ada beberapa format CSV lain yang mungkin menggunakan pemisah dengan karakter tab, titik koma, atau yang lainnya
     * ● Bahkan beberapa Spreadsheet editor, memiliki aturan tertentu untuk membuat CSV file
     * ● Untungnya, Commons CSV mendukung beberapa format Spreadsheet editor
     * ● Kita bisa lihat di class CSVFormat, terdapat banyak sekali format yang didukung, selain DEFAULT
     * ● https://commons.apache.org/proper/commons-csv/apidocs/index.html
     */

    @Test
    void createCSVWithFormat() throws IOException {
        StringWriter writer = new StringWriter(); // object dari package java.io.*

        // CSVFormat // set format CSV sebagai
        CSVFormat format = CSVFormat.TDF
                .builder()
                .setHeader("Nama Depan", "Nama Belakang", "Value")
                .build();

        CSVPrinter printer = new CSVPrinter(writer, format); // CSVPrinter(Appendable appendable, CSVFormat format) throws IOException // object untuk membuat CSV
        printer.printRecord("budhi", "oct", 111); // void printRecord(Object... values) throws IOException // print value yang diberikan sebagai catatan tunggal dari value yang dipisahkan pembatas
        printer.printRecord("marlon", "pardede", 111);
        printer.flush(); // void flush() throws IOException // Membilas aliran yang mendasarinya.

        log.info("Data {}", writer.getBuffer().toString());

        /**
         * result format TDF
         * 11:10:51.106 [main] INFO com.tutorial.membuatCsv.CSVFormatTest - Data Nama Depan	Nama Belakang	Value
         * budhi	oct	111
         * marlon	pardede	111
         */


    }



}
