package com.demidov.cinema.model.entities.types;

import com.demidov.cinema.model.entities.Place;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

public class PlaceMatrixType extends AbstractSingleColumnStandardBasicType<Place[][]>
        implements DynamicParameterizedType {

    public PlaceMatrixType(SqlTypeDescriptor sqlTypeDescriptor, JavaTypeDescriptor<Place[][]> javaTypeDescriptor) {
        super(sqlTypeDescriptor, javaTypeDescriptor);
    }

    @Override
    public String getName() {
        return "place-matrix";
    }

    @Override
    public void setParameterValues(Properties properties) {
        ((StringArrayTypeDescriptor)
                getJavaTypeDescriptor())
                .setParameterValues(parameters);
    }
}
