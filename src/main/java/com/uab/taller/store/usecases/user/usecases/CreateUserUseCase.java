package com.uab.taller.store.usecases.user.usecases;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.Rol;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateFullUserRequest;
import com.uab.taller.store.repository.RolRepository;
import com.uab.taller.store.service.IProfileService;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProfileService profileService;

    @Autowired
    private RolRepository rolRepository;

    public User execute(CreateFullUserRequest createUserRequest) {
        Profile profile = new Profile();
        profile.setName(createUserRequest.getName());
        profile.setLastName(createUserRequest.getLastName());
        profile.setGender(createUserRequest.getGender());
        profile = profileService.save(profile);

        Rol rol = rolRepository.findAll()
                .stream()
                .filter(r -> r.getName().equalsIgnoreCase(createUserRequest.getRoleName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + createUserRequest.getRoleName()));

        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        user.setProfile(profile);
        user.setRol(rol);

        return userService.save(user);
    }
}
