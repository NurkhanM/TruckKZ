package product.truckkz.models.nepolnyi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u001aJ\t\u00103\u001a\u00020\u0001H\u00c6\u0003J\t\u00104\u001a\u00020\u0011H\u00c6\u0003J\t\u00105\u001a\u00020\u0013H\u00c6\u0003J\t\u00106\u001a\u00020\u0015H\u00c6\u0003J\t\u00107\u001a\u00020\u0017H\u00c6\u0003J\t\u00108\u001a\u00020\u0004H\u00c6\u0003J\t\u00109\u001a\u00020\u0013H\u00c6\u0003J\t\u0010:\u001a\u00020\u0004H\u00c6\u0003J\t\u0010;\u001a\u00020\u0004H\u00c6\u0003J\t\u0010<\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010>\u001a\u00020\u0001H\u00c6\u0003J\t\u0010?\u001a\u00020\u0001H\u00c6\u0003J\t\u0010@\u001a\u00020\u000eH\u00c6\u0003J\t\u0010A\u001a\u00020\u0001H\u00c6\u0003J\u00a5\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0013H\u00c6\u0001J\u0013\u0010C\u001a\u00020\u00132\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010E\u001a\u00020\u0007H\u00d6\u0001J\t\u0010F\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u000f\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010,\u00a8\u0006G"}, d2 = {"Lproduct/truckkz/models/nepolnyi/NepolModel;", "", "dateOfBirth", "email", "", "firstName", "id", "", "imageUser", "", "Lproduct/truckkz/models/nepolnyi/ImageUser;", "lastName", "middleName", "passportData", "Lproduct/truckkz/models/nepolnyi/PassportData;", "phoneNumber", "registeredAddress", "Lproduct/truckkz/models/nepolnyi/RegisteredAddress;", "registrationComplete", "", "residenceAddress", "Lproduct/truckkz/models/nepolnyi/ResidenceAddress;", "role", "Lproduct/truckkz/models/nepolnyi/Role;", "status", "verifiedByTechSupport", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Object;Ljava/lang/Object;Lproduct/truckkz/models/nepolnyi/PassportData;Ljava/lang/Object;Lproduct/truckkz/models/nepolnyi/RegisteredAddress;ZLproduct/truckkz/models/nepolnyi/ResidenceAddress;Lproduct/truckkz/models/nepolnyi/Role;Ljava/lang/String;Z)V", "getDateOfBirth", "()Ljava/lang/Object;", "getEmail", "()Ljava/lang/String;", "getFirstName", "getId", "()I", "getImageUser", "()Ljava/util/List;", "getLastName", "getMiddleName", "getPassportData", "()Lproduct/truckkz/models/nepolnyi/PassportData;", "getPhoneNumber", "getRegisteredAddress", "()Lproduct/truckkz/models/nepolnyi/RegisteredAddress;", "getRegistrationComplete", "()Z", "getResidenceAddress", "()Lproduct/truckkz/models/nepolnyi/ResidenceAddress;", "getRole", "()Lproduct/truckkz/models/nepolnyi/Role;", "getStatus", "getVerifiedByTechSupport", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class NepolModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object dateOfBirth = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String firstName = null;
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<product.truckkz.models.nepolnyi.ImageUser> imageUser = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object lastName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object middleName = null;
    @org.jetbrains.annotations.NotNull()
    private final product.truckkz.models.nepolnyi.PassportData passportData = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object phoneNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final product.truckkz.models.nepolnyi.RegisteredAddress registeredAddress = null;
    private final boolean registrationComplete = false;
    @org.jetbrains.annotations.NotNull()
    private final product.truckkz.models.nepolnyi.ResidenceAddress residenceAddress = null;
    @org.jetbrains.annotations.NotNull()
    private final product.truckkz.models.nepolnyi.Role role = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    private final boolean verifiedByTechSupport = false;
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.NepolModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.Object dateOfBirth, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String firstName, int id, @org.jetbrains.annotations.NotNull()
    java.util.List<product.truckkz.models.nepolnyi.ImageUser> imageUser, @org.jetbrains.annotations.NotNull()
    java.lang.Object lastName, @org.jetbrains.annotations.NotNull()
    java.lang.Object middleName, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.PassportData passportData, @org.jetbrains.annotations.NotNull()
    java.lang.Object phoneNumber, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.RegisteredAddress registeredAddress, boolean registrationComplete, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.ResidenceAddress residenceAddress, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.Role role, @org.jetbrains.annotations.NotNull()
    java.lang.String status, boolean verifiedByTechSupport) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public NepolModel(@org.jetbrains.annotations.NotNull()
    java.lang.Object dateOfBirth, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String firstName, int id, @org.jetbrains.annotations.NotNull()
    java.util.List<product.truckkz.models.nepolnyi.ImageUser> imageUser, @org.jetbrains.annotations.NotNull()
    java.lang.Object lastName, @org.jetbrains.annotations.NotNull()
    java.lang.Object middleName, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.PassportData passportData, @org.jetbrains.annotations.NotNull()
    java.lang.Object phoneNumber, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.RegisteredAddress registeredAddress, boolean registrationComplete, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.ResidenceAddress residenceAddress, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.nepolnyi.Role role, @org.jetbrains.annotations.NotNull()
    java.lang.String status, boolean verifiedByTechSupport) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getDateOfBirth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstName() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<product.truckkz.models.nepolnyi.ImageUser> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<product.truckkz.models.nepolnyi.ImageUser> getImageUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getMiddleName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.PassportData component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.PassportData getPassportData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getPhoneNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.RegisteredAddress component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.RegisteredAddress getRegisteredAddress() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getRegistrationComplete() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.ResidenceAddress component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.ResidenceAddress getResidenceAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.Role component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.nepolnyi.Role getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean getVerifiedByTechSupport() {
        return false;
    }
}