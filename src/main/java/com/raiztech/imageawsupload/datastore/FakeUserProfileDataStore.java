package com.raiztech.imageawsupload.datastore;

import com.raiztech.imageawsupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    public static final List<UserProfile> USER_PROFILES = new ArrayList<>();
    static{
        USER_PROFILES.add( new UserProfile(UUID.fromString("838aa4b0-d045-42aa-8551-badb47a47792"), "ensei.tankado",null));
        USER_PROFILES.add( new UserProfile(UUID.fromString("a7e1a43f-77dc-45f5-92a4-494c098b5930"), "raiz.tech",null));
        USER_PROFILES.add( new UserProfile(UUID.fromString("774994d6-df5e-4853-bde7-35837918cabb"), "fe.phi",null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
