package com.cassiomoda.cadastroprodutos.model;

import com.cassiomoda.cadastroprodutos.model.Categoria;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-15T10:02:59", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Categoria> categoria;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Integer> id;
    public static volatile SingularAttribute<Produto, Timestamp> dataCadastro;
    public static volatile SingularAttribute<Produto, Timestamp> dataAlteracao;

}