package org.mvnsearch.coroutines.grpc

import com.google.protobuf.Int32Value
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import org.lognet.springboot.grpc.GRpcService
import org.mvnsearch.service.AccountResponse
import org.mvnsearch.service.AccountServiceImplBase
import org.mvnsearch.service.GetAccountRequest
import org.mvnsearch.service.QueryAccountRequest

/**
 * Account Service coroutines implementation
 *
 * @author linux_china
 */
@GRpcService
class AccountServiceCoroutineImpl : AccountServiceImplBase() {

    override suspend fun findAccount(request: GetAccountRequest): AccountResponse {
        return AccountResponse.newBuilder()
            .setId(request.id)
            .setNick("Jackie")
            .build()
    }

    override suspend fun findById(request: Int32Value): AccountResponse {
        return AccountResponse.newBuilder()
            .setId(request.value)
            .setNick("Jackie")
            .build()
    }

    @ExperimentalCoroutinesApi
    override suspend fun findAll(request: QueryAccountRequest): ReceiveChannel<AccountResponse> =
        produce<AccountResponse> {
            send(
                AccountResponse.newBuilder()
                    .setId(1)
                    .setNick("Jackie")
                    .build()
            )
            send(
                AccountResponse.newBuilder()
                    .setId(2)
                    .setNick("James")
                    .build()
            )
        }
}