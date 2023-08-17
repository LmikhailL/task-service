package com.ates.taskservice.entity;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

import com.ates.taskservice.model.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tasks")
public class TaskEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  @Enumerated(STRING)
  private TaskStatus taskStatus;

  @Column(name = "amount_of_money_to_charge")
  private BigDecimal amountOfMoneyToCharge;

  @Column(name = "amount_of_money_to_pay")
  private BigDecimal amountOfMoneyToPay;

  @OneToOne(cascade = ALL)
  @JoinColumn(name = "users_cud_id")
  private UserCudEntity userCudEntity;

  public void addUser(UserCudEntity toAdd) {
    this.userCudEntity = toAdd;
    toAdd.setTaskEntity(this);
  }
}
