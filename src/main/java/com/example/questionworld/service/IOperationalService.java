    package com.example.questionworld.service;

    import com.example.questionworld.dto.OpUserP;
    import com.example.questionworld.model.OpUser;

    public interface IOperationalService {
        OpUser createOpUser(OpUserP opUserP);

        OpUser getUserById(Integer id);

        OpUser editOpUser(Integer id,OpUserP opUser);

        void changePassword(Integer id, String password);

        void deleteUser(Integer id);

        OpUser login(OpUserP opUserP);
    }
