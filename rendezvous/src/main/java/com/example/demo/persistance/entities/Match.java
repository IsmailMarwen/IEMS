package com.example.demo.persistance.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "`match`")
@AllArgsConstructor
@NoArgsConstructor
public class Match implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatch;
    private int score1;
    private int score2;
    private boolean finished;
    @ManyToOne
    private Equipe eq1;
    @ManyToOne
    private Equipe eq2;
    @JsonIgnore
    @ManyToOne
    private Journee journee;

    @JsonIgnore
    @OneToMany(mappedBy="match",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SauvCarton> sauvcartons;
    @JsonIgnore
    @OneToMany(mappedBy="match",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Elimination> eliminations;
    @JsonIgnore
    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Butteur> butteurs;

    public Long getIdMatch() {
        return idMatch;
    }

    public List<Butteur> getButteurs() {
        return butteurs;
    }

    public void setButteurs(List<Butteur> butteurs) {
        this.butteurs = butteurs;
    }

    public void setIdMatch(Long idMatch) {
        this.idMatch = idMatch;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Equipe getEq1() {
        return eq1;
    }

    public void setEq1(Equipe eq1) {
        this.eq1 = eq1;
    }

    public Equipe getEq2() {
        return eq2;
    }

    public void setEq2(Equipe eq2) {
        this.eq2 = eq2;
    }

    public Journee getJournee() {
        return journee;
    }

    public void setJournee(Journee journee) {
        this.journee = journee;
    }

    public List<SauvCarton> getSauvcartons() {
        return sauvcartons;
    }

    public void setSauvcartons(List<SauvCarton> sauvcartons) {
        this.sauvcartons = sauvcartons;
    }

    public List<Elimination> getEliminations() {
        return eliminations;
    }

    public void setEliminations(List<Elimination> eliminations) {
        this.eliminations = eliminations;
    }

}
