package com.uab.taller.store.usecase.profile.usecases;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProfileByIdUseCase {
    @Autowired
    IProfileService profileService;
    public Profile execute(Long profileId){
        return profileService.getById(profileId);
    }
}
