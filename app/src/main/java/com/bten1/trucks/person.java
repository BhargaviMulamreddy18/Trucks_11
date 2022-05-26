
package com.bten1.trucks;
public class person {

    public String mail;
    public String party_name;
    public String load_type;
    public String loading_point;
    public String unloading_point;
    public String freight;
    public String tons;
    public String party_phone_no;
    public String advance_amt;
    public String delivery_date;
    public String uid;
    public String fixer;
    public person() {
    }

    public person(String mail, String party_name, String load_type, String loading_point, String unloading_point, String freight, String tons, String party_phone_no, String advance_amt, String delivery_date, String uid, String fixer) {
        this.mail = mail;
        this.party_name = party_name;
        this.load_type = load_type;
        this.loading_point = loading_point;
        this.unloading_point = unloading_point;
        this.freight = freight;
        this.tons = tons;
        this.party_phone_no = party_phone_no;
        this.advance_amt = advance_amt;
        this.delivery_date = delivery_date;
        this.uid = uid;
        this.fixer = fixer;
    }

    public String getFixer() {
        return fixer;
    }

    public void setFixer(String fixer) {
        this.fixer = fixer;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getLoad_type() {
        return load_type;
    }

    public void setLoad_type(String load_type) {
        this.load_type = load_type;
    }

    public String getLoading_point() {
        return loading_point;
    }

    public void setLoading_point(String loading_point) {
        this.loading_point = loading_point;
    }

    public String getUnloading_point() {
        return unloading_point;
    }

    public void setUnloading_point(String unloading_point) {
        this.unloading_point = unloading_point;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getTons() {
        return tons;
    }

    public void setTons(String tons) {
        this.tons = tons;
    }

    public String getParty_phone_no() {
        return party_phone_no;
    }

    public void setParty_phone_no(String party_phone_no) {
        this.party_phone_no = party_phone_no;
    }

    public String getAdvance_amt() {
        return advance_amt;
    }

    public void setAdvance_amt(String advance_amt) {
        this.advance_amt = advance_amt;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}