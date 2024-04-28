# Resolución

* Agregué en el manifiesto esta linea
```
    <uses-permission android:name="android.permission.INTERNET" />
```

## TweetsResponse

Creé un archivo en la carpeta model llamado TweetsReponse donde definí el tipo de response que me va a devolver la API. Tiene un array llamado "tweets" que tiene un ```List<Tweet>```.

## TweetsService

Creé un archivo en el main llamado TweetsService donde definí cómo voy a interactuar con la API para obtener datos, definí el metodo que voy a consumir.

## RetrofitClient

Cree este singleton para poder reutilizar la instancia de singleton que me va a permitir consumir la API declarada. Ahí mismo seteo la interfaz de TweetsService.

## TweetsViewModel

Reemplacé el mockedServiceGetTweets por esta función:

```kotlin
private suspend fun tweetServiceGetTweets(oldest: Long?, latest: Long?): Response<TweetsResponse> {
    return RetrofitClient.service.list(oldest,latest)
}
```
Y en la función loadTweets cambié esto

```kotlin
...
val response = tweetServiceGetTweets(oldest = oldest,latest = latest)
if (response.isSuccessful) {
    // Obtener la lista de tweets desde la respuesta
    val newTweets = response.body()?.tweets ?: emptyList()
    val oldTweets = tweetsLiveData.value ?: emptyList()
    ....
```