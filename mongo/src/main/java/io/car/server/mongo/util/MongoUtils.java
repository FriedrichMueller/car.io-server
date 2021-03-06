/*
 * Copyright (C) 2013  Christian Autermann, Jan Alexander Wirwahn,
 *                     Arne De Wall, Dustin Demuth, Saqib Rasheed
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.car.server.mongo.util;

import java.util.List;

import com.google.common.base.Joiner;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author Christian Autermann <autermann@uni-muenster.de>
 */
public class MongoUtils {
    public static double asDouble(DBObject dbo, String attr) {
        return ((Number) dbo.get(attr)).doubleValue();
    }

    public static String valueOf(String property) {
        return "$" + property;
    }

    public static String valueOf(String first, String second,
                                 String... paths) {
        return "$" + path(first, second, paths);
    }

    public static String path(String first, String second,
                              String... paths) {
        return Joiner.on(".").join(first, second, (Object[]) paths);
    }

    public static int length(DBObject dbo, String attr) {
        return ((List<?>) dbo.get(attr)).size();
    }

    public static long asLong(DBObject dbo, String attr) {
        return ((Number) dbo.get(attr)).longValue();
    }

    public static DBObject avg(Object value) {
        return new BasicDBObject(Ops.AVG, value);
    }

    public static DBObject max(Object value) {
        return new BasicDBObject(Ops.MAX, value);
    }

    public static DBObject min(Object value) {
        return new BasicDBObject(Ops.MIN, value);
    }

    public static DBObject addToSet(String path) {
        return new BasicDBObject(Ops.ADD_TO_SET, path);
    }

    public static DBObject unwind(String path) {
        return new BasicDBObject(Ops.UNWIND, path);
    }

    public static DBObject count() {
        return new BasicDBObject(Ops.SUM, 1);
    }

    public static DBObject group(DBObject fields) {
        return new BasicDBObject(Ops.GROUP, fields);
    }

    public static DBObject in(DBObject names) {
        return new BasicDBObject(Ops.IN, names);
    }

    public static DBObject match(String path, Object o) {
        return match(new BasicDBObject(path, o));
    }

    public static DBObject match(Object o) {
        return new BasicDBObject(Ops.MATCH, o);
    }

    public static DBObject project(BasicDBObject fields) {
        return new BasicDBObject(Ops.PROJECT, fields);
    }

    private MongoUtils() {
    }
}
