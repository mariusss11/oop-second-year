package com.marius.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loads")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loadId;

    private String details;

    @OneToMany(mappedBy = "load")
    @JsonManagedReference
    private List<Document> documentList;

    @OneToMany(mappedBy = "load")
    @JsonManagedReference
    private List<Cargo> cargoList;

}
