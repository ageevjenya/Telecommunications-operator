package com.netcracker.app.domain.info.entities;

import com.netcracker.app.domain.info.repositories.PointAccesRepo;

import java.util.*;

import javax.persistence.*;

@Entity
public class PointAcces  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private float longitude;
    private float latitude;

    private int radius;

    private String title;
    private String info;



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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static void newSomePoint(PointAccesRepo pointAccesRepo){
        float minLati = (float) 55.315128;
        float minLong = (float) 36.853015;
        float maxLati = (float) 56.166084;
        float maxLong = (float) 38.738402;
        Set<TypePointAcces> set = new LinkedHashSet<TypePointAcces>();
        set.add(TypePointAcces.G2);
        final Random random = new Random();
        for (int i = 0;  i < 1000; i++) {

            if (i % 2 == 0)
            set.add(TypePointAcces.G3);

            set.add(TypePointAcces.G4);
            PointAcces pointAcces = new PointAcces();
            pointAcces.setLatitude(minLati + random.nextFloat() * (maxLati-minLati));
            pointAcces.setLongitude(minLong + random.nextFloat() * (maxLong-minLong));
            pointAcces.setRadius(3000 + random.nextInt(1500));

            pointAcces.setTypePoint(set);
            pointAcces.setTitle("Адрес точки доступа");
            pointAcces.setInfo("Дополниетльная информация");
            pointAccesRepo.save(pointAcces);
        }
    }
}
