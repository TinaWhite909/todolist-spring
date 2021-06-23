package com.github.tinawhite909.todolistspring.bean;

import java.time.LocalDate;

public class DBTask {
    private Long id;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String content;
    private DBStatus status;

    public DBTask(Builder builder) {
        this.id = builder.id;
        this.startDate = builder.startDate;
        this.finishDate = builder.finishDate;
        this.content = builder.content;
        this.status = builder.status;
    }

    public DBTask() {
    }

    public DBTask(Long id, LocalDate startDate, LocalDate finishDate, String content, DBStatus status) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.content = content;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DBStatus getStatus() {
        return status;
    }

    public void setStatus(DBStatus status) {
        this.status = status;
    }

    public static class Builder {
        Long id;
        LocalDate startDate;
        LocalDate finishDate;
        String content;
        DBStatus status;

        public Builder setId(Long val) {
            id = val;
            return this;
        }

        public Builder setStartDate(LocalDate date) {
            startDate = date;
            return this;
        }

        public Builder setFinishDate(LocalDate date) {
            finishDate = date;
            return this;
        }

        public Builder setContent(String task) {
            content = task;
            return this;
        }

        public Builder setStatus(DBStatus stat) {
            status = stat;
            return this;
        }

        public DBTask build() {
            return new DBTask(this);
        }
    }
}
