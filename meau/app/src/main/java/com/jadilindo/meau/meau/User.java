package com.jadilindo.meau.meau;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private String age;
    private String user_name;
    private String email;
    private String password;
    private String picture;
    private String address;
    private String phone_number;
    public ArrayList<Chat> chats;
    public ArrayList<Animal> favorites;
    public ArrayList<Animal> owns;
    public ArrayList<Animal> sponsors;
    public ArrayList<Animal> helps;
    public ArrayList<RequestForAdoption> requests_for_adoption;
    public ArrayList<RequestForHelp> requests_for_help;

    public User(){
    }

    public User(String artistId, String artistName, String artistGenre) {
    }

    public User(String name,
                String age,
                String user_name,
                String email,
                String password,
                String picture,
                String address,
                String phone_number,
                ArrayList<Chat> chats,
                ArrayList<Animal> favorites,
                ArrayList<Animal> owns,
                ArrayList<RequestForAdoption> requests_for_adoption,
                ArrayList<RequestForHelp> requests_for_help) {

        this.name = name;
        this.age = age;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.address = address;
        this.phone_number = phone_number;
        this.chats = chats;
        this.favorites = favorites;
        this.owns = owns;
        this.requests_for_adoption = requests_for_adoption;
        this.requests_for_help = requests_for_help;
    }

    public User(String id, String name, String age, String user_name, String email, String password, String picture, String address, String phone_number, ArrayList<Chat> chats, ArrayList<Animal> favorites, ArrayList<Animal> owns, ArrayList<RequestForAdoption> requests_for_adoption, ArrayList<RequestForHelp> requests_for_help) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.address = address;
        this.phone_number = phone_number;
        this.chats = chats;
        this.favorites = favorites;
        this.owns = owns;
        this.requests_for_adoption = requests_for_adoption;
        this.requests_for_help = requests_for_help;
    }

    public User(String id, String name, String age, String user_name, String email, String password, String picture, String address, String phone_number, ArrayList<Chat> chats, ArrayList<Animal> favorites, ArrayList<Animal> owns, ArrayList<Animal> sponsors, ArrayList<Animal> helps, ArrayList<RequestForAdoption> requests_for_adoption, ArrayList<RequestForHelp> requests_for_help) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.address = address;
        this.phone_number = phone_number;
        this.chats = chats;
        this.favorites = favorites;
        this.owns = owns;
        this.sponsors = sponsors;
        this.helps = helps;
        this.requests_for_adoption = requests_for_adoption;
        this.requests_for_help = requests_for_help;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    public ArrayList<Chat> getChats() {
        return chats;
    }

    public void setChats(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    public ArrayList<Animal> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Animal> favorites) {
        this.favorites = favorites;
    }

    public ArrayList<Animal> getOwns() {
        return owns;
    }

    public void setOwns(ArrayList<Animal> owns) {
        this.owns = owns;
    }

    public ArrayList<RequestForAdoption> getRequests_for_adoption() {
        return requests_for_adoption;
    }

    public void setRequests_for_adoption(ArrayList<RequestForAdoption> requests_for_adoption) {
        this.requests_for_adoption = requests_for_adoption;
    }

    public ArrayList<RequestForHelp> getRequests_for_help() {
        return requests_for_help;
    }

    public void setRequests_for_help(ArrayList<RequestForHelp> requests_for_help) {
        this.requests_for_help = requests_for_help;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Animal> getSponsors() {
        return sponsors;
    }

    public void setSponsors(ArrayList<Animal> sponsors) {
        this.sponsors = sponsors;
    }

    public ArrayList<Animal> getHelps() {
        return helps;
    }

    public void setHelps(ArrayList<Animal> helps) {
        this.helps = helps;
    }
}
