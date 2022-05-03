package com.nightjar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = -5341395227172188251L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="res_id", nullable = false, unique = true, columnDefinition = "BIGINT")
    private Long id;
    @Column(nullable = false, length = 20)
    private String host;

    @Column(nullable = true, columnDefinition = "tinyint(5) default 0")
    private Integer port;

    @Column(nullable = false, length = 20)
    private String databaseName;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = true, length = 20)
    private String password;

//    @ManyToOne
//    @JoinColumn(name = "ctx_id")
//    private Context context;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "param_id")
    private Parameter parameter;

}
