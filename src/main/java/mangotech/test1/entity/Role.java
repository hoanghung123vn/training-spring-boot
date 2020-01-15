package mangotech.test1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hung Hoang
 * @version 1.0
 */
@Entity
@Data
@Table(name = "roles")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.MERGE, fetch =FetchType.EAGER)
    private Set<Group> groups;

    public Role(){}

    public Role(String name){
        this.name = name;
    }

}
