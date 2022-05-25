
package com.bten1.trucks;
public class person {

   private String Load_type;
   private String loading_point;
   private String unloading_point;
   private String Freight;
   private String Tons;
    private String Email;
    private String party_name;
    private String party_phone_no;

    public String getParty_phone_no() {
        return party_phone_no;
    }

    public void setParty_phone_no(String party_phone_no) {
        this.party_phone_no = party_phone_no;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public person() {
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }


    public person(String load_type, String loading_point, String unloading_point, String freight, String tons) {
        Load_type = load_type;
        this.loading_point = loading_point;
        this.unloading_point = unloading_point;
        Freight = freight;
        Tons = tons;
    }

    public String getLoad_type() {
        return Load_type;
    }

    public void setLoad_type(String load_type) {
        Load_type = load_type;
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
        return Freight;
    }

    public void setFreight(String freight) {
        Freight = freight;
    }

    public String getTons() {
        return Tons;
    }

    public void setTons(String tons) {
        Tons = tons;
    }
}