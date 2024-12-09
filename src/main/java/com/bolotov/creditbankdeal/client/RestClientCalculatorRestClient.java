package com.bolotov.creditbankdeal.client;

import com.bolotov.creditbankdeal.dto.CreditDto;
import com.bolotov.creditbankdeal.dto.LoanOfferDto;
import com.bolotov.creditbankdeal.dto.LoanStatementRequestDto;
import com.bolotov.creditbankdeal.dto.ScoringDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
public class RestClientCalculatorRestClient implements CalculatorRestClient {

    private static final ParameterizedTypeReference<List<LoanOfferDto>> LOAN_OFFER_DTO_TYPE_REFERENCE =
            new ParameterizedTypeReference<>() {
            };

    private static final ParameterizedTypeReference<CreditDto> CREDIT_DTO_TYPE_REFERENCE =
            new ParameterizedTypeReference<>() {
            };

    private final RestClient restClient;

    @Override
    public List<LoanOfferDto> getOffers(LoanStatementRequestDto requestDto) {
        try {
            return restClient.post()
                    .uri("/calculator/offers")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestDto)
                    .retrieve()
                    .body(LOAN_OFFER_DTO_TYPE_REFERENCE);
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new RuntimeException();
        }
    }

    @Override
    public CreditDto getCredit(ScoringDataDto scoringDataDto) {
        try {
            return restClient.post()
                    .uri("/calculator/calc")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(scoringDataDto)
                    .retrieve()
                    .body(CREDIT_DTO_TYPE_REFERENCE);
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new RuntimeException();
        }
    }
}
