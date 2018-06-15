package com.jadilindo.meau.meau;

import java.util.ArrayList;

class Animal {
    private String id;
    private String name;
    private String species;
    private String gender;
    private String size;
    private String age;
    private ArrayList<String> temper;
    private ArrayList<String> health;
    private String desease;
    private String about;
    private boolean adoption_term;
    private boolean pictures_of_house;
    private boolean previous_visit;
    private boolean supervision_1month;
    private boolean supervision_3months;
    private boolean supervision_6months;
    private String action_type;

    Animal(String id,String name, String species, String gender, String size, String age,
           ArrayList<String> temper, ArrayList<String> health, String desease,
           String about, boolean adoption_term, boolean pictures_of_house,
           boolean previous_visit, boolean supervision_1month, boolean supervision_3months,
           boolean supervision_6months, String action_type) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.size = size;
        this.age = age;
        this.temper = temper;
        this.health = health;
        this.desease = desease;
        this.about = about;
        this.adoption_term = adoption_term;
        this.pictures_of_house = pictures_of_house;
        this.previous_visit = previous_visit;
        this.supervision_1month = supervision_1month;
        this.supervision_3months = supervision_3months;
        this.supervision_6months = supervision_6months;
        this.action_type = action_type;
    }
    public Animal() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<String> getTemper() {
        return temper;
    }

    public void setTemper(ArrayList<String> temper) {
        this.temper = temper;
    }

    public ArrayList<String> getHealth() {
        return health;
    }

    public void setHealth(ArrayList<String> health) {
        this.health = health;
    }

    public String getDesease() {
        return desease;
    }

    public void setDesease(String desease) {
        this.desease = desease;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isAdoption_term() {
        return adoption_term;
    }

    public void setAdoption_term(boolean adoption_term) {
        this.adoption_term = adoption_term;
    }

    public boolean isPictures_of_house() {
        return pictures_of_house;
    }

    public void setPictures_of_house(boolean pictures_of_house) {
        this.pictures_of_house = pictures_of_house;
    }

    public boolean isPrevious_visit() {
        return previous_visit;
    }

    public void setPrevious_visit(boolean previous_visit) {
        this.previous_visit = previous_visit;
    }

    public boolean isSupervision_1month() {
        return supervision_1month;
    }

    public void setSupervision_1month(boolean supervision_1month) {
        this.supervision_1month = supervision_1month;
    }

    public boolean isSupervision_3months() {
        return supervision_3months;
    }

    public void setSupervision_3months(boolean supervision_3months) {
        this.supervision_3months = supervision_3months;
    }

    public boolean isSupervision_6months() {
        return supervision_6months;
    }

    public void setSupervision_6months(boolean supervision_6months) {
        this.supervision_6months = supervision_6months;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }
}
