package org.example.Ex12;

import lombok.RequiredArgsConstructor;

public interface UserProjection {
    Long getId();
    String getName();
    String getEmail();


    @RequiredArgsConstructor
    class UserProjectionImpl implements UserProjection{

        @Override
        public Long getId() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getEmail() {
            return null;
        }

        static  UserProjection of(User user){
            return new UserProjectionImpl();
        }
    }
}
