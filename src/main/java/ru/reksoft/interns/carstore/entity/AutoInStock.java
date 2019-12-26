package ru.reksoft.interns.carstore.entity;

import javax.persistence.*;

/**
 * авто на складе
 */
@Entity
@Table(name="auto_in_stock")
public class AutoInStock {

    /**
     *связь с таблицей цвет
     */
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    /**
     * связь с таблицей двигатель
     */
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine ;

    /**
     * связь с таблицей модель
     */
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private Integer id;

    /**
     * количество автомобилей
     */
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