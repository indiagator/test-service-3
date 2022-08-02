package com.code22.testservice3.model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "menuid")
    private String menuid;

    @Column(name = "dishname", length = 80)
    private String dishname;

    @Column(name = "dishprice")
    private Integer dishprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public Integer getDishprice() {
        return dishprice;
    }

    public void setDishprice(Integer dishprice) {
        this.dishprice = dishprice;
    }

}