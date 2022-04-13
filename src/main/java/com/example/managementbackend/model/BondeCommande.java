package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bondecommande")
public class BondeCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private long numeros;

    @NotNull
    private float montant;

    @NotNull
    private long delais;

   /* @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_entreprise")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id", nullable = false)*/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entreprise", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Organisation entreprise;

   /* @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bondecommande")
    private List<ArticleUtilisee> articlesutilisees = new ArrayList<>();
    */


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marchee_id", nullable = false)
    private Marchee marchee;

    @OneToMany(mappedBy = "bondecommande")
    private List<ArticleUtilisee> articlesassociation = new ArrayList<ArticleUtilisee>();


    public BondeCommande(long numeros, float montant, long delais, Organisation entreprise, Marchee marchee, List<ArticleUtilisee> articlesassociation) {
        this.numeros = numeros;
        this.montant = montant;
        this.delais = delais;
        this.entreprise = entreprise;
        this.marchee = marchee;
        this.articlesassociation = articlesassociation;
    }

    public BondeCommande() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumeros() {
        return numeros;
    }

    public void setNumeros(long numeros) {
        this.numeros = numeros;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public long getDelais() {
        return delais;
    }

    public void setDelais(long delais) {
        this.delais = delais;
    }

    public Organisation getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Organisation entreprise) {
        this.entreprise = entreprise;
    }

    public Marchee getMarchee() {
        return marchee;
    }

    public void setMarchee(Marchee marchee) {
        this.marchee = marchee;
    }

    public List<ArticleUtilisee> getArticlesassociation() {
        return articlesassociation;
    }

    public void setArticlesassociation(List<ArticleUtilisee> articlesassociation) {
        this.articlesassociation = articlesassociation;
    }
}
