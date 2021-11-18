package com.example.workorderapi.configuration;

import com.example.workorderapi.models.User;

public class UserData {
    public static User[] Users = new User[]{
            new User(
                    1,
                    "user.1",
                    "user_1@hotmail.com",
                    "P@ssw0rd",
                    "siteEngineer",
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEiLCJ1c2VybmFtZSI6InVzZXIuMSIsInJvbGUiOiJzaXRlRW5naW5lZXIiLCJlbWFpbCI6InVzZXJfMUBob3RtYWlsLmNvbSJ9.Qjy2DibFn0-0fE9ysyQUlLzO4DSNmSG2M3460Zdld4g"),
            new User(
                    2,
                    "user.2",
                    "user_2@hotmail.com",
                    "P@ssw0rd",
                    "foreman",
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEiLCJ1c2VybmFtZSI6InVzZXIuMiIsInJvbGUiOiJmb3JlbWFuIiwiZW1haWwiOiJ1c2VyXzJAaG90bWFpbC5jb20ifQ.WphJ9NzYqMTDLvPE9ZfYrI8dfx6OUOqfkoUVUwBgqe0")
    };
}
