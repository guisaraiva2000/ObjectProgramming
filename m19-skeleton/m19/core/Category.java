package m19.core;

import java.io.Serializable;

public enum Category implements Serializable {

    FICTION("Ficção"),
    SCITECH("Técnica e Científica"),
    REFERENCE("Referência");

    private static final long serialVersionUID = 201901101348L;

    private String _description;
    Category(String description) {
        _description = description;
    }
    public String getDescription() {
        return _description;
    }
}