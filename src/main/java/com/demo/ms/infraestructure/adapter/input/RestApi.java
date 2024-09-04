package com.demo.ms.infraestructure.adapter.input;

import com.demo.ms.application.port.service.TransactionCardServices;
import com.demo.ms.dominio.exception.DoesNotExistTypeOperationException;
import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.infraestructure.adapter.input.mapper.TransactionMapperResponse;
import com.demo.ms.infraestructure.adapter.input.model.CardResponse;
import com.demo.ms.infraestructure.adapter.input.model.TransactionRequest;
import com.demo.ms.infraestructure.adapter.input.model.TransactionResponse;
import com.demo.ms.utils.commons.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.ms.utils.commons.Constants;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestApi {
    private final TransactionCardServices transactionCardServices;
    private final TransactionMapperResponse transactionMapperResponse;
    private final Properties properties;

    @PostMapping("api/v1/operation")
    public ResponseEntity<TransactionResponse> operation(@RequestBody TransactionRequest transactionRequest) {

        if (transactionRequest.getTransactionType().equals(properties.getRecarga())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    transactionMapperResponse.transactionToTransactionResponse(
                            transactionCardServices.rechargeCard(transactionMapperResponse.transactionToTransactionRequest(transactionRequest))
                    )
            );
        } else if (transactionRequest.getTransactionType().equals(properties.getDebito())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    transactionMapperResponse.transactionToTransactionResponse(
                            transactionCardServices.debitoCard(transactionMapperResponse.transactionToTransactionRequest(transactionRequest))
                    )
            );
        } else {
                throw new DoesNotExistTypeOperationException(
                        Constants.COD_EX_NOTEXISTTYPEOPERATION,
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        Constants.MSG_EX_NOTEXISTTYPEOPERATION+" "+transactionRequest.getTransactionType());
        }
    }

    @GetMapping("api/v1")
    public ResponseEntity<List<TransactionResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionMapperResponse.transactionsToTransactionResponses(transactionCardServices.getTransactions()));
    }
}
