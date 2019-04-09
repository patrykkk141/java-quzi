package pl.patryk.quiz.javaquiz.model;

import pl.patryk.quiz.javaquiz.enums.RoleType;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "username")
    private String userName;
    @Column(nullable =false, name= "password")
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "user")
    private List<TestHistory> testHistoryList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public List<TestHistory> getTestHistoryList() {
        return testHistoryList;
    }

    public void setTestHistoryList(List<TestHistory> testHistoryList) {
        this.testHistoryList = testHistoryList;
    }
}
