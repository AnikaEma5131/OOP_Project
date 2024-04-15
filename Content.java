/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasdid;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Content {
    private final SimpleStringProperty name;
    private final SimpleStringProperty url;
    private final SimpleIntegerProperty id;

    // Constructor
    public Content(String name, String url, int id) {
        this.name = new SimpleStringProperty(name);
        this.url = new SimpleStringProperty(url);
        this.id = new SimpleIntegerProperty(id);
    }

    // Getters
    public String getName() {
        return name.get();
    }

    public String getUrl() {
        return url.get();
    }

    public int getId() {
        return id.get();
    }
}
