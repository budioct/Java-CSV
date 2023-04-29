package com.tutorial.membuatCsv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class HeaderCSVTest {

    /**
     * CSV Header
     * ● Seperti yang sempat dibahas di awal, kadang-kadang, saat kita membuat file CSV, biasanya kita menambahkan baris pertama sebagai Header
     * ● Saat menggunakan Commons CSV, kita harus memberi tahu CSVFormat jika baris pertama adalah kolom, jadi kita bisa menggunakan
     * method setHeader() untuk memberitahu bahwa baris pertama adalah header
     * ● Keuntungan menggunakan header, kita bisa menggunakan nama header untuk mendapatkan nilai dari tiap kolom di CSV, jadi tidak perlu
     * menggunakan nomor index lagi
     */

    @Test
    void readCSVWithHeader() throws IOException {

        Path path = Path.of("sample.csv"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        Reader reader = Files.newBufferedReader(path); // Reader adalah Input Stream untuk membaca resource berupa text

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .build();

        // Reader membaca resource berupa text
        // CSVFormat // set format CSV sebagai
        // CSVRecord // untuk membaca record pada file CSV
        CSVParser parser = new CSVParser(reader, format); // CSVParser(Reader reader, CSVFormat format) throws IOException // untuk membaca file CSV
        for (CSVRecord record : parser){
            log.info("First Name: {}", record.get("First Name"));
            log.info("Last Name: {}", record.get("Last Name"));
            log.info("Value: {}", record.get("Value"));
        }

        /**
         * result:
         * 10:50:43.031 [main] INFO com.tutorial.membuatCsv.HeaderCSV - First Name: budhi
         * 10:50:43.035 [main] INFO com.tutorial.membuatCsv.HeaderCSV - Last Name:  octaviansyah
         * 10:50:43.035 [main] INFO com.tutorial.membuatCsv.HeaderCSV - Value:  100
         * 10:50:43.035 [main] INFO com.tutorial.membuatCsv.HeaderCSV - First Name: anjas
         * 10:50:43.035 [main] INFO com.tutorial.membuatCsv.HeaderCSV - Last Name:  mara
         * 10:50:43.035 [main] INFO com.tutorial.membuatCsv.HeaderCSV - Value:  95
         */

    }

    /**
     * Menulis CSV Header
     * ● CSVFormat juga bisa digunakan untuk menulis CSV dengan Header
     * ● Kita cukup sebutkan saja nama-nama header dengan method setHeader()
     */

    @Test
    void writeCSVWithHeader() throws IOException {
        StringWriter writer = new StringWriter(); // object dari package java.io.*

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader("First Name", "Last Name", "Value")
                .build();

        // CSVFormat // set format CSV sebagai
        CSVPrinter printer = new CSVPrinter(writer, format); // CSVPrinter(Appendable appendable, CSVFormat format) throws IOException // object untuk membuat CSV
        printer.printRecord("budhi", "oct", 111); // void printRecord(Object... values) throws IOException // print value yang diberikan sebagai catatan tunggal dari value yang dipisahkan pembatas
        printer.printRecord("marlon", "pardede", 111);
        printer.flush(); // void flush() throws IOException // Membilas aliran yang mendasarinya.

        log.info("Data {}", writer.getBuffer().toString());

        /**
         * result:
         * 10:56:41.149 [main] INFO com.tutorial.membuatCsv.HeaderCSV - Data First Name,Last Name,Value
         * budhi,oct,111
         * marlon,pardede,111
         */

    }




}
