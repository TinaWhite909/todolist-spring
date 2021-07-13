package com.github.tinawhite909.todolistspring.bean;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.bean.NewUser;

import java.time.LocalDate;

public class DBTask {
    private Long id;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String content;
    private DBStatus status;
    private DBUser assigner;
    private DBUser assigned_to;

    public DBTask(Builder builder) {
        this.id = builder.id;
        this.startDate = builder.startDate;
        this.finishDate = builder.finishDate;
        this.content = builder.content;
        this.status = builder.status;
        this.assigner = builder.assigner;
        this.assigned_to = builder.assigned_to;
    }

    public DBTask() {
    }

    public DBTask(Long id, LocalDate startDate, LocalDate finishDate, String content, DBStatus status, DBUser assigner, DBUser assigned_to) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.content = content;
        this.status = status;
        this.assigner = assigner;
        this.assigned_to = assigned_to;
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

    public DBUser getAssigner() {
        return assigner;
    }

    public void setAssigner(DBUser assigner) {
        this.assigner = assigner;
    }

    public DBUser getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(DBUser assigned_to) {
        this.assigned_to = assigned_to;
    }

    public static class Builder {
        Long id;
        LocalDate startDate;
        LocalDate finishDate;
        String content;
        DBStatus status;
        DBUser assigner;
        DBUser assigned_to;

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

        public Builder setAssigner(DBUser assigner1) {
            assigner = assigner1;
            return this;
        }

        public Builder setAssigned_to(DBUser perf) {
            assigned_to = perf;
            return this;
        }

        public DBTask build() {
            return new DBTask(this);
        }
    }
}
