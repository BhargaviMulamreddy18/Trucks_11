package com.bten1.trucks;

public class User {

    String loadtype, loadingpoint, unloadingpoint, freight, tons, advance;


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

    public String getLoadingpoint() {
        return loadingpoint;
    }

    public String getUnloadingpoint() {
        return unloadingpoint;
    }

    public String getFreight() {
        return freight;
    }

    public String getTons() {
        return tons;
    }

    public String getAdvance() {
        return advance;
    }
}