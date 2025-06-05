package com.uab.taller.store.usecase.user.usecases;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateFullUserRequest;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.repository.ProfileRepository;
import com.uab.taller.store.service.IAccountService;
import com.uab.taller.store.service.IProfileService;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
    @Autowired
    IUserService userService;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    IProfileService profileService;

    public User execute(CreateFullUserRequest createUserRequest) {

        Profile profile = new Profile();
        profile.setName(createUserRequest.getName());
        profile.setLastName(createUserRequest.getLastName());
        profile.setGender(createUserRequest.getGender());
        profile = profileService.save(profile);

        User user = new User();

        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        user.setProfile(profile);
        return userService.save(user);
    }
}
