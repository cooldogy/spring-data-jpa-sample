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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "parameter")
public class Parameter implements Serializable {

    private static final long serialVersionUID = 7222296260054072509L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "param_id", nullable = false, unique = true, columnDefinition = "BIGINT")
    private Long id;

    @Column(nullable = false, length = 20)
    private String value;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Integer dbType;

    @ManyToOne
    @JoinColumn(name = "ctx_id")
    private Context context;

    @OneToOne(mappedBy = "parameter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Resource resource;

}
