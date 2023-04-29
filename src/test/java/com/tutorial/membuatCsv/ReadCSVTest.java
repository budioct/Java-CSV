package com.tutorial.membuatCsv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class ReadCSVTest {

    /**
     * Membaca CSV
     * ● Untuk membaca CSV, kita bisa menggunakan class CSVParser
     * ● CSVParser adalah turunan dari Iterable, sehingga otomatis kita bisa melakukan iterasi datanya menggunakan perulangan foreach
     * ● https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVParser.html
     * ● Tiap perulangan, kita bisa ambil dataya dalam bentuk CSVRecord
     */

    @Test
    void testCreateReadCSV() throws IOException {
        Path path = Path.of("sample.csv"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        Reader reader = Files.newBufferedReader(path); // Reader adalah Input Stream untuk membaca resource berupa text

        // Reader membaca resource berupa text
        // CSVFormat // set format CSV sebagai
        // CSVRecord // untuk membaca record pada file CSV
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT); // CSVParser(Reader reader, CSVFormat format) throws IOException // untuk membaca file CSV
        for (CSVRecord record : parser){
            log.info("First Name: {}", record.get(0));
            log.info("Last Name: {}", record.get(1));
            log.info("Value: {}", record.get(2));
        }

        /**
         * Result:
         * 10:37:04.099 [main] INFO com.tutorial.membuatCsv.ReadCSV - First Name: budhi
         * 10:37:04.104 [main] INFO com.tutorial.membuatCsv.ReadCSV - Last Name:  octaviansyah
         * 10:37:04.104 [main] INFO com.tutorial.membuatCsv.ReadCSV - Value:  100
         * 10:37:04.104 [main] INFO com.tutorial.membuatCsv.ReadCSV - First Name: anjas
         * 10:37:04.104 [main] INFO com.tutorial.membuatCsv.ReadCSV - Last Name:  mara
         * 10:37:04.105 [main] INFO com.tutorial.membuatCsv.ReadCSV - Value:  95
         */

    }

}
