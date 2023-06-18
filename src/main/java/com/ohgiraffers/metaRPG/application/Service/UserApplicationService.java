package com.ohgiraffers.metaRPG.application.Service;

import com.ohgiraffers.metaRPG.application.dto.UserDTO;
import com.ohgiraffers.metaRPG.domain.entity.UserEntity;
import com.ohgiraffers.metaRPG.domain.repository.ItemRepository;
import com.ohgiraffers.metaRPG.domain.repository.UserRepository;
import com.ohgiraffers.metaRPG.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

    private UserDomainService userDomainService;

    private UserRepository userRepository;

    private ItemRepository itemRepository;

    @Autowired
    public UserApplicationService(
            UserDomainService userDomainService,
            UserRepository userRepository,
            ItemRepository itemRepository
    ) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public UserDTO initUserDTO(String userName) {
        UserEntity user = userRepository.findUserByName(userName);
        return new UserDTO (
                user.getSequence(),
                user.getName(),
                user.getMoney(),
                user.getHp(),
                user.getSequence(),
                user.getItemSequence(),
                user.getItemUpLv()
        );
    }

};


