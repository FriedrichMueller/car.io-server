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
package io.car.server.core.update;

import com.google.inject.Inject;

import io.car.server.core.entities.User;
import io.car.server.core.util.PasswordEncoder;

/**
 * @author Christian Autermann <autermann@uni-muenster.de>
 */
public class UserUpdater implements EntityUpdater<User> {
    private final PasswordEncoder encoder;

    @Inject
    public UserUpdater(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public User update(User changes, User original) {
        if (changes.getName() != null) {
            original.setName(changes.getName());
        }
        if (changes.getMail() != null) {
            original.setMail(changes.getMail());
        }
        if (changes.getToken() != null) {
            original.setToken(encoder.encode(changes.getToken()));
        }
        return original;
    }
}
