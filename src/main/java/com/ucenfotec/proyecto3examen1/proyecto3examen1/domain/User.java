package com.ucenfotec.proyecto3examen1.proyecto3examen1.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nickName;
    private String status;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE})
    @JoinTable(
            name = "preferences",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> preferences = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Tag> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Tag> preferences) {
        this.preferences = preferences;
    }
}
