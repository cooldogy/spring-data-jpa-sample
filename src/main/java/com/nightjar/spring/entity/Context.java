package com.nightjar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "context")
public class Context implements Serializable {

    private static final long serialVersionUID = 5126236902785738835L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ctx_id", nullable = false, unique = true, columnDefinition = "BIGINT")
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String versionName;

    @Column(nullable = false, length = 100)
    private String path;

    @Column(nullable = false, length = 100)
    private String workDir;

    @OneToMany(mappedBy = "context", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Parameter> parameters;

//    @OneToMany(mappedBy = "context", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Resource> resources = new HashSet<>();

}
