package com.hodorgeek.mt.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TransferRequestPayload {

    private Long fromAccount;

    private Long toAccount;

    private float amount;
}
