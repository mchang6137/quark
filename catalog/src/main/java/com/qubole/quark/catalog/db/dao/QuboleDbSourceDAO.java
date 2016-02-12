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

import com.qubole.quark.catalog.db.mapper.QuboleDbSourceMapper;
import com.qubole.quark.catalog.db.pojo.QuboleDbSource;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * DAO for {@link QuboleDbSource}
 */
@RegisterMapper(QuboleDbSourceMapper.class)
public interface QuboleDbSourceDAO {
  @SqlQuery("select ds.id, ds.name, ds.type, ds.datasource_type, ds.url, ds.ds_set_id, "
      + "qs.dbtap_id, qs.auth_token from data_sources ds join quboledb_sources qs on ds.id = qs.id "
      + "where ds.ds_set_id = :ds_set_id")
  List<QuboleDbSource> findByDSSetId(@Bind("ds_set_id") long dsSetId);
}
