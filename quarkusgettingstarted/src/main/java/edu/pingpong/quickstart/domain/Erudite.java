package edu.pingpong.quickstart.domain;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.NotBlank;

import edu.pingpong.quickstart.validation.NotBorn;
import io.smallrye.common.constraint.NotNull;

// IMPORTANTE 
/**
 * Para serializar o deserializar los JSON recuerda instalar la libreria
 * necesaria llamada:
 * 
 * RESTEasy - JSON-B
 */

public class Erudite {

    // Validation Fields
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String quote;

    // Specific own created validation for this field
    @NotBorn
    // Date format established
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate bornDate;

    // ¡¡¡ Remember to implement default constructor for POST methods !!!
    public Erudite() {
    }

    public Erudite(String name, String quote, LocalDate bornDate) {
        this.name = name;
        this.quote = quote;
        this.bornDate = bornDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "Erudite [bornDate=" + bornDate + ", name=" + name + ", quote=" + quote + "]";
    }
}
