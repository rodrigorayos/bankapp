package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import com.uab.taller.store.usecase.profile.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/profile")
public class ProfileController {

    @Autowired
    IProfileService profileService;
    @Autowired
    GetAllProfilesUseCase getAllProfilesUseCase;
    @Autowired
    GetProfileByIdUseCase getProfileByIsUseCase;
    @Autowired
    CreateProfileUseCase createProfileUseCase;
    @Autowired
    DeleteProfileUseCase deleteProfileUseCase;
    @Autowired
    private UpdateProfileUseCase updateProfileUseCase;

    //CREATE "C"
    @PostMapping ("")
    public Profile save(@RequestBody ProfileRequest  profileRequest){
        return createProfileUseCase.execute(profileRequest);
    }

    //READ "R"
    @GetMapping()
    public List<Profile> getAll(){
        return getAllProfilesUseCase.execute();
    }

    @GetMapping(value = "/{profileId}")
    public Profile getById(@PathVariable Long profileId){
        return getProfileByIsUseCase.execute(profileId);
    }

    //UPDATE "U"
    @PutMapping("/{profileId}")
    public Profile update(@PathVariable Long profileId, @RequestBody ProfileRequest profileRequest) {
        return updateProfileUseCase.execute(profileId,profileRequest);
    }

    //DELETE "D"
    @DeleteMapping("/{profileId}")
    public void deleteById(@PathVariable Long profileId) {
        deleteProfileUseCase.execute(profileId);
    }
}
