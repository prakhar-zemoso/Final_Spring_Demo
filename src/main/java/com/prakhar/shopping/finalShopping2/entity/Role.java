package com.prakhar.shopping.finalShopping2.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Role implements GrantedAuthority {
        public long getId() {
            return id;
        }
        @ManyToMany(mappedBy = "roles")
        private Set<User> users;

        public void setId(long id) {
            this.id = id;
        }


//        public String getName() {
//            return name;
//        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getAuthority() {
            return name;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private  String name;


}
