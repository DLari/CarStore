package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name="auto_in_stock")
public class AutoInStock {

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine ;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private Integer id;

    @Column(name = "presence")
    private Integer presence;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }
}