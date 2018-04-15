package io.zipcoder.controller;

import io.zipcoder.domain.Withdrawal;
import io.zipcoder.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    public WithdrawalController(WithdrawalService withdrawalService)  {
        this.withdrawalService = withdrawalService;
    }

    @RequestMapping(value="accounts/{acountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalsByAccount(@PathVariable Long accountId) {
        return withdrawalService.getWithdrawalsByAccount(accountId);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawalId) {
        return withdrawalService.getWithdrawal(withdrawalId);
    }

    @RequestMapping(value="/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@PathVariable Long accountId, @RequestBody Withdrawal withdrawal) {
        return withdrawalService.createWithdrawal(withdrawal);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@PathVariable Long withdrawalId, @RequestBody Withdrawal withdrawal) {
        return withdrawalService.updateWithdrawal(withdrawal);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId) {
        return withdrawalService.deleteWithdrawal(withdrawalId);
    }
}