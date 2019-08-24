package com.xingyu.qq_pirate_number.umis.dao;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {
    T handle(ResultSet rs) throws Exception;
}
