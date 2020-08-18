package ru.netcracker.trainingproject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PointAcces  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private float longitude;
    private float latitude;

    private float radius;

    private String title;

    @ElementCollection(targetClass = TypePointAcces.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "type_point_acces", joinColumns = @JoinColumn(name = "pointacces_id"))
    @Enumerated(EnumType.STRING)
    private Set<TypePointAcces> typePoint;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public  Set<TypePointAcces> getTypePoint() {
        return typePoint;
    }

    public void setTypePoint( Set<TypePointAcces> typesPoint) {
        this.typePoint = typesPoint;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
