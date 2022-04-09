package com.raiztech.imageawsupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin("*")
public class UserProfileController {

    private final UserProfileServices userProfileServices;

    @Autowired
    public UserProfileController(UserProfileServices userProfileServices) {
        this.userProfileServices = userProfileServices;
    }

    @GetMapping
    public List<UserProfile> getUserProfiles(){
        return userProfileServices.getUserProfiles();
    }

    @PostMapping(
            path="{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfiles(@PathVariable("userProfileId") UUID userProfileId,
                                   @RequestParam("file") MultipartFile file){
        try {
            userProfileServices.uploadUserProfileImage(userProfileId, file);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    @GetMapping("{userProfileId}/image/download")
    public byte[] downloadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId){
        return userProfileServices.downloadUserProfileImage(userProfileId);
    }

}
