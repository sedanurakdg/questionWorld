    package com.example.questionworld.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;

    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;


    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class OpUser {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String username;
        private String password;
    }
