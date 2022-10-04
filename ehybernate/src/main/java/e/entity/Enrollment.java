package e.entity;

import javax.persistence.*;

@Entity
@Table
public class Enrollment {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Student aStudent;

    @ManyToOne
    private Class aClass;

    public long getId() {
        return id;
    }

    public Enrollment setId(long id) {
        this.id = id;
        return this;
    }

    public Student getaStudent() {
        return aStudent;
    }

    public Enrollment setaStudent(Student aStudent) {
        this.aStudent = aStudent;
        return this;
    }

    public Class getaClass() {
        return aClass;
    }

    public Enrollment setaClass(Class aClass) {
        this.aClass = aClass;
        return this;
    }
}
