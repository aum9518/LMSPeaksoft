package com.example.lmspeaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "option_tests")
@Getter
@Setter
@NoArgsConstructor
public class OptionTest {
    @Id
    @GeneratedValue(generator = "optionTest_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "optionTest_gen",
            sequenceName = "optionTest_seq",
            allocationSize = 1)
    private Long id;
    private String option;
    private Boolean statusOption;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Question question;

    public OptionTest(Long id, String option, Boolean statusOption) {
        this.id = id;
        this.option = option;
        this.statusOption = statusOption;
    }
}
