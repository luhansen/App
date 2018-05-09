package com.jadilindo.meau.meau;

public class User {
    private String name;
    private String age;
    private String user_name;
    private String email;
    private String password;
    private String picture;
    private String address;
    private String phone_number;
    private Chat[] chats;
    private Animal[] favorites;
    private Animal[] owns;
    private RequestForAdoption[] requests_for_adoption;
    private RequestForHelp[] requests_for_help;

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
                Chat[] chats,
                Animal[] favorites,
                Animal[] owns,
                RequestForAdoption[] requests_for_adoption,
                RequestForHelp[] requests_for_help) {

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

    public Chat[] getChats() {
        return chats;
    }

    public void setChats(Chat[] chats) {
        this.chats = chats;
    }

    public Animal[] getFavorites() {
        return favorites;
    }

    public void setFavorites(Animal[] favorites) {
        this.favorites = favorites;
    }

    public Animal[] getOwns() {
        return owns;
    }

    public void setOwns(Animal[] owns) {
        this.owns = owns;
    }

    public RequestForAdoption[] getRequests_for_adoption() {
        return requests_for_adoption;
    }

    public void setRequests_for_adoption(RequestForAdoption[] requests_for_adoption) {
        this.requests_for_adoption = requests_for_adoption;
    }

    public RequestForHelp[] getRequests_for_help() {
        return requests_for_help;
    }

    public void setRequests_for_help(RequestForHelp[] requests_for_help) {
        this.requests_for_help = requests_for_help;
    }
}
