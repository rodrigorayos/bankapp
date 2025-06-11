package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.usecases.profile.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private CreateProfileUseCase createProfileUseCase;

    @Autowired
    private GetAllProfilesUseCase getAllProfileUseCase;

    @Autowired
    private GetProfileByIdUseCase getProfileByIdUseCase;

    @Autowired
    private UpdateProfileUseCase updateProfileUseCase;

    @Autowired
    private DeleteProfileUseCase deleteProfileUseCase;

    @PostMapping
    public Profile create(@RequestBody ProfileRequest request) {
        return createProfileUseCase.execute(request);
    }

    @GetMapping
    public List<Profile> getAll() {
        return getAllProfileUseCase.execute();
    }

    @GetMapping("/{id}")
    public Profile getById(@PathVariable Long id) {
        return getProfileByIdUseCase.execute(id);
    }

    @PutMapping("/{id}")
    public Profile update(@PathVariable Long id, @RequestBody ProfileRequest request) {
        return updateProfileUseCase.execute(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteProfileUseCase.execute(id);
    }
}
