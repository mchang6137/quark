/*
 * Copyright (c) 2015. Qubole Inc
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.qubole.quark.catalog.db.dao;

import com.qubole.quark.catalog.db.mapper.CubeMapper;
import com.qubole.quark.catalog.db.pojo.Cube;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * DAO for {@link Cube}
 */

@RegisterMapper(CubeMapper.class)
public interface CubeDAO {
  @SqlQuery("select c.id, c.name, c.query, c.schema_name, c.table_name, c.grouping_column, ds.name"
      + " as destination from data_sources ds join cubes c on ds.id = c.destination_id "
      + "where ds.ds_set_id = :ds_set_id")
  List<Cube> findByDSSetId(@Bind("ds_set_id") long dsSetId);
}
