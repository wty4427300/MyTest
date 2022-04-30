package com.ftest.test;

import java.util.List;

public class AljkBatchWithdrawRequest {
    private List<AljkSyncCargoRequest> requests;

    public List<AljkSyncCargoRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<AljkSyncCargoRequest> requests) {
        this.requests = requests;
    }
}
