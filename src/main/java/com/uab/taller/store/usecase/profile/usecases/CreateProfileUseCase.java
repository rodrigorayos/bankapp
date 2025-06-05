package com.uab.taller.store.usecase.profile.usecases;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProfileUseCase {
    @Autowired
    IProfileService profileService;

    public Profile execute(ProfileRequest profileRequest){
        Profile profileToCreate = new Profile();
        profileToCreate.setName(profileRequest.getName());
        profileToCreate.setLastName(profileRequest.getLastName());
        profileToCreate.setBirthDate(profileRequest.getBirthDate());
        profileToCreate.setGender(profileRequest.getGender  ());
        return profileService.save(profileToCreate);
    }
}