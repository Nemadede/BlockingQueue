package com.blocking_queues;

import com.blocking_queues.threadpools.CustomThreadPoolExecutor;
import com.blocking_queues.threadpools.PoolsControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PullService {
    final CustomThreadPoolExecutor executor = PoolsControl.getPullThreadPoolExecutor();
    DataFetchState dataFetchState;
    final CustomThreadPoolExecutor WriterExecutor = PoolsControl.getWriteThreadPoolExecutor();

    private User user;
    public PullService(User user, DataFetchState dataFetchState){
        this.user = user;
        this.dataFetchState = dataFetchState;
    }

    public void pull(){

        System.out.println("----------> Starting for user "+ user.toString());

        List<String> modelNames = new ArrayList(Arrays.asList("Account", "Bill", "BillPayment", "Customer", "Invoice", "Payment",
            "PaymentMethod", "RefundReceipt", "SalesReceipt", "Vendor", "VendorCredit"));

            dataFetchState = dataFetchState.setTotalCount((modelNames.size() *2 )+1);
            for(String name: modelNames){
                executor.execute(new Pull(name, dataFetchState,WriterExecutor));
            }


    }




}
