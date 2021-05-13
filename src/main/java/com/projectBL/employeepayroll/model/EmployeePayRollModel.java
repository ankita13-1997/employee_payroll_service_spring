package com.projectBL.employeepayroll.model;

import com.projectBL.employeepayroll.dtoModel.EmployeePayrollDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//import org.hibernate.mapping.List;
import java.util.List;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.UUID;

@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class EmployeePayRollModel implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID employeeId;

    private String name;
    private String salary;

    private String gender;
    private String profilePic;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(joinColumns = @JoinColumn(name = "employeeId"))
    private List<String> department;
    private String startDate;
    private String notes;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public EmployeePayRollModel(String name, String salary,String gender,String profilePic ,List<String> department,String startDate,String notes) {
        this.name=name;
        this.salary=salary;
        this.gender=gender;
        this.profilePic=profilePic;
        this.department=department;
        this.startDate=startDate;
        this.notes=notes;

    }
}
