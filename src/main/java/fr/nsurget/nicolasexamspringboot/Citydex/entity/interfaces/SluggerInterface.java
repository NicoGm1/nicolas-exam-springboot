package fr.nsurget.nicolasexamspringboot.Citydex.entity.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SluggerInterface {

    void setSlug(String slug);

    @JsonIgnore
    String getField();

}
