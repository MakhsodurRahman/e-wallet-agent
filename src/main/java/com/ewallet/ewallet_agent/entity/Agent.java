package com.ewallet.ewallet_agent.entity;
import com.ewallet.ewallet_agent.enums.Gender;
import com.ewallet.ewallet_agent.enums.Role;
import com.ewallet.ewallet_agent.enums.Status;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "agent")
public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber; //String

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "pin")
    private String pin;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "profile_Image_Path")
    private String profileImagePath;

    @Column(name = "nid_number")
    private String nidNumber;

    @Column(name = "approved_at")
    private LocalDateTime ApprovedAt; // LocalDateTime


    @OneToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    private Admin approvedBy; //complete it later


    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "agent_wallet_id", referencedColumnName = "id")
    private AgentWallet agentWallet;




    @OneToMany(mappedBy = "agent")
    private List<BankAccountDetails> bankAccountDetails;

    @OneToMany(mappedBy = "agent")
    private List<CardDetails> cardDetails;

    @OneToMany(mappedBy = "agent")
    private List<TransactionHistory> transactionHistory;
}
