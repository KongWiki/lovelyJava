package com.tran.annotation_reflection;

/**
 * @Time: 20-2-5下午10:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@MyannotationFinall("db_people")
public class People {
    @PropertyAnno(columnName = "db_id", type = "int", length = 10)
    private int id;
    @PropertyAnno(columnName = "db_name", type = "String" , length = 128)
    private String name;
    @PropertyAnno(columnName = "db_age", type = "int", length = 10)
    private int age;

    public People() {
    }

    public People(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
