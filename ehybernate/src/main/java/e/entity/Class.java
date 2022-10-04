package e.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Class {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "aClass")
    private List<Enrollment> enrollments = new ArrayList<>();


    public long getId() {
        return id;
    }

    public Class setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Class setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Class setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public Class setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
        return this;
    }
}
