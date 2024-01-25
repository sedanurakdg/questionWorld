    package com.example.questionworld.repository;

    import com.example.questionworld.model.OpUser;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface OpUserRepository extends JpaRepository<OpUser, Integer> {

        Boolean existsByUsername(String name);
        OpUser findOpUserById(Integer id);
        OpUser findOpUserByUsername(String id);
    }
