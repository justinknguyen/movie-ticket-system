package course.ensf607.assignment6.admin;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @SequenceGenerator(name = "Admin_sequence", sequenceName = "Admin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Admin_sequence")
    private Long id;
    private String name;
    private String pass;

    public Admin(Long id, String name, String pass){
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Admin(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
