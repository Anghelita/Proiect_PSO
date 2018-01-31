package com.anghelita.proiect_pso.Entity;

/**
 * Created by Traian on 31-Jan-18.
 */

public class Item {

    String ID;
    String name;
    String date;
    String professorFirstName;
    String ProfessorLastName;
    String course;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProfessorFirstName() {
        return professorFirstName;
    }

    public void setProfessorFirstName(String professorFirstName) {
        this.professorFirstName = professorFirstName;
    }

    public String getProfessorLastName() {
        return ProfessorLastName;
    }

    public void setProfessorLastName(String getProfessorLastName) {
        this.ProfessorLastName = getProfessorLastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
