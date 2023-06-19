package com.ohgiraffers.metaRPG.application.Service;

import com.ohgiraffers.metaRPG.application.dto.UserDTO;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

    private UserRepository userRepository;

    @Autowired
    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO initUserDTO(String userName) {
        UserEntity user = userRepository.findUserByName(userName);
        return new UserDTO(
                user.getSequence(),
                user.getName(),
                user.getHp(),
                user.getStr(),
                user.getMoney(),
                user.getItemSequence(),
                user.getItemUpLv()
        );
    }

}



