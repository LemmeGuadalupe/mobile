package ar.edu.utn.frba.mobile.clases.ui.main
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ar.edu.utn.frba.mobile.clases.ui.model.TweetsResponse

interface TweetsService {

    @GET("/list")
    suspend fun list(
        @Query("oldest") oldest: Long?,
        @Query("latest") latest: Long?
    )
    : Response<TweetsResponse>
}

