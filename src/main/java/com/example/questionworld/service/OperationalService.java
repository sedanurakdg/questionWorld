    package com.example.questionworld.service;

    import com.example.questionworld.dto.OpUserP;
    import com.example.questionworld.repository.OpUserRepository;
    import lombok.AllArgsConstructor;
    import com.example.questionworld.exception.BadRequestException;
    import com.example.questionworld.model.OpUser;
    import lombok.extern.log4j.Log4j2;
    import org.springframework.stereotype.Service;

    import javax.ws.rs.NotFoundException;

    @Log4j2
    @Service
    @AllArgsConstructor
    public class OperationalService implements IOperationalService {

        private final OpUserRepository opUserRepository;

        public OpUser createOpUser(OpUserP opUserP) {
            isUserExistByUsername(opUserP);
            OpUser opUser=new OpUser();
            opUser.setUsername(opUserP.getUsername());
            opUser.setPassword(opUserP.getPassword());
            opUserRepository.save(opUser);
            return opUser;
        }

        public void isUserExistByUsername(OpUserP opUserP) {
            if (opUserRepository.existsByUsername(opUserP.getUsername())) {
                throw new BadRequestException("This user exists with username: " + opUserP.getUsername());
            }
        }

        @Override
        public OpUser getUserById(Integer id) {
            return opUserRepository.findById(id).orElseThrow(NotFoundException::new);
        }

        @Override
        public OpUser editOpUser(Integer id,OpUserP opUserP) {

            OpUser opUser = opUserRepository.findOpUserById(id);
            opUser.setPassword(opUser.getPassword());
            opUser.setUsername(opUserP.getUsername());
            opUserRepository.save(opUser);
            return opUser;
        }

        @Override
        public void changePassword(Integer id, String password) {
            OpUser opUser = opUserRepository.findById(id).orElseThrow(NotFoundException::new);
            opUser.setPassword(password);
            opUserRepository.save(opUser);
        }

        @Override
        public void deleteUser(Integer id) {
            opUserRepository.deleteById(id);
        }

        @Override
        public OpUser login(OpUserP opUserP) {
            OpUser opUser = opUserRepository.findOpUserByUsername(opUserP.getUsername());
            if (opUser.getPassword().equals(opUserP.getPassword())) {
                return opUser;
            } else {
                return null;
            }
        }
    }
