package com.bw.fengyingchao2331.model;

/*
 *@auther: 封英超
 *@Date: 2019/12/31
 *@Time:10:50
 *@Description:${DESCRIPTION}
 *
 */public class JavaBean  {
     String name;
     int age;

    public JavaBean(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
