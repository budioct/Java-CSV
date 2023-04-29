package com.tutorial.membuatCsv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

@Slf4j
public class CreateCSVTest {

    /**
     * Membuat CSV
     * ● Untuk membuat CSV, kita bisa menggunakan class CSVPrinter yang terdapat di library Commons CSV
     * ● Saat membuat CSVPrinter, kita perlu tentukan output tujuan dari CSV
     * ● Di class CSVPrinter, terdapat method printRecord() yang bisa kita gunakan untuk menambah data ke CSV
     * ● https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVPrinter.html
     */

    @Test
    void testCreateCSV() throws IOException {
        StringWriter writer = new StringWriter(); // object dari package java.io.*

        // Appendable // super interface dari package java.io.*
        // CSVFormat // set format CSV sebagai
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT); // CSVPrinter(Appendable appendable, CSVFormat format) throws IOException // object untuk membuat CSV
        printer.printRecord("budhi", "octaviansyah", 100); // void printRecord(Object... values) throws IOException // print value yang diberikan sebagai catatan tunggal dari value yang dipisahkan pembatas
        printer.printRecord("anjas", "mara", 95);
        printer.flush(); // void flush() throws IOException // Membilas aliran yang mendasarinya.

        log.info("Data: {}", writer.getBuffer().toString());
        //System.out.println(writer.getBuffer().toString());

        /**
         * Result:
         * 10:39:22.566 [main] INFO com.tutorial.membuatCsv.CreateCSV - Data: budhi,octaviansyah,100
         */
    }


}
