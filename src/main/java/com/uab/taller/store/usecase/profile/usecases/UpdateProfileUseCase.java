package com.uab.taller.store.usecase.profile.usecases;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfileUseCase {
    @Autowired
    IProfileService profileService;
    public Profile execute(Long profileId, ProfileRequest profileRequest) {
        Profile profileToUpdate = new Profile();
        profileToUpdate.setId(profileId);
        profileToUpdate.setName(profileRequest.getName());
        profileToUpdate.setLastName(profileRequest.getLastName());
        profileToUpdate.setBirthDate(profileRequest.getBirthDate());
        profileToUpdate.setGender(profileRequest.getGender());
        return profileService.save(profileToUpdate  );
    }
}
