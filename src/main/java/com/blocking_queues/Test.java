package com.blocking_queues;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "test")
public class Test extends Model {
    private Integer id;
    private String name;

    public Test(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
