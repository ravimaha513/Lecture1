package com.info.lecture1.interfaces.Impl;

import com.info.lecture1.interfaces.IInitialization;
import com.info.lecture1.interfaces.IStudentRepository;

public class InitializationImpl implements IInitialization {
    @Override
    public IStudentRepository init(String dbName) {

        if(dbName.equalsIgnoreCase("oracle"))
            return new OracleRepository();

        else{
            return new CassandraRepository();
        }
    }
}
