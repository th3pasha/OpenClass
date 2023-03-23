package com.th3.openclass.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FILE", uniqueConstraints = {
        @UniqueConstraint(name = "id", columnNames = "id")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FileInfo {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    private String id;
    private String name;
    private String url;

    public FileInfo(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
