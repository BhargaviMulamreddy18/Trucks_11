
package com.bten1.trucks;
public class User {

    String loadtype,loadingpoint,unloadingpoint,freight,tons,advance;

    public User() {
    }

    public User(String loadtype, String loadingpoint, String unloadingpoint, String freight, String tons, String advance) {
        this.loadtype = loadtype;
        this.loadingpoint = loadingpoint;
        this.unloadingpoint = unloadingpoint;
        this.freight = freight;
        this.tons = tons;
        this.advance = advance;
    }

    public String getLoadtype() {
        return loadtype;
    }

    public void setLoadtype(String loadtype) {
        this.loadtype = loadtype;
    }

    public String getLoadingpoint() {
        return loadingpoint;
    }

    public void setLoadingpoint(String loadingpoint) {
        this.loadingpoint = loadingpoint;
    }

    public String getUnloadingpoint() {
        return unloadingpoint;
    }

    public void setUnloadingpoint(String unloadingpoint) {
        this.unloadingpoint = unloadingpoint;
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

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }
}
