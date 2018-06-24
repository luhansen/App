package com.jadilindo.meau.meau;

import java.util.ArrayList;

public class Animal {
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
    private String picture;
    private boolean adoption_term;
    private boolean pictures_of_house;
    private boolean previous_visit;
    private boolean supervision_1month;
    private boolean supervision_3months;
    private boolean supervision_6months;
    private boolean food_need;
    private boolean finantial_need;
    private boolean med_need;
    private String med_name_need;
    private boolean obj_need;
    private String obj_details_need;
    private boolean sponsor_term;
    private boolean finantial_sponsor;
    private boolean food_finantial_sponsor;
    private boolean health_finantial_sponsor;
    private boolean obj_finantial_sponsor;
    private boolean visit_sponsor;
    private boolean adopted;
    private String targetUserEmail;
    private boolean sponsored;
    private boolean helped;
    private String userHelperEmail;
    private String action_type;


    public Animal() {}

    public Animal(String id, String name, String species, String gender, String size,
                  String age, ArrayList<String> temper, ArrayList<String> health,
                  String desease, String about, String picture, boolean adoption_term,
                  boolean pictures_of_house, boolean previous_visit, boolean supervision_1month,
                  boolean supervision_3months, boolean supervision_6months, boolean food_need,
                  boolean finantial_need, boolean med_need, String med_name_need, boolean obj_need,
                  String obj_details_need, boolean sponsor_term, boolean finantial_sponsor, boolean
                          food_finantial_sponsor, boolean health_finantial_sponsor,
                  boolean obj_finantial_sponsor, boolean visit_sponsor, boolean adopted,
                  String targetUserEmail, boolean sponsored, boolean helped, String userHelperEmail,
                  String action_type) {
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
        this.picture = picture;
        this.adoption_term = adoption_term;
        this.pictures_of_house = pictures_of_house;
        this.previous_visit = previous_visit;
        this.supervision_1month = supervision_1month;
        this.supervision_3months = supervision_3months;
        this.supervision_6months = supervision_6months;
        this.food_need = food_need;
        this.finantial_need = finantial_need;
        this.med_need = med_need;
        this.med_name_need = med_name_need;
        this.obj_need = obj_need;
        this.obj_details_need = obj_details_need;
        this.sponsor_term = sponsor_term;
        this.finantial_sponsor = finantial_sponsor;
        this.food_finantial_sponsor = food_finantial_sponsor;
        this.health_finantial_sponsor = health_finantial_sponsor;
        this.obj_finantial_sponsor = obj_finantial_sponsor;
        this.visit_sponsor = visit_sponsor;
        this.adopted = adopted;
        this.targetUserEmail = targetUserEmail;
        this.sponsored = sponsored;
        this.helped = helped;
        this.userHelperEmail = userHelperEmail;
        this.action_type = action_type;
    }


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

    public boolean isFood_need() {
        return food_need;
    }

    public void setFood_need(boolean food_need) {
        this.food_need = food_need;
    }

    public boolean isFinantial_need() {
        return finantial_need;
    }

    public void setFinantial_need(boolean finantial_need) {
        this.finantial_need = finantial_need;
    }

    public boolean isMed_need() {
        return med_need;
    }

    public void setMed_need(boolean med_need) {
        this.med_need = med_need;
    }

    public String getMed_name_need() {
        return med_name_need;
    }

    public void setMed_name_need(String med_name_need) {
        this.med_name_need = med_name_need;
    }

    public boolean isObj_need() {
        return obj_need;
    }

    public void setObj_need(boolean obj_need) {
        this.obj_need = obj_need;
    }

    public String getObj_details_need() {
        return obj_details_need;
    }

    public void setObj_details_need(String obj_details_need) {
        this.obj_details_need = obj_details_need;
    }

    public boolean isSponsor_term() {
        return sponsor_term;
    }

    public void setSponsor_term(boolean sponsor_term) {
        this.sponsor_term = sponsor_term;
    }

    public boolean isFinantial_sponsor() {
        return finantial_sponsor;
    }

    public void setFinantial_sponsor(boolean finantial_sponsor) {
        this.finantial_sponsor = finantial_sponsor;
    }

    public boolean isFood_finantial_sponsor() {
        return food_finantial_sponsor;
    }

    public void setFood_finantial_sponsor(boolean food_finantial_sponsor) {
        this.food_finantial_sponsor = food_finantial_sponsor;
    }

    public boolean isHealth_finantial_sponsor() {
        return health_finantial_sponsor;
    }

    public void setHealth_finantial_sponsor(boolean health_finantial_sponsor) {
        this.health_finantial_sponsor = health_finantial_sponsor;
    }

    public boolean isObj_finantial_sponsor() {
        return obj_finantial_sponsor;
    }

    public void setObj_finantial_sponsor(boolean obj_finantial_sponsor) {
        this.obj_finantial_sponsor = obj_finantial_sponsor;
    }

    public boolean isVisit_sponsor() {
        return visit_sponsor;
    }

    public void setVisit_sponsor(boolean visit_sponsor) {
        this.visit_sponsor = visit_sponsor;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public String getTargetUserEmail() {
        return targetUserEmail;
    }

    public void setTargetUserEmail(String targetUserEmail) {
        this.targetUserEmail = targetUserEmail;
    }

    public boolean isHelped() {
        return helped;
    }

    public void setHelped(boolean helped) {
        this.helped = helped;
    }

    public String getUserHelperEmail() {
        return userHelperEmail;
    }

    public void setUserHelperEmail(String userHelperEmail) {
        this.userHelperEmail = userHelperEmail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
