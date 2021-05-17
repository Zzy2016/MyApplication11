package com.example.test1launchmode.anno;


//@Target(ElementType.FIELD)
//@Retention(RetentionPolicy.RUNTIME)
//public @interface UserFiled {
//    String name();
//
//    String type();
//
//    int length();
//}

@Table(value = "user_table")
public class User {
    @UserFiled(name = "user_id", type = "int", length = 8)
    private int userId;

    @UserFiled(name = "user_name", type = "varchar", length = 16)
    private String userName;

    @UserFiled(name = "password", type = "varvhar", length = 16)
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
