package de.lubowiecki;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;
import java.util.TreeMap;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private DatePicker date;

    @FXML
    private TextField name;

    @FXML
    private TextArea output;

    private TreeMap<LocalDate, String> dates = new TreeMap<>();

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @FXML
    public void addToOutput() {
        dates.put(date.getValue(), name.getText()); // Dates-Map erweitern
        output.setText(genOutput()); // Ausgabe updaten
    }

    public String genOutput() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<LocalDate, String> e : dates.entrySet()) {
            sb.append(e.getKey().format(FMT));
            sb.append(": ");
            sb.append(e.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}
