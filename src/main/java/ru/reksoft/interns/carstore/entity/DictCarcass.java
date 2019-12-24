package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Setter
@Getter
@Table(name="dict_carcass")
public class DictCarcass {

   /* @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;*/

   /* @OneToMany(mappedBy = "dict_carcass")
    private List<Model> models;*/

    @Id
   // @GeneratedValue
   @Column(name = "id")
    private Integer id;

    @Column( name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}