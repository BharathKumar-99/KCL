package com.adonaiitsolutions.kcl.SignupandSignin;

public class SignupModel {
    String  name,father_name,dob,blood,phone,email,adhar,networkname,doorno,streetname,pin,village,
            taluk,nomineename,nomineeaddar,nomineerelation,nomineedob,state,district,photo;

    public SignupModel(String name, String father_name, String dob, String blood, String phone,
                       String email, String adhar, String networkname, String doorno,
                       String streetname, String pin, String village, String taluk,
                       String nomineename, String nomineeaddar, String nomineerelation,
                       String nomineedob, String state, String district, String photo) {
        this.name = name;
        this.father_name = father_name;
        this.dob = dob;
        this.blood = blood;
        this.phone = phone;
        this.email = email;
        this.adhar = adhar;
        this.networkname = networkname;
        this.doorno = doorno;
        this.streetname = streetname;
        this.pin = pin;
        this.village = village;
        this.taluk = taluk;
        this.nomineename = nomineename;
        this.nomineeaddar = nomineeaddar;
        this.nomineerelation = nomineerelation;
        this.nomineedob = nomineedob;
        this.state = state;
        this.district = district;
        this.photo = photo;
    }

    public SignupModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhar() {
        return adhar;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public String getNetworkname() {
        return networkname;
    }

    public void setNetworkname(String networkname) {
        this.networkname = networkname;
    }

    public String getDoorno() {
        return doorno;
    }

    public void setDoorno(String doorno) {
        this.doorno = doorno;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getNomineename() {
        return nomineename;
    }

    public void setNomineename(String nomineename) {
        this.nomineename = nomineename;
    }

    public String getNomineeaddar() {
        return nomineeaddar;
    }

    public void setNomineeaddar(String nomineeaddar) {
        this.nomineeaddar = nomineeaddar;
    }

    public String getNomineerelation() {
        return nomineerelation;
    }

    public void setNomineerelation(String nomineerelation) {
        this.nomineerelation = nomineerelation;
    }

    public String getNomineedob() {
        return nomineedob;
    }

    public void setNomineedob(String nomineedob) {
        this.nomineedob = nomineedob;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
