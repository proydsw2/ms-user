package com.cibertec.dsw2.Model;

import lombok.*;
import javax.persistence.*;

@SequenceGenerator(name="seq_user_id", initialValue=1, allocationSize=1)
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_id")
    @Column(name = "num_user_id")
    private Integer num_user_id;

    @Column(name = "str_username")
    private String str_username;

    @Column(name = "str_password")
    private String str_password;

    @Column(name = "num_customer_id")
    private Integer num_customer_id;

    @Column(name = "chr_status")
    private String chr_status;

}
