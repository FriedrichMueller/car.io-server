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
package io.car.server.core.entities;

import io.car.server.core.util.Pagination;
import io.car.server.core.util.UpCastingIterable;

public class Measurements extends UpCastingIterable<Measurement> {
    public static MeasurementsBuilder from(
            Iterable<? extends Measurement> delegate) {
        return new MeasurementsBuilder(delegate);
    }

    protected Measurements(Iterable<? extends Measurement> delegate,
                           Pagination pagination, long elements) {
        super(delegate, pagination, elements);
    }

    public static class MeasurementsBuilder {
        private Iterable<? extends Measurement> delegate;
        private Pagination pagination;
        private long elements;

        public MeasurementsBuilder(Iterable<? extends Measurement> delegate) {
            this.delegate = delegate;
        }

        public MeasurementsBuilder withPagination(Pagination pagination) {
            this.pagination = pagination;
            return this;
        }

        public MeasurementsBuilder withElements(long elements) {
            this.elements = elements;
            return this;
        }

        public Measurements build() {
            return new Measurements(delegate, pagination, elements);
        }
    }
}
