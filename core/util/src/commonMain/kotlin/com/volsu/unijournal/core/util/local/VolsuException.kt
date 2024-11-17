package com.volsu.unijournal.core.util.local

sealed class VolsuException(override val message: String) : Throwable() {

    companion object {
        fun find(value: String) = when (value) {
            NetworkError.message -> NetworkError
            InvalidCredentialsError.message -> InvalidCredentialsError
            else -> UnknownError
        }
    }

    data object NetworkError : VolsuException("network error")

    data object InvalidCredentialsError: VolsuException("invalid credentials")

    data object InternalServerError: VolsuException("something went wrong")

    data object UnknownError : VolsuException("unknown error")

    class CustomError(message: String): VolsuException(message)
}

fun Throwable.toVolsuException(): VolsuException {
    return if (message != null)
        VolsuException.find(requireNotNull(message))
    else
        VolsuException.UnknownError
}

fun Throwable.findVolsuException(): VolsuException {
    if(message == null) return VolsuException.UnknownError
    if(this is VolsuException.CustomError) return this

    return if (requireNotNull(message).contains("network"))
        VolsuException.NetworkError
    else if(requireNotNull(message).contains("credential"))
        VolsuException.InvalidCredentialsError
    else
        VolsuException.UnknownError
}