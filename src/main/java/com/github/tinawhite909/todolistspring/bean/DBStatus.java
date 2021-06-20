package com.github.tinawhite909.todolistspring.bean;

public class DBStatus {
    private Long id;
    private String status;

    public DBStatus(){

    }

    public DBStatus(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  Long getIdStatus(){
        return id;
    }

    public void setIdStatus(Long status) {
        this.id = id;
    }
}
